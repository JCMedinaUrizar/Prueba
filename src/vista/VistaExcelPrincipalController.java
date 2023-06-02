package vista;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import model.Celda;
import model.Hoja;
import model.MiLibreria;

public class VistaExcelPrincipalController<T> implements Initializable {

    @FXML
    private BorderPane rootPane;
    @FXML
    private MenuBar menuOpcionesTop;
    @FXML
    private TabPane tabPaneMenuBottom;
    @FXML
    private Tab tabNameHoja;
    @FXML
    private Tab tabAddHoja;
    @FXML
    private TableView<ObservableList<Celda<String>>> tblExcel;

    private Hoja<String> hoja;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        hoja = new Hoja<>();

        tblExcel.getSelectionModel().setCellSelectionEnabled(true);

        // Crear las columnas dinámicamente
        for (char c = 'A'; c <= 'Z'; c++) {
            TableColumn<ObservableList<Celda<String>>, String> column = new TableColumn<>(String.valueOf(c));
            final int columnIndex = tblExcel.getColumns().size();
            column.setCellValueFactory(cellData -> {
                ObservableList<Celda<String>> row = cellData.getValue();
                if (columnIndex >= row.size()) {
                    row.addAll(Collections.nCopies(columnIndex - row.size() + 1, new Celda<>("")));
                }
                return new SimpleStringProperty(row.get(columnIndex).getContenidoCelda());
            });
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            column.setOnEditCommit(event -> {
                ObservableList<Celda<String>> rowValue = event.getTableView().getItems().get(event.getTablePosition().getRow());
                rowValue.get(event.getTablePosition().getColumn()).setContenidoCelda(event.getNewValue());
            });
            column.setEditable(true);
            tblExcel.getColumns().add(column);
        }

        // Crear las filas enumeradas
        for (int i = 1; i <= 100; i++) {
            ObservableList<Celda<String>> row = FXCollections.observableArrayList();
            for (int j = 0; j < tblExcel.getColumns().size(); j++) {
                row.add(new Celda<>(""));
            }
            tblExcel.getItems().add(row);
        }

        tblExcel.setEditable(true);
        tblExcel.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                ObservableList<Celda<String>> selectedRow = tblExcel.getSelectionModel().getSelectedItem();
                int rowIndex = tblExcel.getSelectionModel().getSelectedIndex();
                int columnIndex = tblExcel.getSelectionModel().getSelectedCells().get(0).getColumn();

                Celda<String> selectedCell = selectedRow.get(columnIndex);
                String formula = selectedCell.getContenidoCelda();

                if (formula.startsWith("=")) {
                    String[] tokens = formula.substring(1).split("\\(");
                    String functionName = tokens[0].toUpperCase();
                    String[] arguments = tokens[1].replaceAll("\\)", "").split(",");

                    if (functionName.equals("SUMA") && arguments.length == 2) {
                        double arg1 = Double.parseDouble(arguments[0]);
                        double arg2 = Double.parseDouble(arguments[1]);
                        double result = arg1 + arg2;
                        selectedCell.setContenidoCelda(String.valueOf(result));
                    } else if (functionName.equals("MULTI") && arguments.length == 2) {
                        double arg1 = Double.parseDouble(arguments[0]);
                        double arg2 = Double.parseDouble(arguments[1]);
                        double result = arg1 * arg2;
                        selectedCell.setContenidoCelda(String.valueOf(result));
                    }
                }
            }
    });
}

}