/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package ec.edu.espol.proyectoed_g1;

import ec.edu.espol.proyectoed_g1.modelo.Interfaces.List;
import ec.edu.espol.proyectoed_g1.modelo.Listas.CircularDoublyLinkedList;
import ec.edu.espol.proyectoed_g1.modelo.Listas.LinkedList;
import excepciones.ComboBoxSinEleccion;
import excepciones.NoEsNumero;
import excepciones.StringVacio;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author zahid
 */
public class CrearVehiculoController implements Initializable {

    @FXML
    private Button botonInicio;
    @FXML
    private ComboBox<Marca> cbMarca;
    @FXML
    private ComboBox<String> cbModelo;
    @FXML
    private ComboBox<Integer> cbAnio;
    @FXML
    private ComboBox<Integer> cbKilo;
    @FXML
    private ComboBox<String> cbMotor;
    @FXML
    private ComboBox<String> cbTransmision;
    @FXML
    private ComboBox<Integer> cbPeso;
    @FXML
    private ComboBox<String> cbCiudad;
    @FXML
    private TextField tfPrecio;
    @FXML
    private CheckBox checkNegociable;
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
    @FXML
    private ImageView imgLogo;
    @FXML
    private CheckBox cCarroceria;
    @FXML
    private CheckBox cParachoques;
    @FXML
    private CheckBox cSuspension;
    @FXML
    private CheckBox cFarros;
    @FXML
    private CheckBox cEscape;
    @FXML
    private CheckBox cAceite;
    @FXML
    private CheckBox cFiltros;
    @FXML
    private CheckBox cBateria;
    @FXML
    private CheckBox cFrenos;
    @FXML
    private CheckBox cNeumaticos;
    @FXML
    private Button botonSubirImagen;
    
    private CircularDoublyLinkedList<String> imagenes = new CircularDoublyLinkedList<>();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image img1 = new Image("/imagenes/logo.png");
        imgLogo.setImage(img1);;
        for(Marca m: InicioController.marcas){
            cbMarca.getItems().add(m);
        }
        for(Integer a: InicioController.anios){
            cbAnio.getItems().add(a);
        }
        for(Integer k: InicioController.kilometrajes){
            cbKilo.getItems().add(k);
        }
        for(String mo : InicioController.motores){
            cbMotor.getItems().add(mo);
        }
        for(String t: InicioController.transmisiones){
            cbTransmision.getItems().add(t);
        }
        for(Integer p: InicioController.pesos){
            cbPeso.getItems().add(p);
        }
        for(String c: InicioController.ciudades){
            cbCiudad.getItems().add(c);
        }
        
    }    

    @FXML
    private void irInicio(ActionEvent event) {
        try{
            App.setRoot("inicio");
        } catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public void guardarAccidente(Accidente a, LinkedList<Accidente> accidentes){
        accidentes.addLast(a);
    }
    
    public void guardarMantenimiento(Mantenimiento m, LinkedList<Mantenimiento> mantenimientos){
        mantenimientos.addLast(m);
    }
    
    private static String verificarTFStringVacio(TextField tf) throws StringVacio{
        String str = tf.getText();
        if (str.equals("")){
            throw new StringVacio("Por favor coloque una cuenta válida.");
        }
        return str;
    }
    
    public Precio crearPrecio() throws StringVacio, NoEsNumero{
        verificarTFStringVacio(tfPrecio);
        double cant = Utilitaria.obtenerTFNumero(tfPrecio);
        boolean esNegociable = false;
        if(checkNegociable.isSelected()){
            esNegociable = true;
        }
        return new Precio(cant,esNegociable);
    }
    
    public Usuario crearUsuario() throws StringVacio, NoEsNumero{
        verificarTFStringVacio(tfNombre);
        verificarTFStringVacio(tfApellido);
        verificarTFStringVacio(tfTelefono);
        verificarTFStringVacio(tfCorreo);
        return new Usuario(tfNombre.getText() + " " + tfApellido.getText(),tfTelefono.getText(), tfCorreo.getText());
    }
    
    public LinkedList<Accidente> crearListaAccidentes(){
        LinkedList<Accidente> acc = new LinkedList<>();
        if(cCarroceria.isSelected()){
                guardarAccidente(Accidente.CARROCERIA, acc);
        }
        if(cParachoques.isSelected()){
            guardarAccidente(Accidente.PARACHOQUES, acc);
        }
        if(cSuspension.isSelected()){
            guardarAccidente(Accidente.SUSPENSION, acc);
        }
        if(cFarros.isSelected()){
            guardarAccidente(Accidente.LUCES, acc);
        }
        if(cEscape.isSelected()){
            guardarAccidente(Accidente.ESCAPE, acc);
        }
        return acc;
    }
    
    public Historial crearHistorial(){
        LinkedList<Accidente> accidentes = crearListaAccidentes();
        LinkedList<Mantenimiento> mantenimientos = crearListaMantenimientos();
        return new Historial(accidentes,mantenimientos);
    }
    
    public LinkedList<Mantenimiento> crearListaMantenimientos(){
        LinkedList<Mantenimiento> mantenimientos = new LinkedList<>();
        if(cAceite.isSelected()){
            guardarMantenimiento(Mantenimiento.ACEITE, mantenimientos);
        }
        if(cFiltros.isSelected()){
            guardarMantenimiento(Mantenimiento.FILTROS, mantenimientos);
        }
        if(cBateria.isSelected()){
            guardarMantenimiento(Mantenimiento.BATERIA, mantenimientos);
        }
        if(cFrenos.isSelected()){
            guardarMantenimiento(Mantenimiento.FRENOS, mantenimientos);
        }
        if(cNeumaticos.isSelected()){
            guardarMantenimiento(Mantenimiento.NEUMATICOS, mantenimientos);
        }
        return mantenimientos;
    }
    
    
    
    @FXML
    private void clickEnPonerVenta(ActionEvent event) {
        try{
            //Creando Precio
            Precio precio = crearPrecio();
            Utilitaria.verificarComboBox(cbMarca);
            
            //Creando datos de ComboBoxes
            Marca marca = cbMarca.getValue();
            Utilitaria.verificarComboBox(cbModelo);
            String modelo = cbModelo.getValue();
            Utilitaria.verificarComboBox(cbAnio);
            int year = cbAnio.getValue();
            Utilitaria.verificarComboBox(cbKilo);
            int km = cbKilo.getValue();
            Utilitaria.verificarComboBox(cbTransmision);
            String transmisión = cbTransmision.getValue();
            Utilitaria.verificarComboBox(cbPeso);
            double peso = cbPeso.getValue();
            Utilitaria.verificarComboBox(cbCiudad);
            String ubiAct = cbCiudad.getValue();
            
            //Creando Usuario
            Usuario dueno = crearUsuario();
            boolean esVendido = false;
            
            //Creando Historial
            Historial histReparacion = crearHistorial();
            System.out.println(imagenes);
            Vehicle vehiculo = new Vehicle(precio,marca,modelo,year,km,transmisión,peso,ubiAct,dueno,esVendido,histReparacion,imagenes);
            try{
                App.setRoot("inicio");
            } catch(IOException e){
                e.printStackTrace();
            }
           
        } catch(StringVacio s){
            Utilitaria.mostrarAlerta("No puede dejar campos vacíos", Alert.AlertType.ERROR, "crearVehiculo");
        } catch(NoEsNumero n){
            Utilitaria.mostrarAlerta("El precio ingresado no es un número", Alert.AlertType.ERROR, "crearVehiculo");
        } catch(ComboBoxSinEleccion co){
            Utilitaria.mostrarAlerta("Por favor escoja una opción en todos los campos", Alert.AlertType.ERROR, "crearVehiculo");
        }
        
    }

    @FXML
    private void clickEnCCarroceria(ActionEvent event) {
    }

    @FXML
    private void clickEnCParachoques(ActionEvent event) {
    }

    @FXML
    private void clickEnCSuspension(ActionEvent event) {
    }

    @FXML
    private void clickEnCFaros(ActionEvent event) {
    }

    @FXML
    private void clickEnCbEscape(ActionEvent event) {
    }

    @FXML
    private void clickEnCAceite(ActionEvent event) {
    }

    @FXML
    private void clickEnCFiltros(ActionEvent event) {
    }

    @FXML
    private void clickEnCBateria(ActionEvent event) {
    }

    @FXML
    private void clickEnCFrenos(ActionEvent event) {
    }

    @FXML
    private void clickEnCNeumaticos(ActionEvent event) {
    }

    @FXML
    private void clickEnSubirImagen(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar Imágenes");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.jpeg"));
        List<File> files = (List<File>) fileChooser.showOpenMultipleDialog(new Stage());

        if (files != null) {
            for (File file : files) {
                imagenes.addLast(file.getAbsolutePath());
            }
            System.out.println("Imágenes seleccionadas: " + imagenes.size());
        }
    }

    @FXML
    private void clickEnModelo(MouseEvent event) {
        cbModelo.getItems().clear();
        Marca marca =  cbMarca.getValue();
        for(String modelo: marca.getModelos()){
            cbModelo.getItems().add(modelo);
        }
    }
    
}
