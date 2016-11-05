package colaprioridad;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase que permite implementar un NodoLista<T>.
 * @param <T>
 */
public class NodoLista<T extends Comparable<T>>{
	/**
	 * Tendrá como atributos de la clase: Dato que tendrá el nodo.
	 * 									  Siguiente que es una referencia que aputará al nodo que sigue. 
	 */
    private T dato;
    private NodoLista <T> siguiente;
    
    /**
     * Constructor que permite generar un NodoLista<T> con un dato como parámetro.
     * @param dato
     */
    public NodoLista(T dato){
        this.dato = dato;
        siguiente = null;
    }
    
    /**
     * Método get que devuelve el dato contenido en el NodoLista<T>.
     * @return
     */
    public T getDato(){
        return dato;
    }
    
    /**
     * Método set que permite la modificación del dato contenido en el NodoLista<T>.
     * @param dato
     */
    public void setDato(T dato){
        this.dato = dato;
    }
    
    /**
     * Método get que devuelve la referencia del siguiente.
     * @return
     */
    public NodoLista <T> getSiguiente(){
        return siguiente;
    }
    
    /**
     * Método set que permite cambiar la referencia al siguiente NodoLista<T>.
     * @param siguiente
     */
    public void setSiguiente(NodoLista <T> siguiente){
        this.siguiente = siguiente;
    }
    
    /**
     * Método toString() sobreescrito de la clase Object.    
     */
    public String toString(){
        return dato + "-->";
    }
}
