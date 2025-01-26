/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Supervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.SupervisorException;
import javax.swing.JComboBox;
/**
 *
 * @author Edu
 */
public class ValidateSupervisor {

    public Supervisor validaCamposEntrada(String nome, String dataNascimento, String rua, String bairro, String cidade,
                                          String numero, String complemento, String cep, String email, String senha,
                                          JComboBox<String> departamento, JComboBox<String> estacaoDescarga) {
        Supervisor supervisor = new Supervisor();

        // Validação do Nome
        if (nome == null || nome.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'nome'.");
        }
        supervisor.setNome(nome);

        // Validação da Data de Nascimento
        if (dataNascimento == null || dataNascimento.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'data de nascimento'.");
        }
        if (!dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new SupervisorException("Error - Formato inválido: 'data de nascimento'. Use o formato dd/MM/yyyy.");
        }
        supervisor.setDataNascimento(dataNascimento);

        // Validação da Rua
        if (rua == null || rua.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'rua'.");
        }
        supervisor.setRua(rua);

        // Validação do Bairro
        if (bairro == null || bairro.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'bairro'.");
        }
        supervisor.setBairro(bairro);

        // Validação da Cidade
        if (cidade == null || cidade.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'cidade'.");
        }
        supervisor.setCidade(cidade);

        // Validação do Número
        if (numero == null || numero.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'número'.");
        }
        if (!numero.matches("\\d+")) {
            throw new SupervisorException("Error - O campo 'número' deve conter apenas números.");
        }
        supervisor.setNumero(numero);

        // Validação do Complemento
        supervisor.setComplemento(complemento); // Campo opcional

        // Validação do CEP
        if (cep == null || cep.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'CEP'.");
        }
        if (!cep.matches("\\d{5}-\\d{3}")) {
            throw new SupervisorException("Error - Formato inválido: 'CEP'. Use o formato 00000-000.");
        }
        supervisor.setCep(cep);

        // Validação do Email
        if (email == null || email.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'email'.");
        }
        if (!email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new SupervisorException("Error - Formato inválido: 'email'.");
        }
        supervisor.setEmail(email);

        // Validação da Senha
        if (senha == null || senha.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'senha'.");
        }
        if (senha.length() < 6) {
            throw new SupervisorException("Error - A senha deve conter no mínimo 6 caracteres.");
        }
        supervisor.setSenha(senha);

        // Validação do Departamento (JComboBox)
        if (departamento.getSelectedItem() == null || departamento.getSelectedItem().toString().isEmpty()) {
            throw new SupervisorException("Error - Nenhum departamento selecionado.");
        }
        supervisor.setDepartamento(departamento.getSelectedItem().toString());

        // Validação da Estação de Descarga (JComboBox)
        if (estacaoDescarga.getSelectedItem() == null || estacaoDescarga.getSelectedItem().toString().isEmpty()) {
            throw new SupervisorException("Error - Nenhuma estação de descarga selecionada.");
        }
        supervisor.setEstacaoDescarga(estacaoDescarga.getSelectedItem().toString());

        return supervisor;
    }
}

