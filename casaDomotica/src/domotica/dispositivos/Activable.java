package domotica.dispositivos;

/**
 * Las clases que implementen esta interfaz representarán objetos que podrán activarse y desactivarse.
 * @author HDG61
 */
public interface Activable {
    
    /**
     * Obtiene el estado del elemento.Activado true.
     * @return estado actual del elemento
     */
    public boolean getEstado();
    
    /**
     * Activa el elmento.
     * @throws IllegalStateException - si el elemento ya estaba activado.
     */
    public void on() throws IllegalStateException;
    
    /**
     * Desactiva el elemento.
     * @throws IllegalStateException - si el elemento ya estaba desactivado
     */
    public void off() throws IllegalStateException;
}
