package Controleur;

import java.io.IOException;
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

@WebServlet("/SearchStagiaires")
public class SearchStagiaires extends HttpServlet {
    @EJB
    private Ilocal_StagiaireLocal local_StagiaireLocal;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        List<Stagiaire> searchResults = local_StagiaireLocal.searchStagiaires(keyword);
        request.getSession().setAttribute("keyword", keyword);
        request.setAttribute("stagiaires", searchResults);
        response.sendRedirect("Stagiaire.jsp");
    }
}
