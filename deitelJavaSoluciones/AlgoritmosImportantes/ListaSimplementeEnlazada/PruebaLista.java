//Prueba de Lista

public class PruebaLista{
	public static void main(String [] args){
		ListaSimplementeEnlazada<Integer> lista = new ListaSimplementeEnlazada<>("Lista1");
		
		lista.insertAtFront(-1);
		lista.print();
		lista.insertAtFront(0);
		lista.print();
		lista.insertAtBack(1);
		lista.print();
		lista.insertAtBack(5);
		lista.print();
		
		try{
			int itemRemovido = lista.removeFromFront();
			System.out.printf("%n%d removido%n", itemRemovido);
			lista.print();
			
			itemRemovido = lista.removeFromFront();
			System.out.printf("%n%d removido%n", itemRemovido);
			lista.print();
			
			itemRemovido = lista.removeFromFront();
			System.out.printf("%n%d removido%n", itemRemovido);
			lista.print();
			
			itemRemovido = lista.removeFromFront();
			System.out.printf("%n%d removido%n", itemRemovido);
			lista.print();
		}
		catch (EmptyListException emptyListException){
			emptyListException.printStackTrace();
		}
	}
}