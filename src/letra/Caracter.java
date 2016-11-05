package letra;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * Clase que permite implementar un caracter del código ASCII. 
 */
public class Caracter implements Comparable<Caracter>{
	/**
	 * Atributos de la clase: Caracter contenido.
	 * 						  Su valor en binario del caracter. 
	 * 						  El número de veces que aparecerá en nuestro archivo de texto.
	 */
    private String caracter;
    private String binario;
    private Integer frecuencia;
        
    /**
     * Constructor que permite generar un caracter con su valor en tipo binario.
     * @param caracter
     * @param binario
     */
    public Caracter(String caracter, String binario){
        this.caracter = caracter;
        this.binario = binario;
    }
    
    /**
     * Sobrecarga de contructor.
     * Constructor que permite generar un caracter con su frecuencia, es decir, 
     * el caracter y el número de veces que se repite en el texto.
     * @param caracter
     * @param frecuencia
     */
    public Caracter(String caracter, Integer frecuencia){
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }
    
    /**
     * Método set que permite modificar el caracter.
     * @param caracter
     */
    public void setCaracter(String caracter){
    	this.caracter = caracter;
    }
    
    /**
     * Método get que devuelve el caracter.
     * @return
     */
    public String getCaracter(){
        return caracter;
    }
    
    /**
     * Método set que permite cambiar el valor en binario del caracter.
     * @param binario
     */
    public void setBinario(String binario){
    	this.binario = binario;
    }
    
    /**
     * Método get que retorna el valor en binario del caracter.
     * @return
     */
    public String getBinario(){
        return binario;
    }
    
    /**
     * Método get que devuelve el número de veces que se repite el caracter, es decir, la frecuencia.
     * @return
     */
    public Integer getFrecuencia(){
        return frecuencia;
    }
    
    /**
     * Método set que permite modificar la frecuencia del caracter. 
     * @param frecuencia
     */
    public void setFrecuencia(Integer frecuencia){
    	this.frecuencia = frecuencia;
    }
    
    /**
     * Método toString() sobreescrito de la clase Object.
     */
    public String toString(){
        return caracter + " : " + binario + "\n" + caracter + " : " + frecuencia;
    }

    /**
     * Método compareTo() sobreescrito de la implementación de la interface Comparable<T>.
     */
	@Override
	public int compareTo(Caracter o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}