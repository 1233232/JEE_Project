
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

@WebServlet(name = "Identification", urlPatterns = {"/Identification"})
public class Identification extends HttpServlet {
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
       String pseudo=request.getParameter("pseudo");
        String motDePasse=request.getParameter("motDePasse");
        
        Utilisateur u=new Utilisateur();
        
        u.setPseudo(pseudo);
        u.setMotDePasse(motDePasse); 
        
        HttpSession session=request.getSession();
        session.setAttribute("u", u);
        
        

        

        String message="";
        if ((pseudo.equals("")) || (motDePasse.equals("")) ) {
            
            message = "Merci de remplir ce champs";    
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/Identification.jsp").forward(request, response); 

             
            }
        else{
          UtilisateurDAO ud=new UtilisateurDAO();
           //String result=pd.Enregistrer(e);
           String result=ud.authentification(u);
           if(result.equals("OK"))
           {
               session.setAttribute("UserConnected",pseudo );
               
               getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            
            }
            else{
                 message = "Nom d'utilisateur ou mot de passe incorrect";
                request.setAttribute("message", message);
                getServletContext().getRequestDispatcher("/Identification.jsp").forward(request,response);
            }
        }
        }        
    }



