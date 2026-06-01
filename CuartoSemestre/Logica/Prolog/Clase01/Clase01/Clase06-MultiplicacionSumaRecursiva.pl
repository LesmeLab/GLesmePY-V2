
multi(A,B,R):-mu(A,B,B,R).

mu(A,B,1,A).

mu(A,B,Cont,Acum):-C is Cont -1,mu(A,B,C,AcumRec),Acum is AcumRec+ A.

