/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class CrearVehiculoController implements Initializable {

    @FXML
    private Button botonInicio;
    @FXML
    private ComboBox<?> cbMarca;
    @FXML
    private ComboBox<?> cbModelo;
    @FXML
    private ComboBox<?> cbAnio;
    @FXML
    private ComboBox<?> cbKilo;
    @FXML
    private ComboBox<?> cbMotor;
    @FXML
    private ComboBox<?> cbTransmision;
    @FXML
    private ComboBox<?> cbPeso;
    @FXML
    private ComboBox<?> cbCiudad;
    @FXML
    private TextField tfPrecio;
    @FXML
    private CheckBox checkNegociable;
    @FXML
    private CheckBox checkAccidente;
    @FXML
    private TextArea taAccidente;
    @FXML
    private TextArea taMantenimiento;
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellido;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfCorreo;
    @FXML
    private Button botonPonerVenta;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void irInicio(ActionEvent event) {
    }

    @FXML
    private void clickEnAccidente(ActionEvent event) {
    }

    @FXML
    private void clickEnPonerVenta(ActionEvent event) {
    }
    
}
