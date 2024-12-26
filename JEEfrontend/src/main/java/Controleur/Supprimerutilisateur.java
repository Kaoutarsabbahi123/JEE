package Controleur;

import java.io.IOException;

import Entities.Login;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Login;

/**
 * Servlet implementation class Supprimerutilisateur
 */
@WebServlet("/Supprimerutilisateur")
public class Supprimerutilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private Ilocal_Login local_login;

    /**
     * Default constructor. 
     */
    public Supprimerutilisateur() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		local_login.deleteLogin(id);
		response.sendRedirect("/JEEfrontend/UtilisateurServlet");
	}

}
