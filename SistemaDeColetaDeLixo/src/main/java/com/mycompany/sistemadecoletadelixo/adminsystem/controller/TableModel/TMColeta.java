/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Coleta;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMColeta extends AbstractTableModel {

    private List<Coleta> lista;

    // Constantes para as colunas
    private final int COL_ID = 0;
    private final int COL_DEPARTAMENTO = 1;
    private final int COL_ESTACAO_DESCARGA = 2;
    private final int COL_SUPERVISOR = 3;
    private final int COL_PESO = 4;
    private final int COL_MATERIAIS_COLETADOS = 5;
    private final int COL_OPERADOR = 6;
    private final int COL_ROTA = 7;
    private final int COL_VEICULO = 8;

    public TMColeta(List<Coleta> lstColetas) {
        this.lista = lstColetas;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 9; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_ID:
                return "ID";
            case COL_DEPARTAMENTO:
                return "Departamento";
            case COL_ESTACAO_DESCARGA:
                return "Estação de Descarga";
            case COL_SUPERVISOR:
                return "Supervisor";
            case COL_PESO:
                return "Peso";
            case COL_MATERIAIS_COLETADOS:
                return "Materiais Coletados";
            case COL_OPERADOR:
                return "Operador";
            case COL_ROTA:
                return "Rota";
            case COL_VEICULO:
                return "Veículo";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Coleta aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_ID:
                return aux.getId();
            case COL_DEPARTAMENTO:
                return aux.getDepartamento().getNomeDepartamento(); // Supondo que Departamento tenha um método getNomeDepartamento()
            case COL_ESTACAO_DESCARGA:
                return aux.getEstacaoDeDescarga().getNomeEstacao(); 
            case COL_SUPERVISOR:
                return aux.getSupervisor().getNome(); 
            case COL_PESO:
                return aux.getPeso();
            case COL_MATERIAIS_COLETADOS:
                return aux.getMateriaisColetados().size(); // Número de materiais coletados
            case COL_OPERADOR:
                return aux.getOperador().getNome(); 
            case COL_ROTA:
                return aux.getRota().getNomeRota();
            case COL_VEICULO:
                return aux.getVeiculo().getPlaca(); 
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas
        if (columnIndex == COL_PESO) {
            return Double.class;
        } else if (columnIndex == COL_MATERIAIS_COLETADOS) {
            return Integer.class;
        }
        return String.class;
    }

    public List<Coleta> getLista() {
        return this.lista;
    }
}