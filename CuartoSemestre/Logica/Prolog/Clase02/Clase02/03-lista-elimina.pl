   
/* Si queremos eliminar un elemento de la lista.
% Si X es la cabeza de la lista, la cola T es la lista sin X
% Si X no es la cabeza de la lista, conservamos la cabeza de la lista 
% como parte de la respuestay continuamos eliminando X de la cola T.
*/

elimina(X,[X|T],T).
elimina(X,[H|T],[H|T1]):- elimina(X,T,T1).
 
 
/*
% Probar
% ?- elimina(1,[1,2,3,4],R).
%   R = [2,3,4]
% ?- elimina(1,R,[2,3]).
%   R = [1, 2, 3]  
%   R = [2, 1, 3]  
%   R = [2, 3, 1]
*/