package Controleur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entities.Etat_stagiaire;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_StagiaireLocal;

/**
 * Servlet implementation class AjoutStagiaire
 */
@WebServlet("/AjoutStagiaire")
public class AjoutStagiaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private Ilocal_StagiaireLocal stagiairelocal;

    /**
     * Default constructor. 
     */
    public AjoutStagiaire() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Stagiaire nouveauStagiaire = new Stagiaire();
		String source=request.getParameter("source");
        String cin = request.getParameter("cin");
        String nom = request.getParameter("Nom");
        String prenom = request.getParameter("Prenom");
        String adresse = request.getParameter("adresse");
        String telephone = request.getParameter("telephone");
        String dateNaissanceStr = request.getParameter("datnaiss");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sqlDate = null;
        try {
            java.util.Date utilDate = dateFormat.parse(dateNaissanceStr);
            sqlDate = new java.sql.Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String email = request.getParameter("email");
        String etablissement = request.getParameter("etablissement");
        String filiere = request.getParameter("filiere");

        // Créer un nouvel objet Stagiaire avec les données du formulaire
        nouveauStagiaire.setCin(cin);
        nouveauStagiaire.setNom(nom);
        nouveauStagiaire.setPrenom(prenom);
        nouveauStagiaire.setAdresse(adresse);
        nouveauStagiaire.setTel(telephone);
        nouveauStagiaire.setEmail(email);
        nouveauStagiaire.setEtablissment(etablissement);
        nouveauStagiaire.setFiliere(filiere);
        nouveauStagiaire.setDat_naiss(sqlDate);
        nouveauStagiaire.setEtat(Etat_stagiaire.NOUVEAU.getNom());
        if(source.equals("ajouter")) {
        stagiairelocal.addStagiaire(nouveauStagiaire);
	}
        else{
        	 int id=Integer.valueOf(request.getParameter("id"));
        	 nouveauStagiaire.setId_stagiaire(id);
        	 stagiairelocal.updateStagiaire(nouveauStagiaire);
        }
        response.sendRedirect("/JEEfrontend/StagiaireServlet");

}
}
