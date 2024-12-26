package Controleur;

import java.io.IOException;

import Entities.Login;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sessions.Ilocal_LoginLocal;

/**
 * Servlet implementation class Authentifier
 */
@WebServlet("/Authentifier")
public class Authentifier extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_LoginLocal loginlocal;
    
    public Authentifier() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id_login=request.getParameter("email");
		String mot_passe=request.getParameter("password");
		String role = loginlocal.authentifier(id_login,mot_passe); // Mettez à jour cette méthode en fonction de votre implémentation
		request.getSession().setAttribute("userRole", role);
		HttpSession session = request.getSession();
        Integer remainingAttempts = (Integer) session.getAttribute("remainingAttempts");

        if (remainingAttempts == null) {
            remainingAttempts = 3;
            session.setAttribute("remainingAttempts", remainingAttempts);
        }
        if(role != null) {
    		Login user =loginlocal.getLogin(id_login);
    		request.getSession().setAttribute("utilisateur", user);
    		request.getSession().setAttribute("mot_passe", mot_passe);
    		response.sendRedirect("/JEEfrontend/Statistique");
    	}
		else {
			 remainingAttempts--;

	            if (remainingAttempts > 0) {
	                session.setAttribute("remainingAttempts", remainingAttempts);

	                
	                String errorMessage = "L'email ou le code saisi est incorrecte.<br> Veuillez réessayer.Il vous reste "
	                        + remainingAttempts + " tentatives.";
	                request.setAttribute("errorMessage", errorMessage);
	                request.getRequestDispatcher("Login.jsp").forward(request, response);
	            } else {
	               
	                session.removeAttribute("remainingAttempts"); 
	                response.sendRedirect("erreurTentatives.jsp");
	            }
		}
	}
}	

