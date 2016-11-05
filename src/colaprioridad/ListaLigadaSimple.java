package colaprioridad;
import javax.swing.JOptionPane;
/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que implementa una ListaLigadaSimple<T>.
 */
public class ListaLigadaSimple<T extends Comparable<T>>{
	/**
	 * Creaci�n del NodoLista que contendr� el dato y la liga.
	 */
	private NodoLista<T> inicio;
	
	/**
	 * Constructor que incializa la lista en nula.
	 */
	public ListaLigadaSimple(){
    	inicio = null;
    }
	
	/**
	 * M�todo que permite obtener el inicio de la lista.
	 * @return
	 */
	public NodoLista<T> getInicio(){
        return inicio;
    }
	
	/**
	 * M�todo que permite cambiar el inicio de la lista.
	 * @return
	 */
	public void setInicio(NodoLista<T> inicio){
		this.inicio = inicio;
	}
	
	/**
     * Este m�todo sobrescribe el m�todo toString() de la clase Object.
     * Imprime la lista con las datos de �sta misma.
     */
     
    public String toString(){
        NodoLista<T> iterador = inicio;
        String s = "";
         while( iterador != null ){ 
             s += iterador.getDato() + " --> ";
             iterador = iterador.getSiguiente(); 
         } 
         s += null;
         return s;
    }
        
    /**
     *Permite agregar un elemento al inicio de la lista.
     *@param dato
     */
	public void inserta_inicio(T dato){
        NodoLista<T> nuevo = new NodoLista<T>(dato);
        nuevo.setSiguiente(inicio);
        inicio = nuevo;
    }
	
    /**
     *Permite agregar un elemento al final de la lista.
     *@param dato
     */
	public void inserta_final(T dato){
        NodoLista<T> temporal = inicio;
        if(inicio == null)
        	inserta_inicio(dato);
        else{
             while(temporal.getSiguiente() != null)
                   temporal = temporal.getSiguiente();
             temporal.setSiguiente(new NodoLista<T>(dato));
        }        
    }
	
    /**
     *M�todo que permite recorrer la lista de inicio a fin.
     */
	public String recorreIterativo(){
    	NodoLista<T> temporal = inicio;
    	String s = "";
    	while(temporal != null){
    		s += temporal.getDato() + " --> ";
    		temporal = temporal.getSiguiente();
    	}
    	s += "null";
		return s;
    }
	
    /**
     *M�todo que permite recorrer la lista recursivamente, es decir, 
     *llam�ndose el mismo m�todo dentro de �ste mismo pero con el NodoLista siguiente.
     *@param dato
     */
     
	public String recorreRecursivo(NodoLista<T> p){
		String s = "";
    	if(p != null){
    		s += ((NodoLista<T>) p).getDato() + " --> ";
    		//System.out.println(p.getDato());
    		recorreRecursivo(((NodoLista<T>)p).getSiguiente());
    	}
    	s += "null";
    	return s;
    }
	
    /**
     *M�todo que permite agregar un elemento antes de otro que se desee.
     *@param dato, referencia
     */
     
	public void inserta_antes_de(T dato, T referencia){
        NodoLista<T> temporal = inicio, NodoListaEncontrado = null, nuevo;
        Boolean band = true;
        while(temporal.getDato() != referencia && band)
              if(temporal.getSiguiente() != null){
                  NodoListaEncontrado = temporal;
                  temporal = temporal.getSiguiente();
              }else
                  band = false;
                  
        if(band)
           if(temporal == inicio)
        	   inserta_inicio(dato);
           else{
               nuevo = new NodoLista<T>(dato);
               nuevo.setSiguiente(temporal);
               NodoListaEncontrado.setSiguiente(nuevo);
            }              
    }
	
    /**
     *M�todo que permite agregar un elemento despu�s de otro que se desee.
     *@param dato, referencia
     */
     
	public void inserta_despues_de(T dato, T referencia){
        NodoLista<T> temporal = inicio, nuevo;
        Boolean band = true;
        while(temporal.getDato() != referencia && band)
              if(temporal.getSiguiente() != null)
                 temporal = temporal.getSiguiente();
              else
                 band = false;
        
        if(band)
           if(temporal == inicio)
        	   inserta_inicio(dato);
           else{
               nuevo = new NodoLista<T>(dato);
               nuevo.setSiguiente(temporal.getSiguiente());
               temporal.setSiguiente(nuevo);
           }
    }
	
    /**
     *M�todo que, al insertar elementos, permite que �stos se agreguen de manera descendente.
     *@param dato
     */
     
	public void inserta_ordenado(T dato){
        NodoLista<T> temporal = inicio, NodoListaEncontrado = null, nuevo;
        Boolean band = true;
        
        if(inicio == null)
        	inserta_inicio(dato);
        else{
           while((dato.compareTo(temporal.getDato()))<0 && band)
                 if(temporal.getSiguiente() != null){
                    NodoListaEncontrado = temporal;
                    temporal = temporal.getSiguiente();
                }else
                    band = false;
                    
           if(band)
              if(temporal == inicio)
            	  inserta_inicio(dato);
              else{
                 nuevo = new NodoLista<T>(dato);
                 nuevo.setSiguiente(temporal);
                 NodoListaEncontrado.setSiguiente(nuevo);
              }
           else
        	   inserta_final(dato);
        }
    }
	
    /**
     *M�todo que elimina el primer elemento de la lista.
     *@return dato
     */
     
	public T elimina_primero(){
		T dato = null;
		if(inicio.getSiguiente() != null){
			dato = inicio.getDato();
			inicio = inicio.getSiguiente();
		}
		else 
			inicio = null;
		return dato;
	}
	
	public T eliminaInicioDevolviendo(){
        NodoLista<T> temporal = inicio;
        try{
            if(temporal.getSiguiente() != null)
                inicio = temporal.getSiguiente();
                else
                inicio = null;
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Lista vac�a");
        }
        return temporal.getDato();
    }
    
    /**
     *M�todo que elimina el �ltimo elemento de la lista.
     *@return dato
     */
     
	public T elimina_ultimo(){
        NodoLista<T> temporal = inicio, anterior = null;
        T dato = null;
        try{
            if(inicio.getSiguiente() == null)
               inicio = null;
               else{
                   while(temporal.getSiguiente() != null){
                       anterior = temporal;
                       dato = temporal.getDato();
                       temporal = temporal.getSiguiente();
                    }                
                    anterior.setSiguiente(null);
            }     
        }catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Lista vac�a.");
        }
		return dato;
    }
	
    /**
     *M�todo que permite la eliminaci�n del elemento que se desee.
     *@param dato
     */
     
	public T elimina_elemento(T dato){
		NodoLista<T> aux = inicio, temp = null;
		Boolean band = true;
		
		try{			
			while(aux.getDato() != dato & band)
				if(aux.getSiguiente() != null){
					temp = aux;
					aux = temp.getSiguiente();
				}else
					band = false;
			
			if(band){
				if(inicio == aux)
					inicio = aux.getSiguiente();
				else
					temp.setSiguiente(aux.getSiguiente());
			}else
					JOptionPane.showMessageDialog(null, "El elemento no se encuentra en la lista.");
		}catch(NullPointerException e){
            JOptionPane.showMessageDialog(null,"Lista vac�a");
        }
		return aux.getDato();
	}
	
    /**
     *M�todo que permite la eliminaci�n del elemento est� antes del referenciado. 
     *@param dato
     */
     
	public T elimina_antes(T dato){
		NodoLista<T> temp = inicio, aux = inicio, aux2 = null;
		Boolean band =true;
		
		try{
			if(inicio.getDato() == dato)
			JOptionPane.showMessageDialog(null,"No existe un NodoLista que preceda al que se desea eliminar");
			else{
				while(temp.getDato() != dato && band)
					if(temp.getSiguiente() != null){
						aux2 = aux;
						aux = temp;
						temp = temp.getSiguiente();
					}else
						band = false;
			}
		
			if(band)
				if(inicio.getSiguiente() == temp) //El elemento a eliminar es el primero
					inicio = temp;
				else
					aux2.setSiguiente(temp);
			else
				JOptionPane.showMessageDialog(null,"El elemento no se encuentra en la lista");
		}catch(NullPointerException e){
			JOptionPane.showMessageDialog(null,"Lista vac�a");
		}
		return aux.getDato();
	}
	
    /**
     *M�todo que permite la b�squeda de un elemento en una lista que no est� ordenada.
     *@param dato
     */
     
	public T busca_desordenado(T dato){
		NodoLista<T> aux = inicio;
		T d = null;
		while(aux != null && aux.getDato() != dato){
			d = aux.getDato();
			aux = aux.getSiguiente();
		}
		
		if(aux == null)
//			JOptionPane.showMessageDialog(null, "El elemento NO se encuentra en la lista");
			return null;
		return d;
//		else
//			JOptionPane.showMessageDialog(null, "El elemento S� se encuentra en la lista");
	}
	
    /**
     *M�todo que permite la b�squeda de un elemento en una lista que se orden� previamente.
     *@param dato
     */
	public void busquedaOrdenada(T dato){
		NodoLista<T> aux = inicio;
		while(aux != null && (aux.getDato().compareTo(dato)<0))
			aux = aux.getSiguiente();
		
		if(aux == null || (aux.getDato().compareTo(dato)>0))
			JOptionPane.showMessageDialog(null,"El elemento NO se encuentra en la lista");
		else
			JOptionPane.showMessageDialog(null, "El elemento S� se encuentra en la lista");
	}
	
	/**
     *M�todo que permite la b�squeda de un elemento en una lista de forma recursiva.
     *@param dato
     */
     
	public T busca_rescursivo(NodoLista<T> nodito, T dato){
		NodoLista<T> nuevo = nodito;
		if(nuevo == null)
			if(nodito.getDato().compareTo(dato) == 0)
				JOptionPane.showMessageDialog(null, "El elemento se encuentra en la lista.");
			else
				busca_rescursivo(nodito.getSiguiente(),nodito.getSiguiente().getDato());
		else
			JOptionPane.showMessageDialog(null,"El elemento NO se encuentra en la lista.");
		return nuevo.getDato();
	}
	
    /**
     *M�todo que permite obtener el dato en la posici�n deseada de la lista.
     *@param posicion
     */
     
	public T obtenDatoEnPosicion(Integer posicion) {
    	Integer cont = 0;
    	T dato = null;
    	NodoLista<T> aux = inicio;
    	try{
    		while(aux != null){
    			if(cont == posicion)
    				dato = aux.getDato();
    			else{
    				aux = aux.getSiguiente();
    				cont++;
    			}
    		}
    	}catch(NullPointerException npe){
    		JOptionPane.showMessageDialog(null, "Lista vac�a.");
    	}
		return dato;
	}
	

    public void eliminaPrimero2(){
        if (inicio != null)
            inicio = inicio.getSiguiente();
    }
    
    /**
     * M�todo que permite buscar un elemento en la lista ligada, devolviendo el nodo que lo contiene.
     * @param m
     * @return
     */
    public NodoLista<T> busca (T m){
        NodoLista <T> temporal = inicio;
        Boolean band = true;
        while(temporal.getDato().compareTo(m)!=0 && band&& temporal!=inicio)
        {
            if(temporal.getSiguiente()!= null)
            {
                temporal = temporal.getSiguiente();
            }else 
                band = false;
        }
        
        if(band)
            return temporal;
        else
            return null;
    }
    
    /**
     * M�todo que permite saber el tama�o de la lista ligada.
     * @return
     */
    public Integer longitud(){
        Integer elementos = 0;
        NodoLista<T> aux = inicio;
        while(aux != null){
              elementos++;
              aux = aux.getSiguiente();
        }                 
        return elementos;
    }
    
    /**
     * Prueba de la clase.
     * @param args
     */
	public static void main(String[] args) {
		ListaLigadaSimple<Integer> list = new ListaLigadaSimple<Integer>();
		list.inserta_inicio(42);
		list.inserta_inicio(22);
		list.inserta_final(1);
		list.inserta_final(2);
		list.inserta_antes_de(43, 1);
		list.inserta_ordenado(23);
		list.inserta_ordenado(36);
		System.out.println(list);
	}	
}