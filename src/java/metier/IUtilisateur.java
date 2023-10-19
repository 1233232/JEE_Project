
package metier;

/**
 *
 * @author moham
 */
import Beans.Utilisateur;


public interface IUtilisateur {
    public String authentification(Utilisateur u);
    public String Enregistrer(Utilisateur u);
    
}
