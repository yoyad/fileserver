
package server;


public class usersclass {
    int id;
    String firstname;
    String lastname;
    String password;
    
    public usersclass(int id, String firstname, String lastname,String password){
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
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
    
    
}
