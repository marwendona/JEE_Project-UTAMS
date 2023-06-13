package tn.iit.controller;

import java.io.IOException;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

import java.util.ArrayList;
import java.util.Date;

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
@WebServlet("/AjouteeAutorisationController")
public class AjouteeAutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rdIndex= getServletContext().getRequestDispatcher("/index.jsp");
		ServletContext application = getServletContext();


		//-------------------------------------------
		HttpSession session = request.getSession();
		int idens = (int) session.getAttribute("idens");







		System.out.println(idens);
		System.out.println(request.getParameter("nbHeurSemaine"));

		Date now = new Date();

		Autorisation a =new Autorisation(0,Integer.parseInt(request.getParameter("nbHeurSemaine")),now,idens) ;



		AutorisationDao.ajouteeAutorisation(a, idens);



		//--------------------------------------------






		ArrayList<Autorisation> tAutorisation = (ArrayList<Autorisation>) application.getAttribute("tAutorisation");
		if (tAutorisation == null) { // pour le premier appel
			tAutorisation = new ArrayList<>();
		}


		ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>)  getServletContext().getAttribute("tEnseignant");





		LocalDate date = LocalDate.of(2023, 6, 12);
		int weekNumber = getWeekNumber(date);
		System.out.println("Le numéro de semaine pour la date " + date + " est : " + weekNumber);


		LocalDate today = LocalDate.now();
		int weekNumber1 = getWeekNumber(today);
		System.out.println("Le numéro de semaine pour la date " + date + " est : " + weekNumber1);



		rdIndex.forward(request, response);
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

	public int getWeekNumber(LocalDate date) {
		WeekFields weekFields = WeekFields.of(Locale.getDefault()); // Obtient les champs de semaine pour la région par défaut
		return date.get(weekFields.weekOfWeekBasedYear()); // Renvoie le numéro de la semaine pour la date donnée
	}



}
