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
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Departamento;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.DepartamentoException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;



public class DepartamentoDAO implements IDAO<Departamento> {

    private EntityManager entityManager;
    
    @Override
    public void save(Departamento obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Departamento obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Departamento find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();


        Departamento departamento = this.entityManager.find(Departamento.class, id);

        this.entityManager.close();

        return departamento;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Departamento departamentoJPA = this.entityManager.find(Departamento.class, id);
        if (departamentoJPA != null) {
            this.entityManager.remove(departamentoJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new DepartamentoException("Error - Departamento inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Departamento> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT a FROM Departamento a";
        TypedQuery qry = this.entityManager.createQuery(jpql, Departamento.class);

        List<Departamento> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public List<Departamento> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT a "
                + " FROM Departamento a "
                + " WHERE a.nome like :nome ";
        TypedQuery<Departamento> qry = this.entityManager.createQuery(jpql, Departamento.class);
        qry.setParameter("nome", nome + "%");

        List<Departamento> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
