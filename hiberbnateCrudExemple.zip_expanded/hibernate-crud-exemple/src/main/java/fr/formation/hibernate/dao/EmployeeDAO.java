package fr.formation.hibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import fr.formation.hibernate.model.Employee;
import fr.formation.hibernate.util.HibernateUtil;

public class EmployeeDAO {
    private SessionFactory sessionFactory;

    public EmployeeDAO() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void ajouterEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            // Démarre une nouvelle transaction pour les opérations sur la base de données
            transaction = session.beginTransaction();
            
            // Persiste l'employé dans la base de données
            session.persist(employee); 

            // Valide la transaction
            transaction.commit();
        } catch (Exception e) {
            // En cas d'erreur ou d'exception, annule la transaction
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


    public Employee lireEmployee(int id) {
        Session session = sessionFactory.openSession();
        Employee employee = null;

        try {
            employee = session.get(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employee;
    }
    
    public List<Employee> listerTousLesEmployes() {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;
        List<Employee> employes = null;

        try {
            // Démarre une nouvelle transaction pour les opérations sur la base de données
            transaction = session.beginTransaction();
            
            // Utilise une requête HQL (Hibernate Query Language) pour obtenir tous les employés
            String hql = "FROM Employee";
            Query<Employee> query = session.createQuery(hql, Employee.class);
            employes = query.list();

            // Valide la transaction
            transaction.commit();
        } catch (Exception e) {
            // En cas d'erreur ou d'exception, annule la transaction
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return employes;
    }

    
    public void modifierEmployee(Employee employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.merge(employee); // Fusionne (update) l'employé dans la base de données
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
    

    public void supprimerEmployee(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            if (employee != null) {
                session.remove(employee);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}


