/* es_miembro(Elem,Lista) <- el término Elem pertenece a la lista Lista */
es_miembro(X,[X|_]).
es_miembro(X,[_|Y]) :- es_miembro(X,Y).

/* nel(Lista,N) <- el número de elementos de la lista Lista es N */
nel([],0).
nel([_|Y],N) :- nel(Y,M),
                N is M+1.

/* es_lista(Lista) <- Lista es una lista */
es_lista([]).
es_lista([_|_]).


/* Maximo de una lista, retorna en el 2 argumento */ 
maximo([X],X).
maximo([X|Xs],X):- maximo(Xs,Y), X >=Y.
maximo([X|Xs],N):- maximo(Xs,N), N >= X.

/* Minimo de una lista, retorna en el 2 argumento */ 
minimo([X],X).
minimo([X|Xs],X):- minimo(Xs,Y), X =< Y.
minimo([X|Xs],N):- minimo(Xs,N), N < X.


/* concatena(L1,L2,L3) <- concatenación de las listas L1 y L2 dando lugar a L3 */
concatena([],L,L).
concatena([X|L1],L2,[X|L3]) :- concatena(L1,L2,L3).


/* * - Programa que agrega un elemento al final de una lista  */ 
agregarElemento(E,[],[E]).
agregarElemento(E,[H|T],[H|R]):-agregarElemento(E,T,R).


/* * - Programa invierte una lista */
invertir([],[]).
invertir([X|Xs],A):-invertir(Xs,S),agregarElemento(S,X,A).



