(ns clojure-luminus-spike.routes.users
  (:use compojure.core)
  (:require [clojure-luminus-spike.service.user-service :as us]
            [ring.util.response :as resp]))

(defn get-users []
  (resp/response (us/get-users)))

(defroutes users-routes
  (GET "/users" [] (get-users)))
