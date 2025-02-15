/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;



import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMDepartamento extends AbstractTableModel {

    private List<Departamento> lista;

    // Constantes para as colunas (igual ao exemplo do professor)
    private final int COL_DEPARTAMENTO = 0;
    private final int COL_COLETAS = 1;
    private final int COL_SUPERVISORES = 2;
    private final int COL_OPERADORES = 3;
    private final int COL_VEICULOS = 4;
    private final int COL_ROTAS =5;
    
   

    public TMDepartamento(List<Departamento> lstDepartamentos) {
        this.lista = lstDepartamentos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_DEPARTAMENTO:
                return "Departamentos";
            case COL_COLETAS:
                return "Número de Coletas";
            case COL_SUPERVISORES:
                return "Número de Supervisores";
            case COL_OPERADORES:
                return "Número de Operadores";
            case COL_VEICULOS:
                return "Numero de Veiculos";
            case COL_ROTAS:
                return "Numero de Rotas";
            default:
                return "";
        }
    }
    
@Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Departamento aux = lista.get(rowIndex);
        
        switch (columnIndex) {
            case COL_DEPARTAMENTO:
                return aux.getNomeDepartamento();
            case COL_COLETAS:
                return aux.getColetas().size();
            case COL_SUPERVISORES:
                return aux.getSupervisores().size();
            case COL_OPERADORES:
                return aux.getOperadores().size();
            case COL_VEICULOS:
                return aux.getVeiculos().size();
            case COL_ROTAS:    
                return aux.getRotas().size();
            default:
                return null;
        }
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas (igual ao exemplo)
        if (columnIndex == COL_COLETAS || 
            columnIndex == COL_SUPERVISORES || 
            columnIndex == COL_OPERADORES ||
            columnIndex == COL_VEICULOS) {
            return Integer.class;
        }
        return String.class;
    }

    public List<Departamento> getLista() {
        return this.lista;
    }

}