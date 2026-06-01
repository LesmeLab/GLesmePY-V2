/****
Divisores
*/

divisor(N,P) :- P>0, N>P, 0 is N mod P,!.

listaDivisores(F,LF):-F > 1,listaDivisoresRec(0,F,[],LF).

listaDivisoresRec(F,F,LI,LI).
listaDivisoresRec(X,F,LI,LF):-X < F,Y is X+1,divisor(F,X),
									agregarElemento(LI,X,LTemp),
									listaDivisoresRec(Y,F,LTemp,LF).
									
listaDivisoresRec(X,F,LI,LF):-X < F,Y is X+1,not(divisor(F,X)),
									listaDivisoresRec(Y,F,LI,LF).

agregarElemento([],E,[E]).
agregarElemento([X|L1],E,[X|L3]) :- agregarElemento(L1,E,L3).
