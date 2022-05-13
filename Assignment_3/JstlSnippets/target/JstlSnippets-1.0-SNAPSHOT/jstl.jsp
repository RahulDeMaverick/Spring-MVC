<%-- 
    Document   : jstl
    Created on : Feb 26, 2022, 8:39:37 PM
    Author     : rahuludhayakumar
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>  

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>JSTL CORE TAGS</p>
        
        <c:set var = "marks" scope = "session" value = "${5000}"/>
        <c:out value="${marks}"/>
        <c:if test = "${marks > 2000}">
         <p> salary :  <c:out value = "${marks}"/><p>
      </c:if>
    <c:forEach var="j" begin="1" end="5">  
   Item <c:out value="${j}"/><p>  
    </c:forEach> 
       <c:set var = "hello" value = "Hello world!!!"/>
         <p>Function tags</p>
      <c:if test = "${fn:contains(found, 'hello')}">
         <p>The string found has been found<p>
      </c:if>
       <c:set var = "a" value = "Welcome to the world"/> 
         <p>The length  of the above string is ${fn:length(a)}</p>
                <c:set var = "jslower" value = "Good Morning!!!t"/> 
         <p>The length  of the string is converted to upper case: ${fn:toUpperCase(js)} converted to Upper Case</p>
          <c:set var = "jsupper" value = "hellow Jstl you There??"/> 
         <p>The length  of the string is converted to lower case: ${fn:toLowerCase(js)} converted to Lower Case</p>
         <c:set var = "string2" value = "${fn:replace(jsupper, 'JSTL', 'Servlet')}" />
         <p>The string is replaced is ""${string2}""</p>
          <p> FORMATTING TAGS</p>
        <c:set var = "val" value = "3232323.74747" />
               <p>The Number is formatted as : <fmt:formatNumber type = "number" 
         maxFractionDigits = "3" value = "${val}" /></p>
          <p>The Dollar value is:
         <fmt:setLocale value = "en_US"/>
         <fmt:formatNumber value = "${val}" type = "currency"/>
        <p>The format in percentage is <fmt:formatNumber type = "percent" 
         maxIntegerDigits="3" value = "${val}" /></p>
       
      </p>
      <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver"  
     url="jdbc:mysql://127.0.0.1:3306/local_db"  
     user="root"  password="Apple@950826"/> 
     <sql:query dataSource="${db}" var="rs">  
    SELECT * from movies;  
    </sql:query>  
    <table border="2" width="100%">  
<tr>  
<th>Movie Title</th>  
<th>Actor</th>  
<th>Actress</th>  
<th>Genre</th>  
</tr>  
<c:forEach var="table" items="${rs.rows}">  
<tr>  
<td><c:out value="${table.title}"/></td>  
<td><c:out value="${table.actor}"/></td>  
<td><c:out value="${table.actress}"/></td>  
<td><c:out value="${table.genre}"/></td>  
</tr>  
</c:forEach>  
</table>  
           </body>
</html>
