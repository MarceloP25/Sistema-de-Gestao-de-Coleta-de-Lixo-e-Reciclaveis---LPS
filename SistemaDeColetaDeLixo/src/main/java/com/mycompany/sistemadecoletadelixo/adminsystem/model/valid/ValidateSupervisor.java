/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.valid;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Supervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.SupervisorException;
import java.util.List;
import javax.swing.JComboBox;
/**
 *
 * @author Edu
 */
public class ValidateSupervisor {

    public Supervisor validaCamposEntrada( String nome, String dataNascimento, String cpf, String email,
                                          String cep, String rua, String bairro, String cidade, String numero,
                                          String complemento, String telefone, String dataContrato, String idDepartamento,
                                          String estacaoDescarga, List<String> rotasSupervisionadas, List<String> veiculosSupervisionados) {
        Supervisor supervisor = new Supervisor();

        if (nome == null || nome.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'nome'.");
        }
        supervisor.setNome(nome);

        if (dataNascimento == null || dataNascimento.isEmpty() || !dataNascimento.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new SupervisorException("Error - Formato inválido: 'data de nascimento'. ");
        }
        supervisor.setDataNascimento(dataNascimento);

        if (cpf == null || cpf.isEmpty() || !cpf.matches("\\d{11}|\\d{14}")) {
            throw new SupervisorException("Error - CPF/CNPJ inválido. Informe 11 (CPF) ou 14 (CNPJ) dígitos numéricos.");
        }
        supervisor.setCpf(cpf);

        if (email == null || email.isEmpty() || !email.matches("^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
            throw new SupervisorException("Error - Formato inválido: 'email'.");
        }
        supervisor.setEmail(email);

        if (cep == null || cep.isEmpty() || !cep.matches("\\d{5}-\\d{3}")) {
            throw new SupervisorException("Error - Formato inválido: 'CEP'. ");
        }
        supervisor.setCep(cep);

        if (rua == null || rua.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'rua'.");
        }
        supervisor.setRua(rua);

        if (bairro == null || bairro.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'bairro'.");
        }
        supervisor.setBairro(bairro);

        if (cidade == null || cidade.isEmpty()) {
            throw new SupervisorException("Error - Campo vazio: 'cidade'.");
        }
        supervisor.setCidade(cidade);

        if (numero == null || numero.isEmpty() || !numero.matches("\\d+")) {
            throw new SupervisorException("Error - O campo 'número' deve conter apenas números.");
        }
        supervisor.setNumero(numero);

        supervisor.setComplemento(complemento);

        if (telefone == null || telefone.isEmpty() || !telefone.matches("\\(\\d{2}\\) \\d{4,5}-\\d{4}")) {
            throw new SupervisorException("Error - Formato inválido: 'telefone'. ");
        }
        supervisor.setTelefone(telefone);

        if (dataContrato == null || dataContrato.isEmpty() || !dataContrato.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new SupervisorException("Error - Formato inválido: 'data do contrato'. ");
        }
        supervisor.setDataContrato(dataContrato);

        if (idDepartamento == null || idDepartamento.isEmpty() || !idDepartamento.matches("\\d+")) {
            throw new SupervisorException("Error - ID do departamento inválido.");
        }
        supervisor.setIdDepartamento((idDepartamento));

        if (estacaoDescarga == null || estacaoDescarga.isEmpty()) {
            throw new SupervisorException("Error - Nenhuma estação de descarga informada.");
        }
        supervisor.setEstacaoDescarga(estacaoDescarga);

        if (rotasSupervisionadas == null || rotasSupervisionadas.isEmpty()) {
            throw new SupervisorException("Error - O supervisor deve supervisionar pelo menos uma rota.");
        }
        supervisor.setRotasSupervisionadas(rotasSupervisionadas);

        if (veiculosSupervisionados == null || veiculosSupervisionados.isEmpty()) {
            throw new SupervisorException("Error - O supervisor deve supervisionar pelo menos um veículo.");
        }
        supervisor.setVeiculosSupervisionados(veiculosSupervisionados);

        return supervisor;
    }
}
