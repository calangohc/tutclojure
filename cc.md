
footer=Copyright Phil Jones, 2017
projectname=Introdução ao Clojure
bootswatch=slate
head_extra=<link rel="stylesheet" type="text/css" href="http://app.klipse.tech/css/codemirror.css">
////index.html

[.jumbotron [.container
# Oficina Introdução ao Clojure
No Calango
.] .]

[.container [.row
[.col-md-12 

As ideias do Lisp (incluindo Racket, Scheme, Clojure etc.)

## 1) A sintaxe é muito simples.

As programas são feito de listas.

<pre><code>
    (1 2 3) 
</code></pre>

E listas dentro as listas 

<pre><code>
    (1 2 (3 4))
</code></pre>

Expressões também são listas. Sempre o nome do operador ou função como o primeiro elemento do lista e as operandos / argumentos depois.

<pre><code class="language-klipse">(+ 2 2)</code></pre>

<pre><code class="language-klipse">
    (* 3 (+ 2 5))
</code></pre>
    
#### Exerciso 1.

Traduze esta expressão em Lisp e avalia no seu computador

<pre><code>   
    3 * (5 + 9)
</code></pre>
   
<pre><code class="language-klipse">
; Escreve aqui
</code></pre>

E isso?

<pre><code>
    4 * (1 + 2 + 3 + 4 + 5 + 6) * 5 / 10
</code></pre>

<pre><code class="language-klipse">
; Escreve aqui
</code></pre>


Sua programa em Lisp e nada mais do que um series destas expressões. 

Por exemplo, o expressão condicional utilizando "if"  :

<pre><code class="language-klipse">
    (if (= 0 1) "sim" "nao")
</code></pre>



<pre><code class="language-klipse">
    (= 0 1)
</code></pre>

<pre><code class="language-klipse">
    (= 1 1)
</code></pre>

### Strings

Teste de igualidade :

<pre><code class="language-klipse">
    (= "abc" "abc")
</code></pre>

<pre><code class="language-klipse">
    (= "abc" "abcd")
</code></pre>
        
Concatenar : 
<pre><code class="language-klipse">
    (str "abc" "def")
</code></pre>

Substring :

<pre><code class="language-klipse">
    (subs "Calango Hacker Clube" 0 7)
</code></pre>

### Exerciso 2.

Escreve um teste se a primeiro n caracteres de uma string saos iguais.

<pre><code class="language-klipse">
; Escreve aqui
</code></pre>

## Expressoes e Funcoes

Criando um nome, e vinculando um valor com o nome utilizar o "let"

<pre><code class="language-klipse">
    (let [x 15] 
	    (if (< 10 x) "sim" "nao") )
</code></pre>

Obs. : o "let" cria um "escopo" dentro sue expressao. O nome `x` 'e so definido dentr deste escopo. Como sempre em Lisp, o tamanho do expressao "let" 'e definido pela as parenteses.


Criando uma função também com estrutura de lista ... utilizando o função "defn"

<pre><code class="language-klipse">
    (defn f [x] (* x x))
    (f 8)
</code></pre>

### Exerciso 3.

Criar um função que receber dois argumentos strings e responde se eles tem as primeiros 4 caracteres iguais.

Eg. 

<pre><code>	
    (comp4 "askhkjasdhk" "askhbhdifdsbkfbkdsjb") -> true
    (comp4 "askhfdfsdkfbksdj" "lhsdlfsbdk") -> false
</code></pre>

<pre><code class="language-klipse">
; Escreve aqui
</code></pre>


Adaptar sua função pra receber as dois argumentos e um numero n e teste as primeiros n caracteres.

<pre><code class="language-klipse">
; Escreve aqui
</code></pre>


----

Vai ao <a href="page2.html">Pagina 2</a>

.] .] .]

<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>


////page2.html

[.container [.row
[.col-md-12 


## Listas 

As listas são sua estrutura de dados mais importante nos Lisps, incluindo Clojure.

Nao podemos escrever um lista assim : 

<pre><code class="language-klipse">
    (1 2 3 4)
</code></pre>

    
Pq? A Lisp sempre trata o primeiro item na lista como um funcao. Pra falar sobre um lista sem tentar avaliar, precisamos o "quote".

<pre><code class="language-klipse">
    '(1 2 3 4)
</code></pre>
    

Funções que produzam listas.

<pre><code class="language-klipse">
    (list 1 2 3 4)
</code></pre>

<pre><code class="language-klipse">
    (range 10)
</code></pre>
    
Funções muito importante pra analisar / decompor as listas : *first* e *rest*

<pre><code class="language-klipse">
    (first '(1 2 3))
</code></pre>

<pre><code class="language-klipse">
    (rest '(1 2 3))
</code></pre>


Podemos combinar :

<pre><code class="language-klipse">
    (first (rest '(1 2 3)))
</code></pre>

Construção das listas :

<pre><code class="language-klipse">
    (list 1 2 3)
</code></pre>

Ou "cons", adicionar um elemento normal no inicio duma lista.

<pre><code class="language-klipse">
    (cons "Calango" '("Hacker" "Clube"))
</code></pre>
    
Podemos escrever funções que moda / processar listas. 

<pre><code class="language-klipse">
    (defn vv [xs] (cons (first (rest xs)) (list (first xs))))
    (vv '("Visa" "Versa"))
</code></pre>

### Execrisio 4.

Escreve um função que troca a segunda elemento dos duas listas. Por exemplo 

<pre><code>
    (troc2 '(1 "+" 3) "-") -> (1 "-" 3)
    (troc2 '(23 "*" 4) "/") -> (23 "/" 4)s
</code></pre>

<pre><code class="language-klipse">
; Escreve aqui
</code></pre>


## Recursividade é sua jeito de navegar dentro as estruturas

<pre><code class="language-klipse">
(defn tamanho [xs] 
  (if (empty? xs) 0 (+ 1 (tamanho (rest xs)))))

(tamanho '("a" "b" "c" "d" "e" "f"))
</code></pre>

<pre><code class="language-klipse">
(defn soma [xs]
  (if (empty? xs) 0 (+ (first xs) (soma (rest xs)))))

(soma '(1 2 3 4 5))
</code></pre>

### Exerciso 5.

* 5.1 - Escrever um funciao pra multiplicar cada elemento duma lista vezes 3
* 5.2 - Escrever um funciao pra produzir o ultimo elemento duma lista.
* 5.3 - Escrever um funciao pra reversar uma lista, eg. '(1 2 3 4 5) -> '(5 4 3 2 1)

## Mais de Listas

Podemos pegar a primeiro n elementos dos listas com `take`

<pre><code class="language-klipse">
(take 5 (range 10))
</code></pre>

Em Clojure, nos falamos listas sao "lazy" (preguisozo).

Pq? As valores de listas saos so evaliadas quando nos queremos.

Por exemple podemos criar uma lista **infinito**.

A funcao `repeat` produzi uma lista infinita da repeticoes da seu argumento.

<pre><code class="language-klipse">
(take 10 (repeat 1))
</code></pre>

Podemos utilizar `cycle` pra criar listas infinitos de valores 

<pre><code class="language-klipse">
(take 10 (cycle '("A" "B" "C")))
</code></pre>

Aqui 'e um funciao que produz o quadrada de todos os elementos duma lista

<pre><code class="language-klipse">
(defn q [xs] 
  (if (empty? xs) () 
    (cons (* (first xs) (first xs)) (q (rest xs)) )))

(q (range 10))
</code></pre>

Podemos aplicar isso pra nossa lista infinito?

Claro.

Mas precisamos fazer duas coisas : 

* 1) Embrulhe-la o corpo do funciao nume `lazy-seq` 
* 2) Quando nos queremos mostrar ao usuario, restritar pra uma lista finito ... demora bastante imprimir uma lista infinita :-)

<pre><code class="language-klipse">
(defn q [xs] 
  (lazy-seq
    (if (empty? xs) () 
       (cons (* (first xs) (first xs)) (q (rest xs)) ))))

(take 10 (q (cycle '(1 2 3 4))))
</code></pre>

<pre><code class="language-klipse">

(defn add-last [xs x]
  (if (empty? xs) (list x)
    (cons (first xs) (add-last (rest xs) x))))

(defn rev1 [xs] 
  (if (empty? xs) '()
      (add-last (rev1 (rest xs)) (first xs))))

(defn rev2 [xs] 
  (if (empty? xs) '()
    (let []
      )
    ))

(let [tests '(() (1) (1 2) (1 2 3) (1 2 3 4))]
  (list
	(map rev1 tests)
  	(map rev2 tests)
))
</code></pre>

----

Vai ao <a href="page3.html">Pagina 3</a>

.] .] .]

<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>

////page3.html


[.container [.row
[.col-md-12 

## Funções são cidadãos do primeiro classe 

Podemos passar elas como argumentos :

<pre><code class="language-klipse">
(defn m2 [x] (* 2 x))
    
(defn meu-map [f xs] 
  (lazy-seq
    (if (empty? xs) '() 
      (cons (f (first xs)) (meu-map f (rest xs)) ))))
      
(meu-map m2 '(1 2 3 4 5))
          
</code></pre>

Podemos produzir elas utilizando `partial` pra "customizar" funções que já existe :

<pre><code class="language-klipse">
(meu-map (partial * 2) '(1 2 3 4 5))
</code></pre>

partial 'e um funciao que aceita um outra funciao como argumento, pre-encha algumas argumentos dele, e devolver o funciao meia pronto pra utilizar, esperando so que esta faltando.

Por exemplo. Nos temos o funciao "meu-map" que percore uma lista e aplica um outro funciao como m2.

Podemos utilizar "partial" pra criar um funciao que sempre percore uma lista e aplicar um dobro pra todos os numeros.
<pre><code class="language-klipse">
(def meu-dobro (partial meu-map (partial * 2)))

(meu-dobro '(1 2 3 4 5))

</code></pre>

Obs : "partial" 'e um coisa muito comon em programacao funcional. Mas muitas vezes esta chamada "*curry*" (e a atividade, em ingles, chamada "currying")

### Funções Anônimos

Como nos queremos passar muitos pequenos funções como argumentos para outros funções, temos a capacidade definir funções *anônimos* (tambem chamada *lambdas*)

Em Clojure, escreve assim, usando a `fn` : 

<pre><code class="language-klipse">
    (meu-map (fn [x] (* x 3)) '(1 2 3 4 5))
</code></pre>

Tambem existe um jeito mais curto, usando o #

<pre><code class="language-klipse">
    (meu-map #(* %1 3) (range 9))
</code></pre>

Em realidade, nao precisamos definir nossa funciao "meu-map". A biblioteca padrão contem varias funções pra tratar listas com outras funções

#### Map
<pre><code class="language-klipse">
    (map (partial * 4) '(1 2 3 4 5))
</code></pre>

#### Filter 
<pre><code class="language-klipse">
    (filter (fn [x] (< x 5)) (range 10))
</code></pre>

#### Fold / Reduce
<pre><code class="language-klipse">
    (reduce * 1 '(1 2 3 4 5))
</code></pre>

#### Zip (using 

<pre><code class="language-klipse">
    (map vector (range 10) (range 10))
</code></pre>


----

Vai ao <a href="page4.html">Pagina 4</a>

.] .] .]

<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>


////page4.html
[.container [.row
[.col-md-12 
## Experimentes Visuais

<canvas id="draw1" width="700" height="400" style="background:white;">
</canvas>


<pre><code class="language-klipse">

;; http://blog.klipse.tech/omnibus/2017/04/23/omnibus-1-wallpaper.html

(defn draw-pixel! [canvas x y scale color]
  (let [ctx (.getContext canvas "2d")]
    (set! (.-fillStyle ctx) color)
    (.fillRect ctx (* scale x) (* scale y) scale scale)))

(defn reset-canvas! [canvas]
  (let [ctx (.getContext canvas "2d")]
    (set! (.-fillStyle ctx) "white")
    (.fillRect ctx 0 0 (.-width canvas) (.-height canvas))))


(let [canv (. js/document getElementById "draw1")]
  (reset-canvas! canv)
  (doseq [x (range 400)]
	  (draw-pixel! canv x x 2 "black")  )  )

</code></pre>


## Graphing a Function
<canvas id="draw2" width="700" height="400" style="background:white;">
</canvas>

<pre><code class="language-klipse">



(defn xys [n f] 
	(let [xs (range 400)
		  ys (map f xs)]
		  (zip xs ys)))

(defn mostrar! [f] 
	(let [xs (range 400)
		  ys (map f xs)
		  xys (map vector xs ys)
	      canv (. js/document getElementById "draw2")
	]
	  (reset-canvas! canv)
	  (doseq [[x y] xys]
		  (draw-pixel! canv x y 2 "black")  )  )
) 


(mostrar! #(/ %1 2))

</code></pre>



## Mosaico

<canvas id="draw3" width="700" height="400" style="background:white;">
</canvas>

<pre><code class="language-klipse">


(let [
	  xys (for [x (range 150)
	  			y (range 80)]
	  			[x y])
	  cols (cycle '("red" "darkblue" "yellow" "lightblue" "green" "purple" "aqua" "limegreen"))
	  xycs (map vector xys cols)
	  canv (. js/document getElementById "draw3") 
	 ]
	 (do
	  	 (reset-canvas! canv)
		 (doseq [[[x y] c] xycs]	  
		   (draw-pixel! canv x y 5 c) )
	 )
)

</code></pre>

----
 
  
.]
.].]


<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>




