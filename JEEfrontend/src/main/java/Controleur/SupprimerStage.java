package Controleur;

import java.io.IOException;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Stage;

/**
 * Servlet implementation class SupprimerStage
 */
@WebServlet("/SupprimerStage")
public class SupprimerStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Stage localstage;
    /**
     * Default constructor. 
     */
    public SupprimerStage() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("id"));
		boolean resultatsuppression=localstage.supprimerStageSiConditionsRemplies(id);
		if(resultatsuppression==false) {
			String messageSuppression="Un problème a été detécté lors de la suppression";
			request.getSession().setAttribute("messageSuppression", messageSuppression);
		}
		response.sendRedirect(request.getHeader("referer"));
	}

}
