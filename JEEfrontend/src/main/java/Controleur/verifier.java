package Controleur;

import java.io.IOException;

import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sessions.Ilocal_StagiaireLocal;

@WebServlet("/verifierCode")
public class verifier extends HttpServlet {
    private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_StagiaireLocal stagiairelocal;

    public verifier() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String messagesuccès=null;
        int codeEnvoye = (int) request.getSession().getAttribute("verificationCode");

        String codeSaisiStr = request.getParameter("code1") +
                request.getParameter("code2") +
                request.getParameter("code3") +
                request.getParameter("code4");
        int codesaisi = Integer.valueOf(codeSaisiStr);
        HttpSession session = request.getSession();
        Integer remainingAttempts = (Integer) session.getAttribute("remainingAttempts");

        if (remainingAttempts == null) {
            remainingAttempts = 3;
            session.setAttribute("remainingAttempts", remainingAttempts);
        }

       
        if (codesaisi == codeEnvoye) {
        	String verificationSource = (String) session.getAttribute("verificationSource");
        	 if ("inscriptionstagiaire".equals(verificationSource)) {
        		  
        		 messagesuccès=" <h1>Inscription Réussite</h1>\r\n"
        		 		+ "    <p>Les informations a été créé avec succès ;<br/> vous êtes maintenant membre de notre communauté !</p>";
                 Stagiaire nouveauStagiaire = (Stagiaire) request.getSession().getAttribute("nouveauStagiaire");
                 stagiairelocal.addStagiaire(nouveauStagiaire);
                
                 session.removeAttribute("nouveauStagiaire");
                 session.removeAttribute("verificationSource");
                 request.getSession().setAttribute("messagesuccès", messagesuccès);
                 response.sendRedirect("succes.jsp");
                 
             } else {
            	 messagesuccès="<h1>Modification réussite!</h1><p>Si vous voulez vous connectez accédez au lien suivant"
            	 		+ "<br><a href=\"Login.jsp\">Cliquez ici!</a></p>   ";
            	 request.getSession().setAttribute("messagesuccès", messagesuccès);
            	 response.sendRedirect("mot_passeoublie.jsp");
             }
            
        } 
        
        else {
           
            remainingAttempts--;

            if (remainingAttempts > 0) {
                
                session.setAttribute("remainingAttempts", remainingAttempts);

                
                String errorMessage = "Le code saisi est incorrect. Veuillez réessayer. <br>Il vous reste "
                        + remainingAttempts + " tentatives.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("verification.jsp").forward(request, response);
            } else {
               
                session.removeAttribute("remainingAttempts"); 
                response.sendRedirect("erreurTentatives.jsp");
            }
        }
    }
}
