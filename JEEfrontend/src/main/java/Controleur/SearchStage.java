package Controleur;

import java.io.IOException;
import java.util.List;

import jakarta.ejb.EJB;
import  jakarta.servlet.ServletException;
import  jakarta.servlet.annotation.WebServlet;
import  jakarta.servlet.http.HttpServlet;
import  jakarta.servlet.http.HttpServletRequest;
import  jakarta.servlet.http.HttpServletResponse;
import sessions.Ilocal_Stage;
import Entities.Employe;
import Entities.Stage;

/**
 * Servlet implementation class SearchStage
 */
@WebServlet("/SearchStage")
public class SearchStage extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @EJB
    private Ilocal_Stage local_Stage;
    /**
     * Default constructor. 
     */
    public SearchStage() {
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String keyword = request.getParameter("keyword");
		 List<Stage> searchResults = local_Stage.searchstage(keyword);
	        request.getSession().setAttribute("keyword", keyword);
	        request.setAttribute("stages", searchResults);
	        String role=(String) request.getSession().getAttribute("userRole");
	        if(role.equals("superadmin") || role.equals("chefdrh") ) {
	        response.sendRedirect("Stages.jsp");
	        }
	        else {
	        	response.sendRedirect("Stagesadmin.jsp");
	        }
	}

}
