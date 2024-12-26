package Controleur;
import java.io.IOException;
import java.util.List;

import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_StagiaireLocal;

// Import your Stagiaire class and any necessary database-related classes

@WebServlet("/StagiaireServlet")
public class Stagiaireservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	    private Ilocal_StagiaireLocal localStagiaire;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        try {
            List<Stagiaire> stagiaires = localStagiaire.getallStagiaire();
           
            request.getSession().setAttribute("stagiaires", stagiaires);
            
            RequestDispatcher dispatcher = request.getRequestDispatcher("Stagiaire.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
    }
}
