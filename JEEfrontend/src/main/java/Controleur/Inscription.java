package Controleur;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import Entities.Etat_stagiaire;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_StagiaireLocal;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private Ilocal_StagiaireLocal localStagiaire;

    public Inscription() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Stagiaire nouveauStagiaire = new Stagiaire();
        String verificationSource= request.getParameter("verificationSource");
        request.getSession().setAttribute("verificationSource", verificationSource);
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
       
        request.getSession().setAttribute("nouveauStagiaire", nouveauStagiaire);
        response.sendRedirect("envoyerEmail.jsp");
    }
    }
