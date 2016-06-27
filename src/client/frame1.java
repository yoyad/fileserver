package client;

import implementation.files;
import interfaces.Interface;
import java.awt.Color;
import java.awt.Image;
import java.io.File;                           
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frame1 extends javax.swing.JFrame implements Serializable {

    interfaces.Interface ref;
    List<files> list = new ArrayList<>();
    static String currentTab = "allFiles";
    String operationid = "";
    
    public frame1() {
        ImageIcon back = new ImageIcon("C:\\Users\\shadow\\Downloads\\bl.jpg");
        Image newimg = back.getImage();//.getScaledInstance(1228, 900, java.awt.Image.SCALE_SMOOTH);
        back = new ImageIcon(newimg);
        setContentPane(new JLabel(back));
        initComponents();
        try {
            ref = (Interface) Naming.lookup("rmi://localhost:1234/fileserver");
            list = ref.populatetable(currentTab);
            populatetable(list);
            logo();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        inputsearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        usernameinput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        login = new javax.swing.JButton();
        signup = new javax.swing.JButton();
        passwordinput = new javax.swing.JPasswordField();
        jPanel10 = new javax.swing.JPanel();
        setfilename = new javax.swing.JTextField();
        setfiletype = new javax.swing.JTextField();
        setfilesize = new javax.swing.JTextField();
        setfilephoto = new javax.swing.JLabel();
        download = new javax.swing.JButton();
        setfileid = new javax.swing.JTextField();
        setpublisher = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tabbedpanel = new javax.swing.JTabbedPane();
        allfiles = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        alltables = new javax.swing.JTable();
        documents = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        documentstable = new javax.swing.JTable();
        videos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        videostable = new javax.swing.JTable();
        compressed = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        compressedtable = new javax.swing.JTable();
        executales = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        exetable = new javax.swing.JTable();
        others = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        otherstable = new javax.swing.JTable();
        header = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1228, 900));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 0)), "SEARCH", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        inputsearch.setBackground(new java.awt.Color(204, 204, 204));
        inputsearch.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        inputsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputsearchActionPerformed(evt);
            }
        });

        search.setBackground(new java.awt.Color(255, 255, 153));
        search.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        search.setText("SEARCH");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        refresh.setBackground(new java.awt.Color(0, 153, 255));
        refresh.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(inputsearch, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(search, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
            .addComponent(refresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(inputsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(search)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(refresh))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 0)), "LOGIN FORM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel1.setText("USER_NAME:");

        usernameinput.setBackground(new java.awt.Color(204, 204, 204));
        usernameinput.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jLabel2.setText("PASSWORD:");

        login.setBackground(new java.awt.Color(0, 204, 51));
        login.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        login.setText("LOG_IN");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        signup.setBackground(new java.awt.Color(0, 153, 255));
        signup.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        signup.setText("SIGN_UP");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        passwordinput.setBackground(new java.awt.Color(204, 204, 204));
        passwordinput.setFont(new java.awt.Font("Comic Sans MS", 1, 11)); // NOI18N
        passwordinput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordinputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameinput)
                            .addComponent(passwordinput)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(signup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(login)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(usernameinput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(passwordinput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login)
                    .addComponent(signup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 0)), "FILE_INFO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        setfilename.setEditable(false);
        setfilename.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfilename.setText("FILE_NAME");
        setfilename.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfilename.setEnabled(false);
        setfilename.setPreferredSize(new java.awt.Dimension(229, 22));

        setfiletype.setEditable(false);
        setfiletype.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfiletype.setText("FILE_TYPE");
        setfiletype.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfiletype.setEnabled(false);
        setfiletype.setMinimumSize(new java.awt.Dimension(6, 21));
        setfiletype.setPreferredSize(new java.awt.Dimension(229, 22));

        setfilesize.setEditable(false);
        setfilesize.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfilesize.setText("FILE_SIZE");
        setfilesize.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfilesize.setEnabled(false);
        setfilesize.setPreferredSize(new java.awt.Dimension(229, 22));

        setfilephoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setfilephoto.setText("NO PREVIEW");

        download.setBackground(new java.awt.Color(0, 204, 51));
        download.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        download.setText("DOWNLOAD");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });

        setfileid.setEditable(false);
        setfileid.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfileid.setText("FILE_ID");
        setfileid.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfileid.setEnabled(false);
        setfileid.setPreferredSize(new java.awt.Dimension(229, 19));
        setfileid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setfileidActionPerformed(evt);
            }
        });

        setpublisher.setEditable(false);
        setpublisher.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setpublisher.setText("PUBLISHER");
        setpublisher.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setpublisher.setEnabled(false);
        setpublisher.setPreferredSize(new java.awt.Dimension(229, 22));

        jButton1.setBackground(new java.awt.Color(0, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jButton1.setText("PREVIEW");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setfilephoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(setfilesize, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setfiletype, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setpublisher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setfilename, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setfileid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(download)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(28, 28, 28))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(setfileid, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfiletype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfilesize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfilephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(download)
                    .addComponent(jButton1)))
        );

        tabbedpanel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabbedpanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabbedpanelComponentShown(evt);
            }
        });

        allfiles.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                allfilesComponentShown(evt);
            }
        });

        alltables.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                alltablesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(alltables);

        javax.swing.GroupLayout allfilesLayout = new javax.swing.GroupLayout(allfiles);
        allfiles.setLayout(allfilesLayout);
        allfilesLayout.setHorizontalGroup(
            allfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        allfilesLayout.setVerticalGroup(
            allfilesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        tabbedpanel.addTab("ALL FILES", allfiles);

        documents.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                documentsComponentShown(evt);
            }
        });

        documentstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentstableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(documentstable);

        javax.swing.GroupLayout documentsLayout = new javax.swing.GroupLayout(documents);
        documents.setLayout(documentsLayout);
        documentsLayout.setHorizontalGroup(
            documentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        documentsLayout.setVerticalGroup(
            documentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        tabbedpanel.addTab("DOCUMENTS", documents);

        videos.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                videosComponentShown(evt);
            }
        });

        videostable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videostableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(videostable);

        javax.swing.GroupLayout videosLayout = new javax.swing.GroupLayout(videos);
        videos.setLayout(videosLayout);
        videosLayout.setHorizontalGroup(
            videosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        videosLayout.setVerticalGroup(
            videosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        tabbedpanel.addTab("MEDIA FILES", videos);

        compressed.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                compressedComponentShown(evt);
            }
        });

        compressedtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compressedtableMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(compressedtable);

        javax.swing.GroupLayout compressedLayout = new javax.swing.GroupLayout(compressed);
        compressed.setLayout(compressedLayout);
        compressedLayout.setHorizontalGroup(
            compressedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        compressedLayout.setVerticalGroup(
            compressedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        tabbedpanel.addTab("COMPRESSED", compressed);

        executales.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                executalesComponentShown(evt);
            }
        });

        exetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exetableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(exetable);

        javax.swing.GroupLayout executalesLayout = new javax.swing.GroupLayout(executales);
        executales.setLayout(executalesLayout);
        executalesLayout.setHorizontalGroup(
            executalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        executalesLayout.setVerticalGroup(
            executalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        tabbedpanel.addTab("EXECUTABLES", executales);

        others.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                othersComponentShown(evt);
            }
        });

        otherstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otherstableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(otherstable);

        javax.swing.GroupLayout othersLayout = new javax.swing.GroupLayout(others);
        others.setLayout(othersLayout);
        othersLayout.setHorizontalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
        );
        othersLayout.setVerticalGroup(
            othersLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 783, Short.MAX_VALUE)
        );

        tabbedpanel.addTab("OTHERS", others);

        header.setFont(new java.awt.Font("Traditional Arabic", 1, 14)); // NOI18N
        header.setForeground(new java.awt.Color(0, 204, 0));
        header.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("DISTRIBUTED FILE SERVER");

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
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedpanel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(header)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(tabbedpanel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(header)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputsearchActionPerformed
        try {
            String input = inputsearch.getText();
            list = ref.searchfiles(input);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_inputsearchActionPerformed

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        try {
            String input = inputsearch.getText();
            list = ref.searchfiles(input);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_searchActionPerformed

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
         if (!operationid.equals("")) {
            OutputStream dest = null;
            String name = setfilename.getText();
            byte b[];
            int len;
            try {
                JFileChooser choose = new JFileChooser();
                choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                choose.showSaveDialog(null);
                File file = choose.getSelectedFile();
                String tempfile = file.getCanonicalPath() + "\\" + name;
                System.out.println(tempfile);
                file = new File(tempfile);
               // File file = new File("C:\\Users\\shadow\\Pictures\\" + name);
                dest = new FileOutputStream(file);
                System.out.println("this is test");
                b = ref.downloadfile(operationid);
                System.out.println(b);
                do {
                    len = b.length;
                    dest.write(b);
                } while (len == -1);
                JOptionPane.showMessageDialog(this, "FILE DOWNLOAD COMPLETE\n FILE SAVED TO "+ file.getAbsolutePath(),null,JOptionPane.INFORMATION_MESSAGE);
            } catch (FileNotFoundException ex) {
                System.out.println("file not found " + ex);
            } catch (RemoteException ex) {
                System.out.println("remote exception " + ex);
            } catch (IOException ex) {
                System.out.println("io exception " + ex);
            } finally {
                try {
                    dest.close();
                } catch (IOException ex) {
                    System.out.println("error while closing file" + ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "You Should Select a File", null, JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_downloadActionPerformed

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        String user = usernameinput.getText();
        String pass = passwordinput.getText();
        if (user.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "You should Enter Username or Password", null, JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                boolean r = ref.confirmclient(user, pass);
                if (r) {
                    this.dispose();
                    frame2 f2 = new frame2(this, user);
                    f2.setVisible(r);
                } else {
                    JOptionPane.showMessageDialog(null, "Verification faild or You Are Not registered", null, JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_loginActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        try {
            list = ref.populatetable(currentTab);
            populatetable(list);
            setfileid.setText("");
            setfilename.setText("");
            setfilesize.setText("");
            setfiletype.setText("");
            setpublisher.setText("");
            inputsearch.setText("");
            setfilephoto.setIcon(null);
            setfilephoto.setText("NO PREVIEW");
            operationid = null;
        } catch (RemoteException ex) {
            Logger.getLogger(frame1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_refreshActionPerformed

    private void allfilesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_allfilesComponentShown
        try {
            currentTab = "allFiles";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_allfilesComponentShown

    private void documentsComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_documentsComponentShown
        try {
            currentTab = "documentsTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_documentsComponentShown

    private void tabbedpanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabbedpanelComponentShown

    }//GEN-LAST:event_tabbedpanelComponentShown
//count id filename publisher file type size cover
    private void compressedComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_compressedComponentShown
        try {
            currentTab = "compressedTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_compressedComponentShown

    private void executalesComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_executalesComponentShown
        try {
            currentTab = "executableTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_executalesComponentShown

    private void othersComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_othersComponentShown
        try {
            currentTab = "othersTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_othersComponentShown

    private void alltablesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_alltablesMouseClicked
        int i = alltables.getSelectedRow();
        String fileid = alltables.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = alltables.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = alltables.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = alltables.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = alltables.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_alltablesMouseClicked

    private void documentstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentstableMouseClicked
        int i = documentstable.getSelectedRow();
        String fileid = documentstable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = documentstable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = documentstable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = documentstable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = documentstable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_documentstableMouseClicked

    private void videostableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videostableMouseClicked
        int i = videostable.getSelectedRow();
        String fileid = videostable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = videostable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = videostable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = videostable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = videostable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_videostableMouseClicked

    private void compressedtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_compressedtableMouseClicked
        int i = compressedtable.getSelectedRow();
        String fileid = compressedtable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = compressedtable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = compressedtable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = compressedtable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = compressedtable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_compressedtableMouseClicked

    private void exetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exetableMouseClicked
        int i = exetable.getSelectedRow();
        String fileid = exetable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = exetable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = exetable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = exetable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = exetable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_exetableMouseClicked

    private void otherstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_otherstableMouseClicked
        int i = otherstable.getSelectedRow();
        String fileid = otherstable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = otherstable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = otherstable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = otherstable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = otherstable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_otherstableMouseClicked

    private void videosComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_videosComponentShown
        try {
            currentTab = "videoTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_videosComponentShown

    private void setfileidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setfileidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setfileidActionPerformed

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        this.disable();
        signup s = new signup(this);
        s.setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_signupActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        usernameinput.setText("");
        passwordinput.setText("");
    }//GEN-LAST:event_formWindowActivated

    private void passwordinputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordinputActionPerformed
          String user = usernameinput.getText();
        String pass = passwordinput.getText();
        if (user.equals("") || pass.equals("")) {
            JOptionPane.showMessageDialog(null, "You should Enter Username or Password", null, JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                boolean r = ref.confirmclient(user, pass);
                if (r) {
                    this.dispose();
                    frame2 f2 = new frame2(this, user);
                    f2.setVisible(r);
                } else {
                    JOptionPane.showMessageDialog(null, "Verification faild or You Are Not registered", null, JOptionPane.ERROR_MESSAGE);
                }
            } catch (RemoteException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_passwordinputActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
//        ImageIcon back = new ImageIcon("C:\\Users\\shadow\\Downloads\\Black.jpg");
//        Image newimg = back.getImage().getScaledInstance(this.getWidth(), this.getHeight(), java.awt.Image.SCALE_SMOOTH);
//        back = new ImageIcon(newimg);
        //setContentPane(new JLabel(back));        
    }//GEN-LAST:event_formComponentResized

    public void populatetable(List<files> file) {
        try {
            list = file;
            switch (currentTab) {
                case "allFiles":
                    tablemodel allfilesmodel = new tablemodel(list);
                    alltables.setModel(allfilesmodel);
                    break;
                case "documentsTab":
                    tablemodel documentmodel = new tablemodel(list);
                    documentstable.setModel(documentmodel);
                    break;
                case "videoTab":
                    tablemodel videomodel = new tablemodel(list);
                    videostable.setModel(videomodel);
                    break;
                case "compressedTab":
                    tablemodel compressedmodel = new tablemodel(list);
                    compressedtable.setModel(compressedmodel);
                    break;
                case "executableTab":
                    tablemodel exemodel = new tablemodel(list);
                    exetable.setModel(exemodel);
                    break;
                case "othersTab":
                    tablemodel othersmodel = new tablemodel(list);
                    otherstable.setModel(othersmodel);
                    break;
                default:
                    tablemodel defaultmodel = new tablemodel(list);
                    alltables.setModel(defaultmodel);
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setphoto(String fileId, int width, int height) {
        ImageIcon photo = null;
        String tempid = fileId;
        try {
            for (files temp : list) {
                if (temp.getFileId() == tempid) {
                    photo = temp.getPhoto();
                    Image img = photo.getImage();
                    Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
                    photo = new ImageIcon(newimg);
                    setfilephoto.setText("");
                    setfilephoto.setIcon(photo);
                }
            }

        } catch (Exception e) {
            System.out.println("error happend in getcover methode \n");

        }

    }

    public void logo(){
        String text = "WELCOME TO THE DISTRIBUTED FILE SERVER. DOWNLOAD FILES. GET REGISTERED UPLOAD FILES, CHAT WITH FRIENDS. GO PRO NOW";
        header.setForeground(Color.blue);
        Thread t = new Thread(new Runnable(){
           
            String temp = "";
            public void run(){
                int a = text.length();
                try{
                    Thread.sleep(1000);
                for(int i=0; i<a; i++){
                    temp += text.charAt(i); 
                    header.setText(temp);
                    header.setForeground(Color.blue);
                    if(i == a-1){
                        header.setForeground(Color.blue);
                        Thread.sleep(3000);
                        i=-1;
                        temp = "";
                        header.setText(temp);
                    }
                    Thread.sleep(300);
                }
                }catch(Exception e){
                        JOptionPane.showMessageDialog(null,e.getMessage());
                        }
                }
            
        }); t.start();
    }
    
    
    
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
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        new frame1().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allfiles;
    private javax.swing.JTable alltables;
    private javax.swing.JPanel compressed;
    private javax.swing.JTable compressedtable;
    private javax.swing.JPanel documents;
    private javax.swing.JTable documentstable;
    private javax.swing.JButton download;
    private javax.swing.JPanel executales;
    private javax.swing.JTable exetable;
    private javax.swing.JLabel header;
    private javax.swing.JTextField inputsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton login;
    private javax.swing.JPanel others;
    private javax.swing.JTable otherstable;
    private javax.swing.JPasswordField passwordinput;
    private javax.swing.JButton refresh;
    private javax.swing.JButton search;
    private javax.swing.JTextField setfileid;
    private javax.swing.JTextField setfilename;
    private javax.swing.JLabel setfilephoto;
    private javax.swing.JTextField setfilesize;
    private javax.swing.JTextField setfiletype;
    private javax.swing.JTextField setpublisher;
    private javax.swing.JButton signup;
    private javax.swing.JTabbedPane tabbedpanel;
    private javax.swing.JTextField usernameinput;
    private javax.swing.JPanel videos;
    private javax.swing.JTable videostable;
    // End of variables declaration//GEN-END:variables
}
