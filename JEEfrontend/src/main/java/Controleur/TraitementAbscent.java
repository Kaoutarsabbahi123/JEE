package Controleur;

import java.io.IOException;
import java.sql.Date;
import java.util.Map;

import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_StagiaireLocal;

/**
 * Servlet implementation class TraitementAbscent
 */
@WebServlet("/TraitementAbscent")
public class TraitementAbscent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private Ilocal_StagiaireLocal stagiairelocal;
    /**
     * Default constructor. 
     */
    public TraitementAbscent() {
        // TODO Auto-generated constructor stub
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String dateString = (String) request.getSession().getAttribute("dateinput");
        Date dateAbsence = Date.valueOf(dateString);

        String[] absentsIds = request.getParameterValues("absents");

       
        for (String stagiaireId : absentsIds) {
            int idStagiaire = Integer.parseInt(stagiaireId);

            
            Stagiaire stagiaire = stagiairelocal.getStagiaire(idStagiaire);
            Map<Date, Boolean> liststagiaire=stagiairelocal.getListeAbsencesStagiaire(idStagiaire);
            stagiaire.setListe_abscences(liststagiaire);
            
            stagiaire.ajouterAbsence(dateAbsence, true);
           
            stagiairelocal.updateStagiaire(stagiaire);
        }

        
        response.sendRedirect("abscent.jsp");
    }

}
