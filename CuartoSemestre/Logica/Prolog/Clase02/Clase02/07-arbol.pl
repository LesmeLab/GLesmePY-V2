/*
 Recibe como argumento un término y determina
 si éste corresponde a un árbol binario válido. 
*/
 
arbolBin(#).
arbolBin(tree(R,Hi,Hd)):- arbolBin(Hi), arbolBin(Hd).

/* Consultar lo siguiente:

?- arbolBin(tree(a,tree(b,#,#),#)).
Debe dar = yes
?- arbolBin(tree(a, a, #)).

Debe dar = no

**/