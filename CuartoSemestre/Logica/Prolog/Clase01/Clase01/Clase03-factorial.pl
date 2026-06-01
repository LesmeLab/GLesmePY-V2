/* 2 - Programa que calcula el Factorial de un Nº */
  
factorial(1,1).

factorial(N,F):-N>0,T is N-1,factorial(T,K),F is N*K.


