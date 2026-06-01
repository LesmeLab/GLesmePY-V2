%Ejercicio A
%Adaptar el ejercicio 1 de la clase 1 de Prolog para
%incluir a miembros de familia,
%utilizar como hecho datos de madre,
%formular las reglas completas para: (abuelo, abuela, 
% bisabuelo/a, hermano/a, primo/a, tio/a);
%formula la regla de pariente(X,Y),
%realice varios tipos de consultas al interprete de 
%Prolog que incluyan su nombre, adjunte las capturas
%de pantalla de las ejecuciones.

%padre(papá,hijo)
padre(eladio,gustavo).
padre(eladio,noelia).
padre(eladio,carlos).
padre(eladio,ivan).
padre(heladio,eladio).
padre(justo,patricia).
padre(bisabueloP,heladio).
padre(bisabueloP2,matilde).
padre(bisabueloM,justo).
padre(bisabueloM2,emiliana).

%madre(mama,hija)
madre(patricia,gustavo).
madre(patricia,noelia).
madre(patricia,carlos).
madre(patricia,ivan).
madre(matilde,eladio).
madre(emiliana,patricia).
madre(bisabuelaP,matilde).
madre(bisabuelaP2,heladio).
madre(bisabuelaM,emiliana).
madre(bisabuelaM2,justo).



%Regla abuelos ya incluye a paternos y maternos
abuelos(A,N):-abuelo(A,N);abuela(A,N).
abuelo(A,N):- (padre(A,T),padre(T,N));(padre(A,R),madre(R,N)).
abuela(A,N):- (madre(A,Y),madre(Y,N));(madre(A,P),padre(P,N)).

%Regla bisabuelos ya incluye a bisabuelos paternos y maternos
bisabuelos(B,N):- bisabuelo(B,N);bisabuela(B,N).
bisabuelo(B,N):- (abuelo(B,P),padre(P,N));(abuelo(B,M),madre(M,N)).
bisabuela(B,N):- (abuela(B,M),madre(M,N));(abuela(B,P),padre(P,N)).

%Regla hermanos
hermano(X,Y):-padre(A,X),padre(A,Y),X\=Y.


primo(X,Y):-abuelo(A,X),abuelo(A,Y),padre(P1,X),padre(P2,Y),P1\=P2.
%tio(Tio,Sobrino):-abuelo(A,Sobrino),padre(A,Tio),not(padre(Tio,Sobrino)).

%es_tio(X):-tio(X,_).

