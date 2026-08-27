
//import Iterator,Iterable,Random, Scanner;
public class BufferGap<E> implements Iterable{
	//datos Internos
	private final int TAM_INICIAL = 16;
	private E[] datos;//Arreglo estatico de tipo E inicialmente de tamanho TAM_INICIAL  = 16
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
		if (inicioHueco < finHueco){
			datos[inicioHueco]=obj;
			inicioHueco++;
		}else if (inicioHueco == finHueco){
			if (finHueco == datos.length){
				E[] datosAnt = datos;
				datos = new E[datos.length];
				finHueco = datos.length;
				
				//funcion for-each para copiar solo valores validos <AQUI>
				
				datos[inicioHueco] = obj;
				inicioHueco;
			}else{
				E[] datosAnt = datos;
				datos = new E[datos.length];
				
				//funcion for-each para copiar solo valores validos, y que respete el hueco
				//idea: que haga desde la izq y luego a la derecha --> hueco <---
				
				datos[inicioHueco] = obj;
				inicioHueco++;
				
				//finHueco se queda a la misma distancia de datos.length que antes de agrandar (con el valor nuevo)
			}
		}
		
		
		
		if (finHueco-inicioHueco > 0){
			datos[inicioHueco]=obj;
			inicioHueco++;
		}
		
		//hueco agotado?
		if (finHueco == datos.length){
			if (finHueco == inicioHueco){
				E[] datosAnt = datos;
				datos = new E<>[datosAnt.length*2];
			}
			
			//for each para copiar los datos
		}else if (){
			
		}
	}
	
	public E borrar(){
		
	}
	
	public void moverCursor(int delta){
		if (delta == 0){
			break;
		}
		//derecha
		if (inicioHueco+delta>=datos.length && delta>0){
			
		}
		
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