(defproject clojure-luminus-spike "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [lib-noir "0.8.4"]
                 [ring-server "0.3.1"]
                 [ring/ring-json "0.3.1"]
                 [selmer "0.6.8"]
                 [com.taoensso/timbre "3.2.1"]
                 [com.taoensso/tower "2.0.2"]
                 [markdown-clj "0.9.44"]
                 [environ "0.5.0"]
                 [noir-exception "0.2.2"]
                 [postgresql/postgresql "9.1-901-1.jdbc4"]
                 [ragtime "0.3.6"]
                 [korma "0.3.2"]
                 [clj-yaml "0.4.0"]]

  :repl-options {:init-ns clojure-luminus-spike.repl}
  :plugins [[lein-ring "0.8.10"]
            [lein-environ "0.5.0"]
            [ragtime/ragtime.lein "0.3.6"]]
  :ring {:handler clojure-luminus-spike.handler/app
         :init    clojure-luminus-spike.handler/init
         :destroy clojure-luminus-spike.handler/destroy}
  :ragtime
  {:migrations ragtime.sql.files/migrations,
   :database
   "jdbc:postgresql://localhost/clojure?user=clojure_user&password=cl0jure"
   }
  :profiles
  {:uberjar {:aot :all}
   :production {:ring {:open-browser? false
                       :stacktraces?  false
                       :auto-reload?  false}}
   :dev {:dependencies [[ring-mock "0.1.5"]
                        [ring/ring-devel "1.3.0"]
                        [pjstadig/humane-test-output "0.6.0"]]
         :injections [(require 'pjstadig.humane-test-output)
                      (pjstadig.humane-test-output/activate!)]
         :env {:dev true}}}
  :min-lein-version "2.0.0")
