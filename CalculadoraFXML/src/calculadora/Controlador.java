package calculadora;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * El controlador se encarga de responder a los eventos que causa el usuario
 * invocando las peticiones al modelo cuando se hace alguna solicitud sobre la
 * información (por ejemplo, en este caso cuando el usuario pulse en el botón 
 * de igual para calcular la expresión).
 * 
 * @author 
 */
public class Controlador implements Initializable {
    
    @FXML
    private TextField entrada;
    private String input= "";
    private String resultado;
    
    /**
     * Al pinchar en el botón de igual se intentará evaluar la expresión 
     * mediante el método evaluar de la clase Modelo.
     * 
     * @param event 
     */
    @FXML
    private void calcular(ActionEvent event) {
        resultado = Modelo.evaluar(input);
        if(resultado == "Error"){
            mostrarError("Formato no válido");
        }else{
            entrada.setText(resultado); 
        }
        
    }
    
    
    /**
     * Al pinchar en el botón de raíz se intentará calcular la raíz cuadrada 
     * mediante el método evaluar de la clase Modelo.
     * 
     * @param event 
     */
    @FXML
    private void radicalizar(ActionEvent event) {
        resultado = Modelo.evaluar(input);
        resultado = Modelo.raizCuadrada(resultado);
        if(resultado == null){
           mostrarError("Formato no válido");
        }else{
            entrada.setText(resultado); 
        }
    }
    
    
    /**
     * Borra el contenido del campo de texto de la calculadora
     * @param event 
     */
    @FXML
    private void borrar(ActionEvent event) {
        System.out.print(((Button) event.getSource()).getText());
        input = ((Button) event.getSource()).getText().equals("s") ? Modelo.suprimir(input): Modelo.clear();
        entrada.setText(input);
    }
    
    /** 
     * Copiar la entrada recibida por teclado al campo de texto (TextField) 
     * @param event 
     */
    @FXML
    private void copiarAlTextField(ActionEvent event) {
        
        input += ((Button) event.getSource()).getText();
        entrada.setText(input);
        System.out.print(input);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

	/**
     * Ventanita para mostrar mensajes de error
     * @param error 
     */
    private void mostrarError(String error)  {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle("Error");
        alert.setContentText(error);
        alert.showAndWait();
    }    

}
