(ns clojure-luminus-spike.db.core
  (:use korma.core
        [korma.db :only (defdb)])
  (:require [clojure-luminus-spike.db.schema :as schema]))

(defdb db schema/db-spec)

(declare users tools)

(defentity users
  (has-many tools))

(defentity tools)

(defn create-user [user]
  (insert users
          (values user)))

(defn update-user [id first-name last-name email]
  (update users
  (set-fields {:first_name first-name
               :last_name last-name
               :email email})
  (where {:id id})))

(defn get-user [id]
  (first (select users
                 (where {:id id})
                 (limit 1))))

(defn list-user []
  (select users))

(defn add-tools [tool]
  (insert tools
          (values tool)))
