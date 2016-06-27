
package fileserver;

import javax.swing.ImageIcon;


public class userstable {
    String firstname;
    String lastname;
    String password;
    ImageIcon photo;
    public userstable(String firstname, String lastname, String password,ImageIcon photo){
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.photo = photo;    
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

    public ImageIcon getPhoto() {
        return photo;
    }
    
    
}
