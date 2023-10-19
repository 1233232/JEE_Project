
package DAO;

import Beans.Utilisateur;
import Hibernate.NewHibernateUtil;
import metier.IUtilisateur;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author moham
 */
public class UtilisateurDAO implements IUtilisateur {

    @Override
    public String authentification(Utilisateur u) {
        
        String pseudo = u.getPseudo();
        String motDePasse = u.getMotDePasse();
        
        Session se = NewHibernateUtil.getSessionFactory().openSession();
        Transaction tr = se.beginTransaction();
        
        Utilisateur user = (Utilisateur) se.get(Utilisateur.class, pseudo);
        if (user != null) {
               if (user.getPseudo().equals(pseudo) && (user.getMotDePasse().equals(motDePasse))) {
                         return "OK";
                } else {
                       return "KO";
                 }
        } else {
               return "KO";
        }    }

    @Override
    public String Enregistrer(Utilisateur u) {
                try{
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            se.save(u);
            tr.commit();
            return "ENR";
            
            
        }catch (Exception x) {
            return "AUTRE CHOSE";
    }    }
    
}
