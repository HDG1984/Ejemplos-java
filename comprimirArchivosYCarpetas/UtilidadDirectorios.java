package Ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class UtilidadDirectorios {

    /**
     * Lista donde se almacenan los diferentes archivos y carpetas existentes en un directorio
     */
    private ArrayList vector;

    /**
     * Método constructor.
     */
    public UtilidadDirectorios() {
        vector = new ArrayList();
    }

    /**
     * Método que comprime una carpeta.
     * @param directorio Ruta del archivo o carpeta a comprimir.
     * @param salida Ruta donde ubicar el archivo comprimido.
     * @param nombreFichero Nombre del archivo comprimido.
     */
    public void zip(File directorio, String salida, String nombreFichero) {
        // Ruta relativa del archivo de salida
        String outFilename = salida + File.separator + nombreFichero;
        
        // Indicación de la ruta absoluta donde se va a generar el archivo zip
        System.out.println("Generando archivo comprimido zip: ");
        System.out.println("zip-->" + directorio.getAbsolutePath());

        // Comprobamos si había un zip de algún intento anterior y lo borramos
        String zipAntiguoName = directorio.getAbsolutePath() + File.separator + outFilename;       
        File   zipAntiguoFile = new File(zipAntiguoName);
        try {
            if (zipAntiguoFile.exists()) { // Si el archivo existe, se borra
                System.out.printf("\nBorrando el anterior zip: %s\n", zipAntiguoName);
                zipAntiguoFile.delete();
            }
        } catch (SecurityException ex) {  // Control ante una posible excepción de seguridad (abortamos el proceso)
            System.out.printf("No se pudo borrar el zip anterior. Aborte proceso y borre manualmente.\n");
            System.exit(-1);
        }

        // Procedemos a aplicar el algoritmo recursivo de compresión
        byte[] buf = new byte[1024];
        vector.clear();
        listar(directorio);
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outFilename));
            System.out.println ("\nSe han empaquetado los siguientes archivos:");
            System.out.println(vector);
            for (int i = 0; i < vector.size(); i++) {
                FileInputStream in = new FileInputStream("" + vector.get(i));
                out.putNextEntry(new ZipEntry("" + vector.get(i)));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método recursivo que va explorando los archivos y carpetas de una carpeta dada.
     * @param dir Arhivo a comprimir.
     */
    private void listar(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                listar(new File(dir, children[i]));
            }
        } else {
            vector.add(dir);
        }
    }
}