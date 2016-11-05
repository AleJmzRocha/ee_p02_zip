package archivo;
import java.io.*;
import colaprioridad.*;
import arbolbinario.*;
import letra.*;
/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que permite generar el Arbol Binario con las letras.
 */
public class ArbolCaracteres{
	/**
	 * Atributos de la clase.
	 */
	private BufferedReader br;
	Character letra = 0;
    private Character[] caracteres = new Character[256];
	String arbolBinario = "", recorrido = "";	
    private ColaPrioridad <NodoArbol<Caracter>> cola;   
    private ListaLigadaSimple <Caracter> frecuencias, valor;
    
    /**
     * Constructor que incializa las listas y la cola de prioridad a utilizar.
     */
    public ArbolCaracteres(){
    	frecuencias = new ListaLigadaSimple<Caracter>();
    	valor = new ListaLigadaSimple<Caracter>();
    	cola = new ColaPrioridad <NodoArbol<Caracter>>();
    }
	
    /**
     * M�todo get que permite devolver la cola de prioridad.    
     * @return
     */
	public ColaPrioridad<NodoArbol<Caracter>> getCola() {
		return cola;
	}

	/**
	 * M�todo set que permite modificar la cola de prioridad.
	 * @param cola
	 */
	public void setCola(ColaPrioridad<NodoArbol<Caracter>> cola) {
		this.cola = cola;
	}

	/**
	 * M�todo que permite el llenado de un arreglo con los s�mbolos del c�digo ASCII. 
	 * @return
	 */
	public Character[] simbolos(){
		for(int i = 0; i <= 255 ; i++)
			caracteres[i] = letra++;
		return caracteres;
	}
/**
 * M�todo de lectura del archivo y conteo de frecuencias de cada caracter para insertarlo en la cola de prioridad.
 * @param file
 */
    public void leerArchivo(String file){
    	simbolos();
    	recorrido = file;
        int frecuencia[] = new int[256];
        try{
            br = new BufferedReader(new FileReader(file));
            String s = br.readLine();
            while (s != null){
                for (int i = 0; i < s.length(); i++){
                    for(int j = 0; j < caracteres.length;j++)
                        if(s.charAt(i) == caracteres[j])
                        	frecuencia[j] += 1;
                }
                s = br.readLine();
            }
            
            for (int i = 0; i < frecuencia.length; i++){
                if(frecuencia[i] > 0){
                	frecuencias.inserta_ordenado(new Caracter(caracteres[i] + "", frecuencia[i]));
                    cola.insertar(new NodoArbol<Caracter> (new Caracter(caracteres[i] + "", frecuencia[i])));
                }
            }
        } catch(IOException e){
            System.out.println("Error al leer el archivo");
        }
        finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("Error al intentar cerrar el archivo");
            }
        }
    }
    
    /**
     * M�todo en donde se suman las frecuencias para crear la ra�z del �rbol e insertando el mismo en la cola de prioridad, creando as� el �rbol mismo.
     */
    public void sumarFrecuencias(){
        NodoArbol <Caracter> izquierda, derecha, raiz;
        izquierda = new NodoArbol<Caracter>(null);
        derecha = new NodoArbol<Caracter>(null);
        raiz = new NodoArbol<Caracter>(null);
        
        while (cola.getInicio().getSiguiente()!=null){   
            izquierda = cola.retirar();
            derecha = cola.retirar();
            raiz.setDato(new Caracter (null, izquierda.getDato().getCaracter() + derecha.getDato().getCaracter()));
            raiz.setDerecha(derecha);
            raiz.setIzquierda(izquierda);
            cola.insertar(raiz);
            raiz = new NodoArbol<Caracter>(null);
        }   
    }
    
    /**
     * M�todo para recorrer el �rbol asignando 0 para izquierda y 1 para derecha.
     * @param raiz
     * @param direccion
     */    
    public void preorden(NodoArbol<Caracter> raiz, String direccion){
        if(raiz != null){
            String unos = direccion;
            if(raiz.getIzquierda()==null&&raiz.getDerecha()==null){
            	arbolBinario += direccion + raiz.getDato().getCaracter();
                valor.inserta_final(new Caracter(raiz.getDato().getCaracter(), direccion));
            }
            preorden(raiz.getIzquierda(), direccion += "0");
            preorden(raiz.getDerecha(), unos += "1");
        }
    }
    
    
    
    /**
     * M�todo que lee un archivo permitiendo comprimirlo y guardarlo.
     * @param file
     */
    public void comprimir(String file){
        try{
            br = new BufferedReader(new FileReader(file));
            String s = br.readLine(), mensaje = "", aux = "";
            NodoLista<Caracter> temporal = valor.getInicio();
            while (s != null){
                for(int i = 0; i < s.length();i++){
                    while (temporal != null){
                        aux = s.charAt(i)+"";
                        if(aux.equals(temporal.getDato().getCaracter()))
                        	mensaje += temporal.getDato().getBinario();
                        aux = "";
                        temporal = temporal.getSiguiente();
                    }
                    temporal = valor.getInicio();
                }
                s = br.readLine();
            }
            Guardar.guardarArchivo(mensaje, arbolBinario);
        } catch(IOException e) {
            System.out.println("Error al leer el archivo.");
        }
        finally{
            try{
                br.close();
            }catch(Exception e){
                System.out.println("Error al intentar cerrar el archivo.");
            }
        }
    }

    /**
     * M�todo get que permite devolver la cadena generada al recorrer el �rbol.
     * @return
     */
    public String getRecorrido() {
		return recorrido;
	}

    /**
     * M�todo que permite modificar la cadena generada al recorrer el �rbol.
     * @param recorrido
     */
	public void setRecorrido(String recorrido) {
		this.recorrido = recorrido;
	}

	/**
     * M�todo que descomprime el archivo reconstruyendo el mensaje original.
     * @param cadena
     */
    public void descomprimir(String cadena){
        try {
            br = new BufferedReader(new FileReader(cadena));
            String s = br.readLine(), auxiliar = "";
            String arbol = s, mensajeReconstruido = "";
            s = br.readLine();
            while (s != null){
                auxiliar += s;
                s = br.readLine();
            }
            mensajeReconstruido = reconstruirMensaje(reconstruirArbol(arbol), auxiliar);
            Guardar.guardarArchivo(mensajeReconstruido);
        } catch(IOException e){
            System.out.println("Error al leer el archivo");
        }
        finally{
            try {
                br.close();
            }catch(Exception e){
                System.out.println("Error al leer el archivo");
            }
        }
    }
    /**
     *M�todo que permite recorre el �rbol, que, dependiendo del valor que tenga se ir� por izquierda o derecha entontrando el car�cter.
     * @param arbol
     * @return
     */
    public NodoArbol<String> reconstruirArbol(String arbol){
        NodoArbol <String> nuevo = new NodoArbol<String>(null), aux = nuevo;
        for(int i = 0;i < arbol.length();i++){
            if(arbol.charAt(i)=='|'){
                break;
            }else
            	if(arbol.charAt(i)=='0'){
            		if(aux.getIzquierda() == null){
            			aux.setIzquierda(new NodoArbol<String>(""));
            			aux = aux.getIzquierda();
            		}else
            			aux = aux.getIzquierda();
            	}else
            		if(arbol.charAt(i)=='1'){
            			if(aux.getDerecha()==null){
            				aux.setDerecha(new NodoArbol<String>(""));
            				aux = aux.getDerecha();
            			}else
            				aux = aux.getDerecha();
            		}else
            			if(arbol.charAt(i) != '0' && arbol.charAt(i) != '1'){
            				aux.setDato(arbol.charAt(i) + "");
            				aux = nuevo;
            			}
        }
        return nuevo;
    }
    /**
     * M�todo que permite recorrer el �rbol, analiz�ndolo y permitiendo la reconstrucci�n del mensaje original.
     * @param raiz
     * @param cadena
     * @return
     */
    public String reconstruirMensaje(NodoArbol<String> raiz, String cadena){
        NodoArbol<String> aux = raiz;
        String mensaje = "";
        for(int i = 0; i < cadena.length(); i++){
            if(cadena.charAt(i) == '0'){
                if(aux.getIzquierda() != null){
                    aux = aux.getIzquierda();
                    if(aux.getDerecha() == null && aux.getIzquierda()==null){
                        mensaje += aux.getDato();
                        aux = raiz;
                    }
                }             	
            }else
            	if(cadena.charAt(i) == '1'){
            		if(aux.getDerecha() != null){
            			aux = aux.getDerecha();
            			if(aux.getDerecha() == null && aux.getIzquierda() == null){
            				mensaje += aux.getDato();
            				aux = raiz;
            			}
            		}            	
            	}
        }
        return mensaje;
    }
}