package server;

import interfaces.Interface;
import java.awt.Image;
import java.rmi.Naming;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import implementation.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
public class login extends javax.swing.JFrame {

    String username;
    String password;
    String databasename;
    String databasepassword;
    String query;
    ImageIcon photo;
    Connection con;
    static int currentid;
    List<admins> userslist = new ArrayList();
    List<String> UsersName = new ArrayList<>();
    String[] combobox;
     interfaces.Interface ref;
    public login() {
      
        try{
            ref = (Interface) Naming.lookup("rmi://localhost:1234/fileserver");
            userslist = ref.getloginlist();
            setusers();
        ImageIcon back = new ImageIcon("C:\\Users\\shadow\\Downloads\\Black.jpg");
        Image newimg = back.getImage().getScaledInstance(489, 229, java.awt.Image.SCALE_SMOOTH);
        back = new ImageIcon(newimg);
        setContentPane(new JLabel(back));
              initComponents();
       }catch(Exception e){
           System.out.println("error: " + e);
       }
        
    }

    public void setusers() {
        try {
            UsersName = ref.adminlist();
            combobox = UsersName.toArray(new String[UsersName.size()]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
        }
    }

    public ImageIcon getphoto(int id){
        ImageIcon photo = null;
        try{
            Statement st = con.createStatement();
            String query = "select photo from admins where id = '" + id + "'";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                Blob pho = rs.getBlob("photo");
                photo = new ImageIcon(pho.getBytes(1, (int)pho.length()));
            }
        }catch(Exception e){
            
        }
        
        return photo;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cover = new javax.swing.JLabel();
        cancle = new javax.swing.JButton();
        login = new javax.swing.JButton();
        inputusername = new javax.swing.JComboBox(combobox);
        inputpassword = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 255));
        jLabel1.setText("USER_NAME:");

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 255, 255));
        jLabel2.setText("PASS_WORD:");

        cover.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        cover.setForeground(new java.awt.Color(255, 255, 255));
        cover.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cover.setPreferredSize(new java.awt.Dimension(195, 155));

        cancle.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        cancle.setForeground(new java.awt.Color(255, 0, 0));
        cancle.setText("CANCEL");

        login.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        login.setForeground(new java.awt.Color(0, 153, 0));
        login.setText("LOGIN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        inputusername.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        inputusername.setForeground(new java.awt.Color(0, 255, 255));
        inputusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputusernameActionPerformed(evt);
            }
        });

        inputpassword.setBackground(new java.awt.Color(255, 204, 204));
        inputpassword.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        inputpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputpasswordActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Aharoni", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ADMINISTRATOR PANEL  USER AUTHENTICATION FORM");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(cancle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                                .addComponent(login))
                            .addComponent(inputusername, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(inputpassword))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cancle)
                            .addComponent(login))
                        .addGap(60, 60, 60))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cover, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
              databasepassword = userslist.get(currentid).getPassword();
                password = inputpassword.getText();
                if(username == null){
                    JOptionPane.showMessageDialog(null, "you should select user name", null, JOptionPane.WARNING_MESSAGE);
                    inputpassword.setText("");
                }else{
                    if(password.equals("")){
                        JOptionPane.showMessageDialog(null, "you should enter a password", null, JOptionPane.WARNING_MESSAGE);
                        inputpassword.setText("");
                    }else if(!password.equals(databasepassword)){
                        JOptionPane.showMessageDialog(null, "password doesn't match", null, JOptionPane.ERROR_MESSAGE);
                        inputpassword.setText("");
                    }else if(password.equals(databasepassword)){
                        System.out.println("password confrim");
                        this.dispose();
                        try {
                            new frame(userslist,currentid).setVisible(rootPaneCheckingEnabled);
                        } catch (RemoteException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NotBoundException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
    }//GEN-LAST:event_loginActionPerformed

    private void inputusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputusernameActionPerformed
        if (inputusername.getSelectedIndex() > 0) {
            username = inputusername.getSelectedItem().toString();
            currentid = inputusername.getSelectedIndex() - 1;
            photo =  userslist.get(currentid).getPhoto();
            Image img = photo.getImage();
            Image newimg = img.getScaledInstance(195, 155, java.awt.Image.SCALE_SMOOTH);
            photo = new ImageIcon(newimg);
            cover.setText("");
            cover.setIcon(photo);
        }else if(inputusername.getSelectedIndex() == 0){
            username = null;
            cover.setIcon(null);
            cover.setText("NO PREVIEW");
        }
    }//GEN-LAST:event_inputusernameActionPerformed

    private void inputpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputpasswordActionPerformed
                databasepassword = userslist.get(currentid).getPassword();
                password = inputpassword.getText();
                if(username == null){
                    JOptionPane.showMessageDialog(null, "you should select user name", null, JOptionPane.WARNING_MESSAGE);
                    inputpassword.setText("");
                }else{
                    if(password.equals("")){
                        JOptionPane.showMessageDialog(null, "you should enter a password", null, JOptionPane.WARNING_MESSAGE);
                        inputpassword.setText("");
                    }else if(!password.equals(databasepassword)){
                        JOptionPane.showMessageDialog(null, "password doesn't match", null, JOptionPane.ERROR_MESSAGE);
                        inputpassword.setText("");
                    }else  if(password.equals(databasepassword)){
                        System.out.println("password confrim");
                        this.dispose();
                        try {
                            new frame(userslist,currentid).setVisible(true);
                        } catch (RemoteException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (NotBoundException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (MalformedURLException ex) {
                            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
    }//GEN-LAST:event_inputpasswordActionPerformed

    public static void main(String args[]) {

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    private javax.swing.JLabel cover;
    private javax.swing.JPasswordField inputpassword;
    private javax.swing.JComboBox inputusername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton login;
    // End of variables declaration//GEN-END:variables
}
