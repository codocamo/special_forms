;;SPECIAL FORMS

;quote do let def fn defn if loop recur var try catch throw monitor-enter monitor-exit new finally
;loop* case* reify* letfn* import* deftype* let* fn* set! *


;def
;renames or "DEFINES" a value or form within the current namespace

(def example_def '(1 2 3))
example_def
(def example_def (conj [] 1))
example_def


;quote (short hand ')
;supresses evaluation good if you just want to use a list as a list without it trying to eval the first element

(println (map inc [2 3 9 5 6]))
(println '(map inc [2 3 9 5 6]))
(println (quote (map inc [2 3 9 5 6])))
(println (quote '(map inc [2 3 9 5 6])))


;do
;evaluates all the forms within the do block and only returns the last form to get evaluated (any efects of te other forms still apply they just wont be returned by the do form)

(do
  (println "YOYOY")
  (println (+ 3 3))
  (map inc [2 3 9 5 6]))

(do
  (def example_output (conj [] 1) )
  (if (empty? example_output) (quote "Was Empty") (quote "Was Not Empty")))

;let
;names value or form localy within that let form, good for grabing results from one form and imidiatly using it in another form without needing it again


(let [example_output (conj [] 1)]
  (if (empty? example_output) (quote "Was Empty") (quote "Was Not Empty")))


;if
;allows you to write code that exicutes based on a boolean predicate

(if true "true" "false")
(if false "true" "false")


;fn*/fn (short hand #)
;creates an anonymous function and is very usefull for passing in to a function that takes a function as an argument E.G map

(fn [x] (+ 1 x) 1)
(#(+ 1 %) 1)

(map #(+ 1 %) [0 1 2 3 4 5])


;defn/defn*
;a mixture def and fn. a named anonymous function! good for creating a clasic function

(defn example_function "docs" [arg1 arg2] (+ arg1 arg2))
(example_function 1 2)


;var
;any functions and stored values are stored within a var. when evaluating funtions and defined values, clojure looks for a var with the same name in the namespace you are in.
;at one point you may want to reference the var and not the value the var gives back
;does not work with special forms
(var =)
(var map)
(var true?)
