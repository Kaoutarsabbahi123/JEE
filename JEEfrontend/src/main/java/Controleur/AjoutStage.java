package Controleur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entities.Departement;
import Entities.Division;
import Entities.Employe;
import Entities.Etat_stage;
import Entities.Stage;
import Entities.Statut;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Division;
import sessions.Ilocal_Employe;
import sessions.Ilocal_Stage;

/**
 * Servlet implementation class AjoutStage
 */
@WebServlet("/AjoutStage")
public class AjoutStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB 
    private Ilocal_Stage localstage;
    @EJB
    private Ilocal_Employe localemploye;
    @EJB
    private Ilocal_Division localdivision;
    /**
     * Default constructor. 
     */
    public AjoutStage() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Stage stage=new Stage();
		String source=request.getParameter("source");
        String sujet = request.getParameter("sujet");
        String date_debut= request.getParameter("Date_debut");
        String date_fin= request.getParameter("Date_fin");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        java.sql.Date sqlDate1 = null;
        try {
            java.util.Date utilDate = dateFormat.parse(date_debut);
            sqlDate = new java.sql.Date(utilDate.getTime());
            java.util.Date utilDate1 = dateFormat.parse(date_fin);
            sqlDate1 = new java.sql.Date(utilDate1.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int id_emp=Integer.valueOf(request.getParameter("ListeEncadrant"));
        Employe emp=localemploye.getEmploye(id_emp);
        int id_div=Integer.valueOf(request.getParameter("Listedivision"));
        Division div=localdivision.getDivision(id_div);
        String type= request.getParameter("votreListetype");
        // Créer un nouvel objet Stagiaire avec les données du formulaire
        stage.setSujet(sujet);
        stage.setDate_debut(sqlDate);
        stage.setDate_fin(sqlDate1);
        stage.setDivision(div);
        stage.setEncadrant(emp);
        stage.setType(type);
        stage.setStatut(Statut.NON_AFFECTE.getNom());
        stage.setEtat(Etat_stage.NON_ARCHIVE.getNom());
        if(source.equals("ajouter")) {
            localstage.addStage(stage);
	}
        else{
        	int id=Integer.valueOf(request.getParameter("id"));
       	    stage.setId_stage(id);
       	    localstage.updateStage(stage);
        	
        }
        response.sendRedirect("/JEEfrontend/Stageservlet");

	}
	}


