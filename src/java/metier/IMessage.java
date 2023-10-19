
package metier;

import Beans.Messages;
import java.util.List;

/**
 *
 * @author Hp
 */
public interface IMessage {
    public List<Messages> getListMsg();
    public String Enregistrer(Messages m);
    
}
