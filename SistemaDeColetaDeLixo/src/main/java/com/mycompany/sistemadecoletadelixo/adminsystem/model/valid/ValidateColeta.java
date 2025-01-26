/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Coleta;
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

        // Validação do Supervisor
        if (supervisor.getSelectedItem() == null || supervisor.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum supervisor selecionado.");
        coleta.setSupervisor(supervisor.getSelectedItem().toString());

        // Validação do Operador
        if (operador.getSelectedItem() == null || operador.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum operador selecionado.");
        coleta.setOperador(operador.getSelectedItem().toString());

        // Validação da Rota
        if (rota.getSelectedItem() == null || rota.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhuma rota selecionada.");
        coleta.setRota(rota.getSelectedItem().toString());

        // Validação do Veículo
        if (veiculo.getSelectedItem() == null || veiculo.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum veículo selecionado.");
        coleta.setVeiculo(veiculo.getSelectedItem().toString());

        // Validação dos Materiais Coletados
        if (materiaisColetados.getSelectedItem() == null || materiaisColetados.getSelectedItem().toString().isEmpty())
            throw new ColetaException("Error - Nenhum material coletado selecionado.");
        coleta.setMateriaisColetados(materiaisColetados.getSelectedItem().toString());

        // Validação do Peso
        if (peso.isEmpty())
            throw new ColetaException("Error - Campo vazio: 'peso'.");
        if (!peso.matches("^[0-9]+(\\.[0-9]+)?$")) // Valida números inteiros ou decimais
            throw new ColetaException("Error - Valor inválido no campo 'peso'. Use um número válido.");
        coleta.setPeso(Double.parseDouble(peso));

        return coleta;
    }
}

