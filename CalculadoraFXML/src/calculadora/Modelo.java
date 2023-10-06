package calculadora;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 
 * @author 
 */
public class Modelo {
    
    
    /**
     * Evaluar la cadena que se pasa como parámetro
     * @param cadena String con la expresión a evaluar
     * @return Una cadena con el resultado o bien null si la cadena recibida
     *         como parámetro no era válida
     */
    public static String evaluar(String cadena) {
        String evaluacion = "Error";
       
        Pattern p = Pattern.compile("[0-9]{1,}(.[0-9]+)?(\\+|-|\\*|\\/)?[0-9]?(.[0-9]+)?");
        Matcher m = p.matcher(cadena);
        boolean b = m.matches();
        
        if(m.matches() == true){
           
            ScriptEngine engine = new ScriptEngineManager().getEngineByName("JavaScript");
            
            // Se intenta evaluar la expresión contenida en la variable cadena
            try {
                evaluacion = engine.eval(cadena).toString();
            } catch (ScriptException ex) {
               
                Logger.getLogger(Calculadora.class.getName()).log(Level.SEVERE, null, ex);
            }
              
        }
            return evaluacion.toString(); 
        
    }

    /**
     * Evalúa la expresión pasada en text y posteriormente realiza la raíz 
     * cuadrada dicha expresión
     * 
     * @param texto Presunta expresión a calcular la raíz
     * @return Cadena de caracteres con el resultado del cálculo o bien null
     *         si la expresión que se pasó no era válida
     */
    static String raizCuadrada(String text) {
        String result = null;

        result = Double.valueOf(Math.sqrt(Double.parseDouble(text))).toString();
      
        return result ;
    }
    
    public static String suprimir(String input){
        return input.substring(0,input.length()-1);
    }
    
    public static String clear(){
        return "";
    }
   
}
