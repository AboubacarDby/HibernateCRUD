package fr.formation.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Ajouter à cette classe l'annotation @Entity pour indiquer qu'il s'agit d'une entité persistante (JPA Entity Class)
@Entity
// Utiliser l'annotation @Table pour spécifier le nom de la table dans la base de données
@Table(name = "Employee")
public class Employee {
    // Utiliser l'annotation @Id pour indiquer que cette propriété est la clé primaire
    @Id
    // Utiliser @GeneratedValue avec la stratégie GenerationType.IDENTITY pour indiquer que la clé primaire est générée automatiquement
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id") // Utiliser @Column pour spécifier le nom de la colonne dans la table
    private int id;
    
    @Column(name= "nom")
    private String nom;
    
    @Column(name= "prenom")
    private String prenom;
    
    @Column(name= "age")
    private int age;
    
    @Column(name= "poste")
    private String poste;

    // Constructeur par défaut
    public Employee() {
        super();
    }

    // Constructeur avec des paramètres
    public Employee(int id, String nom, String prenom, int age, String poste) {
        super();
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.poste = poste;
    }

    // Getters et setters pour accéder aux propriétés
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    // Redéfinition de la méthode toString pour afficher les informations de l'employé
    @Override
    public String toString() {
        return "Employee [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", poste=" + poste + "]";
    }
}
