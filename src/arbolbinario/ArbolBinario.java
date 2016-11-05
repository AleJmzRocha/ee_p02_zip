package arbolbinario;

/**
 * 
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 *
 * Clase que implementa un Arbol Binario.
 * @param <T>
 */
public class ArbolBinario <T extends Comparable<T>>{
	/**
	 * Tiene una ra�z, que es el comienzo del �rbol de tipo NodoArbol<T>.
	 */
	private NodoArbol<T> raiz;
	
	/**
	 * Implementaci�n del constructor que incializa la ra�z en nula.
	 */
	public ArbolBinario(){
		raiz = null;
	}

	/**
	 * M�todo get que obtiene la ra�z.
	 * @return
	 */
	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	/**
	 * M�todo set que permite modificar la ra�z.
	 * @param raiz
	 */
	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	
	/**
	 * M�todo que permite saber la altura del arbol binario.
	 * @param raiz
	 * @param altura
	 * @return
	 */
	public Integer altura(NodoArbol<T> raiz, Integer altura){
        altura += 1;
        Integer izquierda, derecha;
        if (raiz != null){
            System.out.println("El nivel del nodo: " + raiz.getDato() + " es: " + altura);
            izquierda = altura(raiz.getIzquierda(), altura);
            derecha = altura(raiz.getDerecha(),altura);
         }else
             return -1;
        
        if (izquierda > derecha)
          return izquierda += 1;
        else
          return derecha += 1; 
    }
	
	/**
	 * M�todo que permite recorrer el �rbol de manera prefija.
	 * @param raiz
	 */
    public void preorden(NodoArbol <T> raiz){
        if(raiz!=null){
        	System.out.println(raiz.getDato());
            preorden(raiz.getIzquierda());
            preorden(raiz.getDerecha());
        }
    }
        
    /**
	 * M�todo que permite recorrer el �rbol de manera infija.
	 * @param raiz
	 */
    public void inorden(NodoArbol <T> raiz){
        if(raiz != null){   
            inorden(raiz.getIzquierda());
            System.out.println(raiz.getDato());
            inorden(raiz.getDerecha());
        }
    }
    
    /**
	 * M�todo que permite recorrer el �rbol de manera posfija.
	 * @param raiz
	 */
    public void posorden(NodoArbol <T> raiz){
        if(raiz != null){
            posorden(raiz.getIzquierda());
            posorden(raiz.getDerecha());
            System.out.println(raiz.getDato());
        }
    }
}