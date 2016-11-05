package arbolbinario;

/**
 * 
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 *
 * Clase que implementa un Arbol Binario.
 * @param <T>
 */
public class ArbolBinario <T extends Comparable<T>>{
	/**
	 * Tiene una raíz, que es el comienzo del árbol de tipo NodoArbol<T>.
	 */
	private NodoArbol<T> raiz;
	
	/**
	 * Implementación del constructor que incializa la raíz en nula.
	 */
	public ArbolBinario(){
		raiz = null;
	}

	/**
	 * Método get que obtiene la raíz.
	 * @return
	 */
	public NodoArbol<T> getRaiz() {
		return raiz;
	}

	/**
	 * Método set que permite modificar la raíz.
	 * @param raiz
	 */
	public void setRaiz(NodoArbol<T> raiz) {
		this.raiz = raiz;
	}
	
	/**
	 * Método que permite saber la altura del arbol binario.
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
	 * Método que permite recorrer el árbol de manera prefija.
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
	 * Método que permite recorrer el árbol de manera infija.
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
	 * Método que permite recorrer el árbol de manera posfija.
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