<%-- 
    Document   : index
    Created on : 29 janv. 2023, 09:03:37
    Author     : USER
--%>
<%@page import="entity.*,java.util.*,Service.*"%>
<%
    ArrayList<Scene>ray=(ArrayList<Scene>)request.getAttribute("listScene");
    int idwatch=(int)request.getAttribute("idwatch");
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
       <p><a href="<%= request.getContextPath() %>/addscene?idwatch=<%=idwatch %>">add scene</a></p>
       <%for (Scene elem : ray) {%>
            <p>intitule:<%=elem.getIntitule()%></p>
            <p>plateau:<%=elem.plateau()%></p>
            <p>numero:<%=elem.getNumero()%></p>
            <p>dure:<%=elem.getDure()%></p>
            <p><a href="<%= request.getContextPath() %>/listAct?idscene=<%= elem.getIdscene()%>">consulter les action</a></p>
            <p><a href="<%= request.getContextPath() %>/modifscene?idscene=<%=elem.getIdscene()%>">modifier</a></p>
       <%}%>
    </body>
</html>

