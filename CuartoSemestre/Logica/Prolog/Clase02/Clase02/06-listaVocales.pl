/*	Ej 1
  imprimir_vocales(lista) 
 Imprima todos los elementos de una lista que no sean consonantes. 
 Debe ser exitoso para toda lista, asumiendo que 
 solo contengan vocales y consonantes y que no sean listas anidadas
*/
imprimir_vocales([]).
imprimir_vocales([H|T]):- vocal(H),write(H),imprimir_vocales(T).
imprimir_vocales([H|T]):- not(vocal(H)),write('-'),imprimir_vocales(T).
vocal(a).
vocal(e).
vocal(i).
vocal(o).
vocal(u).
  
/* Ej 2
   vocales(lista1,Lista2)
   Recibe una lista y retorna una nueva lista que contenga solo las vocales que aparezcan en la primera lista. 
*/

retornar_vocales([],[]).
retornar_vocales([H|T],[H|Resto]):-vocal(H),retornar_vocales(T,Resto).
retornar_vocales([H|T],Resto):-not(vocal(H)),retornar_vocales(T,Resto).



/*
 Ej 3
	lista_de_pos_pares(lista1,Lista2)
	Recibe una lista y retorna una nueva lista formada por los 
	elementos de posiciones pares del la primera lista.

lista_de_pos_pares([],[]).
lista_de_pos_pares([X],[]).
lista_de_pos_pares([X,Y|T],[Y|Resto]):- lista_de_pos_pares(T,Resto).
*/