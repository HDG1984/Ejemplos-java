/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.RasterFormatException;
import java.io.*;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

/**
 * Programa para trabajar con imágenes.
 * @profesorado
 */
public class Ejercicio4 {

    /**
    * Método principal.
    */
    public static void main(String[] args) {
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String rutaF1 = System.getProperty("user.dir") + "/recursos/foto.png";
        String rutaF2 = System.getProperty("user.dir") + "/recursos/foto2.png";
        // Variables de salida
      
        
        // Variables auxiliares
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        try{
            //ImageInputStream archivoImagen = ImageIO.createImageInputStream(rutaF1);
           // ImageInputStream archivoImagen = new ImageInputStream(rutaF1);
            BufferedImage bufferImagen = ImageIO.read(new File(rutaF1));
            int anchoImg = bufferImagen.getWidth();
            int altoImg = bufferImagen.getHeight();
            System.out.println(anchoImg);
            System.out.println(altoImg);
            String dibujo = "";
            for(int i=0; i<altoImg; i++){   
                for(int j=0; j<anchoImg; j++){
                    Color c = new Color(bufferImagen.getRGB(j,i));
                    if(c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 255){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }
            System.out.println();
            }
        }catch(IOException e){
            
        }
        
            
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
         
        
        System.out.println ();
	System.out.println ("Archivo cerrado y procesamento finalizado");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
}
