(ns clojure-luminus-spike.db.schema
  (:use environ.core))

(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/clojure"
   :user (env :postgre-user)
   :password (env :postgre-passwd)})
