package domotica.dispositivos;

/**
 * Las clases que implementen esta interfaz representarán objetos que permitirán regular su intensidad.
 * @author HDG61
 */
public interface Regulable {
    
    /**
     * Obtiene el valor regulable de intensidad.
     * @return intensidad actual.
     */
    public int getIntensidad();
    
    /**
     * Incrementa el valor de intensidad.
     * @return intensidad alcanzada tras la operación.
     */
    public int up();
    
    /**
     * Decrementa el valor de intensidad.
     * @return intensidad alcanzada tras la operación.
     */
    public int down();
}
