package Controleur;

import java.io.IOException;
import java.util.List;

import Entities.Departement;
import Entities.Employe;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Departement;
import sessions.Ilocal_Employe;

/**
 * Servlet implementation class EncadrantServlet
 */
@WebServlet("/EncadrantServlet")
public class EncadrantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Employe local_employe;
    @EJB
    private Ilocal_Departement local_dep;
    /**
     * Default constructor. 
     */
    public EncadrantServlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            List<Employe> encadrants = local_employe.getallEmploye();
            List<Departement> departements=local_dep.getalldepartement();
            request.getSession().setAttribute("encadrants", encadrants);
            request.getSession().setAttribute("departements", departements);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Encadrant.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
	}


}
