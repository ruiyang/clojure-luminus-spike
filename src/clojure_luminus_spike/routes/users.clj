(ns clojure-luminus-spike.routes.users
  (:use compojure.core
        clojure-luminus-spike.db.core)
  (:require [clojure-luminus-spike.service.user-service :as us]
            [ring.util.response :as resp]
            [clojure-luminus-spike.db.core :as db]))

;; (defn get-users []
;;   (resp/response (us/get-users)))

;; (defn get-user [id]
;;   (resp/response (us/get-user (Integer/valueOf id))))

(defroutes users-routes
  (GET "/users" [] (db/list-user)))
