package arbolbinario;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase que permite la implementación de un NodoArbol<T>.
 * @param <T>
 */
public class NodoArbol<T extends Comparable<T>> implements Comparable<NodoArbol<T>>{
	/**
	 * Sus atributos serán: Dato que contiene el NodoArbol<T>.
	 * 						Referencias hacia izquierda y derecha.
	 */
	private T dato;
	private NodoArbol<T> izquierda, derecha;
	
	/**
	 * Constructor que pide como parámetro el dato a insertar e inicializa izquierda y derecha en nulas.
	 * @param dato
	 */
	public NodoArbol(T dato){
		this.dato = dato;
		this.izquierda = derecha = null;
	}
	
	/**
	 * Método get que devuelve el dato contenido en el nodo.
	 * @return
	 */
	public T getDato() {
		return dato;
	}
	
	/**
	 * Método set que permite modificar el dato que está contenido en el nodo.
	 * @param dato
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * Método get que retorna la referencia izquierda, siendo ésta un NodoArbol<T>.
	 * @return
	 */
	public NodoArbol<T> getIzquierda() {
		return izquierda;
	}
	
	/**
	 * Método set que permite hacer la modificación de la referencia izquierda.
	 * @param izquierda
	 */
	public void setIzquierda(NodoArbol<T> izquierda) {
		this.izquierda = izquierda;
	}
	
	/**
	 * Método get que retorna la referencia derecha, siendo ésta un NodoArbol<T>.
	 * @return
	 */
	public NodoArbol<T> getDerecha() {
		return derecha;
	}
	
	/**
	 * Método set que permite hacer la modificación de la referencia derecha.
	 * @param derecha
	 */
	public void setDerecha(NodoArbol<T> derecha) {
		this.derecha = derecha;
	}
	
	/**
	 * Método toString() sobreescrito de la clase Object.
	 */
	@Override
	public String toString(){
		String s = "";
		s += this.getDato();
		return s;
	}
    
	/**
	 * Método sobreescrito de la implementación de la interfaz Comparable<T>.
	 */    
	@Override
	public int compareTo(NodoArbol<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}