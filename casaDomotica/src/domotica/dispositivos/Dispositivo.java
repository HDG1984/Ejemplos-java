package domotica.dispositivos;

/**
 * Clase abstracta que representa un dispositivo domótico genérico. Contendrá una identificación única que se incrementara de forma automática empezando por 1, una descripción y su ubicación en la vivienda.Constructor de un objeto dispositivo domótico con una descripción y ubicación.
 * @author HDG61
 */

public abstract class Dispositivo {
    
    //Atributos
    
    /**
     * Descripción del dispositivo
     */
    private String descripcion;
    /**
     * Número de habitación del dispositivo
     */
    private int ubicacion;
    /**
     * Identificación única del dispositivo
     */
    private final int id;
    /**
     * Variable auxiliar de id
     */
    private static int idSiguiente=1;
    
    //Constructores
    
    /**
     * Constructor de un objeto dispositivo domótico con una descripción y ubicación.
     * @param descripcion - descripción del dispositivo
     * @param ubicacion - número de habitación del dispositivo
     */
    
    public Dispositivo(String descripcion, int ubicacion){
        
        id = idSiguiente;
        idSiguiente++;
        this.descripcion = descripcion;
        
        if(ubicacion < 1 || ubicacion >5){
            throw new IllegalArgumentException( "Ubicación no válida: " + ubicacion);
        }else{
            this.ubicacion = ubicacion;
        }
        
    }
    
    //Métodos publicos
    
    /**
     * Obtiene el identificador único del dispositivo.
     * @return id del dispositivo.
     */
    public int getId(){
        return id;
    }
    
    /**
     * Obtiene la descripcion del dispositivo.
     * @return descripcion del dispositivo.
     */
    public String getDescripcion(){
        return descripcion;
    }
    
    /**
     * Obtiene la ubicación del dispositivo.
     * @return ubicación del dispositivo.
     */
    public int getUbicacion(){
        return ubicacion;
    }
    
    /**
     * Representación del estado de un dispositivo de forma textual.
     * @return Cadena de texto que representa un dispositivo
     */
    public String toString() {
    return String.format("tipo:%-11s id:%d descripción:\"%s\" ubicacion:%d",
            this.getClass().getSimpleName(), this.id, this.descripcion, this.ubicacion);
    }
}
