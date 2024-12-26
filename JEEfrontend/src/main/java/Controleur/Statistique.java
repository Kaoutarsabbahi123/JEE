package Controleur;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.ejb.EJB;
import sessions.Ilocal_Employe;
import sessions.Ilocal_Stage;
import sessions.Ilocal_Stagiaire;

/**
 * Servlet implementation class Statistique
 */
@WebServlet("/Statistique")
public class Statistique extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Stagiaire localstagiaire;
    @EJB
    private Ilocal_Stage localstage;
    @EJB
    private Ilocal_Employe localemploye;
    /**
     * Default constructor. 
     */
    public Statistique() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int nbrStagiairenouveau=localstagiaire.nbrNouveauStagiaire();
		int nbrStagiaireencours=localstagiaire.nbrencoursStagiaire();
		int nbrStagiairearchive=localstagiaire.nbrarchiveStagiaire();
		int nbrStageaffecte=localstage.nbrstageaffecte();
		int nbrStagenonaffecte=localstage.nbrstagenonaffecte();
		int nbrempaffecte=localemploye.nbremployeaffecte();
		int  nbrempnonaffecte=localemploye.nbremployenonaffecte();
		request.getSession().setAttribute("nbrStagiairenouveau",nbrStagiairenouveau );
		request.getSession().setAttribute("nbrStagiaireencours",nbrStagiaireencours);
		request.getSession().setAttribute("nbrStagiairearchive",nbrStagiairearchive );
		request.getSession().setAttribute("nbrStageaffecte",nbrStageaffecte);
		request.getSession().setAttribute("nbrStagenonaffecte",nbrStagenonaffecte );
		request.getSession().setAttribute("nbrempaffecte",nbrempaffecte);
		request.getSession().setAttribute("nbrempnonaffecte",nbrempnonaffecte);
		response.sendRedirect("acceuil.jsp");
	}

}
