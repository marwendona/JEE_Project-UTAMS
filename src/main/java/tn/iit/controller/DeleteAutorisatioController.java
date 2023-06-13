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

import tn.iit.dao.AutorisationDao;
import tn.iit.dao.EnseignantDao;
import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;


/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/DeleteAutorisatioController")
public class DeleteAutorisatioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAutorisatioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		ServletContext application = getServletContext();

		int idauto = Integer.parseInt(request.getParameter("idauto"));
		
		 HttpSession session = request.getSession();
			int idens = (int) session.getAttribute("idens");
		    int y=(int)session.getAttribute("y");
		    ArrayList<Autorisation>   tAutorisation=AutorisationDao.getAutorisationById(idens);
		    for (Autorisation a : tAutorisation) {
		           y+=a.getNbHeurSemaine();
		        }
		 
			session.setAttribute("y", y);
			//getAutorisationById

		
		AutorisationDao.delete(idauto);
		
		


		application.setAttribute("tAutorisation", AutorisationDao.getAutorisationByIdEnseignant(idens)); 
		
		response.sendRedirect("autorisation.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
