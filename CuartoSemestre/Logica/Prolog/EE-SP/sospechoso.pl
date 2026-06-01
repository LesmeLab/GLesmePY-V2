/*sospechoso(X),antecedentes(N,X),perseguido(X)
 * X es culpable si
 * Es sospechoso y tiene mas de 4 antecedentes y no es perseguido
 * */

sospechoso(carlos).
sospechoso(ivan).
sospechoso(adela).

antecedentes(14,carlos).
antecedentes(2,ivan).
antecedentes(5,adela).

perseguido(adela).

culpable(X):-sospechoso(X),antecedentes(N,X),N>4,not(perseguido(X)).