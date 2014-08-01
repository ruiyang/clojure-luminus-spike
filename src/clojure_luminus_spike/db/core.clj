(ns clojure-luminus-spike.db.core
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [clojure-luminus-spike.db.schema :as schema]))

(defdb db schema/db-spec)

(declare users list-item)

(defentity users
  (has-many list-item))

(defentity list-item
  (table "list_item"))

(defn create-user [user]
  (insert users
          (values user)))

(defn update-user [id email password]
  (update users
  (set-fields {:email email
               :pass password})
  (where {:id id})))

(defn get-user [id]
  (first (select users
                 (where {:id id})
                 (limit 1))))

(defn list-user []
  (select users))

(defn add-list-item [tool user]
  (insert list-item
          (values (assoc tool :users_id (:id user)))))
