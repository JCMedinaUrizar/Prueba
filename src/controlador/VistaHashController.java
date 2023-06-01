/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Oscar
 */
public class VistaHashController implements Initializable {

    @FXML
    private Button btnCrearTablaHash;
    @FXML
    private TextField txtCubetas;
    @FXML
    private TextField txtIngresarDatos;
    @FXML
    private Button btnInsertInTablaHash;
    @FXML
    private TableView<?> tblHash;
    @FXML
    private TableColumn<?, ?> colHash;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnBorrarTodo;
    @FXML
    private Button btnAbrir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
