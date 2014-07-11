(ns clojure-luminus-spike.middleware
  (:require [taoensso.timbre :as timbre]
            [ring.middleware.json :refer [wrap-json-response]]
            [selmer.parser :as parser]
            [environ.core :refer [env]]
            [selmer.middleware :refer [wrap-error-page]]
            [noir-exception.core
              :refer [wrap-internal-error wrap-exceptions]]))

(defn log-request [handler]
  (fn [req]
    (timbre/debug req)
    (handler req)))

(def development-middleware
  [log-request
   wrap-error-page
   wrap-exceptions])

(def production-middleware
  [#(wrap-internal-error % :log (fn [e] (timbre/error e)))
   wrap-json-response])

(defn load-middleware []
  (concat (when (env :dev) development-middleware)
          production-middleware))
