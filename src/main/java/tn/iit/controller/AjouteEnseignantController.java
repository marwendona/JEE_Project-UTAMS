package tn.iit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.EnseignantDao;
import tn.iit.model.Enseignant;





@WebServlet("/AjouteEnseignantController")
public class AjouteEnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		RequestDispatcher rdIndex = getServletContext().getRequestDispatcher("/index.jsp");
		RequestDispatcher rdEns = getServletContext().getRequestDispatcher("/EnseignantController");
		ServletContext application = getServletContext();


		HttpSession session = request.getSession();
		Enseignant e = (Enseignant) session.getAttribute("enseignant");

		System.out.println("enseignant  de la session e"+e.toString());

		EnseignantDao.save(e);


		ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>) application.getAttribute("tEnseignant");
		if (tEnseignant == null) { // pour le premier appel
			tEnseignant = new ArrayList<>();
		}


		System.out.println("ListEnseignant 9bal ma zed"+tEnseignant.toString());

		tEnseignant=EnseignantDao.getAllEnseignan();
		application.setAttribute("tEnseignant", tEnseignant);

		String a = application.getAttribute("tEnseignant").toString();
		System.out.println("application ListEnseignant"+a);
		//---------------------------
		//session.invalidate();


		request.setAttribute("enseignant", "");

		rdIndex.forward(request, response);


	}




}
