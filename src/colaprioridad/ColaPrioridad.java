package colaprioridad;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase que permite implementar una cola de prioridad con una lista simplemente ligada.
 */
public class ColaPrioridad<T extends Comparable<T>>{
	/**
	 * Atributo cola que será de tipo lista ligada.
	 */
    private ListaLigadaSimple<T> cola = new ListaLigadaSimple<T>();
    
    /**
     * Método que obtiene el inicio de la cola.
     * @return
     */
    public NodoLista<T> getInicio(){
    	return cola.getInicio();
    }
    
    /**
     * Método que permite insertar de manera ordenada a la cola de prioridad.    
     * @param dato
     */
    public void insertar(T dato){
        cola.inserta_ordenado(dato);
    }
    
    /**
     * Método que permite eliminar un elemento de la cola de prioridad.
     * @return
     */
    public T retirar(){
        return cola.eliminaInicioDevolviendo();
    }
}