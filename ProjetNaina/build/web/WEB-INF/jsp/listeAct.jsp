<%-- 
    Document   : index
    Created on : 29 janv. 2023, 09:03:37
    Author     : USER
--%>
<%@page import="entity.*,java.util.*,Service.*"%>
<%
    ArrayList<Act>ray=(ArrayList<Act>)request.getAttribute("listAct");
    int idscene=(int)request.getAttribute("idscene");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p><a href="<%= request.getContextPath() %>/addact?idscene=<%=idscene %>">add act</a></p>
       <%for (Act elem : ray) {%>
            <p>intitule:<%=elem.getIntitule()%></p>
            <p>auteur:<%=elem.acteur()%></p>
            <p>sentiment:<%=elem.sentiment()%></p>
            <p><a href="<%= request.getContextPath() %>/modifact?idact=<%=elem.getIdact()%>">modifier</a></p>
       <%}%>
    </body>
</html>

