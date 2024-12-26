package Controleur;

import java.io.IOException;
import java.util.List;

import Entities.Login;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Login;

/**
 * Servlet implementation class Searchutilisateur
 */
@WebServlet("/Searchutilisateur")
public class Searchutilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Login local_login;
    /**
     * Default constructor. 
     */
    public Searchutilisateur() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    String keyword = request.getParameter("keyword");
	        List<Login> searchResults = local_login.searchUsers(keyword);
	        request.getSession().setAttribute("keyword", keyword);
	        request.setAttribute("utilisateurs", searchResults);
	        response.sendRedirect("Utilisateur.jsp");
	}

}
