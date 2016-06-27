
package interfaces;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import implementation.*;
public interface Interface extends Remote {
    
    
    public List<String> adminlist()throws RemoteException;
    public List<admins> getloginlist() throws RemoteException;
    
    
    public client getinfo(String username) throws RemoteException;
    public int signupuser(String firstname, String lastname,String username, String job, String password, byte[] photo) throws RemoteException;
    public boolean confirmclient(String username, String pass) throws RemoteException;
    
    
    public List<files> populatetable(String currenttab) throws RemoteException;
    public List<files> searchfiles(String searchthis) throws RemoteException;
    
    
    public byte[] downloadfile(String fileid) throws RemoteException;
    public int uploadfile(int filelength,String filename, String publisher,byte[] insertedfile,String filetype,float filesize,byte[] photo,int len) throws RemoteException;
    public int deletfile(String operationid) throws RemoteException;
    
    
    public int check(String username) throws RemoteException;
    public int clear(String username, int flag) throws RemoteException;
    public int writechat(String touser,String mess) throws RemoteException;
    public String readchat(String username) throws RemoteException;
    public List<String> available(String username) throws RemoteException;
    public void remove(String user) throws RemoteException;
}
