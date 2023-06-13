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

import tn.iit.model.Enseignant;


/**
 * Servlet implementation class EnseignantController
 */
@WebServlet("/EnseignantController")
public class EnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//doGet(request, response);
		RequestDispatcher rdIndex = getServletContext().getRequestDispatcher("/index.jsp");
		rdIndex.forward(request, response);
		/*
		HttpSession session = request.getSession(); 
		ServletContext application = getServletContext();
		ArrayList<Enseignant> tUser = (ArrayList<Enseignant>) application.getAttribute("ListEnseignant");
		*/




		//rdIndex.forward(request, response);


	}

}
