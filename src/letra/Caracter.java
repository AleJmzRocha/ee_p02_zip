package letra;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que permite implementar un caracter del c�digo ASCII. 
 */
public class Caracter implements Comparable<Caracter>{
	/**
	 * Atributos de la clase: Caracter contenido.
	 * 						  Su valor en binario del caracter. 
	 * 						  El n�mero de veces que aparecer� en nuestro archivo de texto.
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
     * el caracter y el n�mero de veces que se repite en el texto.
     * @param caracter
     * @param frecuencia
     */
    public Caracter(String caracter, Integer frecuencia){
        this.caracter = caracter;
        this.frecuencia = frecuencia;
    }
    
    /**
     * M�todo set que permite modificar el caracter.
     * @param caracter
     */
    public void setCaracter(String caracter){
    	this.caracter = caracter;
    }
    
    /**
     * M�todo get que devuelve el caracter.
     * @return
     */
    public String getCaracter(){
        return caracter;
    }
    
    /**
     * M�todo set que permite cambiar el valor en binario del caracter.
     * @param binario
     */
    public void setBinario(String binario){
    	this.binario = binario;
    }
    
    /**
     * M�todo get que retorna el valor en binario del caracter.
     * @return
     */
    public String getBinario(){
        return binario;
    }
    
    /**
     * M�todo get que devuelve el n�mero de veces que se repite el caracter, es decir, la frecuencia.
     * @return
     */
    public Integer getFrecuencia(){
        return frecuencia;
    }
    
    /**
     * M�todo set que permite modificar la frecuencia del caracter. 
     * @param frecuencia
     */
    public void setFrecuencia(Integer frecuencia){
    	this.frecuencia = frecuencia;
    }
    
    /**
     * M�todo toString() sobreescrito de la clase Object.
     */
    public String toString(){
        return caracter + " : " + binario + "\n" + caracter + " : " + frecuencia;
    }

    /**
     * M�todo compareTo() sobreescrito de la implementaci�n de la interface Comparable<T>.
     */
	@Override
	public int compareTo(Caracter o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}