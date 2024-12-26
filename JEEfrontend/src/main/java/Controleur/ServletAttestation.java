package Controleur;

import java.io.IOException;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import Entities.Division;
import Entities.Employe;
import Entities.Entreprise;
import Entities.Etat_stagiaire;
import Entities.Stage;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Division;
import sessions.Ilocal_Employe;
import sessions.Ilocal_Entreprise;
import sessions.Ilocal_Stage;
import sessions.Ilocal_Stagiaire;

/**
 * Servlet implementation class ServletAttestation
 */
@WebServlet("/ServletAttestation")
public class ServletAttestation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Stagiaire localstagiaire;
    @EJB
    private Ilocal_Stage localstage;
    @EJB
    private Ilocal_Employe localemploye;
    @EJB
    private Ilocal_Division localdivision;
    @EJB
    private Ilocal_Entreprise localentreprise;
    /**
     * Default constructor. 
     */
    public ServletAttestation() {
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int id =Integer.valueOf(request.getParameter("id"));
		   Stagiaire stagiaire=localstagiaire.getStagiaire(id);
		   String nom =stagiaire.getNom();
		   String cin=stagiaire.getCin();
		   String prenom=stagiaire.getPrenom();
		   Stage stage =stagiaire.getStage();
		   String sujet =stage.getSujet();
		   String type=stage.getType();
		   Date date_debut=stage.getDate_debut();
		   Date date_fin=stage.getDate_fin();
		   String formattedDateDebut;
		   String formattedDateFin;
		   SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		   formattedDateDebut = dateFormat.format(date_debut);
		   formattedDateFin = dateFormat.format(date_fin);
		   java.util.Date date;
		   java.util.Date date1;
		try {
			date = dateFormat.parse(formattedDateDebut);
			date1 = dateFormat.parse(formattedDateFin);
		    Calendar calendardebut = Calendar.getInstance();
		       Calendar calendarfin = Calendar.getInstance();
		       Calendar todayCalendar = Calendar.getInstance();
		       int currentYear = todayCalendar.get(Calendar.YEAR);
		       int currentMonth = todayCalendar.get(Calendar.MONTH) + 1; // Les mois commencent à partir de zéro
		       int currentDay = todayCalendar.get(Calendar.DAY_OF_MONTH);
		       calendardebut.setTime(date);
		       calendarfin.setTime(date1);
		       int yeardebut = calendardebut.get(Calendar.YEAR);
		       int monthdebut = calendardebut.get(Calendar.MONTH) + 1; // Les mois commencent à partir de zéro
		       int daydebut = calendardebut.get(Calendar.DAY_OF_MONTH);
		       int yearfin = calendarfin.get(Calendar.YEAR);
		       int monthfin = calendarfin.get(Calendar.MONTH) + 1; // Les mois commencent à partir de zéro
		       int dayfin = calendarfin.get(Calendar.DAY_OF_MONTH);
		       
		       request.getSession().setAttribute("yeardebut", yeardebut);
			   request.getSession().setAttribute("monthdebut", monthdebut);
			   request.getSession().setAttribute("daydebut", daydebut);
			   request.getSession().setAttribute("yearfin", yearfin);
			   request.getSession().setAttribute("monthfin", monthfin);
			   request.getSession().setAttribute("dayfin", dayfin);
			   request.getSession().setAttribute("currentYear", currentYear);
			   request.getSession().setAttribute("currentMonth", currentMonth);
			   request.getSession().setAttribute("currentDay", currentDay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   Employe encadrant=stage.getEncadrant();
		   Division division=stage.getDivision();
		   String nomEnc=encadrant.getNom();
		   String prenomEnc=encadrant.getPrenom();
		   String nomdiv=division.getNom_div();
		   Entreprise entrp=division.getEntrp();
		   String entreprise=entrp.getNom();
		   String ville=entrp.getVille();
		   request.getSession().setAttribute("nom", nom);
		   request.getSession().setAttribute("cin", cin);
		   request.getSession().setAttribute("prenom", prenom);
		   request.getSession().setAttribute("sujet", sujet);
		   request.getSession().setAttribute("type", type);
		   request.getSession().setAttribute("date_debut", formattedDateDebut);
		   request.getSession().setAttribute("date_fin", formattedDateFin);
		   request.getSession().setAttribute("nomEnc", nomEnc);
		   request.getSession().setAttribute("prenomEnc", prenomEnc);
		   request.getSession().setAttribute("nomdiv", nomdiv);
		   request.getSession().setAttribute("entreprise", entreprise);
		   request.getSession().setAttribute("ville", ville);
		   stagiaire.setEtat(Etat_stagiaire.EN_ARCHIVE.getNom());
		   localstagiaire.updateStagiaire(stagiaire);
		   response.sendRedirect("attestation.jsp");
	}
}
