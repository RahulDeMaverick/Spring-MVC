<%-- 
    Document   : Add
    Created on : Feb 24, 2022, 7:13:33 PM
    Author     : rahuludhayakumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Item</title>
    </head>
   <c:set var = "items" value="${sessionScope.items}"/>
        <c:choose>
            <c:when test="${items != null}">
                <h2>The following item has been added to your shopping cart successfully</h2>
                <c:forEach var="name" items="${items}">
                    <p>${name}</p>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <h2>Please add items to your cart</h2>
            </c:otherwise>
        </c:choose>
        <p>
            [<a href="View.jsp">View Cart</a>]
            [<a href="books.html">Go to Books Page</a>]
            [<a href="music.html">Go to Music Page</a>]
            [<a href="computer.html">Go to Computers Page</a>]
        </p>
</html>