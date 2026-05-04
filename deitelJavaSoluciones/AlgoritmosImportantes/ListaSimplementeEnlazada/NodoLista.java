//NodoLista(Generico)
//NodoLista y clase Lista

public class NodoLista<T>{
	private T dato;
	private NodoLista<T> nextNodo;
	
	public void setDato(T dato){
		this.dato = dato;
	}
	
	public T getDato(){
		return dato;
	}
	
	public void setNextNodo(NodoLista<T> nextNodo){
		this.nextNodo = nextNodo;
	}
	
	public NodoLista<T> getNextNodo(){
		return nextNodo;
	}
	
	public NodoLista(T object){
		this(object, null);
	}
	
	public NodoLista(T object, NodoLista<T> nodo){
		setDato(object);
		setNextNodo(nodo);
	}
}