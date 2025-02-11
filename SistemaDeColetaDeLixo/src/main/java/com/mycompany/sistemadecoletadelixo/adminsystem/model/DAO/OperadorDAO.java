/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemadecoletadelixo.adminsystem.model.DAO;

import com.mycompany.sistemadecoletadelixo.adminsystem.factory.DatabaseJPA;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.entities.Operador;
import com.mycompany.sistemadecoletadelixo.adminsystem.model.exceptions.OperadorException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
/**
 *
 * @author marce
 */
public class OperadorDAO implements IDAO<Operador> {

    private EntityManager entityManager;
    
    @Override
    public void save(Operador obj) { 
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public void update(Operador obj) {  
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();
        this.entityManager.merge(obj);
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    @Override
    public Operador find(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        Operador operador = this.entityManager.find(Operador.class, id);

        this.entityManager.close();

        return operador;
    }

    @Override
    public boolean delete(Long id) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();
        this.entityManager.getTransaction().begin();

        Operador operadorJPA = this.entityManager.find(Operador.class, id);
        if (operadorJPA != null) {
            this.entityManager.remove(operadorJPA);
        } else {
            this.entityManager.getTransaction().rollback();
            throw new OperadorException("Error - Operador inexistente.");
        }

        this.entityManager.getTransaction().commit();
        this.entityManager.close();
        return true;
    }

    @Override
    public List<Operador> findAll() {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = "SELECT o FROM Operador o";
        TypedQuery qry = this.entityManager.createQuery(jpql, Operador.class);

        List<Operador> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

    public Operador findByCpf(String cpf) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT o "
                + " FROM Operador o "
                + " WHERE o.cpf like :cpf";
        TypedQuery<Operador> qry = this.entityManager.createQuery(jpql, Operador.class);
        qry.setParameter("cpf", cpf);

        List lst = qry.getResultList();
        this.entityManager.close();

        if (lst.isEmpty()) {
            return null;
        } else {
            return (Operador) lst.get(0);
        }
    }

    public List<Operador> filterByName(String nome) {
        this.entityManager = DatabaseJPA.getInstance().getEntityManager();

        String jpql = " SELECT o "
                + " FROM Operador o "
                + " WHERE o.nome like :nome ";
        TypedQuery<Operador> qry = this.entityManager.createQuery(jpql, Operador.class);
        qry.setParameter("nome", nome + "%");

        List<Operador> lst = qry.getResultList();

        this.entityManager.close();
        return lst;
    }

}
