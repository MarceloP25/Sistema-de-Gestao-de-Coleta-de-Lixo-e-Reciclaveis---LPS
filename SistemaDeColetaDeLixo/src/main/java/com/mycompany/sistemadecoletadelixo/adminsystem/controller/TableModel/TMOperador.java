/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Operador;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMOperador extends AbstractTableModel {

    private List<Operador> lista;

    // Constantes para as colunas
    private final int COL_NOME = 0;
    private final int COL_CPF = 1;
    private final int COL_EMAIL = 2;
    private final int COL_TELEFONE = 3;
    private final int COL_DEPARTAMENTO = 4;
    private final int COL_DATA_CONTRATO = 5;
    private final int COL_VEICULOS = 6;
    private final int COL_ROTAS = 7;

    public TMOperador(List<Operador> lstOperadores) {
        this.lista = lstOperadores;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 8; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_NOME:
                return "Nome";
            case COL_CPF:
                return "CPF";
            case COL_EMAIL:
                return "Email";
            case COL_TELEFONE:
                return "Telefone";
            case COL_DEPARTAMENTO:
                return "Departamento";
            case COL_DATA_CONTRATO:
                return "Data de Contrato";
            case COL_VEICULOS:
                return "Número de Veículos";
            case COL_ROTAS:
                return "Número de Rotas";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Operador aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_NOME:
                return aux.getNome();
            case COL_CPF:
                return aux.getCpf();
            case COL_EMAIL:
                return aux.getEmail();
            case COL_TELEFONE:
                return aux.getTelefone();
            case COL_DEPARTAMENTO:
                return aux.getDepartamento().getNomeDepartamento(); 
            case COL_DATA_CONTRATO:
                return aux.getDataContrato();
            case COL_VEICULOS:
                return aux.getVeiculos().size(); // Número de veículos associados
            case COL_ROTAS:
                return aux.getRotas().size(); // Número de rotas associadas
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas
        if (columnIndex == COL_VEICULOS || columnIndex == COL_ROTAS) {
            return Integer.class; // Colunas de números inteiros
        }
        return String.class; // Todas as outras colunas são do tipo String
    }

    public List<Operador> getLista() {
        return this.lista;
    }
}