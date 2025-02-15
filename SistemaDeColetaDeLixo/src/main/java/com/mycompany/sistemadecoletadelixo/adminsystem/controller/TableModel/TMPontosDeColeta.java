/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.PontoDeColeta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMPontosDeColeta extends AbstractTableModel {

    private List<PontoDeColeta> lista;

    // Constantes para as colunas
    private final int COL_ID = 0;
    private final int COL_NOME_PONTO = 1;
    private final int COL_RUA = 2;
    private final int COL_NUMERO_LIXEIRAS = 3;
    private final int COL_TIPOS_LIXO = 4;

    public TMPontosDeColeta(List<PontoDeColeta> lstPontosDeColeta) {
        this.lista = lstPontosDeColeta;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 5; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID:
                return "ID";
            case COL_NOME_PONTO:
                return "Nome do Ponto";
            case COL_RUA:
                return "Rua";
            case COL_NUMERO_LIXEIRAS:
                return "Número de Lixeiras";
            case COL_TIPOS_LIXO:
                return "Tipos de Lixo";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        PontoDeColeta aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_ID:
                return aux.getId();
            case COL_NOME_PONTO:
                return aux.getNomePonto();
            case COL_RUA:
                return aux.getRua();
            case COL_NUMERO_LIXEIRAS:
                return aux.getNumeroLixeiras();
            case COL_TIPOS_LIXO:
                return String.join(", ", aux.getTiposLixo()); // Converte a lista de tipos de lixo em uma string
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas
        if (columnIndex == COL_NUMERO_LIXEIRAS) {
            return Integer.class;
        }
        return String.class;
    }

    public List<PontoDeColeta> getLista() {
        return this.lista;
    }
}