package arbolbinario;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que permite la implementaci�n de un NodoArbol<T>.
 * @param <T>
 */
public class NodoArbol<T extends Comparable<T>> implements Comparable<NodoArbol<T>>{
	/**
	 * Sus atributos ser�n: Dato que contiene el NodoArbol<T>.
	 * 						Referencias hacia izquierda y derecha.
	 */
	private T dato;
	private NodoArbol<T> izquierda, derecha;
	
	/**
	 * Constructor que pide como par�metro el dato a insertar e inicializa izquierda y derecha en nulas.
	 * @param dato
	 */
	public NodoArbol(T dato){
		this.dato = dato;
		this.izquierda = derecha = null;
	}
	
	/**
	 * M�todo get que devuelve el dato contenido en el nodo.
	 * @return
	 */
	public T getDato() {
		return dato;
	}
	
	/**
	 * M�todo set que permite modificar el dato que est� contenido en el nodo.
	 * @param dato
	 */
	public void setDato(T dato) {
		this.dato = dato;
	}
	
	/**
	 * M�todo get que retorna la referencia izquierda, siendo �sta un NodoArbol<T>.
	 * @return
	 */
	public NodoArbol<T> getIzquierda() {
		return izquierda;
	}
	
	/**
	 * M�todo set que permite hacer la modificaci�n de la referencia izquierda.
	 * @param izquierda
	 */
	public void setIzquierda(NodoArbol<T> izquierda) {
		this.izquierda = izquierda;
	}
	
	/**
	 * M�todo get que retorna la referencia derecha, siendo �sta un NodoArbol<T>.
	 * @return
	 */
	public NodoArbol<T> getDerecha() {
		return derecha;
	}
	
	/**
	 * M�todo set que permite hacer la modificaci�n de la referencia derecha.
	 * @param derecha
	 */
	public void setDerecha(NodoArbol<T> derecha) {
		this.derecha = derecha;
	}
	
	/**
	 * M�todo toString() sobreescrito de la clase Object.
	 */
	@Override
	public String toString(){
		String s = "";
		s += this.getDato();
		return s;
	}
    
	/**
	 * M�todo sobreescrito de la implementaci�n de la interfaz Comparable<T>.
	 */    
	@Override
	public int compareTo(NodoArbol<T> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}