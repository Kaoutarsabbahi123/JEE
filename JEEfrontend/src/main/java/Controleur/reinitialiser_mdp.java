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
 * Servlet implementation class reinitialiser_mdp
 */
@WebServlet("/reinitialiser_mdp")
public class reinitialiser_mdp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
private Ilocal_LoginLocal loginlocal;
    /**
     * Default constructor. 
     */
    public reinitialiser_mdp() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String id_login=(String) request.getSession().getAttribute("resetEmail");
	String nv_mdp=request.getParameter("nv_mdp");
	Login login=loginlocal.getLogin(id_login);
	login.setMot_passe(nv_mdp);
	loginlocal.updateLogin(login);
	response.sendRedirect("succes.jsp");
	}

}
