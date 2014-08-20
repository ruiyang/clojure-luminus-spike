(ns clojure-luminus-spike.routes.home
  (:use compojure.core)
  (:require [clojure-luminus-spike.layout :as layout]
            [clojure-luminus-spike.util :as util]
            [ring.util.response :as resp]))

(defn home-page []
  (layout/render
    "home.html" {:content (util/md->html "/md/docs.md")}))

(defn about-page []
  (layout/render "about.html"))

(defn test-json []
  (resp/response {:a "test", :b "this is b"}))

(defn test-json2 []
  (resp/response {:key1 "test", :key2 "this is b"}))

(defroutes home-routes
  (GET "/" [] (home-page))
  (GET "/about" [] (about-page))
  (GET "/json" [] (test-json))
  (GET "/json2" [] (test-json2)))
