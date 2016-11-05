package archivo;
/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * Clase que permite guardar el archivo comprimido y descomprimido.
 */

import javax.swing.*;
import java.io.*;
public class Guardar{
	
	/**
	 * M�todo que guarda el �rbol binario y el mensaje original en binario comprimido.
	 * @param mensaje
	 * @param raiz
	 */
    public static void guardarArchivo(String mensaje, String raiz){
        try{       
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(fileChooser);
            File file = fileChooser.getSelectedFile();
            if(file != null){
                FileWriter fw = new FileWriter(file + ".txt");
                fw.write(raiz + "| ");
                fw.write("\n");
                fw.write(mensaje);
                fw.close();
                System.out.println("Archivo guardado en: " + file + ".txt");
            }
        }
        catch(IOException e){
        	System.out.println("Fallo al guardar " + e);
        }
    }
    
    /**
     * Metodo que guarda el archivo descomprimido.
     * @param cadena
     */
    public static void guardarArchivo(String cadena){
        try{       
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showSaveDialog(fileChooser);
            File file = fileChooser.getSelectedFile();
            if(file != null){
                FileWriter fw = new FileWriter(file + ".txt");
                fw.write(cadena);
                fw.close();
                System.out.println("Archivo guardado en: " + file + ".txt");
            }
        }
        catch(IOException e){
            System.out.println("Fallo al guardar " + e);
        }
    }
}