package Controleur;

import java.io.IOException;
import java.util.Properties;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

/**
 * Servlet implementation class Emailparuser
 */
@WebServlet("/Emailparuser")
public class Emailparuser extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Emailparuser() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 String email = request.getParameter("email");
	        String subject = request.getParameter("subject");
	        String messageBody = request.getParameter("message");

	       
	        sendEmail(email, subject, messageBody);

	       
	        response.sendRedirect("email.jsp");
	    }

	 private void sendEmail(String toEmail, String subject, String messageBody) {
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
	            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
	            message.setSubject(subject);
	            message.setText(messageBody);

	            // Envoi du message
	            Transport.send(message);
	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	}

