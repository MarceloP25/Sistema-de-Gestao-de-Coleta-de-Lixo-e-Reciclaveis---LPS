/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Material;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMMaterial extends AbstractTableModel {

    private List<Material> lista;

    // Constantes para as colunas
    private final int COL_NOME = 0;
    private final int COL_TIPO = 1;
    private final int COL_LIBERAR_DESCARTE = 2;
    private final int COL_INSTRUCOES_DESCARTE = 3;

    public TMMaterial(List<Material> lstMateriais) {
        this.lista = lstMateriais;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 4; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_TIPO:
                return "Tipo";
            case COL_LIBERAR_DESCARTE:
                return "Liberar Descarte";
            case COL_INSTRUCOES_DESCARTE:
                return "Instruções de Descarte";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Material aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_NOME:
                return aux.getNome();
            case COL_TIPO:
                return aux.getTipo();
            case COL_LIBERAR_DESCARTE:
                return aux.getLiberarDescarte();
            case COL_INSTRUCOES_DESCARTE:
                return aux.getInstrucoesDescarte();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Todas as colunas são do tipo String
        return String.class;
    }

    public List<Material> getLista() {
        return this.lista;
    }
}