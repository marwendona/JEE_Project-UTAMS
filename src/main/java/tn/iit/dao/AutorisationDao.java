package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import antlr.collections.List;
import tn.iit.model.*;
import tn.iit.utils.JDBCUTIL;

public class AutorisationDao {

	public static void ajouteeAutorisation(Autorisation autorisation,int id) {


		//String query="insert into autorisation values(0,'"+autorisation.getIdAutorisation()+"','"+autorisation.getNbHeurSemaine()+"','"+autorisation.getDate()+"','"+id+"')";
		String query="insert into autorisation values('0','"+autorisation.getNbHeurSemaine()+"','2023-06-13','"+id+"')";

		System.out.println(query);
		try {
			JDBCUTIL.getStatement().executeUpdate(query);
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}
	public static void delete(int id) {
		String query="DELETE FROM autorisation WHERE idAutorisation = "+id;
		System.out.println(query);
		try {
			JDBCUTIL.getStatement().executeUpdate(query);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}


	public static ArrayList<Autorisation> getAllAutorisation() {
		ArrayList<Autorisation> autorisations = new ArrayList<>();
		String query="SELECT * FROM autorisation";
		System.out.println(query);
		ResultSet rs = null;
		try {
			rs=	JDBCUTIL.getStatement().executeQuery(query);
			while (rs.next()) {
				Autorisation obj = new Autorisation();
				obj.setIdAutorisation(rs.getInt("idAutorisation"));
				obj.setNbHeurSemaine(rs.getInt("nbHeurSemaine"));
				obj.setDate(rs.getDate("date"));
				obj.setIdEnseignant(rs.getInt("idEnseignant"));
				autorisations.add(obj);
			}


		}
		catch(SQLException e){
			e.printStackTrace();
		}


		return autorisations;
	}
	public static ArrayList<Autorisation> getAutorisationByIdEnseignant(int id) {

		ArrayList<Autorisation> autorisations = new ArrayList<>();
		String query = "SELECT * FROM autorisation WHERE idEnseignant = " + id;
		System.out.println(query);
		ResultSet rs = null;
		try {
			rs=	JDBCUTIL.getStatement().executeQuery(query);
			while (rs.next()) {
				Autorisation obj = new Autorisation();
				obj.setIdAutorisation(rs.getInt("idAutorisation"));
				obj.setNbHeurSemaine(rs.getInt("nbHeurSemaine"));
				obj.setDate(rs.getDate("date"));
				obj.setIdEnseignant(rs.getInt("idEnseignant"));
				autorisations.add(obj);
			}


		}
		catch(SQLException e){
			e.printStackTrace();
		}


		return autorisations;



	}
	public static ArrayList<Autorisation> getAutorisationById(int id) {

		ArrayList<Autorisation> autorisations = new ArrayList<>();
		String query = "SELECT * FROM autorisation WHERE idAutorisation = " + id;
		System.out.println(query);
		ResultSet rs = null;
		try {
			rs=	JDBCUTIL.getStatement().executeQuery(query);
			while (rs.next()) {
				Autorisation obj = new Autorisation();
				obj.setIdAutorisation(rs.getInt("idAutorisation"));
				obj.setNbHeurSemaine(rs.getInt("nbHeurSemaine"));
				obj.setDate(rs.getDate("date"));
				obj.setIdEnseignant(rs.getInt("idEnseignant"));
				autorisations.add(obj);
			}


		}
		catch(SQLException e){
			e.printStackTrace();
		}


		return autorisations;



	}




	public static void update(Enseignant enseignant) {
		String query = "UPDATE Enseignant SET nom='" + enseignant.getNom() + "', prenom='" + enseignant.getPrenom() + "', institut='" + enseignant.getInstitut() + "' WHERE id_enseignant=" + enseignant.getId();
		System.out.println(query);
		try {
			JDBCUTIL.getStatement().executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Enseignant getAllEnseignan2() {
		return null;
	}

}