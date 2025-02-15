/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.EstacaoDescarga;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMEstacaoDeDescarga extends AbstractTableModel {

    private final List<EstacaoDescarga> lista;
    
    // Constantes para as colunas
    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CAPACIDADE_MAXIMA = 2;
    private final int COL_TIPO_MATERIAL_ACEITO = 3;
    private final int COL_STATUS_OPERACAO = 4;
    private final int COL_DEPARTAMENTOS = 5;

    public TMEstacaoDeDescarga(List<EstacaoDescarga> lstEstacoesDescarga) {
        this.lista = lstEstacoesDescarga;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID:
                return "ID";
            case COL_NOME:
                return "Nome";
            case COL_CAPACIDADE_MAXIMA:
                return "Capacidade Máxima";
            case COL_TIPO_MATERIAL_ACEITO:
                return "Tipo de Material Aceito";
            case COL_STATUS_OPERACAO:
                return "Status da Operação";
            case COL_DEPARTAMENTOS:
                return "Número de Departamentos";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EstacaoDescarga aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_ID:
                return aux.getIdEstacao();
            case COL_NOME:
                return aux.getNomeEstacao();
            case COL_CAPACIDADE_MAXIMA:
                return aux.getCapacidadeMaxima();
            case COL_TIPO_MATERIAL_ACEITO:
                return aux.getTipoMaterialAceito();
            case COL_STATUS_OPERACAO:
                return aux.getStatusOperacao();
            case COL_DEPARTAMENTOS:
                return aux.getDepartamento().size(); // Número de departamentos associados
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas
        if (columnIndex == COL_CAPACIDADE_MAXIMA) {
            return Float.class;
        } else if (columnIndex == COL_DEPARTAMENTOS) {
            return Integer.class;
        }
        return String.class;
    }

    public List<EstacaoDescarga> getLista() {
        return this.lista;
    }
}
