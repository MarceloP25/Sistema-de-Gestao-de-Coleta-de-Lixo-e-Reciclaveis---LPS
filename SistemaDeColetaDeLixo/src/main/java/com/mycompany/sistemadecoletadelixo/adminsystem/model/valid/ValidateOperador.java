/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Operador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.OperadorException;
import javax.swing.JComboBox;
/**
 *
 * @author Edu
 */



public class ValidateOperador {

    public Operador validaCamposEntrada(String nome, String dataNascimento, String rua, String bairro, String cidade,
                                        String numero, String complemento, String cep, String email, String senha,
                                        JComboBox<String> departamento, JComboBox<String> veiculo, JComboBox<String> rota) {
        Operador operador = new Operador();

        // Validação do Nome
        if (nome.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'nome'.");
        operador.setNome(nome);

        // Validação da Data de Nascimento
        if (dataNascimento.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'data de nascimento'.");
        if (!dataNascimento.matches("^\\d{4}-\\d{2}-\\d{2}$")) // Formato esperado: YYYY-MM-DD
            throw new OperadorException("Error - Data de nascimento em formato inválido. Use o formato YYYY-MM-DD.");
        operador.setDataNascimento(dataNascimento);

        // Validação do Endereço
        if (rua.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'rua'.");
        operador.setRua(rua);

        if (bairro.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'bairro'.");
        operador.setBairro(bairro);

        if (cidade.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'cidade'.");
        operador.setCidade(cidade);

        if (numero.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'número'.");
        if (!numero.matches("\\d+"))
            throw new OperadorException("Error - Valor inválido no campo 'número'. Apenas números são permitidos.");
        operador.setNumero(Integer.parseInt(numero));

        operador.setComplemento(complemento); // Opcional

        if (cep.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'CEP'.");
        if (!cep.matches("\\d{5}-\\d{3}")) // Formato esperado: XXXXX-XXX
            throw new OperadorException("Error - CEP em formato inválido. Use o formato XXXXX-XXX.");
        operador.setCep(cep);

        // Validação do Email
        if (email.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'email'.");
        if (!email.matches("^[\\w.%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"))
            throw new OperadorException("Error - Email inválido.");
        operador.setEmail(email);

        // Validação da Senha
        if (senha.isEmpty())
            throw new OperadorException("Error - Campo vazio: 'senha'.");
        if (senha.length() < 6)
            throw new OperadorException("Error - A senha deve ter no mínimo 6 caracteres.");
        operador.setSenha(senha);

        // Validação do Departamento (JComboBox)
        if (departamento.getSelectedItem() == null || departamento.getSelectedItem().toString().isEmpty())
            throw new OperadorException("Error - Nenhum departamento selecionado.");
        operador.setDepartamento(departamento.getSelectedItem().toString());

        // Validação do Veículo (JComboBox)
        if (veiculo.getSelectedItem() == null || veiculo.getSelectedItem().toString().isEmpty())
            throw new OperadorException("Error - Nenhum veículo selecionado.");
        operador.setVeiculo(veiculo.getSelectedItem().toString());

        // Validação da Rota (JComboBox)
        if (rota.getSelectedItem() == null || rota.getSelectedItem().toString().isEmpty())
            throw new OperadorException("Error - Nenhuma rota selecionada.");
        operador.setRota(rota.getSelectedItem().toString());

        return operador;
    }
}
