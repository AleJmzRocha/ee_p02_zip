package ventana;
import javax.swing.*;
import archivo.*;
import java.awt.event.*;
import java.io.*;

/**
 * @authors Mart�nez Carrera Dulce Carolina
 * 			Mart�nez Hern�ndez Gabriela
 * 			S�nchez L�zcares Perla Melina
 * 			Jim�nez Rocha Alejandra
 * 
 * @credits JF Programaci�n
 * 			Madrugador2010
 * 			discoduroderoer.es 
 * Clase que permite hacer la interfaz del programa.
 */
public class Menu extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
    private JMenu despliegue;
    private JMenuItem salir, compresion, restaurar;
    private JFileChooser fileChooser = new JFileChooser();
    File f, file;
    ArbolCaracteres arbol = new ArbolCaracteres();
        
    /**
     * Permite generar la ventana que contiene las opciones de comprimir, descomprimir y salir.
     * En la opci�n comprimir genera el bot�n: Guardar archivo.
     */
    public Menu(){
        setLayout(null);
        setBounds(20,20,200,150);
        setTitle("Huffman");
        
        menu = new JMenuBar();
        setJMenuBar(menu);
        despliegue = new JMenu("Archivo");
        menu.add(despliegue);
        
        compresion = new JMenuItem("Comprimir");
        despliegue.add(compresion);
        compresion.addActionListener(this);
        
        restaurar = new JMenuItem("Descomprimir");
        despliegue.add(restaurar);
        restaurar.addActionListener(this);
        
        salir = new JMenuItem("Salir");
        despliegue.add(salir);
        salir.addActionListener(this);
    }
    
    //getAbsolutePath() devuelve la direcci�n absoluta, es decir referida a la ra�z del disco
    /**
     * Permite agregarle una acci�n a cada bot�n del men�.
     */
    public void actionPerformed(ActionEvent e){
        try{
            if (e.getSource() == salir) 
                System.exit(0);
            else
            	if (e.getSource() == compresion){
            		fileChooser.showOpenDialog(null);
            		f = fileChooser.getSelectedFile();
            		arbol.leerArchivo(f.getAbsolutePath());
            		arbol.sumarFrecuencias();
            		arbol.preorden(arbol.getCola().retirar(),"");
            		Ventana v = new Ventana(f.getAbsolutePath(),arbol);
            		v.setVisible(true);
            	}else
            		if (e.getSource() == restaurar){
            			fileChooser.showOpenDialog(null);
            			file = fileChooser.getSelectedFile();
            			arbol.descomprimir(file.getAbsolutePath());
            		}
        	}catch(NullPointerException npe){
        		System.out.println("Ocurri� un error.");
       	}
    }
    
    /**
     * Clase interna que permite realizar la acci�n de guardar archivo.
     */
    class Ventana extends JFrame implements ActionListener{
    	private static final long serialVersionUID = 1L;
        private JButton button;
        ArbolCaracteres arbol; 
        
        /**
         * Constructor de la clase, donde se encuentran las propiedades de la ventana para guardar el archivo.
         * @param carpeta
         * @param arbol
         */        
        public Ventana(String carpeta, ArbolCaracteres arbol){
        	this.arbol = arbol;
            setLayout(null);
            setBounds(60,100,200,120);
            setResizable(false);
            
            button = new JButton("Guardar archivo");
            button.setBounds(20,30,150,30);
            button.addActionListener(this);
            add(button);
        }
        
        /**
         * Agrega una acci�n al bot�n: Guardar archivo.
         */
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button)
            	arbol.comprimir(arbol.getRecorrido());
        }
    }
    /**
     * Ejecuta la clase men�.
     * @param args
     */
    public static void main(String[] args){
        Menu ventana = new Menu();
        ventana.setVisible(true);
    }    
}