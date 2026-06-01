
/* Predicado que retorna recibe una lista y retorna otra lista con las vocales */
/* Caso base */
retornar_vocales([],[]).

/* Si existe cola y la cabeza es vocal: llama recursivamente y agregar a la lista */
retornar_vocales([H|T],LFinal):-vocal(H),retornar_vocales(T,LTemp),agregarElemento(H,LTemp,LFinal).

/* Si existe cola y la cabeza no es vocal: llama recursivamente */
retornar_vocales([H|T],LTemp):-not(vocal(H)),retornar_vocales(T,LTemp).

/* Predicado que valida (true) a los caracteres que son vocales */
vocal(a).
vocal(e).
vocal(i).
vocal(o).
vocal(u).


/* Predicado auxiliar: Programa que agrega un elemento al final de una lista  */ 
agregarElemento(E,[],[E]).
agregarElemento(E,[H|T],[H|R]):-agregarElemento(E,T,R).

