/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookdatabase;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author rahuludhayakumar
 */
@WebServlet(urlPatterns = {"/BookController"})
public class BookController extends HttpServlet {
    
    protected void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException{
    
        List<Books> booksList = new ArrayList<Books>();
        int count = Integer.valueOf(req.getParameter("amount"));
        
        for (int i = 0; i < count; i++) {
            String isbn = req.getParameter("isbn" + String.valueOf(i));
            String name = req.getParameter("name" + String.valueOf(i));
            String authors = req.getParameter("authors" + String.valueOf(i));
            String price = req.getParameter("price" + String.valueOf(i));
            Books bk = new Books(isbn,name,authors,price);
            booksList.add(bk);
        }
               int result;
        try {
            result = BooksDAO.addbooks(booksList,count);
            req.setAttribute("result", count);
            req.getRequestDispatcher("Add.jsp").forward(req,res);
         } catch (SQLException ex) {
            Logger.getLogger(BookController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
