package tn.iit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import antlr.collections.List;
import tn.iit.model.*;
import tn.iit.utils.JDBCUTIL;

public class EnseignantDao {

	public static void save(Enseignant enseignant) {


		String query="insert into Enseignant values(0,'"+enseignant.getNom()+"','"+enseignant.getPrenom()+"','"+enseignant.getInstitut()+"')";

		System.out.println(query);
		try {
			JDBCUTIL.getStatement().executeUpdate(query);
		}
		catch(SQLException e){
			e.printStackTrace();
		}

	}
	public static void delete(int id) {
		String query="DELETE FROM enseignant WHERE id_enseignant = "+id;
		System.out.println(query);
		try {
			JDBCUTIL.getStatement().executeUpdate(query);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}


	public static ArrayList<Enseignant> getAllEnseignan() {
		ArrayList<Enseignant> enseignants = new ArrayList<>();
		String query="SELECT * FROM enseignant";
		System.out.println(query);
		ResultSet rs = null;
		try {
			rs=	JDBCUTIL.getStatement().executeQuery(query);
			while (rs.next()) {
				Enseignant obj = new Enseignant();
				obj.setId(rs.getInt("id_enseignant"));
				obj.setPrenom(rs.getString("prenom"));
				obj.setNom(rs.getString("nom"));
				obj.setInstitut(rs.getString("institut"));
				enseignants.add(obj);
			}


		}
		catch(SQLException e){
			e.printStackTrace();
		}


		return enseignants;
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