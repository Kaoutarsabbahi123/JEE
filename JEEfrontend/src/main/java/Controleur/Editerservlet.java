package Controleur;

import java.io.IOException;

import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_StagiaireLocal;

/**
 * Servlet implementation class Editerservlet
 */
@WebServlet("/Editerservlet")
public class Editerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Ilocal_StagiaireLocal stagiairelocal;
    public Editerservlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     int id=Integer.valueOf(request.getParameter("id"));
     Stagiaire stagiaire=stagiairelocal.getStagiaire(id);
     request.getSession().setAttribute("stagiaire", stagiaire);
     
     
	}


}
