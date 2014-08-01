(ns clojure-luminus-spike.service.user-service
  (:require [clojure-luminus-spike.db.core :as db]))

(defn get-users []
  (db/list-user))

(get-users)
