veces(_,[],0).

veces(X,[X|L],C):-veces(X,L,C1),C is C1 + 1.

veces(X,[Y|L],C):-not(X==Y),veces(X,L,C).
