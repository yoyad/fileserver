
package implementation;

import java.io.Serializable;
import javax.swing.ImageIcon;


public class admins implements Serializable{

    int id;
    String firstname;
    String lastname;
    String password;
    int issuper;
    ImageIcon photo;
    public admins(int id, String firstname, String lastname, String password, int asuper, ImageIcon photo) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.issuper = asuper;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPassword() {
        return password;
    }

    public int getIssuper() {
        return issuper;
    }

    public ImageIcon getPhoto() {
        return photo;
    }
    
}
