/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;


import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Cidadao;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMCidadao extends AbstractTableModel {

    private List<Cidadao> lista;

    // Constantes para as colunas
    private final int COL_ID = 0;
    private final int COL_NOME = 1;
    private final int COL_CPF = 2;
    private final int COL_EMAIL = 3;
    private final int COL_TELEFONE = 4;
    private final int COL_CEP = 5;
    private final int COL_RUA = 6;
    private final int COL_BAIRRO = 7;
    private final int COL_CIDADE = 8;
    private final int COL_NUMERO = 9;
    private final int COL_COMPLEMENTO = 10;

    public TMCidadao(List<Cidadao> lstCidadaos) {
        this.lista = lstCidadaos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 11; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID:
                return "ID";
            case COL_NOME:
                return "Nome";
            case COL_CPF:
                return "CPF";
            case COL_EMAIL:
                return "Email";
            case COL_TELEFONE:
                return "Telefone";
            case COL_CEP:
                return "CEP";
            case COL_RUA:
                return "Rua";
            case COL_BAIRRO:
                return "Bairro";
            case COL_CIDADE:
                return "Cidade";
            case COL_NUMERO:
                return "Número";
            case COL_COMPLEMENTO:
                return "Complemento";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cidadao aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_ID:
                return aux.getId();
            case COL_NOME:
                return aux.getNome();
            case COL_CPF:
                return aux.getCpf();
            case COL_EMAIL:
                return aux.getEmail();
            case COL_TELEFONE:
                return aux.getTelefone();
            case COL_CEP:
                return aux.getCep();
            case COL_RUA:
                return aux.getRua();
            case COL_BAIRRO:
                return aux.getBairro();
            case COL_CIDADE:
                return aux.getCidade();
            case COL_NUMERO:
                return aux.getNumero();
            case COL_COMPLEMENTO:
                return aux.getComplemento();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Todas as colunas são do tipo String
        return String.class;
    }

    public List<Cidadao> getLista() {
        return this.lista;
    }
}