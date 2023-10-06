package Ejercicio5;

import java.io.*;
import java.util.ArrayList;

/**
 * Programa para comprimir archivos y carpetas.
 *
 */
public class Ejercicio5{

    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String ruta = System.getProperty("user.dir");
        String rutaComprimir = "../PROG08_Tarea2021_22_Solucion";
        File fComprimir = new File(rutaComprimir);
        String rutaZIP = ruta+"/recursos";
        //ESTO ES LO ÚNICO QUE TENÉIS QUE MODIFICAR
        String nombreZIP = "Diaz_Gutierrez_Helio_PROG08_Tarea.zip";
        
        // Variables de salida
        
        // Variables auxiliares
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
	System.out.println ("COMPRIMIENDO LA TAREA");
	System.out.println ("---------------------");
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------

        UtilidadDirectorios directorios = new UtilidadDirectorios();
        
        /* Directorio a recorrer; directorio de salida; nombre del archivo */
        directorios.zip(fComprimir, rutaZIP, nombreZIP);
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println ();
	System.out.println ("RESULTADO");
	System.out.println ("---------");
	System.out.printf ("Archivo comprimido correctamente: %s\n", 
                rutaZIP + File.separator + nombreZIP);

    }
}
