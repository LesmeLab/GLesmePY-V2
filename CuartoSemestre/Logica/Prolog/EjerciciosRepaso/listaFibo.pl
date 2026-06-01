fibonacci(1,1).
fibonacci(2,1).
fibonacci(N,F):-N>2,N1 is N-1,N2 is N-2,fibonacci(N1, F1),fibonacci(N2, F2), F is F1 + F2.


listaFibo(F,LF):-F > 1,listaFiboRec(0,F,[],LF).

listaFiboRec(F,F,LI,LI).
listaFiboRec(X,F,LI,LF):-X < F,Y is X+1,
									  fibonacci(Y,ResultFibo),
									  agregarElemento(LI,ResultFibo,LTemp),
									  listaFiboRec(Y,F,LTemp,LF).


agregarElemento([],E,[E]).
agregarElemento([X|L1],E,[X|L3]) :- agregarElemento(L1,E,L3).
