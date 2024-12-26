package Controleur;

import java.io.IOException;
import java.util.List;

import Entities.Division;
import Entities.Employe;
import Entities.Stage;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Division;
import sessions.Ilocal_Employe;
import sessions.Ilocal_Stage;
import sessions.Ilocal_StagiaireLocal;

/**
 * Servlet implementation class Stageservlet
 */
@WebServlet("/Stageservlet")
public class Stageservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Stage localstage;
    @EJB
    private Ilocal_Employe local_employe;
    @EJB
    private Ilocal_Division local_division;
    @EJB
    private Ilocal_StagiaireLocal localStagiaire;
    /**
     * Default constructor. 
     */
    public Stageservlet() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
            
            List<Stage> stages = localstage.getallStage();
            List<Employe> encadrants=local_employe.getallEmploye();
            List<Division> divisions=local_division.getalldivison();
           
            request.getSession().setAttribute("stages", stages);
            request.getSession().setAttribute("encadrants", encadrants);
            request.getSession().setAttribute("divisions", divisions);
            String role=(String) request.getSession().getAttribute("userRole");
            List<Stagiaire> nouveaustagiaires = localStagiaire.getlistestagiairenouveau();
            request.getSession().setAttribute("nouveaustagiaires", nouveaustagiaires);
            
            if(role.equals("superadmin") || role.equals("chefdrh") ) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Stages.jsp");
            dispatcher.forward(request, response);
            }
            else {
            	RequestDispatcher dispatcher = request.getRequestDispatcher("Stagesadmin.jsp");
                dispatcher.forward(request, response);
            }
        } catch (Exception e) {
           
            e.printStackTrace();
            response.getWriter().println("An error occurred.");
        }
	}

}
