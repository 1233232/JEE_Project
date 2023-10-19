
package Servlet;

import Beans.Messages;
import DAO.MessagesDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
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
@WebServlet(name = "Accueil", urlPatterns = {"/Accueil"})
public class Accueil extends HttpServlet {
          private MessagesDAO msg;

    @Override
    public void init() throws ServletException {
        msg = new MessagesDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                 List< Messages> listeMsg = msg.getListMsg();
        request.setAttribute("listeMsg", listeMsg);
        getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response); 
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String message =request.getParameter("message");
        HttpSession session=request.getSession();
        String user=(String) session.getAttribute("UtilisateurConnecter");
        String msg="";
        
        if(message.equals("")){
            msg="Remplir les champs ";
            request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
            
        }
        else if(user==null){
            msg="Vous devez se connecter";
            request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
        }

        else{
        Messages m=new Messages();
        m.setMessage(message);
        m.setPseudo(user);
        Date date=new Date();
        m.setDate(date);
        
           MessagesDAO MDAO=new MessagesDAO();
           //String result=pd.Enregistrer(e);
           String result=MDAO.Enregistrer(m);
           if(result.equals("Enregistrer")){
               
               msg="ajout avec succés";            
            }
            else{
                msg="une erreur a été survenue";
            }
           request.setAttribute("msg",msg);
            getServletContext().getRequestDispatcher("/Accueil.jsp").forward(request, response);
        }        
    }        
        
    }



