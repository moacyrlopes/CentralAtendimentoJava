Resposta 1:
Ana deve ser atendida primeiro, pois ela foi a primeira cliente a entrar na fila.
O quarto atendimento deverá ser realizado pelo Guichê 1.
Deve ser recuperado primeiro o último atendimento realizado, porque o histórico usa uma pilha, que segue o princípio LIFO: o último elemento que entra é o primeiro 
que sai. 


Cada dupla deve preencher:
  ESTRUTURA:
- fila(fifo),  
-Pilha(lifo) 
-e por último, Fila circular.

JUSTIFICATIVA: 
-Os clientes devem ser atendidos na ordem em que chegaram.
- A última operação realizada deve ser a primeira a ser recuperada ao utilizar a opção desfazer .
-Os guichês trabalham continuamente na sequência 1 -  2 -  3 - 1. 

PERGUNTA TESTE A:

Carlos não poderia ser atendido primeiro porque quem chega é organizado utilizando uma fila FIFO, o primeiro que  entrar na fila deve ser o primeiro a ser atendido. Como Ana entrou antes de Bruno e Carlos, Ana foi atendida primeiro. 


PERGUNTA FINAL: 

A fila foi utilizada para organizar os clientes que aguardam ser chamados , respeitando a ordem de chegada.

A pilha foi utilizada para armazenar o histórico dos atendimentos, pra conseguir recuperar a última operação realizada com a opção de desfazer.

 A fila circular foi utilizada para fazer o “rodízio” entre os três guichês. Dessa forma, após utilizar um guichê, ele retorna ao final da estrutura. 
