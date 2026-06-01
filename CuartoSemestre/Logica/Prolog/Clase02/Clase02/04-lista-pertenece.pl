/*
%   Comprobar si un elemento X pertenece a la Lista
*/

pertenece(X,[X|_]) :- !.
pertenece(X,[_|R]):- pertenece(X,R). 

/*
Probar
?- pertenece(b,[a,b,c]).
   Yes
?- pertenece(b,[a,[b,c]]).
   No
?- pertenece([b,c],[a,[b,c]]).
   Yes
   
   */
