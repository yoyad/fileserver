
package implementation;

import java.io.Serializable;
import javax.swing.ImageIcon;


public class client implements Serializable{
  String username;
  String firstname;
  String lastname;
  String password;
  String job;
  ImageIcon photo;
  
  public client(String firstname, String lastname, String username, String password, String job, ImageIcon photo){
      this.firstname = firstname;
      this.lastname = lastname;
      this.username = username;
      this.password = password;
      this.job = job;
      this.photo = photo;
  }

    public String getUsername() {
        return username;
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

    public String getJob() {
        return job;
    }

    public ImageIcon getPhoto() {
        return photo;
    }
  
}
