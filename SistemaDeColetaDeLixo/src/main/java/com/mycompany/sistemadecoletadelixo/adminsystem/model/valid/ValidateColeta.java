/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.*;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.ColetaException;
import javax.swing.JComboBox;
/**
 *
 * @author Edu
 */


public class ValidateColeta {

    public Coleta validaCamposEntrada(JComboBox<String> supervisor, JComboBox<String> operador, JComboBox<String> rota,
                                      JComboBox<String> veiculo, JComboBox<String> materiaisColetados, String peso) {
        Coleta coleta = new Coleta();

        if (supervisor.getSelectedItem() == null || supervisor.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum supervisor selecionado.");
        coleta.setSupervisor((Supervisor)supervisor.getSelectedItem());

            if (operador.getSelectedItem() == null) {
            throw new ColetaException("Error - Nenhum operador selecionado.");
}            coleta.setOperador((Operador) operador.getSelectedItem());


        if (rota.getSelectedItem() == null || rota.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhuma rota selecionada.");
        coleta.setRota((Rota)rota.getSelectedItem());

        if (veiculo.getSelectedItem() == null || veiculo.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum veículo selecionado.");
        coleta.setVeiculo((Veiculo)veiculo.getSelectedItem());

        if (materiaisColetados.getSelectedItem() == null || materiaisColetados.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum material coletado selecionado.");
        coleta.setMateriaisColetados((Material)materiaisColetados.getSelectedItem());

        if (peso.isEmpty())
            throw new ColetaException("Error - Campo vazio: 'peso'.");
        if (!peso.matches("^[0-9]+(\\.[0-9]+)?$"))
            throw new ColetaException("Error - Valor inválido no campo 'peso'. Use um número válido.");
        coleta.setPeso(peso);

        return coleta; 
    }
}

