package server;

import java.awt.Image;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import implementation.*;
import interfaces.Interface;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import javax.swing.JLabel;
public class frame extends javax.swing.JFrame {

    Connection con;
    int userid;
    String username;
    interfaces.Interface ref;
   List<files> list = new ArrayList<>();
   static String currentTab = "allFiles";
   String operationid = "";
    public frame(List<admins> listd, int userid) throws RemoteException, NotBoundException, MalformedURLException {
        ref = (Interface) Naming.lookup("rmi://localhost:1234/fileserver");
         ImageIcon back = new ImageIcon("C:\\Users\\shadow\\Downloads\\Black.jpg");
        Image newimg = back.getImage();
        back = new ImageIcon(newimg);
        setContentPane(new JLabel(back));
        initComponents();
        setlogintime();
        setServerTime();
        userid+=1;
        setuserinfo(listd,userid);
         list = ref.populatetable(currentTab);
            populatetable(list);
    }

//////////////////this method will set the login time//////////////////////////////////
    public void setlogintime() {

        String m, s, h;
        java.util.Date d = new java.util.Date();
        h = Integer.toString(d.getHours());
        m = Integer.toString(d.getMinutes());
        s = Integer.toString(d.getSeconds());
        if (Integer.parseInt(h) < 10) {
            String temp = h;
            h = "0";
            h += temp;
        }
        if (Integer.parseInt(m) < 10) {
            String temp = m;
            m = "0";
            m += temp;
        }
        if (Integer.parseInt(s) < 10) {
            String temp = s;
            s = "0";
            s += temp;
        }
        loginTime.setText(h + ":" + m + ":" + s);
    }
///////////////////////////end of setlogintime method//////////////////////////////////    

///////////////////this method will set the server time/////////////////////////////////
    public void setServerTime() {

        Thread t = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    String m, s, h;
                    java.util.Date d = new java.util.Date();
                    h = Integer.toString(d.getHours());
                    m = Integer.toString(d.getMinutes());
                    s = Integer.toString(d.getSeconds());
                    if (Integer.parseInt(h) < 10) {
                        String temp = h;
                        h = "0";
                        h += temp;
                    }
                    if (Integer.parseInt(m) < 10) {
                        String temp = m;
                        m = "0";
                        m += temp;
                    }
                    if (Integer.parseInt(s) < 10) {
                        String temp = s;
                        s = "0";
                        s += temp;
                    }
                    serverTime.setText(h + ":" + m + ":" + s);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        serverTime.setText("00:00:00");
                    }
                }
            }
        });
        t.start();
    }
///////////////////end of setservertime methode////////////////////////////////////////

////////////this method will set the user info///////////////////////////////////////////    
    public void setuserinfo(List<admins> li , int id){
        try{
            
            username= li.get(id-1).getFirstname();
            ImageIcon photo = li.get(id-1).getPhoto();
            Image img = photo.getImage();
            Image newimg = img.getScaledInstance(98, 99, java.awt.Image.SCALE_SMOOTH);
            photo = new ImageIcon(newimg);
            userPhoto.setText("");
            userPhoto.setIcon(photo);
            userName.setText(username);
        }catch(Exception e){
            
        }
    }
////////////////end of method setuserinfo///////////////////////////////////////////////    
        
/////////this method will fill in all the tables selected with the corspoding table type from the database/////////////////////////
   public void populatetable(List<files> file){
        try{
            list = file;
                   switch(currentTab){
                        case "allFiles":
                           tablemodel allfilesmodel = new tablemodel(list);
                           allTable.setModel(allfilesmodel);
                           break;
                        case "documentsTab":
                           tablemodel documentmodel = new tablemodel(list);
                           documentTable.setModel(documentmodel);
                           break;
                        case "videoTab":
                           tablemodel videomodel = new tablemodel(list);
                           videoTable.setModel(videomodel);
                           break;
                        case "compressedTab":
                           tablemodel compressedmodel = new tablemodel(list);
                           compressedTable.setModel(compressedmodel);
                           break;
                        case "executableTab":
                           tablemodel exemodel = new tablemodel(list);
                           execuTable.setModel(exemodel);
                           break;
                        case "othersTab":
                           tablemodel othersmodel = new tablemodel(list);
                           othersTable.setModel(othersmodel);
                           break;
                        default:
                           tablemodel defaultmodel = new tablemodel(list);
                           allTable.setModel(defaultmodel);
                           break;
                           
                   }
        }catch(Exception e){
                e.printStackTrace();
                }
    }
/////////////////////////end of method populateTables/////////////////////////////////////////////////    


 public void setphoto(String fileId,int width, int height) {
            ImageIcon photo = null;
            String tempid = fileId;
        try {
            for(files temp : list){
                if(temp.getFileId() == tempid){
                    photo = temp.getPhoto();
                    Image img = photo.getImage();
                    Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
                    photo = new ImageIcon(newimg);
                    filePhoto.setText("");
                    filePhoto.setIcon(photo);
                }
            }
            
        } catch (Exception e) {
            System.out.println("error happend in getcover methode \n");
           
        }

    }
 
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        loginTime = new javax.swing.JTextField();
        serverTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        searchInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        tab = new javax.swing.JTabbedPane();
        allFiles = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        allTable = new javax.swing.JTable();
        documents = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        documentTable = new javax.swing.JTable();
        videos = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        videoTable = new javax.swing.JTable();
        compressed = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        compressedTable = new javax.swing.JTable();
        executables = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        execuTable = new javax.swing.JTable();
        others = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        othersTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        setId = new javax.swing.JTextField();
        setFile_name = new javax.swing.JTextField();
        setFile_type = new javax.swing.JTextField();
        setFile_size = new javax.swing.JTextField();
        setPublisher = new javax.swing.JTextField();
        filePhoto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        userPhoto = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        onlineClients = new javax.swing.JTextField();
        offlineClients = new javax.swing.JTextField();
        clientManager = new javax.swing.JButton();
        uploadFile = new javax.swing.JButton();
        deleteFile = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        chandeUserName = new javax.swing.JButton();
        chaneUserPassword = new javax.swing.JButton();
        changeUserPhoto = new javax.swing.JButton();
        userAccountSetting = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        addNewUser = new javax.swing.JButton();
        deleteUser = new javax.swing.JButton();
        userControlPanel = new javax.swing.JButton();
        sign_out = new javax.swing.JButton();
        refreshTable = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 153));

        loginTime.setEditable(false);
        loginTime.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        loginTime.setEnabled(false);

        serverTime.setEditable(false);
        serverTime.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        serverTime.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel3.setText("LOGIN_TIME:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel4.setText("SERVER_TIME:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(serverTime, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(loginTime))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(serverTime)
                    .addComponent(jLabel4))
                .addGap(1, 1, 1))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));

        searchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInputActionPerformed(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Broadway", 1, 10)); // NOI18N
        searchButton.setForeground(new java.awt.Color(0, 0, 255));
        searchButton.setText("SEARCH");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(searchInput)
            .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tab.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 10)); // NOI18N
        tab.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabComponentShown(evt);
            }
        });

        allFiles.setBackground(new java.awt.Color(204, 255, 204));
        allFiles.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                allFilesComponentShown(evt);
            }
        });

        allTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        allTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(allTable);

        javax.swing.GroupLayout allFilesLayout = new javax.swing.GroupLayout(allFiles);
        allFiles.setLayout(allFilesLayout);
        allFilesLayout.setHorizontalGroup(
            allFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        allFilesLayout.setVerticalGroup(
            allFilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        tab.addTab("ALL_FILES", allFiles);

        documents.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                documentsComponentShown(evt);
            }
        });

        documentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        documentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(documentTable);

        javax.swing.GroupLayout documentsLayout = new javax.swing.GroupLayout(documents);
        documents.setLayout(documentsLayout);
        documentsLayout.setHorizontalGroup(
            documentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        documentsLayout.setVerticalGroup(
            documentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        tab.addTab("DOCUMENTS", documents);

        videos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                videosComponentShown(evt);
            }
        });

        videoTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        videoTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videoTableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(videoTable);

        javax.swing.GroupLayout videosLayout = new javax.swing.GroupLayout(videos);
        videos.setLayout(videosLayout);
        videosLayout.setHorizontalGroup(
            videosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        videosLayout.setVerticalGroup(
            videosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        tab.addTab("MEDIAS", videos);

        compressed.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                compressedComponentShown(evt);
            }
        });

        compressedTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        compressedTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compressedTableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(compressedTable);

        javax.swing.GroupLayout compressedLayout = new javax.swing.GroupLayout(compressed);
        compressed.setLayout(compressedLayout);
        compressedLayout.setHorizontalGroup(
            compressedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        compressedLayout.setVerticalGroup(
            compressedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        tab.addTab("COMPRESSED", compressed);

        executables.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                executablesComponentShown(evt);
            }
        });

        execuTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        execuTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                execuTableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(execuTable);

        javax.swing.GroupLayout executablesLayout = new javax.swing.GroupLayout(executables);
        executables.setLayout(executablesLayout);
        executablesLayout.setHorizontalGroup(
            executablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        executablesLayout.setVerticalGroup(
            executablesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        tab.addTab("EXCUTABLES", executables);

        others.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                othersComponentShown(evt);
            }
        });

        othersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                othersTableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(othersTable);

        javax.swing.GroupLayout othersLayout = new javax.swing.GroupLayout(others);
        others.setLayout(othersLayout);
        othersLayout.setHorizontalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        othersLayout.setVerticalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 595, Short.MAX_VALUE)
        );

        tab.addTab("OTHERS", others);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));

        setId.setEditable(false);
        setId.setText("ID:");
        setId.setEnabled(false);
        setId.setPreferredSize(new java.awt.Dimension(102, 22));

        setFile_name.setEditable(false);
        setFile_name.setText("NAME:");
        setFile_name.setEnabled(false);
        setFile_name.setPreferredSize(new java.awt.Dimension(102, 22));

        setFile_type.setEditable(false);
        setFile_type.setText("TYPE:");
        setFile_type.setEnabled(false);
        setFile_type.setPreferredSize(new java.awt.Dimension(102, 22));

        setFile_size.setEditable(false);
        setFile_size.setText("SIZE:");
        setFile_size.setEnabled(false);
        setFile_size.setPreferredSize(new java.awt.Dimension(102, 22));

        setPublisher.setEditable(false);
        setPublisher.setText("PUB:");
        setPublisher.setEnabled(false);
        setPublisher.setPreferredSize(new java.awt.Dimension(102, 22));

        filePhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        filePhoto.setText("NO PREVIEW");
        filePhoto.setPreferredSize(new java.awt.Dimension(102, 100));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(setId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(setFile_name, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(setFile_type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(setFile_size, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(setPublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(filePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(setId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setFile_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setFile_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setFile_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filePhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        userPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userPhoto.setText("NO PREVIEW");
        userPhoto.setPreferredSize(new java.awt.Dimension(98, 99));

        userName.setEditable(false);
        userName.setText("USER:");
        userName.setEnabled(false);

        onlineClients.setEditable(false);
        onlineClients.setText("ONLINE:");
        onlineClients.setEnabled(false);

        offlineClients.setEditable(false);
        offlineClients.setText("OFFLINE:");
        offlineClients.setEnabled(false);

        clientManager.setFont(new java.awt.Font("Tahoma", 1, 7)); // NOI18N
        clientManager.setText("ACTION CENTER");
        clientManager.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientManagerActionPerformed(evt);
            }
        });

        uploadFile.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        uploadFile.setText("UPLOAD_FILE");
        uploadFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadFileActionPerformed(evt);
            }
        });

        deleteFile.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        deleteFile.setText("DELETE_FILE");
        deleteFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(userName)
            .addComponent(onlineClients)
            .addComponent(offlineClients)
            .addComponent(clientManager, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(uploadFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteFile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(userPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(onlineClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(offlineClients, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clientManager)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(uploadFile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteFile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 9)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ACCOUNT CONTROL");

        chandeUserName.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        chandeUserName.setText("EDIT USER_NAME");
        chandeUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chandeUserNameActionPerformed(evt);
            }
        });

        chaneUserPassword.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        chaneUserPassword.setText("EDIT PASSWORD");
        chaneUserPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chaneUserPasswordActionPerformed(evt);
            }
        });

        changeUserPhoto.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        changeUserPhoto.setText("CHANGE PHOTO");
        changeUserPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeUserPhotoActionPerformed(evt);
            }
        });

        userAccountSetting.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        userAccountSetting.setText("ACCOUNT SETTING");
        userAccountSetting.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userAccountSettingActionPerformed(evt);
            }
        });

        jPanel13.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SUPER ADMIN ONLY");

        addNewUser.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        addNewUser.setText("ADD NEW USER");
        addNewUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewUserActionPerformed(evt);
            }
        });

        deleteUser.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        deleteUser.setText("DELETE USER");
        deleteUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserActionPerformed(evt);
            }
        });

        userControlPanel.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        userControlPanel.setText("CONTROL PANEL");
        userControlPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userControlPanelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(addNewUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(deleteUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(userControlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addNewUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteUser)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(userControlPanel))
        );

        sign_out.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        sign_out.setText("SIGN OUT");
        sign_out.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_outActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chandeUserName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(chaneUserPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(changeUserPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(userAccountSetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sign_out, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chandeUserName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chaneUserPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(changeUserPhoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userAccountSetting)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(sign_out))
        );

        refreshTable.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        refreshTable.setForeground(new java.awt.Color(0, 153, 0));
        refreshTable.setText("REFRESH");
        refreshTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshTableActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("view");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refreshTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tab)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(refreshTable, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabComponentShown

    }//GEN-LAST:event_tabComponentShown

    private void allFilesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_allFilesComponentShown
         try {
            currentTab = "allFiles";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
           // System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }//GEN-LAST:event_allFilesComponentShown

    private void documentsComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_documentsComponentShown
       try {
            currentTab = "documentsTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_documentsComponentShown

    private void videosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_videosComponentShown
         try {
            currentTab = "videoTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_videosComponentShown

    private void compressedComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_compressedComponentShown
        try {
            currentTab = "compressedTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_compressedComponentShown

    private void executablesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_executablesComponentShown
          try {
            currentTab = "executableTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_executablesComponentShown

    private void othersComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_othersComponentShown
          try {
            currentTab = "othersTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_othersComponentShown

    private void searchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchInputActionPerformed
        try {
            String input = searchInput.getText();
            list = ref.searchfiles(input);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_searchInputActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
     try {
            String input = searchInput.getText();
            list = ref.searchfiles(input);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void chandeUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chandeUserNameActionPerformed
            String newusername = JOptionPane.showInputDialog(null,"enter new first name");
            try{
                String query = "update ";
            }catch(Exception e){
                
            }
    }//GEN-LAST:event_chandeUserNameActionPerformed

    private void chaneUserPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chaneUserPasswordActionPerformed

    }//GEN-LAST:event_chaneUserPasswordActionPerformed

    private void changeUserPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeUserPhotoActionPerformed

    }//GEN-LAST:event_changeUserPhotoActionPerformed

    private void userAccountSettingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userAccountSettingActionPerformed

    }//GEN-LAST:event_userAccountSettingActionPerformed

    private void addNewUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewUserActionPerformed

    }//GEN-LAST:event_addNewUserActionPerformed

    private void deleteUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserActionPerformed
                    
    }//GEN-LAST:event_deleteUserActionPerformed

    private void userControlPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userControlPanelActionPerformed

    }//GEN-LAST:event_userControlPanelActionPerformed

    private void sign_outActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_outActionPerformed
                this.dispose();
                new login().setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_sign_outActionPerformed

    private void clientManagerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientManagerActionPerformed

    }//GEN-LAST:event_clientManagerActionPerformed

    private void uploadFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadFileActionPerformed
                this.disable();
                new upload(this,username).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_uploadFileActionPerformed

    private void deleteFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFileActionPerformed
        int i = 0;  
        try{
                if(operationid.equals("")){
                    JOptionPane.showMessageDialog(this, "YOU SHOULD SELECT FILE FIRST", null, JOptionPane.WARNING_MESSAGE);
                }else{
                    int b = JOptionPane.YES_NO_OPTION;
                    JOptionPane.showConfirmDialog(this, "ARE YOU SURE YOU WANT TO DELETE FILE","WARNING", b);
                    if(b == JOptionPane.NO_OPTION){
                        JOptionPane.showMessageDialog(this, "FILE DELETION ABORTED",null,JOptionPane.INFORMATION_MESSAGE);
                    }else if(b == JOptionPane.YES_OPTION){
                        ref.deletfile(operationid);
                        JOptionPane.showMessageDialog(this, "FILE DELETED SUCCESSFULLY", null, JOptionPane.INFORMATION_MESSAGE);                    }
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(this, "error happens", null, JOptionPane.ERROR_MESSAGE);
            }
    }//GEN-LAST:event_deleteFileActionPerformed

    private void allTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allTableMouseClicked
      int i = allTable.getSelectedRow();
            String fileid = allTable.getValueAt(i, 0).toString();
            operationid = fileid;
            setId.setText(fileid);
            String filename = allTable.getValueAt(i, 1).toString();
            setFile_name.setText( filename);
            String publisher = allTable.getValueAt(i, 2).toString();
            setPublisher.setText(publisher);
            String filetype = allTable.getValueAt(i, 3).toString();
            setFile_type.setText(filetype);
            String filesize = allTable.getValueAt(i, 4).toString();
            setFile_size.setText(filesize);
            setphoto(fileid,(int)filePhoto.getWidth(),(int)filePhoto.getHeight());
    }//GEN-LAST:event_allTableMouseClicked

    private void documentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentTableMouseClicked
         int i = documentTable.getSelectedRow();
            String fileid = documentTable.getValueAt(i, 0).toString();
            operationid = fileid;
            setId.setText(fileid);
            String filename = documentTable.getValueAt(i, 1).toString();
            setFile_name.setText(filename);
            String publisher = documentTable.getValueAt(i, 2).toString();
            setPublisher.setText( publisher);
            String filetype = documentTable.getValueAt(i, 3).toString();
            setFile_type.setText(filetype);
            String filesize = documentTable.getValueAt(i, 4).toString();
            setFile_size.setText(filesize);
           setphoto(fileid,(int)filePhoto.getWidth(),(int)filePhoto.getHeight());
    }//GEN-LAST:event_documentTableMouseClicked

    private void videoTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videoTableMouseClicked
        int i = videoTable.getSelectedRow();
            String fileid = videoTable.getValueAt(i, 0).toString();
            operationid = fileid;
            setId.setText(fileid);
            String filename = videoTable.getValueAt(i, 1).toString();
            setFile_name.setText(filename);
            String publisher = videoTable.getValueAt(i, 2).toString();
            setPublisher.setText(publisher);
            String filetype = videoTable.getValueAt(i, 3).toString();
            setFile_type.setText(filetype);
            String filesize = videoTable.getValueAt(i, 4).toString();
            setFile_size.setText(filesize);
            setphoto(fileid,(int)filePhoto.getWidth(),(int)filePhoto.getHeight());
    }//GEN-LAST:event_videoTableMouseClicked

    private void compressedTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compressedTableMouseClicked
      int i = compressedTable.getSelectedRow();
            String fileid = compressedTable.getValueAt(i, 0).toString();
            operationid = fileid;
            setId.setText(fileid);
            String filename = compressedTable.getValueAt(i, 1).toString();
            setFile_name.setText(filename);
            String publisher = compressedTable.getValueAt(i, 2).toString();
            setPublisher.setText(publisher);
            String filetype = compressedTable.getValueAt(i, 3).toString();
            setFile_type.setText(filetype);
            String filesize = compressedTable.getValueAt(i, 4).toString();
            setFile_size.setText(filesize);
          setphoto(fileid,(int)filePhoto.getWidth(),(int)filePhoto.getHeight());
    }//GEN-LAST:event_compressedTableMouseClicked

    private void execuTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_execuTableMouseClicked
        int i = execuTable.getSelectedRow();
            String fileid = execuTable.getValueAt(i, 0).toString();
            operationid = fileid;
            setId.setText(fileid);
            String filename = execuTable.getValueAt(i, 1).toString();
            setFile_name.setText(filename);
            String publisher = execuTable.getValueAt(i, 2).toString();
            setPublisher.setText(publisher);
            String filetype = execuTable.getValueAt(i, 3).toString();
            setFile_type.setText(filetype);
            String filesize = execuTable.getValueAt(i, 4).toString();
            setFile_size.setText(filesize);
           setphoto(fileid,(int)filePhoto.getWidth(),(int)filePhoto.getHeight());
    }//GEN-LAST:event_execuTableMouseClicked

    private void othersTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othersTableMouseClicked
         int i = othersTable.getSelectedRow();
            String fileid = othersTable.getValueAt(i, 0).toString();
            operationid = fileid;
            setId.setText(fileid);
            String filename = othersTable.getValueAt(i, 1).toString();
            setFile_name.setText(filename);
            String publisher = othersTable.getValueAt(i, 2).toString();
            setPublisher.setText(publisher);
            String filetype = othersTable.getValueAt(i, 3).toString();
            setFile_type.setText(filetype);
            String filesize = othersTable.getValueAt(i, 4).toString();
            setFile_size.setText(filesize);
           setphoto(fileid,(int)filePhoto.getWidth(),(int)filePhoto.getHeight());
    }//GEN-LAST:event_othersTableMouseClicked

    private void refreshTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshTableActionPerformed
              try {
            list = ref.populatetable(currentTab);
            populatetable(list);
            setId.setText("");
            setFile_name.setText("");
            setFile_size.setText("");
            setFile_type.setText("");
            setPublisher.setText("");
            searchInput.setText("");
            filePhoto.setIcon(null);
            filePhoto.setText("NO PREVIEW");
            operationid = null;
        } catch (RemoteException ex) {
                  System.out.println("error in refresh" + ex);
        }
    }//GEN-LAST:event_refreshTableActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewUser;
    private javax.swing.JPanel allFiles;
    private javax.swing.JTable allTable;
    private javax.swing.JButton chandeUserName;
    private javax.swing.JButton chaneUserPassword;
    private javax.swing.JButton changeUserPhoto;
    private javax.swing.JButton clientManager;
    private javax.swing.JPanel compressed;
    private javax.swing.JTable compressedTable;
    private javax.swing.JButton deleteFile;
    private javax.swing.JButton deleteUser;
    private javax.swing.JTable documentTable;
    private javax.swing.JPanel documents;
    private javax.swing.JTable execuTable;
    private javax.swing.JPanel executables;
    private javax.swing.JLabel filePhoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTextField loginTime;
    private javax.swing.JTextField offlineClients;
    private javax.swing.JTextField onlineClients;
    private javax.swing.JPanel others;
    private javax.swing.JTable othersTable;
    private javax.swing.JButton refreshTable;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchInput;
    private javax.swing.JTextField serverTime;
    private javax.swing.JTextField setFile_name;
    private javax.swing.JTextField setFile_size;
    private javax.swing.JTextField setFile_type;
    private javax.swing.JTextField setId;
    private javax.swing.JTextField setPublisher;
    private javax.swing.JButton sign_out;
    private javax.swing.JTabbedPane tab;
    private javax.swing.JButton uploadFile;
    private javax.swing.JButton userAccountSetting;
    private javax.swing.JButton userControlPanel;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel userPhoto;
    private javax.swing.JTable videoTable;
    private javax.swing.JPanel videos;
    // End of variables declaration//GEN-END:variables
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
