
footer=Copyright Phil Jones, 2017
projectname=Introdução ao Clojure
bootswatch=slate
head_extra=<link rel="stylesheet" type="text/css" href="http://app.klipse.tech/css/codemirror.css">
final_js=
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

* 1.1 - Traduze esta expressão em Lisp e avalia no seu computador

<pre><code>   
    3 * (5 + 9)
</code></pre>
   
<pre><code class="language-klipse">
; Escreve aqui
</code></pre>

* 1.2 - E isso?

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

* 2.1 - Escrever um teste se a primeiro 4 caracteres de uma string saos iguais.

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

* 3.1 - Criar um função que receber dois argumentos strings e responde se eles tem as primeiros 4 caracteres iguais.

Eg. 

<pre><code>	
    (comp4 "askhkjasdhk" "askhbhdifdsbkfbkdsjb") -> true
    (comp4 "askhfdfsdkfbksdj" "lhsdlfsbdk") -> false
</code></pre>

<pre><code class="language-klipse">
; Escreve aqui
</code></pre>


* 3.2 - Adaptar sua função pra receber as dois argumentos e um numero n e teste as primeiros n caracteres.

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

* 4.1 - Escreve um função que troca os segundos elementos dos duas listas. Por exemplo :

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

### Exercício 5.

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

### Exercício 6

* 6.1 - Escrever um funciao que calcular o raiz quadrada de cada elemento duma lista utilizando o `map` proprio do Clojure. Raiz quadrada 'e `(.sqrt js/Math 3)` 

<pre><code class="language-klipse">

</code></pre>

O funciao `iterate` cria um sequencia infinita com um valor inicial `x` e o funciao, `f` e produz um sequence x f(x) (f (f x)) (f (f (f x))) etc.

<pre><code class="language-klipse">

(take 10 (iterate #(+ % 1) 0))
</code></pre>

* 6.2 - Escrever um funciao que produz o sequence '(1 4 7 10 13 16 19 22 25 ...)

<pre><code class="language-klipse">

</code></pre>

* 6.3 - Escrever um funciao *rqs* que produz a lista preguisoza (possivalmente infinito) de numeros com suas raizes quadrados. eg. 

<pre>
(rqs) -> ([0 0]
 [1 1]
 [2 1.4142135623730951]
 [3 1.7320508075688772]
 [4 2]
 [5 2.23606797749979]
 [6 2.449489742783178]
 [7 2.6457513110645907] 
 [8 2.8284271247461903] 
 [9 3] ... )
</pre>

<pre><code class="language-klipse">

(take 40 (rqs))

</code></pre>

* 6.3 - Escrever um funciao de ordenacao duma lista como "quicksort" utilizando `filter` e recursividade.

<pre><code class="language-klipse">

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



### Exercício 7

* 7.1 - O que que 'e o estrutura de dados que represente este imagem

* 7.2 - Modar o programa de "mosaico" pra fazer um padrao "checkerboard" :

![Aqui](https://fxfactory.com/downloads/docs/noiseindustries/fxfactorypro/Thumbnails/Checkerboard.jpg) 


* 7.3 - Modar o programa de "mosaico" pra fazer um padrao mais interesante.

* 7.4 - Escreve um funciao "histograma" que receber uma lista de dados tipo '(["maca" 43023] ["pera" 14389] ["banana" 866437] ... ) e desenha um histograma, ordenada pela o valor numerico. (Como escreve texto no canvas : https://www.w3schools.com/graphics/canvas_text.asp )

Pode usar esta canvas (chamada "draw4")

<canvas id="draw4" width="700" height="400" style="background:white;">

</canvas>


<pre><code class="language-klipse">



</code></pre>
 
----

Vai ao <a href="page5.html">Pagina 5</a> 
  
.]
.].]


<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>

////page5.html

[.container [.row 
[.col-md-12

## Maps

### Keywords 

Comecam com : e sao muito utilizadas comos chaves de maps / estruturas.

<pre><code class="language-klipse">

(let [s {:a 1 :b 2 :c 3}]
	(get s :a) )

</code></pre>


O Clojure pode utilizar uma `keyword` como um funciao pra extrai um valor duma map. 

<pre><code class="language-klipse">

(let [s {:a 1 :b 2 :c 3}]
	(:b s) )

</code></pre>

Pegar as chaves com `keys`

<pre><code class="language-klipse">

(let [s {:a 1 :b 2 :c 3}]
	(keys s) )

</code></pre>

Podemos estrair as valores duma map com *destructuring* 

<pre><code class="language-klipse">

(let [s {:a 1 :b 2 :c 3}
      f (fn [{:keys [a b c]}] (str "a=" a " b=" b " c=" c))]
	(f s)
)

</code></pre>


Podemos sobre-escreve um valor 

<pre><code class="language-klipse">

(let [s {:a 1 :b 2 :c 3}
     s2 (conj s {:c 4})  ]
(:c s2) )

</code></pre>


### Exercício 8

* 8.1 Escreve um programa que atualizar qualquer senha menos do que 8 caracteres com algumas caracteres extra, eg. "123" -> "123preciso-um-senha-maior"

<pre><code class="language-klipse">

(let [usuarios [{:nome "paolo" :senha "123"} {:nome "fred" :senha "vbub2k4agsA a"} {:nome "moema" :senha "issoEMeuSenhaDeVerdade"} {:nome "wallace" :senha "senha" }]]
  
)
</code></pre>

----

Vai ao <a href="page6.html">Pagina 6</a> 


.] .] .]

<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>


////page6.html

[.container [.row 
[.col-md-12

## Install Leiningen

[https://leiningen.org/](https://leiningen.org/)

<pre><code>

lein new cl1

cd cl1

</code></pre>

Edita *project.clj*

<pre><code>

(defproject cl1 "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]

  :aot [cl1.core]
  :main cl1.core
  )
</code></pre>


Edita *src/cl1/core.clj*

<pre><code>
(ns cl1.core)

(defn f [x] (* x x x))

(defn -main [& args]
  (println (map f (range 100)))
  )
</code></pre>

Executar

<pre><code>
lein run
</code></pre>


Ou no repl

<pre><code>
lein repl

(load "core")

(in-ns "cl1.core")

(map f (range 100))

</code></pre>

### Exercício 9

* 9.1 - Cria um arquivo chamada "teste.csv"

<pre>
mes, banana, laranja, pera
jan, 432, 542, 564
fev, 52, 46, 874
mar, 434, 54, 76
abr, 345, 342, 655
mai, 53, 32, 54
jun, 764, 453, 734
</pre>

## Lendo arquivos 

Le um arquivo com `slurp`

<pre><code>

(slurp "teste.csv")

</code></pre>

Podemos cortar as strings com `split`

<pre><code>

(split "algumas palavras separadas pelas espacos" #"")

</code></pre>

Obs : #" " 'e notacao de *expressoes regulares* (Regex) que sao utilizadas pela `split`.

Podemos ler um arquivo CSV e convertar pra um estrutura de dados representando uma tabela assim :

<pre><code>

(defn tab [t]
  (let [lines (str/split t #"\n")
        dadas (rest lines)
        f-linha (fn [l] (let [xs (str/split l #",\s+")]
                         {:mes (first xs) :d (rest xs)}))]
    {:heads (first lines)
     :linhas (map f-linha dadas)})
  )

(defn -main [& args]
  (let [data (slurp "teste.csv")
        tabulo (tab data)
        ]
    (println tabulo))
  )

</code></pre>

* 9.1a - Atualizar sua programa como este exemplo acima e comprovar voce pode imprimir seu arquivo.csv
* 9.2 - Adicionar um funciao pra imprimir o tabelo em HTML eg.

<pre><code>
&lt;table>
&lt;tr>&lt;th>mes&lt;/th>&lt;th>banana&lt;/th> ... &lt;/tr>
&lt;tr>&lt;td>jam&lt;/td>
...

&lt;/table>
</code></pre>

* 9.3 - Crie uma funçião que, quando dada uma tabela, calcula a soma e a média de cada coluna. (Se voce preferir reorganizar seu representacao da tabela fica a vontage)

* 9.4 - Pode adicionar funciones pra calcular o máximo e mínimo dos colunas.

## Exploracao de dados abertos

* 9.5 - Procura alguma arquivo CSV interesante no [http://dados.gov.br/](http://dados.gov.br/) baixa, escreve um programa que fazer alguma analysis destes dados.

----

<a href="page7.html">Proxima</a>

.] .] .]

<script>
    window.klipse_settings = {
        selector: '.language-klipse'// css selector for the html elements you want to klipsify
    };
</script>
<script src="http://app.klipse.tech/plugin/js/klipse_plugin.js"></script>

//// page7.html

[.container [.row
[.col-md-12 

## FigWheel 

**(Ambient "Hot" de desenvolvemento ClojureScript)**


[GitHub do FigWheel](https://github.com/bhauman/lein-figwheel)

O FigWheel ja esta integrada com Leiningen.

### Criar um projeto de FigWheel com Reagent 

[Reagent](https://reagent-project.github.io/) 'e uma das envelopes de [React.js](https://facebook.github.io/react/) utilizando pela ClojureScript)

<pre><code>

lein new figwheel hello-world -- --reagent

cd hello-world
 
</code></pre>


Dentro o hello-world vai encontrar duas arquivos importantes : 

 * project.clj
 * src/hello-world/core.cljs
 
O `project.clj` esta a configuracao do projeto. Neste momento, nao precisamos mexer com ele.

### Interacao e Animacao

Olha [o projeto](https://github.com/calangohc/tutclojure/tree/master/rfw) que adicionei no [GitHub deste tutorial](https://github.com/calangohc/tutclojure)

O codigo do exemplo de animacao interativo esta no src/hello-world/core.cljs

<script src="http://gist-it.appspot.com/https://github.com/calangohc/tutclojure/blob/master/rfw/src/cljs/rfw/core.cljs"></script>

Executar o App : 

<pre><code>

git clone https://github.com/calangohc/tutclojure/ tc
cd tc/rfw
lein clean
lein figwheel

</code><pre>


.] .] .]
