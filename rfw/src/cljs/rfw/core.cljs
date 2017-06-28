(ns rfw.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; O Estado do app fica dentro o reagent/atom "app-state".
;;

(defonce app-state
  (reagent/atom {:position {:x 10 :y 150} :direction {:x 5 :y 0} :time 0}))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; O app.


(defn update! [ratom] (swap! ratom #(let [pos (:position %)
                                          dir (:direction %)]
                                      (conj % {:position {:x (+ (:x pos) (:x dir))
                                                          :y (+ (:y pos) (:y dir))}
                                               :time (+ (:time %) 1)}))))


(defn new-direction! [ratom dx dy] (swap! ratom update :direction (fn [x] {:x dx :y dy})))



(defn page [ratom]
  (let [direction-button (fn [name dx dy] [:button {:on-click #(new-direction! ratom dx dy)} name  ])
        pos (:position @ratom)
        w "800"
        h "500"]
    [:div {:style {:font-family "mono"}}
     [:h2 "Jogo"]
     [:div {:id "play"}
      [:svg {:width w :height h}
       [:rect {:width w :height h :style {:fill "black"}}]
       [:circle {:cx (:x pos) :cy (:y pos) :r "10" :stroke "lightblue" :stroke-width "4" :fill "blue"}]
       ]]

     [:div {:id "control"}
      (direction-button "<" -2 0)
      (direction-button "^" 0 -2)
      (direction-button "X" 0 0)
      (direction-button "v" 0 2)
      (direction-button ">" 2 0)

      ]
     [:div (str "X: " (:x pos) " Y:" (:y pos) " DX: " (:x (:direction @ratom)) " DY: " (:y (:direction @ratom)) " Time: " (:time @ratom))]

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
