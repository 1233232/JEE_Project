
package Servlet;

import Beans.Utilisateur;
import DAO.UtilisateurDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author moham
 */
@WebServlet(name = "CreerUtilisateur", urlPatterns = {"/CreerUtilisateur"})
public class CreerUtilisateur extends HttpServlet {
          private UtilisateurDAO user;

    @Override
    public void init() throws ServletException {
        user = new UtilisateurDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom=request.getParameter("nom");
        String prenom=request.getParameter("prenom");
        String pseudo=request.getParameter("pseudo");
        String motDePasse=request.getParameter("motDePasse");
        String confirmation=request.getParameter("confirmation");
        
        Utilisateur u=new Utilisateur();
        u.setNom(nom);
        u.setPrenom(prenom);
        u.setPseudo(pseudo);
        u.setMotDePasse(motDePasse);
        
        HttpSession session=request.getSession();
        session.setAttribute("u",u);
        
        String msg="";
        if ((nom.equals("")) || (prenom.equals("")) || (pseudo.equals("")) || (motDePasse.equals("")) || (confirmation.equals("")) )
           {
 
                 msg = "Merci de remplir ce champs";
                 request.setAttribute("msg", msg);                 
                 getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
            
            }
        else if(!confirmation.equals(motDePasse))
        {
            msg="Le mot de passe et confirmation doivent etre identiques !!";
            request.setAttribute("msg", msg);                 
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        }
        
        else{
        
           UtilisateurDAO ud=new UtilisateurDAO();
           //String result=pd.Enregistrer(e);
           String result=ud.Enregistrer(u);
           if(result.equals("Enregistrer")){
               
               msg="ajout avec succés";            
            }
            else{
                msg="une erreur a été survenue";
            }
           request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/CreerUtilisateur.jsp").forward(request, response);
        }        
    }



}
