<%-- 
    Document   : CreerUtilisateur
    Created on : 28-Dec-2022, 08:44:29
    Author     : moham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <title>Inscription</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    </head>
    <body>
        <h1>Formulaire d'inscription</h1>
        <form method="Post" action='CreerUtilisateur'>

        <%
        String msg=(String)request.getAttribute("msg");
        if(msg==null){
            msg="";
          
        }
        %>
        <font COLOR=" #ff0000"><%=msg %></font>
            <table>
                <tr>
                    <td>Nom :</td>
                    <td><input type="text" name="nom" value="${u.nom}"></td>
                </tr>
                <tr>
                    <td>Prenom :</td>
                    <td><input type="text" name="prenom" value="${u.prenom}"></td>
                </tr>
                <tr>
                    <td>Pseudo :</td>
                    <td><input type="text" name="pseudo" value="${u.pseudo}"></td>
                </tr>
                <tr>
                    <td>Mot dePasse :</td>
                    <td><input type="password" name="motDePasse" value="${u.motDePasse}"></td>
                </tr>
                <tr>
                    <td>Confirmation :</td>
                    <td><input type="password" name="confirmation" ></td>
                </tr> 
                <tr>
                    <td><input type="submit" value="Creer Mon Compte" class="btn btn-primary"></td>
                    <td><input type="reset" value="Effacer" class="btn btn-primary"></td>
                </tr>                
            </table>
        </form>
    </body>
</html>
