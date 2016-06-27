package fileserver;

//import java.awt;
import java.awt.Color;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class database extends javax.swing.JFrame {

    String firstname;
    String lastname;
    String password;
    ImageIcon photo; 
   userstable user;
    Connection con;
    static files file;
    public database(userstable user, Connection con) {
        initComponents();
        logos();
        setlogintime();
        setcurrenttime();
        this.con = con;
        this.user = user;
        photo = this.user.getPhoto();
        preview.setText("");
        preview.setIcon(photo);
        usr.setText(this.user.getFirstname());
      }

    public void logos(){
        logo.setText("WELCOME TO THE FILE SERVER");
        logo.setForeground(Color.yellow);
        Thread t = new Thread(new Runnable(){
            String text = "WELCOME TO THE FILE SERVER";
            String temp = "";
            public void run(){
                int a = text.length();
                try{
                    Thread.sleep(1000);
                for(int i=0; i<a; i++){
                    temp += text.charAt(i); 
                    logo.setText(temp);
                    logo.setForeground(Color.red);
                    if(i == a-1){
                        logo.setForeground(Color.yellow);
                        Thread.sleep(3000);
                        i=-1;
                        temp = "";
                        logo.setText(temp);
                        
                    }
                    Thread.sleep(300);
                }
                }catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                        }
                }
            
        }); t.start();
    }
    public  void setlogintime(){
        
                     String m,s,h;
                    Date d = new Date();
                    h = Integer.toString(d.getHours());
                    m = Integer.toString(d.getMinutes());
                    s = Integer.toString(d.getSeconds());
                    if(Integer.parseInt(h) <10){
                        String temp = h;
                        h = "0";
                        h +=temp;   
                    }
                     if(Integer.parseInt(m) <10){
                        String temp = m;
                        m = "0";
                        m +=temp;   
                    }
                      if(Integer.parseInt(s) <10){
                        String temp = s;
                        s = "0";
                        s +=temp;   
                    }
                        logintime.setText(h + ":" + m + ":" + s);
    }
    
    public void setcurrenttime(){
        
        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    String m,s,h;
                    Date d = new Date();
                    h = Integer.toString(d.getHours());
                    m = Integer.toString(d.getMinutes());
                    s = Integer.toString(d.getSeconds());
                    if(Integer.parseInt(h) <10){
                        String temp = h;
                        h = "0";
                        h +=temp;   
                    }
                     if(Integer.parseInt(m) <10){
                        String temp = m;
                        m = "0";
                        m +=temp;   
                    }
                      if(Integer.parseInt(s) <10){
                        String temp = s;
                        s = "0";
                        s +=temp;   
                    }
                        currenttime.setText(h + ":" + m + ":" + s);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        currenttime.setText("00:00:00");
                    }
                }
            }
        });
        t.start();
    }
    
    public java.util.List<files> search(String input) {
        java.util.List<files> found = new ArrayList<>();
        input += "%";
        ResultSet rs;
        try {
            PreparedStatement pst = con.prepareStatement("select * from file where filename like ?");
            pst.setString(1, input);
            rs = pst.executeQuery();
            while (rs.next()) {
                found.add(converttodata(rs));
            }
            return found;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            return null;
        }
     }

    public files converttodata(ResultSet rs) {
        files file;
        try {
            int id = rs.getInt("id");
            String filename = rs.getString("fileName");
            String author = rs.getString("author");
            //Blob file = rs.getBlob("file");
            //Blob cover = rs.getBlob("cover");
            file = new files(id,filename,author);
            return file;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),null,JOptionPane.ERROR_MESSAGE);
            return null;
        }finally{
            try {
                rs.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(),null,JOptionPane.ERROR_MESSAGE);
              }
        }
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        input = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        preview = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();
        usr = new javax.swing.JToggleButton();
        logintime = new javax.swing.JToggleButton();
        jLabel5 = new javax.swing.JLabel();
        deactiveclient = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        activeclient = new javax.swing.JToggleButton();
        curtime = new javax.swing.JLabel();
        currenttime = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        upload = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        logout = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        jTabbedPane2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("SEARCH....");

        input.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N

        search.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search.setForeground(new java.awt.Color(51, 0, 204));
        search.setText("SEARCH");
        search.setDefaultCapable(false);
        search.setFocusable(false);
        search.setOpaque(false);
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        jRadioButton1.setBackground(new java.awt.Color(204, 204, 204));
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 153, 0));
        jRadioButton1.setText("FILE NAME");
        jRadioButton1.setFocusPainted(false);
        jRadioButton1.setFocusable(false);

        jRadioButton2.setBackground(new java.awt.Color(204, 204, 204));
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 153, 102));
        jRadioButton2.setText("AUTHOR");
        jRadioButton2.setFocusable(false);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        preview.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        preview.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        preview.setText("NO PREVIEW");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("LOGGGED IN AS");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("LOGGED IN TIME");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("SERVER STATUS");

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jToggleButton1.setForeground(new java.awt.Color(0, 204, 0));
        jToggleButton1.setSelected(true);
        jToggleButton1.setEnabled(false);
        jToggleButton1.setFocusPainted(false);

        usr.setBackground(new java.awt.Color(0, 0, 0));
        usr.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        usr.setForeground(new java.awt.Color(0, 204, 51));
        usr.setSelected(true);
        usr.setEnabled(false);
        usr.setFocusPainted(false);
        usr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usrActionPerformed(evt);
            }
        });

        logintime.setBackground(new java.awt.Color(0, 0, 0));
        logintime.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        logintime.setForeground(new java.awt.Color(0, 204, 0));
        logintime.setSelected(true);
        logintime.setEnabled(false);
        logintime.setFocusPainted(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel5.setText("ACTIVE CLIENT");

        deactiveclient.setBackground(new java.awt.Color(0, 0, 0));
        deactiveclient.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        deactiveclient.setForeground(new java.awt.Color(0, 204, 0));
        deactiveclient.setSelected(true);
        deactiveclient.setEnabled(false);
        deactiveclient.setFocusPainted(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel6.setText("DEACTIVE CLIENT");

        activeclient.setBackground(new java.awt.Color(0, 0, 0));
        activeclient.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        activeclient.setForeground(new java.awt.Color(0, 204, 0));
        activeclient.setSelected(true);
        activeclient.setEnabled(false);
        activeclient.setFocusPainted(false);

        curtime.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        curtime.setText("CURRENT TIME");

        currenttime.setBackground(new java.awt.Color(0, 0, 0));
        currenttime.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        currenttime.setForeground(new java.awt.Color(0, 204, 0));
        currenttime.setSelected(true);
        currenttime.setEnabled(false);
        currenttime.setFocusPainted(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(preview, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(usr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(91, 91, 91)
                                        .addComponent(logintime, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(curtime)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(currenttime, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(activeclient, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(deactiveclient, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(preview, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(usr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logintime)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(curtime)
                    .addComponent(currenttime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(activeclient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(deactiveclient))
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(table);

        upload.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        upload.setForeground(new java.awt.Color(0, 153, 0));
        upload.setText("UPLOAD");
        upload.setFocusable(false);
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 0, 0));
        jButton2.setText("DELETE");
        jButton2.setFocusable(false);

        logout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 0, 0));
        logout.setText("LOGOUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        logo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logout)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButton2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(152, 152, 152))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(upload)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2)
                                .addGap(263, 263, 263))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(logo)
                                .addGap(298, 298, 298))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(input, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(upload)
                            .addComponent(logout)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("DATABASE", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("users", jPanel2);

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 595, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usrActionPerformed

    }//GEN-LAST:event_usrActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        String in = input.getText();
        List<files> temp = new ArrayList<>();
        temp = search(in);
       tablemodel tmodel = new tablemodel(temp);
       table.setModel(tmodel);
    }//GEN-LAST:event_searchActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try{
            con.close();
            this.dispose();
            LogIn l = new LogIn();
        l.setVisible(true);
        l.setDefaultCloseOperation(EXIT_ON_CLOSE);
        l.setResizable(false);
        l.setLocation(400, 250);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(),null,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_logoutActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
            
            JPopupMenu pop = new JPopupMenu();
                JLabel name = new JLabel("name");
                pop.add(name);
               pop.show(rootPaneCheckingEnabled);
                
                
    }//GEN-LAST:event_uploadActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton activeclient;
    private javax.swing.JToggleButton currenttime;
    private javax.swing.JLabel curtime;
    private javax.swing.JToggleButton deactiveclient;
    private javax.swing.JTextField input;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton logintime;
    private javax.swing.JLabel logo;
    private javax.swing.JButton logout;
    private javax.swing.JLabel preview;
    private javax.swing.JButton search;
    private javax.swing.JTable table;
    private javax.swing.JButton upload;
    private javax.swing.JToggleButton usr;
    // End of variables declaration//GEN-END:variables
}
