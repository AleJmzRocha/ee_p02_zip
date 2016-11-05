package colaprioridad;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que permite implementar un NodoLista<T>.
 * @param <T>
 */
public class NodoLista<T extends Comparable<T>>{
	/**
	 * Tendr� como atributos de la clase: Dato que tendr� el nodo.
	 * 									  Siguiente que es una referencia que aputar� al nodo que sigue. 
	 */
    private T dato;
    private NodoLista <T> siguiente;
    
    /**
     * Constructor que permite generar un NodoLista<T> con un dato como par�metro.
     * @param dato
     */
    public NodoLista(T dato){
        this.dato = dato;
        siguiente = null;
    }
    
    /**
     * M�todo get que devuelve el dato contenido en el NodoLista<T>.
     * @return
     */
    public T getDato(){
        return dato;
    }
    
    /**
     * M�todo set que permite la modificaci�n del dato contenido en el NodoLista<T>.
     * @param dato
     */
    public void setDato(T dato){
        this.dato = dato;
    }
    
    /**
     * M�todo get que devuelve la referencia del siguiente.
     * @return
     */
    public NodoLista <T> getSiguiente(){
        return siguiente;
    }
    
    /**
     * M�todo set que permite cambiar la referencia al siguiente NodoLista<T>.
     * @param siguiente
     */
    public void setSiguiente(NodoLista <T> siguiente){
        this.siguiente = siguiente;
    }
    
    /**
     * M�todo toString() sobreescrito de la clase Object.    
     */
    public String toString(){
        return dato + "-->";
    }
}
