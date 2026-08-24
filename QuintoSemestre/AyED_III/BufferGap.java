
//import Iterator,Iterable,Random, Scanner;
public class BufferGap<E>{
	//datos Internos
	private final int TAM_INICIAL = 16;
	private E[] datos;
	private int inicioHueco;
	private int finHueco;
	private long desplazamientos;
	
	//metodos
	public BufferGap(){
		this.datos = new E[TAM_INICIAL];
		this.inicioHueco =0;
		this.finHueco = TAM_INICIAL;
	}
	
	public void insertar(E obj){
		//?
	}
	
	public E borrar(){
		//
	}
	
	public void moverCursor(int delta){
		//?
	}
	
	public int posicionCursor(){
		//?
	}
	
	public E get(int index){
		//?
	}
	
	public E set(E obj, int index){
		//?
	}
	
	public int size(){
		return datos.length() - finHueco + inicioHueco;
	}
	
	public int capacidad(){
		return datos.length;
	}
	
	public long desplazamientos(){
		//?
	}
	
	public void reiniciarDesplazamientos(){
		desplazamientos = 0;
	}
	
	public Iterator<E> iterator(){
		//?Iterable
	}
	
	public String toString(){
		
	}
}