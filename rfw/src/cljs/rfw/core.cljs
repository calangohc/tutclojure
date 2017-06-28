(ns rfw.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce app-state
  (reagent/atom {:p {:x 50 :y 150} :d {:x 5 :y 0} :time 0}))




;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn update! [ratom] (swap! ratom #(conj % {:p {:x (+ (-> % :p :x) (-> % :d :x))
                                                 :y (+ (-> % :p :y) (-> % :d :y))}
                                             :time (+ (:time @ratom) 1)})))


(defn new-direction! [ratom dx dy] (swap! ratom update :d (fn [x] {:x dx :y dy})))



(defn page [ratom]
  (let [direction-button (fn [name dx dy] [:input {:type "button" :value name :on-click #(new-direction! ratom dx dy)} ])  ]
    [:div
     [:h2 "Jogo"]
     [:div {:id "play"}
      [:svg {:width "500" :height "300"}
       [:circle {:cx (-> @ratom :p :x) :cy (-> @ratom :p :y) :r "20" :stroke "green" :stroke-width "10" :fill "blue"}]
       ]]

     [:div {:id "control"}
      (direction-button "<" -5 0)
      (direction-button "^" 0 -5)
      (direction-button "X" 0 0)
      (direction-button "v" 0 5)
      (direction-button ">" 5 0)

      ]
     [:div (str "X: " (-> @ratom :p :x) " Y:" (-> @ratom :p :y) " DX: " (-> @ratom :d :x) " DY: " (-> @ratom :d :y) " Time: " (:time @ratom))]

     ]))


(js/setInterval #(update! app-state) 100 )

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
