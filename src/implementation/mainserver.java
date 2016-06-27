package implementation;
import com.mysql.jdbc.Blob;
import interfaces.Interface;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class mainserver extends UnicastRemoteObject implements Interface,Serializable{

    private static String currenttab;
    Connection con;
    public static int check;
    static List<String> availables = new ArrayList<>();
    public mainserver() throws RemoteException, IOException {
        try {
            Class.forName("com.mysql.jdbc.Driver"); 
            con = DriverManager.getConnection("jdbc:mysql://localhost/file_server", "root", "abe.abe60");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
    }
   
/*###############################################################################################################################
#################################################################################################################################
                                           operations , first look and helper methods
                                           operations , first look and helper methods
#################################################################################################################################
###############################################################################################################################*/
   
    
    @Override
    public List<files> populatetable(String currenttab) throws RemoteException {
        this.currenttab = currenttab;
        List<files> filelist = new ArrayList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            String query;
            switch (currenttab) {
                case "allFiles":
                    query = "select id,filename,publisher,type,size,cover from files";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    rs.close();
                    st.close();
                    break;
                case "documentsTab":
                    query = "select  id,filename,publisher,type,size,cover from files where type = 'pdf' OR type = 'doc' OR type = 'docx'";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    rs.close();
                    st.close();
                    break;
                case "videoTab":
                    query = "select id,filename,publisher,type,size,cover from files where type = 'mp4' OR type = 'avi' OR type = 'flv' OR type = 'mkv' OR type = 'mp3' OR type = 'wma'";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    rs.close();
                    st.close();
                    break;
                case "compressedTab":
                    query = "select id,filename,publisher,type,size,cover from files where type = 'zip' OR type = 'rar' OR type = 'iso'";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    break;
                case "executableTab":
                    query = "select id,filename,publisher,type,size,cover from files where type = 'exe'";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    rs.close();
                    st.close();
                    break;
                case "othersTab":
                    query = "select id,filename,publisher,type,size,cover from files where type NOT IN('pdf','docx','doc','mp3','mp4','flv','mkv',"
                            + "'avi','wma','rar','iso','exe','zip')";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    rs.close();
                    break;
                default:
                    query = "select id,filename,publisher,type,size,cover from files";
                    rs = st.executeQuery(query);
                    while (rs.next()) {
                        filelist.add(convertor(rs));
                    }
                    rs.close();
                    st.close();
            }
        } catch (Exception e) {
            System.out.println("error on populate table happens\n" + e);
        }
        return filelist;
    }//////////done

    
    @Override
    public List<files> searchfiles(String searchthis) throws RemoteException {
        String input = searchthis;
        String input1 = input;
        input += "%";
        int found = 0;
        List<files> searchedlist = new ArrayList<>();
        try {
            String query;
            Statement st = con.createStatement();
            ResultSet rs = null;
            switch (currenttab) {
                case "allFiles":
                    if (input == null) {
                    } else {
                        query = "select id,filename,publisher,type,size,cover from files where filename like '" + input + "'";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            searchedlist.add(convertor(rs));
                            found++;
                        }
                    }
                    rs.close();
                    st.close();
                    break;
                case "documentsTab":
                    if (input == null) {
                        return null;
                    } else {
                        query = "select id,filename,publisher,type,size,cover from files where filename like '" + input
                                + "' AND  type IN ('pdf','docx','doc')";
                        System.out.println("documents is active");
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            searchedlist.add(convertor(rs));
                            found++;
                        }
                    }
                    rs.close();
                    st.close();
                    break;
                case "videoTab":
                    if (input == null) {
                        return searchedlist;
                    } else {
                        query = "select id,filename,publisher,type,size,cover from files where filename like '" + input
                                + "' AND  type IN ('mp4','mp3','avi','flv','mkv','wma')";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            searchedlist.add(convertor(rs));
                            found++;
                        }
                    }
                    rs.close();
                    st.close();
                    break;
                case "compressedTab":
                    if (input == null) {
                        return null;
                    } else {
                        query = "select id,filename,publisher,type,size,cover from files where filename like '" + input
                                + "' AND  type IN ('rar','zip','iso')";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            searchedlist.add(convertor(rs));
                            found++;
                        }
                    }
                    rs.close();
                    st.close();
                    break;
                case "executableTab":
                    if (input == null) {
                        return searchedlist;
                    } else {
                        query = "select id,filename,publisher,type,size,cover from files where filename like '" + input
                                + "' AND  type IN ('exe')";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            searchedlist.add(convertor(rs));
                            found++;
                        }
                    }
                    rs.close();
                    st.close();
                    break;
                case "othersTab":
                    if (input == null) {
                        return searchedlist;
                    } else {
                        query = "select id,filename,publisher,type,size,cover from files where filename like '" + input
                                + "' AND  type NOT IN('pdf','docx','doc','mp3','mp4','flv','mkv',"
                                + "'avi','wma','rar','iso','exe','zip')";
                        rs = st.executeQuery(query);
                        while (rs.next()) {
                            searchedlist.add(convertor(rs));
                            found++;
                        }
                    }
                    rs.close();
                    st.close();
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return searchedlist;
    }
    
    
    
     public files convertor(ResultSet rs) {
        String fileid;
        String filename;
        String filetype;
        String publisher;
        float filesize;
        ImageIcon photo;
        Blob pho;
        try {
            fileid = rs.getString("id");
            filename = rs.getString("filename");
            publisher = rs.getString("publisher");
            filetype = rs.getString("type");
            filesize = rs.getFloat("size");
            pho = (Blob) rs.getBlob("cover");
            photo = new ImageIcon(pho.getBytes(1, (int) pho.length()));
            return new files(fileid, filename, publisher, filetype, filesize, photo);
        } catch (Exception e) {
            System.out.println("error happens in convertor \n" );
            e.printStackTrace();
            return null;
        }
    }
    
    @Override
     public List<String> adminlist() throws RemoteException{
      String query;
      List<admins> userslist = new ArrayList<>();
      List<String> UsersName = new ArrayList<>();
       try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            query = "select * from admins";
            rs = st.executeQuery(query);
            while (rs.next()) {
                userslist.add(converusers(rs));
            }
            rs.close();
            st.close();
            for (admins user : userslist) {
                String fullname = user.getFirstname() + " " + user.getLastname();
                UsersName.add(fullname);
            }
            UsersName.add(0, "selecet User_Name");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
      
      return UsersName;
  }
    
    @Override
     public List<admins> getloginlist() throws RemoteException{
      List<admins> userslist = new ArrayList();
      String query;
      try {
            Statement st = con.createStatement();
            ResultSet rs = null;
            query = "select * from admins";
            rs = st.executeQuery(query);
            while (rs.next()) {
                userslist.add(converusers(rs));
            }
            rs.close();
            st.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
      return userslist;
  }
    
     public admins converusers(ResultSet rs){
       admins user = null;
        String firstname;
        String lastname;
        String password;
        Blob pho;
        ImageIcon photo;
        int issuper;
        int id;
        try {
            id = rs.getInt("id");
            firstname = rs.getString("firstname");
            lastname = rs.getString("lastname");
            password = rs.getString("password");
            issuper = rs.getInt("super");
             pho = (Blob) rs.getBlob("photo");
            photo = new ImageIcon(pho.getBytes(1, (int) pho.length()));
            user = new admins(id, firstname, lastname, password,issuper,photo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
        return user;
  }  
     
     
     
    
    @Override
     public int uploadfile(int filelength, String filename, String publisher, byte[] bytefile, String filetype, float filesize, byte[] bytephoto,int len) throws RemoteException {
      int a,counter;
      String fileid;
      FileInputStream insertedfile=null,photo=null;
        try{
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select count from files ");
            rs.last();
            int rowcount = rs.getRow();
            if(rowcount == 0){
                fileid = "File_Id_1"; 
                counter = 1;
            }else{
               counter = rs.getInt("count") + 1;
               fileid = "File_Id_" + Integer.toString(counter);
            }
          
         PreparedStatement ps = null;
                 String query = "INSERT INTO files (count,id,filename,publisher,file,type,size,cover) VALUES (?,?,?,?,?,?,?,?)";
                  ps = con.prepareStatement(query);
                  ps.setInt(1, counter);
                  ps.setString(2, fileid);
                  ps.setString(3, filename);
                  ps.setString(4, publisher);
                 ps.setBytes(5, bytefile);
                 ps.setString(6, filetype);
                  ps.setFloat(7, filesize);
                 ps.setBytes(8, bytephoto);
                 a = ps.executeUpdate();
                 ps.close();
                 rs.close();
                 st.close();
      }catch(Exception e){
          System.out.println("error while uploadin" + e);
          a=0;
      }
        return a;
    }
    
    @Override
     public byte[] downloadfile(String fileid) throws RemoteException {
        Blob tempblobfile = null;
        InputStream is = null;
        byte[] toreturn = null;
        try {
            Statement st = con.createStatement();
            String query = "select file from files where id = '" + fileid + "'";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                tempblobfile =  (Blob) rs.getBlob("file");
                toreturn = new byte[(int)tempblobfile.length()];
                is = tempblobfile.getBinaryStream();
                is.read(toreturn);
            }
            rs.close();
            is.close();
            return toreturn;
        } catch (Exception e) {
            System.out.println("error happend in getfile methode \n" + e);  
            return null;
        }
       
    }
    
    @Override
     public int deletfile(String operationid) throws RemoteException {
         String query = "delete from files where id = '" + operationid + "'";
         int i = 0;
         try{
         Statement st = con.createStatement();
         i = st.executeUpdate(query);
         }catch(Exception e){
             System.out.println("error happens during deletion " + e);
         }
         return i;
    }
    
                                                /*done operations and  the first look*/
/*##################################################################################################################################
##################################################################################################################################*/
                
     
     
    @Override
    public int check(String username){
        check = availables.size();
        return check;
    }
     
    @Override
     public List<String> available(String username) throws RemoteException{
         int i = 0;
         if(availables.size() == 0){
             availables.add(username);
             i = 1;
         }else{
         for(String temp : availables){
             if(temp.equals(username))
                 i = 1;
         }
        }
         if( i == 0)
         availables.add(username);
         return availables;
     }
     
    @Override
     public void remove(String user) throws RemoteException{
        int i = -1;
         for(String tm : availables){
             ++i;
             if(tm.equals(user)) 
                 
                 
                 availables.remove(i);
         }
     }
     
    @Override
    public int writechat(String touser,String mess) throws RemoteException{
        int a = 0;
        try{
            Statement st = con.createStatement();
            String sql = "update clients SET message = '" + mess +"' where username = '" + touser + "'";
            a = st.executeUpdate(sql);
            st.close();
        }catch(Exception e){
            System.out.println("serror happens on writechat " + e);
        }
        return a;
    }
  
    
    @Override
    public String readchat(String username) throws RemoteException{
        String msg = "";
        try{
           Statement st = con.createStatement();
           String query = "select message from clients where username = '" + username + "'";
           ResultSet rs = st.executeQuery(query);
           while(rs.next()){
               msg = rs.getString("message");
               int test = msg.length();
               System.out.println(test);
               if(test>=1){
              // if(!msg.equals("")){
                   clear(username,1);
                   System.out.println(msg);
               }
           }
           rs.close();
           st.close();
        }catch(Exception e){
            System.out.println("error happens on readchat " + e);
        }
        return msg;
        
    }
 
  
    @Override
    public int clear(String username, int flag) throws RemoteException{
        int a = 0;
        try{
            if(flag == 1){
            Statement st = con.createStatement();
            String sql = "update clients SET message ='' where username = '" + username + "'";
            a = st.executeUpdate(sql);
            st.close();
            }
        }catch(Exception e){
            System.out.println("serror happens on clearchat " + e);
        }
        return a;
    }
   
    
    
    
//########################################################################################################################
//########################################################################################################################
/*                                                   client staff goes here  
                                                     client staff goes here
##########################################################################################################################
########################################################################################################################*/
  
    @Override
    public int signupuser(String firstname, String lastname,String username, String password, String job, byte[] photo) throws RemoteException {
        int counter, a=0;
        try{
             Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select id from clients ");
            rs.last();
            int rowcount = rs.getRow();
            if(rowcount == 0){
                counter = 1;
            }else{
               counter = rs.getInt("id") + 1;
            }
             PreparedStatement ps = null;
             String query = "INSERT INTO clients (id,firstname,lastname,username,password,job,photo) VALUES (?,?,?,?,?,?,?)";
               ps = con.prepareStatement(query);
                  ps.setInt(1, counter);
                  ps.setString(2, firstname);
                  ps.setString(3, lastname);
                  ps.setString(4, username);
                  ps.setString(5, password);
                  ps.setString(6, job);
                 ps.setBytes(7, photo);
                 a = ps.executeUpdate();
                 ps.close();
                 rs.close();
                 st.close();
        }catch(Exception e){
            a=0;
            System.out.println("error happens while sign up" + e.getMessage());
        }
        
        return a;
    }
    
    
    @Override
    public boolean confirmclient(String username, String pass) throws RemoteException {
        String databaseusername,databasepassword = "";
        boolean result = false;
        int a = 0;
        String query = "select username,password from clients where username = '" + username + "'";
        try {
            ResultSet rs;
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
            while(rs.next()){
                databaseusername = rs.getString("username");
                databasepassword = rs.getString("password");
                a++;
            }
            if(a != 0){
                if(databasepassword.equals(pass))
                    result = true;
            }rs.close();
            st.close();
        } catch (SQLException ex) {
            Logger.getLogger(mainserver.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    
    
    @Override
    public client getinfo(String username) throws RemoteException{
        client c = null;
        try{
            String firstname,lastname,password,job;
            ImageIcon photo;
            Blob b;
            String query = "select * from clients where username = '" + username + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                firstname = rs.getString("firstname");
                lastname = rs.getString("lastname");
                password = rs.getString("password");
                job = rs.getString("job");
                b = (Blob) rs.getBlob("photo");
                photo = new ImageIcon(b.getBytes(1, (int) b.length()));
                c = new client(firstname,lastname,username,password,job,photo);
            }rs.close();
            st.close();
        }catch(Exception e){
            System.out.println("error happents on getinfo of the client " + e);
        }
        
        return c;
    }
    
                                                   /* done client staff*/
/*##########################################################################################################################
##########################################################################################################################*/
    
 
    
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1234);
            mainserver Server = new mainserver();
            reg.rebind("fileserver", Server);
            System.out.println("server is running...........");
            System.out.println("waiting for client request...............");
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
