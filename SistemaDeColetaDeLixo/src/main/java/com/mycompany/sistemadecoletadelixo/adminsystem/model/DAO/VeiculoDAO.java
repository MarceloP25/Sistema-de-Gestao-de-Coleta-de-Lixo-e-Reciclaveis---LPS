/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO;

/**
 *
 * @author marce
 */
import com.mycompany.sistemadecoletadelixo.adminsystem.factory.DatabaseJPA;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Veiculo;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.VeiculoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class VeiculoDAO implements IDAO<Veiculo> {

    private EntityManager entityManager;
    
    @Override
    public void save(Veiculo obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Veiculo obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Veiculo find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        Veiculo veiculo = this.entityManager.find(Veiculo.class, id);

        this.entityManager.close();

        return veiculo;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Veiculo veiculoJPA = this.entityManager.find(Veiculo.class, id);
        if (veiculoJPA != null) {
            this.entityManager.remove(veiculoJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new VeiculoException("Error - Veiculo inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Veiculo> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Veiculo a";
        TypedQuery qry = this.entityManager.createQuery(jpql, Veiculo.class);

        List<Veiculo> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
    public List<Veiculo> filterByModel(String modelo) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Veiculo a "
                + " WHERE a.modelo like :modelo ";
        TypedQuery<Veiculo> qry = this.entityManager.createQuery(jpql, Veiculo.class);
        qry.setParameter("modelo", modelo + "%");

        List<Veiculo> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
        public List<Veiculo> filterByDepartamento(String departamento) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Veiculo a "
                + " WHERE a.departamento like :departamento ";
        TypedQuery<Veiculo> qry = this.entityManager.createQuery(jpql, Veiculo.class);
        qry.setParameter("departamento", departamento + "%");

        List<Veiculo> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }
    
}
