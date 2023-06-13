package tn.iit.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.EnseignantDao;
import tn.iit.model.Enseignant;


/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		ServletContext application = getServletContext();
		ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>) application.getAttribute("tEnseignant");

		int idens = Integer.parseInt(request.getParameter("idens"));

		//Enseignant enseignant = tEnseignant.get(pos);


		//tEnseignant.remove(pos);
		EnseignantDao.delete(idens);

		ArrayList<Enseignant> l=EnseignantDao.getAllEnseignan();
		System.out.println("liste de la BD "+l.toString());
		application.setAttribute("tEnseignant", l);
		//application.setAttribute("tEnseignant", tEnseignant);

		request.setAttribute("id", -1);

		response.sendRedirect("index.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
