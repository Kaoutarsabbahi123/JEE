package Controleur;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Employe;
import Entities.Employe;
import Entities.Login;

/**
 * Servlet implementation class SearchEncadrant
 */
@WebServlet("/SearchEncadrant")
public class SearchEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private Ilocal_Employe local_employe;
    /**
     * Default constructor. 
     */
    public SearchEncadrant() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String keyword = request.getParameter("keyword");
        List<Employe> searchResults = local_employe.searchEmploye(keyword);
        request.getSession().setAttribute("keyword", keyword);
        request.setAttribute("encadrants", searchResults);
        response.sendRedirect("Encadrant.jsp");
}

}
