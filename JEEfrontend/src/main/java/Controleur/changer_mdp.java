package Controleur;

import java.io.IOException;


import Entities.Login;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_LoginLocal;

/**
 * Servlet implementation class changer_mdp
 */
@WebServlet("/changer_mdp")
public class changer_mdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	    private Ilocal_LoginLocal loginlocal;

    /**
     * Default constructor. 
     */
    public changer_mdp() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String currentpass=request.getParameter("currentPassword");
		String newpass=request.getParameter("newPassword");
		String role=(String)request.getSession().getAttribute("userRole");
		if(role != null) {
				Login l=(Login) request.getSession().getAttribute("utilisateur");
				if(currentpass.equals(l.getMot_passe())) {
					l.setMot_passe(newpass);
					loginlocal.updateLogin(l);
					String successMessage = "Mot de passe mis à jour avec succès";
					request.getSession().setAttribute("successMessage", successMessage);
					request.getSession().setAttribute("success", true);
					request.getSession().setAttribute("mot_passe",newpass);
					request.getRequestDispatcher("info.jsp").forward(request, response);
				}
				
			}
	}

}
