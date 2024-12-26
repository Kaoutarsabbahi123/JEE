package Controleur;

import java.io.IOException;

import Entities.Etat_stagiaire;
import Entities.Stage;
import Entities.Stagiaire;
import Entities.Statut;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Stage;
import sessions.Ilocal_Stagiaire;

/**
 * Servlet implementation class TraitementAffectation
 */
@WebServlet("/TraitementAffectation")
public class TraitementAffectation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Stagiaire stagiairelocal;
    @EJB
    private Ilocal_Stage stagelocal;
    /**
     * Default constructor. 
     */
    public TraitementAffectation() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String[] affectids = request.getParameterValues("affecter");
           int id =Integer.valueOf(request.getParameter("idstage"));
	        
	        for (String affectid : affectids) {
	            int idStagiaire = Integer.parseInt(affectid);
          
	            
	            Stagiaire stagiaire = stagiairelocal.getStagiaire(idStagiaire);
                Stage stage=stagelocal.getStage(id);
                stagiaire.setStage(stage);
                stagiaire.setEtat(Etat_stagiaire.EN_COURS.getNom());
	            if(stage.getStatut().equals("non affecte")) {
	            	stage.setStatut(Statut.AFFECTE.getNom());
	            	stagelocal.updateStage(stage);
	            }
	           
	            stagiairelocal.updateStagiaire(stagiaire);
	        }

	        
	        response.sendRedirect("/JEEfrontend/Stageservlet");
	    }

	}

