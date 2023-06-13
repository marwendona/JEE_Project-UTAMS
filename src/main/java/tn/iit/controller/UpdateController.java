package tn.iit.controller;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class UpdateController
 */
@WebServlet("/Update")
public class UpdateController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UpdateController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idens = Integer.parseInt(request.getParameter("idens"));
        ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>)  getServletContext().getAttribute("tEnseignant");

        System.out.println(idens);

        Enseignant enseignant =findById( tEnseignant ,idens);


        HttpSession session = request.getSession();
        session.setAttribute("idens", idens);

        request.setAttribute("idens", idens);
        request.setAttribute("enseignant", enseignant);
        request.getRequestDispatcher("update.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext application = getServletContext();
        HttpSession session = request.getSession();
        int idens = (int) session.getAttribute("idens");
        System.out.println(idens);






        Enseignant enseignant=new Enseignant(
                idens,
                request.getParameter("nom"),
                request.getParameter("prenom"),
                request.getParameter("institut")
        );

        EnseignantDao.update(enseignant);

        ArrayList<Enseignant> tEnseignant = (ArrayList<Enseignant>)  getServletContext().getAttribute("tEnseignant");
        tEnseignant=EnseignantDao.getAllEnseignan();
        application.setAttribute("tEnseignant", tEnseignant);

        System.out.println(enseignant.toString());

        response.sendRedirect("index.jsp");
    }

    public Enseignant findById(ArrayList<Enseignant> enseignants, int id) {
        for (Enseignant enseignant : enseignants) {
            if (enseignant.getId() == id) {
                return enseignant;
            }
        }
        return null;
    }
}
