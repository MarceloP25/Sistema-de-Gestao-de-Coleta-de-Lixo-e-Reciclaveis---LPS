
package com.mycompany.sistemadecoletadelixo.adminsystem.model.entities;

/**
 *
 * @author marce
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Departamento departamento;

    @ManyToOne
    private EstacaoDescarga estacaoDeDescarga;

    @ManyToOne
    private Supervisor supervisor;

    private float peso;

    @OneToMany
    private List<Material> materiaisColetados;

    @ManyToOne
    private Operador operador;

    @ManyToOne
    private Rota rota;

    @ManyToOne
    private Veiculo veiculo;

    public Coleta() {
        this.id = -1L;
        this.departamento = new Departamento();
        this.estacaoDeDescarga = new EstacaoDescarga();
        this.supervisor = new Supervisor();
        this.peso = 0;
        this.materiaisColetados = new ArrayList<>();
        this.operador = new Operador();
        this.rota = new Rota();
        this.veiculo = new Veiculo();
    }

    public Coleta(
            Departamento departamento,
            EstacaoDescarga estacaoDeDescarga,
            Supervisor supervisor,
            float peso,
            List<Material> materiaisColetados,
            Operador operador,
            Rota rota,
            Veiculo veiculo
    ) {
        this.departamento = departamento;
        this.estacaoDeDescarga = estacaoDeDescarga;
        this.supervisor = supervisor;
        this.peso = peso;
        this.materiaisColetados = materiaisColetados;
        this.operador = operador;
        this.rota = rota;
        this.veiculo = veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public EstacaoDescarga getEstacaoDeDescarga() {
        return estacaoDeDescarga;
    }

    public void setEstacaoDeDescarga(EstacaoDescarga estacaoDeDescarga) {
        this.estacaoDeDescarga = estacaoDeDescarga;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public List<Material> getMateriaisColetados() {
        return materiaisColetados;
    }

    public void setMateriaisColetados(List<Material> materiaisColetados) {
        this.materiaisColetados = materiaisColetados;
    }

    public Operador getOperador() {
        return operador;
    }

    public void setOperador(Operador operador) {
        this.operador = operador;
    }

    public Rota getRota() {
        return rota;
    }

    public void setRota(Rota rota) {
        this.rota = rota;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }
}