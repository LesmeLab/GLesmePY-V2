% sumatoria(N,R)
% Recibe un número N, retorna en R la suma de todos los números enteros naturales entre 1 - N. 
% Ej: sumatoria(5,R). R=15. Puede utilizar predicados - variables adicionales.


sumar(N,N,Acumulado,R):-R is Acumulado + N.

sumar(M,N,Acumulado,R):-Acumuladosig is Acumulado + M, Msig is M + 1, sumar(Msig,N,Acumuladosig,R),!.

sumatoria(N,R):- sumar(1,N,0,R).
