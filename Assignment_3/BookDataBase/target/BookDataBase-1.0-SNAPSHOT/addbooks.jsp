<%-- 
    Document   : addbooks
    Created on : Feb 22, 2022, 4:08:31 PM
    Author     : rahuludhayakumar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <%
       
            int val = Integer.valueOf(request.getParameter("amount"));
        %>
        <h1>Hello World!</h1>
        
            <form action="http://127.0.0.1:8080/BookDataBase/BookController" method="get">
            <table border="1">
                <tr/><th/>ISBN<th/>Book Title<th/>Authors<th/>Price
                <%for (int i = 0; i < val; i++) {%>
                    <tr/>
                    <td/><input type="text" name="isbn<%=String.valueOf(i)%>"/>
                    <td/><input type="text" name="name<%=String.valueOf(i)%>"/>
                    <td/><input type="text" name="authors<%=String.valueOf(i)%>"/>
                    <td/><input type="text" name="price<%=String.valueOf(i)%>"/>
                <%}%>
                <tr/><td/>
                <input type="submit" name="submit" value="Add Books">
                <input type="hidden" name="amount" value="<%=val%>">
            </table>
        </form>
    </body>
</html>
