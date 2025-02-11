/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO;

import com.mycompany.sistemadecoletadelixo.adminsystem.factory.DatabaseJPA;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Supervisor;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.SupervisorException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author marce
 */
public class SupervisorDAO implements IDAO<Supervisor> {

    private EntityManager entityManager;
    
    @Override
    public void save(Supervisor obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Supervisor obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Supervisor find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Supervisor supervisor = this.entityManager.find(Supervisor.class, id);

        this.entityManager.close();

        return supervisor;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Supervisor supervisorJPA = this.entityManager.find(Supervisor.class, id);
        if (supervisorJPA != null) {
            this.entityManager.remove(supervisorJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new SupervisorException("Error - Supervisor inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Supervisor> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT s FROM Supervisor s";
        TypedQuery qry = this.entityManager.createQuery(jpql, Supervisor.class);

        List<Supervisor> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public Supervisor findByCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT s "
                + " FROM Supervisor s "
                + " WHERE s.cpf like :cpf";
        TypedQuery<Supervisor> qry = this.entityManager.createQuery(jpql, Supervisor.class);
        qry.setParameter("cpf", cpf);

        List lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Supervisor) lst.get(0);
        }
    }

    public List<Supervisor> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT s "
                + " FROM Supervisor s "
                + " WHERE s.nome like :nome ";
        TypedQuery<Supervisor> qry = this.entityManager.createQuery(jpql, Supervisor.class);
        qry.setParameter("nome", nome + "%");

        List<Supervisor> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}