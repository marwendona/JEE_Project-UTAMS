package tn.iit.model;

public class Enseignant {
    private int id;
    private String nom = "";
    private String prenom = "";

    public Enseignant(String nom, String prenom) {
        super();
        this.nom = nom;
        this.prenom = prenom;
    }

    public Enseignant() {
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Enseignant [nom=" + nom + ", prenom=" + prenom + "]";
    }

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
}
