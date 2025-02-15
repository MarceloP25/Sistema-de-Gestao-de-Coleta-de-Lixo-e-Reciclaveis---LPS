/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Supervisor;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMSupervisor extends AbstractTableModel {

    private List<Supervisor> lista;

    // Constantes para as colunas
    private final int COL_NOME = 0;
    private final int COL_CPF = 1;
    private final int COL_EMAIL = 2;
    private final int COL_TELEFONE = 3;
    private final int COL_DEPARTAMENTO = 4;
    private final int COL_DATA_CONTRATO = 5;

    public TMSupervisor(List<Supervisor> lstSupervisores) {
        this.lista = lstSupervisores;
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
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Supervisor aux = lista.get(rowIndex);

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
                return aux.getDepartamento().getNomeDepartamento(); // Supondo que Departamento tenha um método getNomeDepartamento()
            case COL_DATA_CONTRATO:
                return aux.getDataContrato();
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas
        return String.class; // Todas as colunas são do tipo String
    }

    public List<Supervisor> getLista() {
        return this.lista;
    }
}