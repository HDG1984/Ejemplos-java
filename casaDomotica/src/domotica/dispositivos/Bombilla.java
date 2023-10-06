package domotica.dispositivos;

/**
 * Clase que representa una lámpara domótica, permite regular su intensidad
 * @author HDG61
 */
public final class Bombilla extends Dispositivo implements Regulable, Activable {
    
    //Atributos
    
    /**
     * Intensidad bombilla entre o y 10
     */
    private int intensidad;
    /**
     * número de veces que se manipula una bombilla
     */
    private int numVecesManipulada = 0;
    
    //Atributos constantes
    
    /**
     * Mínima intensidad posible para una bombilla: 0
     */
    public final int MIN_INTENSIDAD = 0;
    /**
     * Máxima intensidad posible para una bombilla: 10.
     */
    public final int MAX_INTENSIDAD = 10;
    
    //Constructores
    
    /**
     * Instancia un objeto Bombilla con los parámetros descripción y una ubicación.
     * @param descripcion - descripción del dispositivo
     * @param ubicacion - número de habitación del dispositivo
     */
    public Bombilla(String descripcion, int ubicacion){
        
        super(descripcion, ubicacion);
        this.intensidad = MIN_INTENSIDAD;
    }
    
    //Métodos publicos
    
    /**
     * Obtiene número de veces que la bombilla ha sido manipulada.
     * @return número de veces manipulada
     */
    public int getNumVecesManipulada() {
        return numVecesManipulada;
    }
    
    /**
     * Obtiene la intensidad actual de la bombilla.
     * @return intensidad actual
     */
    public int getIntensidad() {
        return this.intensidad;
    }
    
    /**
     * Incrementa en 1 la intensidad de la bombilla, alcanzada intensidad máxima, no se considerara que haya sido manipulada.
     * @return intensidad actual
     */
    public int up() {
        if(this.intensidad >= MAX_INTENSIDAD){
            return this.intensidad;
        }else{
            numVecesManipulada++;
            return this.intensidad++;
        }
    }

    /**
     * Decrementa en 1 la intensidad de la bombilla, alcanzada intensidad mínima, no se considerara que haya sido manipulada.
     * @return intensidad actual
     */
    public int down() {
        if(this.intensidad <= MIN_INTENSIDAD){
            return this.intensidad;
        }else{
            numVecesManipulada++;
            return this.intensidad--;
        }
    }

    /**
     * Obtiene el estado actual de la bombilla, si la intensidad es 0 = false (apagada), si es cualquier número mayor = true (encendida).
     * @return estado actual
     */
    public boolean getEstado() {
        return this.intensidad >0 ? true : false;
    }

    /**
     * Enciende la bombilla y pone su intensidad al valor máximo.
     * @throws IllegalStateException - si la bombilla ya está encendida
     */
    public void on() throws IllegalStateException {
        if(!this.getEstado()){
            this.intensidad = MAX_INTENSIDAD;
            numVecesManipulada++;
        }else{
            throw new IllegalStateException("Bombilla ya encendida");
        } //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Apaga la bombilla, intensidad = 0.
     * @throws IllegalStateException - si la bombilla ya está apagada
     */
    public void off() throws IllegalStateException {
        if(this.getEstado()){
            this.intensidad = MIN_INTENSIDAD;
            numVecesManipulada++;
        }else{
            throw new IllegalStateException("Bombilla ya apagada");
        } //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Devuelve una cadena que representa el estado de la bombilla de forma textual.
     * @return Cadena de texto que representa una bombilla
     */
    public String toString() {
    return String.format("tipo:%-11s id:%d descripción:\"%s\" ubicacion:%d estado:%s int:%d NVM:%d" ,
            this.getClass().getSimpleName(), this.getId(), this.getDescripcion(), this.getUbicacion(), this.getEstado()? "encendida":"apagada", this.getIntensidad(), this.getNumVecesManipulada());
    }

}
