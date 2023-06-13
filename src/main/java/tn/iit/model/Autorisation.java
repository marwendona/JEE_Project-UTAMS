package tn.iit.model;

import java.time.LocalDate;
import java.util.Date;

public class Autorisation {
	private int idAutorisation;
	private int nbHeurSemaine;
	private  Date date;
	private int idEnseignant;

	public Autorisation(int idAutorisation, int nbHeurSemaine, Date date, int idEnseignant) {
		super();
		this.idAutorisation = idAutorisation;
		this.nbHeurSemaine = nbHeurSemaine;
		this.date = date;
		this.idEnseignant = idEnseignant;
	}


	public Autorisation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getIdAutorisation() {
		return idAutorisation;
	}


	public void setIdAutorisation(int idAutorisation) {
		this.idAutorisation = idAutorisation;
	}


	public int getNbHeurSemaine() {
		return nbHeurSemaine;
	}



	public void setNbHeurSemaine(int nbHeurSemaine) {
		this.nbHeurSemaine = nbHeurSemaine;
	}




	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getIdEnseignant() {
		return idEnseignant;
	}


	public void setIdEnseignant(int idEnseignant) {
		this.idEnseignant = idEnseignant;
	}


	@Override
	public String toString() {
		return "Autorisation [idAutorisation=" + idAutorisation + ", nbHeurSemaine=" + nbHeurSemaine + ", date=" + date
				+ ", idEnseignant=" + idEnseignant + "]";
	}




}
