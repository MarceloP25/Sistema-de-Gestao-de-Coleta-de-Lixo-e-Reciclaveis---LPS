/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.controller.TableModel;

import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Veiculo;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TMVeiculos extends AbstractTableModel {

    private List<Veiculo> lista;

    // Constantes para as colunas
   colunass
    private final int COL_MODELO = 2;
    private final int COL_CONSUMO_POR_KM = 3;
    private final int COL_EIXOS = 4;
    private final int COL_COMPRIMENTO = 5;
    private final int COL_ALTURA = 6;
    private final int COL_LARGURA = 7;
    private final int COL_CARTEIRA_CONDUCAO = 8;
    private final int COL_CARGA = 9;
    private final int COL_COMBUSTIVEL = 10;
    private final int COL_DATA_MANUTENCAO = 11;
    private final int COL_DEPARTAMENTO = 12;
    private final int COL_OPERADORES = 13;

    public TMVeiculos(List<Veiculo> lstVeiculos) {
        this.lista = lstVeiculos;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return 14; // Número de colunas
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case COL_MODELO:
                return "Modelo";
            case COL_CONSUMO_POR_KM:
                return "Consumo por Km";
            case COL_CARGA:
                return "Carga";
            case COL_DEPARTAMENTO:
                return "Departamento";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Veiculo aux = lista.get(rowIndex);

        switch (columnIndex) {
            case COL_PLACA:
                return aux.getPlaca();
            case COL_CHASSI:
                return aux.getChassi();
            case COL_MODELO:
                return aux.getModelo();
            case COL_CONSUMO_POR_KM:
                return aux.getConsumoPorKm();
            case COL_EIXOS:
                return aux.getEixos();
            case COL_COMPRIMENTO:
                return aux.getComprimento();
            case COL_ALTURA:
                return aux.getAltura();
            case COL_LARGURA:
                return aux.getLargura();
            case COL_CARTEIRA_CONDUCAO:
                return aux.getCarteiraConducao();
            case COL_CARGA:
                return aux.getCarga();
            case COL_COMBUSTIVEL:
                return aux.getCombustivel();
            case COL_DATA_MANUTENCAO:
                return aux.getDataManutencao();
            case COL_DEPARTAMENTO:
                return aux.getDepartamento().getNomeDepartamento(); // Supondo que Departamento tenha um método getNomeDepartamento()
            case COL_OPERADORES:
                return aux.getOperador().size(); // Número de operadores associados ao veículo
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        // Tipos das colunas
        if (columnIndex == COL_CONSUMO_POR_KM || 
            columnIndex == COL_EIXOS || 
            columnIndex == COL_COMPRIMENTO || 
            columnIndex == COL_ALTURA || 
            columnIndex == COL_LARGURA || 
            columnIndex == COL_CARGA) {
            return Double.class;
        } else if (columnIndex == COL_OPERADORES) {
            return Integer.class;
        }
        return String.class;
    }

    public List<Veiculo> getLista() {
        return this.lista;
    }
}