(ns clojure-luminus-spike.db.schema
  (:use environ.core))

(def db-spec
  {:subprotocol "postgresql"
   :subname "//localhost/clojure"
   :user (env :postgre_user)
   :password (env :postgre_passwd)})
