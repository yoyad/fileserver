
package server;

import interfaces.Interface;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class upload extends javax.swing.JFrame implements Serializable{

    int id;
    int fileid;
    String filename;
    String path;
    String ftype;
    float fsize;
   String cover;
   Connection con;
   frame athis;
   
   String publisher;
    interfaces.Interface ref;
    public upload(frame athis,String publisher) {
        this.athis = athis;
        this.publisher = publisher;
        fileid++;
        
         try{
           ref = (Interface) Naming.lookup("rmi://localhost:1234/fileserver");
            initComponents();
            this.setVisible(rootPaneCheckingEnabled);
            this.setResizable(false);
            this.setBounds(500, 200, 400, 280);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
       
    }

    

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        dir = new javax.swing.JTextField();
        selectfile = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        size = new javax.swing.JTextField();
        upload = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cdir = new javax.swing.JTextField();
        selectcover = new javax.swing.JButton();
        cancle = new javax.swing.JButton();
        progress = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBounds(new java.awt.Rectangle(500, 200, 0, 0));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("SELECTED FILE");

        dir.setEditable(false);
        dir.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        dir.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        dir.setEnabled(false);

        selectfile.setText("BROWSE");
        selectfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectfileActionPerformed(evt);
            }
        });

        jLabel2.setText("FILE NAME");

        name.setEditable(false);
        name.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        name.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        name.setEnabled(false);

        jLabel3.setText("FILE TYPE");

        type.setEditable(false);
        type.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        type.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        type.setEnabled(false);

        jLabel4.setText("FILE SIZE");

        size.setEditable(false);
        size.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        size.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        size.setEnabled(false);

        upload.setText("UPLOAD");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        jLabel5.setText("COVER");

        cdir.setEditable(false);
        cdir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        cdir.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        cdir.setEnabled(false);

        selectcover.setText("BROWSE");
        selectcover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectcoverActionPerformed(evt);
            }
        });

        cancle.setText("CANCLE");
        cancle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cancle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(upload))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dir)
                            .addComponent(name)
                            .addComponent(type)
                            .addComponent(size)
                            .addComponent(cdir, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(selectfile)
                    .addComponent(selectcover))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectfile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cdir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selectcover))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upload)
                    .addComponent(cancle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(progress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void selectfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectfileActionPerformed
         JFileChooser choose = new JFileChooser();
         choose.showOpenDialog(null);
         try{
         path = choose.getSelectedFile().getAbsolutePath();
         dir.setText(path);
         filename = choose.getSelectedFile().getName();
         name.setText(filename);
         String[] ar = filename.split("\\.");
         int index = ar.length - 1;
         ftype = ar[index];
         type.setText(ftype);
          fsize = choose.getSelectedFile().length();
          fsize = ((fsize/1024)/1024);
         size.setText(Float.toString(fsize) + " MB");
         }catch(Exception e){
             System.out.println(e);
         }
    }//GEN-LAST:event_selectfileActionPerformed

    private void selectcoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectcoverActionPerformed
        try{ 
        JFileChooser choose = new JFileChooser();
         choose.setFileFilter(new imagefilter());
         choose.setFileSelectionMode(JFileChooser.FILES_ONLY);
         choose.showOpenDialog(null);
         cover = choose.getSelectedFile().getAbsolutePath();
         cdir.setText(choose.getSelectedFile().getName());
        }catch(Exception e){
        }
    }//GEN-LAST:event_selectcoverActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
             int a = 0;
        try{
            PreparedStatement ps = null;
             if(path == null){
                JOptionPane.showMessageDialog(null, "you should select file first", null ,JOptionPane.WARNING_MESSAGE);
            }else if(cover == null && path != null){  
               JOptionPane.showMessageDialog(null, "you should select file cover", null ,JOptionPane.WARNING_MESSAGE);
             }else if(path != null && cover != null){
                 File file = new File(path);
                 FileInputStream fin = new FileInputStream(file);
                 File file2 = new File(cover);
                 FileInputStream fin2 = new FileInputStream(file2);
                 byte [] b1 = new byte[(int)file.length()];
                 byte [] b2 = new byte[(int)file2.length()];
                 fin.read(b1);
                 fin2.read(b2);
                   a = ref.uploadfile((int)file.length(),filename,publisher,b1,ftype,fsize,b2,(int)file2.length());
                   
            }
           if(a != 0){
               JOptionPane.showMessageDialog(null, "File inserted successfully" , null, JOptionPane.INFORMATION_MESSAGE);
           }else{
               JOptionPane.showMessageDialog(null, "Some Internal Error Happens" , null, JOptionPane.ERROR_MESSAGE);
           }
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_uploadActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        this.dispose();
        athis.enable();
    }//GEN-LAST:event_formWindowClosed

    private void cancleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancleActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancleActionPerformed

   /*
   public static void main(String args[]) {
       /* 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
    /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(upload.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new upload("admin");
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancle;
    private javax.swing.JTextField cdir;
    private javax.swing.JTextField dir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JProgressBar progress;
    private javax.swing.JButton selectcover;
    private javax.swing.JButton selectfile;
    private javax.swing.JTextField size;
    private javax.swing.JTextField type;
    private javax.swing.JButton upload;
    // End of variables declaration//GEN-END:variables
}
