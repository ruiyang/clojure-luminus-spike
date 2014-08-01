(ns clojure-luminus-spike.repl
  (:use clojure-luminus-spike.handler
        ring.server.standalone
        clojure-luminus-spike.db.core
        [clj-yaml.core :as yaml]
        [korma.db]
        [ring.middleware file-info file]))

(defonce server (atom nil))

(defn get-handler []
  ;; #'app expands to (var app) so that when we reload our code,
  ;; the server is forced to re-resolve the symbol in the var
  ;; rather than having its own copy. When the root binding
  ;; changes, the server picks it up without having to restart.
  (-> #'app
      ; Makes static assets in $PROJECT_DIR/resources/public/ available.
      (wrap-file "resources")
      ; Content-Type, Content-Length, and Last Modified headers for files in body
      (wrap-file-info)))

(defn start-server
  "used for starting the server in development mode from REPL"
  [& [port]]
  (let [port (if port (Integer/parseInt port) 3000)]
    (reset! server
            (serve (get-handler)
                   {:port port
                    :init init
                    :auto-reload? true
                    :destroy destroy
                    :join? false}))
    (println (str "You can view the site at http://localhost:" port))))

(defn stop-server []
  (.stop @server)
  (reset! server nil))

(defn load-fixtures
  "load fixtures after creating database"
  []
  (let [all-fixtures (yaml/parse-string (slurp "test/seed/seed.yml"))]
    (transaction
     (let [users (:users all-fixtures)]
       (map #(let [created-user (create-user (dissoc % :list_item))]
               (map (fn [list_item]
                      (add-list-item list_item created-user))
                    (:list_item %)))
            users)))))
