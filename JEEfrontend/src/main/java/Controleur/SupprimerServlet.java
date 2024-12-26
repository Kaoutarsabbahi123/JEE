package Controleur;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_StagiaireLocal;

/**
 * Servlet implementation class SupprimerServlet
 */
@WebServlet("/SupprimerServlet")
public class SupprimerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private Ilocal_StagiaireLocal localStagiaire;
    /**
     * Default constructor. 
     */
    public SupprimerServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int id=Integer.valueOf(request.getParameter("id"));
				
				localStagiaire.SupprimerStagiaire(id);
				response.sendRedirect("/JEEfrontend/StagiaireServlet");
	}

}
