package tn.iit.model;

public class Enseignant {

    private int id;
    private String nom="";
    private String prenom="";
    private String institut="";

    public Enseignant( String nom, String prenom,String institut) {
        super();

        this.nom = nom;
        this.prenom = prenom;
        this.institut=institut;
    }
    public Enseignant(int id, String nom, String prenom,String institut) {
        super();

        this.id=id;
        this.nom = nom;
        this.prenom = prenom;
        this.institut=institut;
    }



    public String getInstitut() {
        return institut;
    }



    public void setInstitut(String institut) {
        this.institut = institut;
    }



    public Enseignant() {

    }


    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "Enseignant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", institut=" + institut + "]";
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
