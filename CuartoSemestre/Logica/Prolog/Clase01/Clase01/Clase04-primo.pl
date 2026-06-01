
/* Programa para saber si un numero es o no primo */ 

primo(2).  /* Por definicion 2 es primo */
primo(T):-K is T-1,primo2(T,K).

primo2(_,1).
primo2(N,I):-nodiv(N,I),H is I-1,primo2(N,H).

nodiv(X,Y):-W is X rem Y,not(W=0).
