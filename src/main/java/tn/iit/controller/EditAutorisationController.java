package tn.iit.controller;

import java.io.IOException;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.AutorisationDao;
import tn.iit.dao.EnseignantDao;
import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class EditAutorisationController
 */
@WebServlet("/EditAutorisationController")
public class EditAutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rdAutorisation = getServletContext().getRequestDispatcher("/autorisation.jsp");
		ServletContext application = getServletContext();
		
		int idens = Integer.parseInt(request.getParameter("idens"));
		System.out.println(idens);

        HttpSession session = request.getSession();
		session.setAttribute("idens", idens);
		
		ArrayList<Autorisation> tAutorisation = (ArrayList<Autorisation>) application.getAttribute("tAutorisation");
		if (tAutorisation == null) { // pour le premier appel
			tAutorisation = new ArrayList<>();
		}
		
		tAutorisation=AutorisationDao.getAutorisationByIdEnseignant(idens);
		application.setAttribute("tAutorisation", tAutorisation); 
		
		int x=SommeHeureSemaine(tAutorisation);
		int y=4-x;
		
		session.setAttribute("y", y);
		
		
		
		
		ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>)  getServletContext().getAttribute("tEnseignant");
		
		   Enseignant enseignant =findById( tEnseignant ,idens);
           request.setAttribute("idens", idens);
	       request.setAttribute("enseignant", enseignant);
	       
	       
	       
	       LocalDate date = LocalDate.of(2023, 6, 12);
	       int weekNumber = getWeekNumber(date);
	       System.out.println("Le numéro de semaine pour la date " + date + " est : " + weekNumber);
	       

	       LocalDate today = LocalDate.now();
	       int weekNumber1 = getWeekNumber(today);
	       System.out.println("Le numéro de semaine pour la date " + date + " est : " + weekNumber1);
		
		
		
		rdAutorisation.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	   public Enseignant findById(ArrayList<Enseignant> enseignants, int idens) {
	        for (Enseignant enseignant : enseignants) {
	            if (enseignant.getId() == idens) {
	                return enseignant;
	            }
	        }
	        return null;
	    }
	   
	   
	   public int SommeHeureSemaine(ArrayList<Autorisation> tAutorisation) {
	       int x=0; 
		   for (Autorisation a : tAutorisation) {
	           x+=a.getNbHeurSemaine();
	        }
	        return x;
	    }
	   
	   
	   
	   public int getWeekNumber(LocalDate date) {
	        WeekFields weekFields = WeekFields.of(Locale.getDefault()); // Obtient les champs de semaine pour la région par défaut
	        return date.get(weekFields.weekOfWeekBasedYear()); // Renvoie le numéro de la semaine pour la date donnée
	    }
	
	

}
