package model;

import java.util.ArrayList;
import java.util.List;

public class Hoja<T> {

    //Atributos
    private List<List<Celda<T>>> matriz;

    public Hoja() {
        matriz = new ArrayList<>();
    }

    public void addRow(List<Celda<T>> fila) {
        matriz.add(fila);
    }

    public void setCelda(int rowIndex, int columnIndex, Celda<T> celda) {
        if (rowIndex >= 0 && rowIndex < matriz.size()) {
            List<Celda<T>> row = matriz.get(rowIndex);
            if (columnIndex >= 0 && columnIndex < row.size()) {
                T contenidoCelda = celda.getContenidoCelda();
                if (contenidoCelda != null) {
                    String contenido = contenidoCelda.toString();
                    if (contenido.isEmpty()) {
                        row.remove(columnIndex);
                    } else {
                        row.set(columnIndex, celda);
                    }
                }
            }
        }
    }
}
