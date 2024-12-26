package Controleur;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_EmployeLocal;

/**
 * Servlet implementation class SupprimerEncadrant
 */
@WebServlet("/SupprimerEncadrant")
public class SupprimerEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private Ilocal_EmployeLocal employelocal;
    /**
     * Default constructor. 
     */
    public SupprimerEncadrant() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("id"));
		boolean resultatsuppression=employelocal.supprimerEmployeSiConditionsRemplies(id);
		if(resultatsuppression==false) {
			String messageSuppression="Un problème a été detécté lors de la suppression";
			request.getSession().setAttribute("messageSuppression", messageSuppression);
		}
		response.sendRedirect(request.getHeader("referer"));
	}


}
