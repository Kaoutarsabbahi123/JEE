package Controleur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entities.Departement;
import Entities.Employe;
import Entities.Etat_stage;
import Entities.Statut;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Departement;
import sessions.Ilocal_Employe;

/**
 * Servlet implementation class AjoutEncadrant
 */
@WebServlet("/AjoutEncadrant")
public class AjoutEncadrant extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private Ilocal_Employe local_employe;
	 @EJB
	 private Ilocal_Departement local_dep;
    public AjoutEncadrant() {
        // TODO Auto-generated constructor stub
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Employe emp =new Employe();
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
        int id_dep=Integer.valueOf(request.getParameter("votreListe"));
        Departement dep=local_dep.getDepartement(id_dep);
        // Créer un nouvel objet Stagiaire avec les données du formulaire
        emp.setAdresse(adresse);
        emp.setCin(cin);
        emp.setDat_naiss(sqlDate);
        emp.setEmail(email);
        emp.setNom(nom);
        emp.setPrenom(prenom);
        emp.setStatut(Statut.NON_AFFECTE.getNom());
        emp.setEtat(Etat_stage.NON_ARCHIVE.getNom());
        emp.setTel(telephone);
        emp.setDepartement(dep);
        if(source.equals("ajouter")) {
        local_employe.addEmploye(emp);
	}
        else{
        	int id=Integer.valueOf(request.getParameter("id"));
       	    emp.setId_emp(id);
        	local_employe.updateEmploye(emp);
        }
        response.sendRedirect("/JEEfrontend/EncadrantServlet");

	}


}
