package fr.formation.hibernate;

import fr.formation.hibernate.dao.EmployeeDAO;
import fr.formation.hibernate.model.Employee;

public class App {

	public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAO();

        // Création d'un nouvel employé
        Employee nouvelEmploye = new Employee();
        nouvelEmploye.setNom("Doe");
        nouvelEmploye.setPrenom("John");
        nouvelEmploye.setAge(30);
        nouvelEmploye.setPoste("Développeur");

        // Ajout de l'employé à la base de données
        employeeDAO.ajouterEmployee(nouvelEmploye);
        System.out.println("Nouvel employé ajouté : " + nouvelEmploye);

        // Lecture d'un employé par son ID
        int idALire = 1; // Remplacez par l'ID de l'employé que vous souhaitez lire
        Employee employeLu = employeeDAO.lireEmployee(idALire);
        if (employeLu != null) {
            System.out.println("Lecture de l'employé avec ID " + idALire + ": " + employeLu);
        } else {
            System.out.println("Aucun employé trouvé avec l'ID " + idALire);
        }

        // Lecture de tous les employés
        System.out.println("Liste de tous les employés :");
        employeeDAO.listerTousLesEmployes().forEach(System.out::println);

        // Mise à jour d'un employé existant
        int idAModifier = 1; // Remplacez par l'ID de l'employé que vous souhaitez modifier
        Employee employeAModifier = employeeDAO.lireEmployee(idAModifier);
        if (employeAModifier != null) {
            employeAModifier.setAge(31); // Modification de l'âge
            employeAModifier.setPoste("Développeur senior"); // Modification du poste
            employeeDAO.modifierEmployee(employeAModifier);
            System.out.println("Employé modifié avec succès : " + employeAModifier);
        } else {
            System.out.println("Aucun employé trouvé avec l'ID " + idAModifier);
        }

        // Suppression d'un employé par son ID
        int idASupprimer = 2; // Remplacez par l'ID de l'employé que vous souhaitez supprimer
        Employee employeASupprimer = employeeDAO.lireEmployee(idASupprimer);
        if (employeASupprimer != null) {
            employeeDAO.supprimerEmployee(idASupprimer);
            System.out.println("Employé supprimé avec succès : " + employeASupprimer);
        } else {
            System.out.println("Aucun employé trouvé avec l'ID " + idASupprimer);
        }

        // Liste de tous les employés après les opérations
        System.out.println("Liste de tous les employés après les opérations :");
        employeeDAO.listerTousLesEmployes().forEach(System.out::println);
    }

}
