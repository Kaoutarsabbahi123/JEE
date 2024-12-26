package Controleur;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/EnvoiEmail")
public class envoiEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public envoiEmail() {
        // TODO Auto-generated constructor stub
    }
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        int verificationCode = generateVerificationCode();

	        
	        String email = request.getParameter("email");
	        request.getSession().setAttribute("resetEmail", email);
	        
	        request.getSession().setAttribute("verificationCode", verificationCode);

	        // Envoyer le code par e-mail
	        sendVerificationCodeByEmail(email, verificationCode);

	        // Rediriger vers la page de vérification du code
	        response.sendRedirect("verification.jsp"); 
	    }

	    private int generateVerificationCode() {
	        // Générer un code aléatoire à 4 chiffres
	        Random random = new Random();
	        return 1000 + random.nextInt(9000);
	    }

	    private void sendVerificationCodeByEmail(String email, int verificationCode) {
	        // Configuration pour l'envoi d'e-mails 
	        String host = "smtp.gmail.com";
	        String username = "kaoutarsabbahi37@gmail.com";
	        String password = "knlt qefb uzcg rque";

	        // Propriétés SMTP
	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", host);
	        properties.put("mail.smtp.user", username);
	        properties.put("mail.smtp.password", password);
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");

	        // Création de la session
	        Session session = Session.getDefaultInstance(properties, new jakarta.mail.Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(username, password);
	            }
	        });

	        try {
	            // Création du message
	            MimeMessage message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(username));
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
	            message.setSubject("Code de vérification");
	            message.setText("Votre code de vérification est : " + verificationCode);
	            // Envoi du message
	            Transport.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	}
	


