/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.shoppingcart;

import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author rahuludhayakumar
 */
@WebServlet(urlPatterns = {"/ShoppingCartServlet"})
public class ShoppingCartServlet extends HttpServlet {
    
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	if (cart == null) {
            cart = new Cart();
        }
        Enumeration<String> items = request.getParameterNames();
        while (items.hasMoreElements()) {
            String name = items.nextElement();
            if (name.equals("Submit")) continue;
            String val[] = request.getParameterValues("check");
            if(val != null){
            for (String s: val) {           
            cart.deleteItem(s);
                }}
        }
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("View.jsp").forward(request, response);
    }
     
      protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	String[] items = request.getParameterValues("books");
	if (items == null)
            items = request.getParameterValues("music");
	if (items == null)
            items = request.getParameterValues("computers");
        
        
        HttpSession session = request.getSession();
	Cart cart = (Cart)session.getAttribute("cart");
	if (cart == null) {
            cart = new Cart();
	}
        String hidd = request.getParameter("hidd");

            if(hidd != null && hidd .equals("1")){
            if( cart == null){
                cart = new Cart();
            }
            }
        
        if (items == null) {
            session.setAttribute("items", items);
            session.setAttribute("cart", cart);
            request.getRequestDispatcher("Add.jsp").forward(request, response);
            return;
        }
        
	for (String name : items) {
            Item item = cart.findItem(name);
            if (item != null) {
                int amount = item.getCount();
                cart.modifyItemCount(name, ++amount);
            } else {
                cart.addItem(new Item(name, 1));
            }
        }
        session.setAttribute("items", items);
        session.setAttribute("cart", cart);
        request.getRequestDispatcher("Add.jsp").forward(request, response);
    }

    
}
