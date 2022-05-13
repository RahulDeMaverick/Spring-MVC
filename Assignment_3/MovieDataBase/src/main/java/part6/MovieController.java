/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package part6;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author rahuludhayakumar
 */
@WebServlet(urlPatterns = {"/MovieController"})
public class MovieController extends HttpServlet {
    
    
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String movieTitle = request.getParameter("Movie Title");
        String leadActor = request.getParameter("Lead Actor");
        String leadActress = request.getParameter("Lead Actress");
        String genre = request.getParameter("Genre");
        String year = request.getParameter("Year");
        MovieDAO movieDAO = new MovieDAO();
        int result = movieDAO.addMovie(movieTitle, leadActor, leadActress, genre, year);
        request.setAttribute("result", String.valueOf(result));
         request.getRequestDispatcher("Add.jsp").forward(request, response);
    }
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String keyword = request.getParameter("keyword");
        String search = request.getParameter("search");
        MovieDAO movieDAO = new MovieDAO();
        List<Movie> result = movieDAO.get(search, keyword);
        request.setAttribute("keyword", keyword);
        request.setAttribute("result", result);
        request.getRequestDispatcher("browse.jsp").forward(request, response);
    }
    
}
