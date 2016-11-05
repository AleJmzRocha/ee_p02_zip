package colaprioridad;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que permite implementar una cola de prioridad con una lista simplemente ligada.
 */
public class ColaPrioridad<T extends Comparable<T>>{
	/**
	 * Atributo cola que ser� de tipo lista ligada.
	 */
    private ListaLigadaSimple<T> cola = new ListaLigadaSimple<T>();
    
    /**
     * M�todo que obtiene el inicio de la cola.
     * @return
     */
    public NodoLista<T> getInicio(){
    	return cola.getInicio();
    }
    
    /**
     * M�todo que permite insertar de manera ordenada a la cola de prioridad.    
     * @param dato
     */
    public void insertar(T dato){
        cola.inserta_ordenado(dato);
    }
    
    /**
     * M�todo que permite eliminar un elemento de la cola de prioridad.
     * @return
     */
    public T retirar(){
        return cola.eliminaInicioDevolviendo();
    }
}