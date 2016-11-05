package ventana;
import javax.swing.*;
import archivo.*;
import java.awt.event.*;
import java.io.*;

/**
 * @authors Martínez Carrera Dulce Carolina
 * 			Martínez Hernández Gabriela
 * 			Sánchez Lázcares Perla Melina
 * 			Jiménez Rocha Alejandra
 * 
 * @credits JF Programación
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
     * En la opción comprimir genera el botón: Guardar archivo.
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
    
    //getAbsolutePath() devuelve la dirección absoluta, es decir referida a la raíz del disco
    /**
     * Permite agregarle una acción a cada botón del menú.
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
        		System.out.println("Ocurrió un error.");
       	}
    }
    
    /**
     * Clase interna que permite realizar la acción de guardar archivo.
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
         * Agrega una acción al botón: Guardar archivo.
         */
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button)
            	arbol.comprimir(arbol.getRecorrido());
        }
    }
    /**
     * Ejecuta la clase menú.
     * @param args
     */
    public static void main(String[] args){
        Menu ventana = new Menu();
        ventana.setVisible(true);
    }    
}