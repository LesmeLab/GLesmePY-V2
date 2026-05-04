//ListaSimplementeEnlazada

public class ListaSimplementeEnlazada<T>{
	private NodoLista<T> firstNodo;
	private NodoLista<T> lastNodo;
	private String name;
	private int longitud = 0;
	
	public ListaSimplementeEnlazada(String listName){
		name = listName;
		firstNodo = lastNodo = null;
	}
	
	public void insertAtFront(T insertarItem){
		if (isEmpty()){
			firstNodo = lastNodo = new NodoLista<T>(insertarItem);
		} else {
			firstNodo = new NodoLista<T>(insertarItem, firstNodo);
		}
		
	}
	
	public void insertAtBack(T insertarItem){
		if (isEmpty()){
			firstNodo = lastNodo = new NodoLista<T>(insertarItem);
		}else{
			lastNodo.setNextNodo(new NodoLista<T>(insertarItem));
			lastNodo = lastNodo.getNextNodo();
		}
	}
	
	public T removeFromFront() throws EmptyListException {
		if(isEmpty()){
			throw new EmptyListException(name);
		}
		T itemRemovido = firstNodo.getDato();
		
		if (firstNodo == lastNodo){
			firstNodo = lastNodo = null;
		}else{
			firstNodo = firstNodo.getNextNodo();
		}
		return itemRemovido;
	}
	
	public T removeFromBack() throws EmptyListException{
		if (isEmpty()){
			throw new EmptyListException(name);
		}
		T itemRemovido = lastNodo.getDato();
		
		if (firstNodo == lastNodo){
			firstNodo = lastNodo = null;
		}else{
			NodoLista<T> current = firstNodo;
			while(current.getNextNodo() != lastNodo){
				current = current.getNextNodo();
			}
			lastNodo = current;
			current.setNextNodo(null);
		}
		return itemRemovido;
	}
	
	public boolean isEmpty(){
		return firstNodo == null;
	}
	
	public void print(){
		if(isEmpty()){
			System.out.printf("Empty %s%n", name);
			return;
		}
		
		System.out.printf("The %s is: ", name);
		NodoLista<T> current = firstNodo;
		
		while(current != null){
			System.out.printf("%s ", current.getDato());
			current = current.getNextNodo();
		}
		System.out.println();
	}
}