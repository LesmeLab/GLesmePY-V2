

/** 
Problema1:
-----------
Con estas relaciones y afirmaciones entre sospechoso(X), antecedentes(N,X) 
y perseguido(X) queremos saber si una persona es o no culpable.
Para que X sea culpable debe ser: 
Sospechoso, Tener mas de 4 antecedentes y NO Perseguido.
*/

sospechoso(pedro).
sospechoso(arturo).
sospechoso(marcelo).
sospechoso(guardia).
sospechoso(funcionario).

antecedentes(6,pedro).
antecedentes(5,arturo).
antecedentes(1,guardia).
antecedentes(8,funcionario).

perseguido(guardia).
perseguido(funcionario).

es_culpable(X):-sospechoso(X),antecedentes(N,X),N>4,not(perseguido(X)).
es_culpable(jose).
es_culpable(ana).
es_culpable(tomas).


/**
Problema2:
-----------
**/

  estudiante(luis).  
  estudiante(juan).  
  
  informatico(luis). 
  
  hobby(X,musica) :- 
    informatico(X), 
    estudiante(X).  
  

/** Probar hobby(X,musica), para saber a quién no le gusta la música como hobby. **/

