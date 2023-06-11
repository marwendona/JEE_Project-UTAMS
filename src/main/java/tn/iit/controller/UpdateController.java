package tn.iit.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.model.Enseignant;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pos = Integer.parseInt(request.getParameter("pos"));
    	ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>)  getServletContext().getAttribute("tEnseignant");
        

        Enseignant enseignant = tEnseignant.get(pos);
        
        
        request.setAttribute("pos", pos);
        request.setAttribute("enseignant", enseignant);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pos = Integer.parseInt(request.getParameter("pos"));

    	ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>)  getServletContext().getAttribute("tEnseignant");
        

        Enseignant enseignant=new Enseignant(request.getParameter("nom"),
                request.getParameter("prenom"));
        

        tEnseignant.set(pos, enseignant);
        getServletContext().setAttribute("tEnseignant", tEnseignant);
        response.sendRedirect("index.jsp");
    }

}
