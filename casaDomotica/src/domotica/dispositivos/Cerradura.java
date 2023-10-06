package domotica.dispositivos;

/**
 * Clase que representa un mecanismo de cerradura domótica. Podrá estar abierta (false o "desactivada") o cerrada (true o "activada").
 * @author HDG61
 */
public final class Cerradura extends Dispositivo implements Activable {
    
    //Atributos
    
    /**
     * Estado del dispositivo (Activado, desactivado)
     */
    private boolean estado;
    
    //Constructores
    
    /**
     * Constructor que instancia un objeto Cerradura con los parametros descripción y ubicación y estado inicial.
     * @param descripcion - descripción del dispositivo
     * @param ubicacion - número de habitación del dispositivo
     * @param estadoInicial - estado inicial del dispositivo (cerradura abierta o cerrada)
     */
    public Cerradura(String descripcion, int ubicacion, boolean estadoInicial){
        super(descripcion, ubicacion);
        this.estado = estadoInicial;
    }
    
    /**
     * Constructor que instancia un objeto Cerradura con los parametros descripción y ubicación.
     * @param descripcion - descripción del dispositivo
     * @param ubicacion - número de habitación del dispositivo
     */
    public Cerradura(String descripcion, int ubicacion){
        this(descripcion, ubicacion, false); 
    }
    
    /**
     * Metodos publicos
     */
    
    /**
     * Obtiene el estado actual de la cerradura. true (cerrado), false (abierta).
     * @return estado actual de la cerradura.
     */
    public boolean getEstado(){
        return estado;
    }
    
    /**
     * Activa la cerradura (cierra).
     * @throws IllegalStateException - si la cerradura ya está cerrada (activada)
     */
    public void on() throws IllegalStateException{
        if(estado == true){
            throw new IllegalStateException("Cerradura ya activada (cerrada)");
        }else{
            estado = true;
        }
    }
    
    /**
     * Desactiva la cerradura (abre).
     * @throws IllegalStateException - si la cerradura ya está abierta (desactivada)
     */
    public void off() throws IllegalStateException{
        if(estado == false){
            throw new IllegalStateException("Cerradura ya desactivada (abierta)");
        }else{
            estado = false;
        }
    }
    
    /**
     * Representación del estado de una cerradura de forma textual.
     * @return Cadena de texto que representa una cerradura.
     */
    public String toString() {
        return String.format("%s estado:%s", super.toString(), this.estado ? "cerrada" : "abierta");
    }
}
