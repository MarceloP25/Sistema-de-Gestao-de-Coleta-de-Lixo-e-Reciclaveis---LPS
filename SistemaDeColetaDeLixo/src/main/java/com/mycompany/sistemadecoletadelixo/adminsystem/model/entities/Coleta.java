
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
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public class Coleta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany
    private Departamento departamento;
    
    private EstacaoDescarga estacaoDeDescarga;
    private Supervisor supervisor;
    private float peso;
    private List<Material> materiaisColetados;
    private Operador operador;
    private Rota rota;
    private Veiculo veiculo;
    
    public Coleta(){
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
            List materiaisColetados,
            Operador operador,
            Rota rota,
            Veiculo veiculo
        ){
        this.departamento = departamento;
        this.estacaoDeDescarga = estacaoDeDescarga;
        this.supervisor = supervisor;
        this.peso = peso;
        this.materiaisColetados = materiaisColetados;
        this.operador = operador;
        this.rota = rota;
        this.veiculo = veiculo;
    }
}

