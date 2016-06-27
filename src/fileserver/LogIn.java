package fileserver;

import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

//under construction

public class LogIn extends javax.swing.JFrame {
    String name[];
    Connection con;
    userstable currentuser;
    List<userstable> users = new ArrayList<>();
    List<String> names = new ArrayList<>();

    public LogIn() {
        checkCon();

        if (con != null) {
            users = fechtuserstable();
            for (userstable user : users) {
                String fullname = user.getFirstname() + " " + user.getLastname();
                names.add(fullname);
            }
            names.add(0,"select user");
            name  = names.toArray(new String[names.size()]);
            initComponents();
        }else{
            System.exit(-1);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user = new javax.swing.JComboBox(name);
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        forgot = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        preview = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("SELECT USER");

        user.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userItemStateChanged(evt);
            }
        });
        user.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("PASSWORD");

        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        login.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        login.setText("LOG_IN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        forgot.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        forgot.setText("FORGOT PASS");
        forgot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgotActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(forgot)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(login))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 4, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(user, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(forgot))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        preview.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        preview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preview.setText("NO PREVIEW AVILABLE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userActionPerformed

    }//GEN-LAST:event_userActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        
        if (currentuser == null) {
            JOptionPane.showMessageDialog(null, "you must select a user",null,JOptionPane.WARNING_MESSAGE);
            password.setText("");
            return;
        }
        String pass1 = new String(password.getPassword());
        String pass2 = currentuser.getPassword();
        if (pass1.equals("")) {
            JOptionPane.showMessageDialog(null, "you must enter pass word ",null,JOptionPane.WARNING_MESSAGE);
            password.setFocusable(true);
        } else {
            if (pass1.equals(pass2)) {
                try{
                     this.dispose();
                database u = new database(currentuser,con);
                u.setVisible(rootPaneCheckingEnabled);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "can not confirm pass word",null,JOptionPane.ERROR_MESSAGE);
                password.setText("");
            }
        }
    }//GEN-LAST:event_loginActionPerformed

    private void forgotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgotActionPerformed
        //   handle forgot password
    }//GEN-LAST:event_forgotActionPerformed

    private void userItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if(user.getSelectedIndex()==0){
                preview.setIcon(null);
                preview.setText("NO PREVIEW AVAILABLE");
            }else{
            currentuser = users.get((user.getSelectedIndex()-1));
            preview.setText("");
            preview.setIcon(currentuser.getPhoto());
            }
        }

    }//GEN-LAST:event_userItemStateChanged

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
         if (currentuser == null) {
            JOptionPane.showMessageDialog(null, "you must select a user",null,JOptionPane.WARNING_MESSAGE);
            return;
        }
        String pass1 = new String(password.getPassword());
        String pass2 = currentuser.getPassword();
        if (pass1.equals("")) {
            JOptionPane.showMessageDialog(null, "you must enter pass word ",null,JOptionPane.WARNING_MESSAGE);
            password.setFocusable(true);
        } else {
            if (pass1.equals(pass2)) { 
                try{
                   this.dispose();
                database u = new database(currentuser,con);
                u.setVisible(rootPaneCheckingEnabled);
                }catch(Exception e){
                    System.out.println(e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "can not confirm pass word",null,JOptionPane.ERROR_MESSAGE);
                password.setText("");
            }
        }
    }//GEN-LAST:event_passwordActionPerformed
    public Connection checkCon() {
        try {
            con = con = DriverManager.getConnection("jdbc:mysql://localhost/fileserver", "root", "");
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(),null,JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public List<userstable> fechtuserstable() {
        List<userstable> temp = new ArrayList<>();
        ResultSet rs;
        Statement st;
        Blob pho;
        ImageIcon photo;
        userstable singleuser;
        String firstname, lastname, password;
        try {
            String query = "select * from login";
            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                firstname = rs.getString("firstName");
                lastname = rs.getString("lastName");
                password = rs.getString("password");
                pho = rs.getBlob("photo");
              photo = new ImageIcon(pho.getBytes(1, (int)pho.length()));
              
                singleuser = new userstable(firstname, lastname, password,photo);
                temp.add(singleuser);
            }
            rs.close();
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           // ex.printStackTrace();
            System.exit(-1);
        }
        return temp;
    }

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton forgot;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton login;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel preview;
    private javax.swing.JComboBox user;
    // End of variables declaration//GEN-END:variables
}
