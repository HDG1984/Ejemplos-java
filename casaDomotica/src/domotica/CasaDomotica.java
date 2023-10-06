package domotica;

import domotica.Domotica;
import domotica.dispositivos.Activable;
import domotica.dispositivos.Bombilla;
import domotica.dispositivos.Cerradura;
import domotica.dispositivos.Dispositivo;

/**
 * Clase que representa una casa domótica con distintos tipos de dispositivos.
 * @author HDG61
 */
public class CasaDomotica {
    
    //Atributos
    /**
     * Array de referencias a objetos de tipo Dispositivo con cada uno de los posibles dispositivos domóticos  
     */
    private Dispositivo[] dispositivos;
    /**
     * Propietario de la vivienda
     */
    private String propietario;
    /**
     * Descripción de la vivienda
     */
    private String descripcion;
    
    //Constructores
    
    /**
     * Constructor para una vivenda domótica.
     * @param propietario - Propietario de la vivienda
     * @param descripcion - Descripción de la vivienda
     * @param dispositivos - Cada uno de los posibles dispositivos 
     */
    public CasaDomotica(String propietario, String descripcion, Dispositivo... dispositivos){
        
        this.propietario = propietario;
        this.descripcion = descripcion;
        this.dispositivos = new Dispositivo[dispositivos.length];
        for(int i=0; i<dispositivos.length; i++){
            this.dispositivos[i] = dispositivos[i];
        }
    }
    
    //Metodos publicos
    
    /**
     * Número de dispositivos que hay en la vivienda.
     * @return número de dispositivos
     */
    public int getNumDispositivos(){
    
        return dispositivos.length;
    }
    
    /**
     * Obtiene el número de bombillas que hay en la vivienda.
     * @return número de bombillas
     */
    public int getNumBombillas(){
        int numBombillas =0;
        for(int i=0; i< dispositivos.length; i++){
            if(dispositivos [i] instanceof Bombilla){
                numBombillas++;
            }
        }
        return numBombillas;
    }
    
    /**
     * Obtiene el número de cerraduras que hay en la vivienda.
     * @return número de cerraduras
     */
    public int getNumCerraduras(){
        int numCerradura =0;
        for(int i=0; i< dispositivos.length; i++){
            if(dispositivos [i] instanceof Cerradura){
                numCerradura++;
            }
        }
        return numCerradura;
    }
    
    /**
     * Cierra todas las cerraduras de la casa que estén aún sin cerrar.
     * @return Número de cerraduras activadas (cerradas).
     */
    public int cerrarCerraduras(){
        int cerradurasCerradas =0;
        for(int i=0; i< dispositivos.length; i++){
            if(dispositivos[i] instanceof Cerradura){
                ((Cerradura)dispositivos[i]).on();
                cerradurasCerradas++;
            }
        }
        return cerradurasCerradas;
    }
    
    /**
     * Activa todos los dispositivos de la casa que estén aún sin activar.
     * @return número de dispositivos que se han activado
     */
    public int activarDispositivosActivables(){
        int totalDispositivosActivo =0;
        for(int i=0; i< dispositivos.length; i++){
            if(dispositivos[i] instanceof Activable){
                try{
                ((Activable)dispositivos[i]).on();
                totalDispositivosActivo++;
                }catch(Exception e){
                   
                }
            }
        }
        return totalDispositivosActivo;
    }
    
    //Métodos privados
    
    /**
     * Método auxiliar para obtener el estado del dispositivo.
     * @param d - dispositivo
     * @return estado del dispositivo
     */
    private String escribeEstado(Dispositivo d){
        String result = "";
        if(d instanceof Cerradura){
           result = ((Cerradura) d).toString();
        }else{
            result = ((Bombilla)d).toString();
        }
        return result;
    }
    
    /**
     * Método auxiliar que crea del array dispositivos un StringBuilder con los metodos toString de cada dispositivo, mostrándolos en el método toString de esta clase.
     * @return StringBuilder con todos los dispositivos y sus datos
     */
    private String toStringInstancia(){
        StringBuilder result=new StringBuilder("");
        for(int i=Domotica.MIN_UBICACION; i<=Domotica.MAX_UBICACION; i++){
            result.append("\n Estancia: " + i + "\n");
            for(int j=0; j<dispositivos.length; j++){
                Dispositivo d=dispositivos[j];
                if(d.getUbicacion() == i){
                    result.append("\n" + d.toString());
                }
            }
            
        }
        return result.toString();
    }
    
    /**
     * Método toString que devuelve los datos de todos los dispositivos creados.
     * @return los datos de todos los dispositivos creados
     */
    public String toString(){
        return String.format("CASA DOMOTICA \n Propietario: %s \n Descripción: %s\n %s ",this.propietario, this.descripcion, toStringInstancia() );

    }
}
