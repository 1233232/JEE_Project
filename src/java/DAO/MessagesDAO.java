
package DAO;

import Beans.Messages;
import Hibernate.NewHibernateUtil;
import java.util.List;
import metier.IMessage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author moham
 */
public class MessagesDAO implements IMessage{

    @Override
    public List<Messages> getListMsg() {
       List< Messages> listeMsg = null;
        try {
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            listeMsg = se.createQuery("from Messages").list();

            // commit transaction
            tr.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return listeMsg;     }

    @Override
    public String Enregistrer(Messages m) {
                try{
            Session se = NewHibernateUtil.getSessionFactory().openSession();
            Transaction tr = se.beginTransaction();
            se.save(m);
            tr.commit();
            return "Enregistrer";
            
            
        }catch (Exception x) {
            return "AUTRE CHOSE";
    }    }    }
    

