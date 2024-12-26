package Controleur;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Login;
import Entities.Login;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/UtilisateurServlet")
public class UtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Login local_login;
    /**
     * Default constructor. 
     */
    public UtilisateurServlet() {
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		try {
            
            List<Login> utilisateurs = local_login.getallLogin();

            
            request.getSession().setAttribute("utilisateurs", utilisateurs);
           
            RequestDispatcher dispatcher = request.getRequestDispatcher("Utilisateur.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
           
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
	}

}
