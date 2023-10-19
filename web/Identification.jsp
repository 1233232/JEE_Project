<%-- 
    Document   : Identification
    Created on : 28-Dec-2022, 08:44:58
    Author     : moham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Identification</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Formulair de Connexion</h1>
        <form method="Post" action="Identification">
            <%
                String message= (String) request.getAttribute("message");
                if(message==null){
                    message="";
                }%>
                <font COLOR=" #ff0000"><%=message %></font>
            
            <table>
                <tr>
                    <td> Pseudo :</td>
                    <td><input type="text" name="pseudo" value="${u.pseudo}"></td>
                </tr>
                <tr>
                    <td> Mot de passe :</td>
                    <td><input type="password" name="motDePasse"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Se Connecter" class="btn btn-primary"></td>
                    <td><a href="CreerUtilisateur.jsp">Creer un Compte</a></td>
                </tr>
            </table>
        </form>
    </body>
</html>
