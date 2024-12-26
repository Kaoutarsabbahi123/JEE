package Controleur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entities.Etat_stagiaire;
import Entities.Login;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Login;


/**
 * Servlet implementation class Ajoututilisateur
 */
@WebServlet("/Ajoututilisateur")
public class Ajoututilisateur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
    private Ilocal_Login local_login;
    /**
     * Default constructor. 
     */
    public Ajoututilisateur() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Login nouveaulogin = new Login();
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
        String role = request.getParameter("role");
        String id = request.getParameter("id");
        String mot_passe = request.getParameter("mot_passe");
        // Créer un nouvel objet Stagiaire avec les données du formulaire
        nouveaulogin.setId_login(id);
        nouveaulogin.setCin(cin);
        nouveaulogin.setNom(nom);
        nouveaulogin.setPrenom(prenom);
        nouveaulogin.setAdresse(adresse);
        nouveaulogin.setTel(telephone);
        nouveaulogin.setEmail(email);
        nouveaulogin.setRole(role);
        nouveaulogin.setDat_naiss(sqlDate);
        nouveaulogin.setMot_passe(mot_passe);
        if(source.equals("ajouter")) {
        local_login.addLogin(nouveaulogin);
	}
        else{
        	local_login.updateLogin(nouveaulogin);
        }
        response.sendRedirect("/JEEfrontend/UtilisateurServlet");

	}

}
