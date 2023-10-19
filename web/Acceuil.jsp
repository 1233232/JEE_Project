<%-- 
    Document   : Acceuil
    Created on : 28-Dec-2022, 08:44:07
    Author     : moham
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
       <head>
        <title>Acceuil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
         <form action="Accueil" method="post" >
                        <% String msg1 = (String) session.getAttribute("UtilisateurConnecter");
                           
                            if (msg1 == null) {
                                msg1 = "";
                            }%>                      
                    <h1>Bonjour <%= msg1%>, Mon site vous plait? Laissez-moi un message !</h1>                
                        <% String msg = (String) request.getAttribute("msg");
                            if (msg == null) {
                                msg = "";
                            }%>       

                        <font COLOR=" #ff0000"><%=msg%></font>            
            <table>
                <tr>
                    <td>Message :</td>
                    <td><textarea rows="3" name="message"></textarea></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Poster" class="btn btn-primary"></td>
                    <td><a href="Identification.jsp">Se Connecter</a></td>
                    
                </tr>
                <tr>
                    <td><a href="Accueil">Afficher la liste des messages</a></td>
                </tr>
                <c:forEach var="msg" items="${listeMsg}">
                <tr>
                    <td><c:out value="${msg.pseudo} a ecrit le ${msg.date} " /></td>
                    <td>    <c:out value="${msg.messages}"/></td>
                </tr> 
                 </c:forEach>
            </table>
           </form>

    </body>
</html>


