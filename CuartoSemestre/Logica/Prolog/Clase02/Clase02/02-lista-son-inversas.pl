

 /* Consultar si son inversas */
 
inver(L1,L2):-inver(L1,L2,[]).
 /** inver(L1,L2,R) Realiza la inversion de L1 en R **/

inver([],L,L).
/** inver(L1,L2,R) Cuando se vacie L1 [] entonces debe quedar que L2 = R **/


inver([H|T],L,S):-inver(T,L,[H|S]).
 /** inver(L1,L2,R) Realiza la inversion de la primera lista L1 en S **/


 
 
 