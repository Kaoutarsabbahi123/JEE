package Controleur;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
 * Servlet implementation class Servlettoutstagiaireabscent
 */
@WebServlet("/Servlettoutstagiaireabscent")
public class Servlettoutstagiaireabscent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 @EJB
	 private Ilocal_StagiaireLocal localStagiaire;

    /**
     * Default constructor. 
     */
    public Servlettoutstagiaireabscent() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
			 String dateInput = request.getParameter("dateInput");
			 request.getSession().setAttribute("dateinput", dateInput);
			 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			 List<Stagiaire> stagiaires = localStagiaire.getallStagiaire();
	           
	         request.getSession().setAttribute("stagiaires", stagiaires);
		        java.sql.Date sqlDate = null;
		        try {
		            java.util.Date utilDate = dateFormat.parse(dateInput);
		            sqlDate = new java.sql.Date(utilDate.getTime());
		        } catch (ParseException e) {
		            e.printStackTrace();
		        }
	            
	            List<Integer>  absentsList = localStagiaire.getAbsentsByDate(sqlDate);
	            request.setAttribute("afficherTable", !absentsList.isEmpty());
	            if (!absentsList.isEmpty()) {
	           
	            request.getSession().setAttribute("listdesabscents",  absentsList);
	            }
	           
	            RequestDispatcher dispatcher = request.getRequestDispatcher("abscent.jsp");
	            dispatcher.forward(request, response);
	        } catch (Exception e) {
	            
	            e.printStackTrace();
	            response.getWriter().println("An error occurred.");
	        }
	}


}
