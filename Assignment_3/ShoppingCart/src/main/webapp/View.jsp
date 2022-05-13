<%-- 
    Document   : View
    Created on : Feb 24, 2022, 7:13:20 PM
    Author     : rahuludhayakumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart</title>
    </head>
    <body>
        <c:set var="cart" value="${sessionScope.cart}"/>
        <h2 align="center">View Your Cart</h2>
        <form action="http://127.0.0.1:8080/ShoppingCart/ShoppingCartServlet" method="get">
            <table border=1 align="center">
                <tr/><th/>Object<th/>Amount<th/>Delete
                <c:if test="${cart != null}">
                    <c:forEach var="item" items="${cart.cart}">                        
                        <tr/><td/>${item.name}
                        <td/><input type="text" name="${item.name}" value="${item.count}"/>
                        <td/><input type="checkbox"  name="check"  value="${item.name}">
                    </c:forEach>
                </c:if>
            </table>
            <br/>
            <div align="center">
                <input name="hidd" type="hidden" value="1">
                <input type="submit" name="Submit" value="Submit">
            </div>
        </form>
        <p>
            [<a href="books.html">Go to Books Page</a>] 
            [<a href="music.html">Go to Music Page</a>] 
            [<a href="computer.html">Go to Computers Page</a>] 
        </p>
    </body>
</html>