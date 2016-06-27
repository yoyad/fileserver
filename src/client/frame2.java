package client;

import implementation.client;
import implementation.files;
import interfaces.Interface;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class frame2 extends javax.swing.JFrame implements Serializable {

    interfaces.Interface ref;
    List<files> list = new ArrayList<>();
    List<String> avialables = new ArrayList<>();
    static String currentTab = "allFiles";
    String operationid;
    frame1 f;
    client currentuser;
    String[] onlines;
    String username;
    public static int check;

    public frame2(frame1 f, String username) {
        this.f = f;
        try {
            ref = (Interface) Naming.lookup("rmi://localhost:1234/fileserver");
            this.username = username;
            ImageIcon back = new ImageIcon("C:\\Users\\shadow\\Downloads\\bl.jpg");
            Image newimg = back.getImage();//.getScaledInstance(1228, 900, java.awt.Image.SCALE_SMOOTH);
            back = new ImageIcon(newimg);
            setContentPane(new JLabel(back));
            initComponents();
            getmessage();
            getavailable();
            list = ref.populatetable(currentTab);
            currentuser = ref.getinfo(username);
            populatetable(list);
            setuserinfor();
        } catch (Exception e) {
            System.out.println("error: " + e);
        }
    }

    /*
    avialables = ref.available(username);
                onlines = avialables.toArray(new String[avialables.size()]);
                for(int i=0; i<onlines.length; i++){
                System.out.println(onlines);
                DefaultComboBoxModel model = new DefaultComboBoxModel( onlines );
                selectonlinefriend.setModel( model );
    
     */
    public void getavailable() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    avialables = ref.available(username);
                    onlines = avialables.toArray(new String[avialables.size()]);
                    int checker = ref.check(username);
                    if (check <= checker - 1) {
                        System.out.println(check + " " + checker);
                        DefaultComboBoxModel model = new DefaultComboBoxModel(onlines);
                        selectonlinefriend.setModel(model);
                        System.out.println(avialables.get(check));
                        check++;
                    }
                } catch (Exception ex) {
                    System.out.println("error in getavailable " + ex);
                }
            }
        });
        t.start();
    }

    public void getmessage() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        String msg = ref.readchat(username);
                        if (!msg.equals("")) {
                            msghistory.append(msg + "\n");
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(frame2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(frame2.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

        });
        t.start();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        inputsearch = new javax.swing.JTextField();
        search = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        setfilename = new javax.swing.JTextField();
        setfiletype = new javax.swing.JTextField();
        setfilesize = new javax.swing.JTextField();
        setfilephoto = new javax.swing.JLabel();
        download = new javax.swing.JButton();
        setfileid = new javax.swing.JTextField();
        setpublisher = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        servertime = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        allfilespanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        allfilestable = new javax.swing.JTable();
        documentspanel = new javax.swing.JPanel();
        df = new javax.swing.JScrollPane();
        documentstable = new javax.swing.JTable();
        videopanel = new javax.swing.JPanel();
        df1 = new javax.swing.JScrollPane();
        videotable = new javax.swing.JTable();
        compressedpanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        compressedtable = new javax.swing.JTable();
        exepanel = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        exetable = new javax.swing.JTable();
        otherspanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        otherstable = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        userphoto = new javax.swing.JLabel();
        setusername = new javax.swing.JTextField();
        setuserjob = new javax.swing.JTextField();
        logout = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        msghistory = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        msgsent = new javax.swing.JTextArea();
        String[] name  = {"shadow","abeny"};
        selectonlinefriend = new javax.swing.JComboBox();
        attach = new javax.swing.JButton();
        send = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        upload = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 0, 51), new java.awt.Color(0, 0, 0)), "SEARCH_PANEL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        inputsearch.setBackground(new java.awt.Color(204, 204, 204));
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
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(inputsearch)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(refresh, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(inputsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search)
                    .addComponent(refresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(153, 153, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 153, 0), java.awt.Color.black), "FILE_INFO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        setfilename.setEditable(false);
        setfilename.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfilename.setText("FILE_NAME");
        setfilename.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfilename.setEnabled(false);
        setfilename.setPreferredSize(new java.awt.Dimension(229, 21));

        setfiletype.setEditable(false);
        setfiletype.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfiletype.setText("FILE_TYPE");
        setfiletype.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfiletype.setEnabled(false);
        setfiletype.setPreferredSize(new java.awt.Dimension(229, 21));
        setfiletype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setfiletypeActionPerformed(evt);
            }
        });

        setfilesize.setEditable(false);
        setfilesize.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setfilesize.setText("FILE_SIZE");
        setfilesize.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setfilesize.setEnabled(false);
        setfilesize.setPreferredSize(new java.awt.Dimension(229, 21));

        setfilephoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setfilephoto.setText("NO PREVIEW");

        download.setBackground(new java.awt.Color(0, 102, 255));
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
        setfileid.setPreferredSize(new java.awt.Dimension(229, 21));

        setpublisher.setEditable(false);
        setpublisher.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        setpublisher.setText("PUBLISHER");
        setpublisher.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setpublisher.setEnabled(false);
        setpublisher.setPreferredSize(new java.awt.Dimension(229, 21));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(setfilephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(download)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setfilename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setfileid, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setpublisher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setfiletype, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setfilesize, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(setfileid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(setfilename, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setpublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfiletype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfilesize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setfilephoto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(download))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 8)); // NOI18N
        jLabel4.setText("SERVER_TIME:");

        servertime.setEditable(false);
        servertime.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(servertime, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servertime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1228, 850));
        jTabbedPane1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jTabbedPane1ComponentShown(evt);
            }
        });

        allfilespanel.setBackground(new java.awt.Color(204, 255, 204));
        allfilespanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                allfilespanelComponentShown(evt);
            }
        });

        allfilestable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                allfilestableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(allfilestable);

        javax.swing.GroupLayout allfilespanelLayout = new javax.swing.GroupLayout(allfilespanel);
        allfilespanel.setLayout(allfilespanelLayout);
        allfilespanelLayout.setHorizontalGroup(
            allfilespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        allfilespanelLayout.setVerticalGroup(
            allfilespanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ALL_FILES", allfilespanel);

        documentspanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                documentspanelComponentShown(evt);
            }
        });

        documentstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentstableMouseClicked(evt);
            }
        });
        df.setViewportView(documentstable);

        javax.swing.GroupLayout documentspanelLayout = new javax.swing.GroupLayout(documentspanel);
        documentspanel.setLayout(documentspanelLayout);
        documentspanelLayout.setHorizontalGroup(
            documentspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(df)
        );
        documentspanelLayout.setVerticalGroup(
            documentspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(df, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("DOCUMENTS", documentspanel);

        videopanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                videopanelComponentShown(evt);
            }
        });

        videotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                videotableMouseClicked(evt);
            }
        });
        df1.setViewportView(videotable);

        javax.swing.GroupLayout videopanelLayout = new javax.swing.GroupLayout(videopanel);
        videopanel.setLayout(videopanelLayout);
        videopanelLayout.setHorizontalGroup(
            videopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(df1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1223, Short.MAX_VALUE)
        );
        videopanelLayout.setVerticalGroup(
            videopanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(df1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("VIDEOS", videopanel);

        compressedpanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                compressedpanelComponentShown(evt);
            }
        });

        compressedtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                compressedtableMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(compressedtable);

        javax.swing.GroupLayout compressedpanelLayout = new javax.swing.GroupLayout(compressedpanel);
        compressedpanel.setLayout(compressedpanelLayout);
        compressedpanelLayout.setHorizontalGroup(
            compressedpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6)
        );
        compressedpanelLayout.setVerticalGroup(
            compressedpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("COMPRESSED", compressedpanel);

        exepanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                exepanelComponentShown(evt);
            }
        });

        exetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exetableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(exetable);

        javax.swing.GroupLayout exepanelLayout = new javax.swing.GroupLayout(exepanel);
        exepanel.setLayout(exepanelLayout);
        exepanelLayout.setHorizontalGroup(
            exepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7)
        );
        exepanelLayout.setVerticalGroup(
            exepanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("EXECUTABLES", exepanel);

        otherspanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                otherspanelComponentShown(evt);
            }
        });

        otherstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                otherstableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(otherstable);

        javax.swing.GroupLayout otherspanelLayout = new javax.swing.GroupLayout(otherspanel);
        otherspanel.setLayout(otherspanelLayout);
        otherspanelLayout.setHorizontalGroup(
            otherspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9)
        );
        otherspanelLayout.setVerticalGroup(
            otherspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("OTHERS", otherspanel);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 51), new java.awt.Color(0, 0, 0)), "user info", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(255, 0, 0))); // NOI18N

        userphoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userphoto.setText("NO PREVIEW");
        userphoto.setPreferredSize(new java.awt.Dimension(113, 117));

        setusername.setEditable(false);
        setusername.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        setusername.setText("NAME:");
        setusername.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setusername.setEnabled(false);

        setuserjob.setEditable(false);
        setuserjob.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        setuserjob.setText("JOB:");
        setuserjob.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        setuserjob.setEnabled(false);

        logout.setBackground(new java.awt.Color(255, 0, 0));
        logout.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        logout.setText("LOG_OUT");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(setusername)
                    .addComponent(setuserjob)
                    .addComponent(logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userphoto, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(setusername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(setuserjob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logout)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(userphoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 255, 0), java.awt.Color.darkGray), "MESSAGING", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        msghistory.setEditable(false);
        msghistory.setBackground(new java.awt.Color(204, 204, 204));
        msghistory.setColumns(20);
        msghistory.setRows(5);
        msghistory.setText("\n");
        jScrollPane1.setViewportView(msghistory);

        msgsent.setColumns(20);
        msgsent.setRows(5);
        msgsent.setText("MESSAGE TO BE SENT....");
        jScrollPane2.setViewportView(msgsent);

        attach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        attach.setText("ATTACH");

        send.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        send.setText("SEND");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(attach, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(selectonlinefriend, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attach)
                    .addComponent(send))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(selectonlinefriend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(255, 0, 0), new java.awt.Color(0, 0, 0)), "FILE_UPLOAD", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 10))); // NOI18N

        upload.setBackground(new java.awt.Color(0, 255, 51));
        upload.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        upload.setText("UPLOAD FILE TO DATABASE");
        upload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uploadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upload)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(10, 10, 10)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void allfilespanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_allfilespanelComponentShown
        try {
            currentTab = "allFiles";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_allfilespanelComponentShown

    private void documentspanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_documentspanelComponentShown
        try {
            currentTab = "documentsTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_documentspanelComponentShown

    private void jTabbedPane1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTabbedPane1ComponentShown

    }//GEN-LAST:event_jTabbedPane1ComponentShown

    private void videopanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_videopanelComponentShown
        try {
            currentTab = "videoTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_videopanelComponentShown

    private void compressedpanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_compressedpanelComponentShown
        try {
            currentTab = "compressedTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_compressedpanelComponentShown

    private void exepanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_exepanelComponentShown
        try {
            currentTab = "executableTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_exepanelComponentShown

    private void otherspanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_otherspanelComponentShown
        try {
            currentTab = "othersTab";
            list = ref.populatetable(currentTab);
            populatetable(list);
        } catch (RemoteException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_otherspanelComponentShown

    private void allfilestableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_allfilestableMouseClicked
        int i = allfilestable.getSelectedRow();
        String fileid = allfilestable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = allfilestable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = allfilestable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = allfilestable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = allfilestable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_allfilestableMouseClicked

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

    private void videotableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_videotableMouseClicked
        int i = videotable.getSelectedRow();
        String fileid = videotable.getValueAt(i, 0).toString();
        operationid = fileid;
        setfileid.setText(fileid);
        String filename = videotable.getValueAt(i, 1).toString();
        setfilename.setText(filename);
        String publisher = videotable.getValueAt(i, 2).toString();
        setpublisher.setText(publisher);
        String filetype = videotable.getValueAt(i, 3).toString();
        setfiletype.setText(filetype);
        String filesize = videotable.getValueAt(i, 4).toString();
        setfilesize.setText(filesize);
        setphoto(fileid, (int) setfilephoto.getWidth(), (int) setfilephoto.getHeight());
    }//GEN-LAST:event_videotableMouseClicked

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

    private void setfiletypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setfiletypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setfiletypeActionPerformed

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

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        try {
            this.dispose();
            f.setVisible(true);
            ref.remove(username);
        } catch (RemoteException ex) {
            System.out.println("ex");
        }

    }//GEN-LAST:event_logoutActionPerformed

    private void uploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uploadActionPerformed
        this.disable();
        new upload(this, currentuser.getUsername()).setVisible(rootPaneCheckingEnabled);
    }//GEN-LAST:event_uploadActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        String msg = msgsent.getText();
        msghistory.append(currentuser.getUsername() + ": " + msg + "\n");
        String to = selectonlinefriend.getSelectedItem().toString();
        int a = 0;
        try {
            msg = username + ": " + msg;
            a = ref.writechat(to, msg);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "sorry can't send message", null, JOptionPane.ERROR_MESSAGE);
        }
        if (a == 0) {
            msghistory.append("message was not sent\n");
        }
    }//GEN-LAST:event_sendActionPerformed

    public void populatetable(List<files> file) {
        try {
            list = file;
            switch (currentTab) {
                case "allFiles":
                    tablemodel allfilesmodel = new tablemodel(list);
                    allfilestable.setModel(allfilesmodel);
                    break;
                case "documentsTab":
                    tablemodel documentmodel = new tablemodel(list);
                    documentstable.setModel(documentmodel);
                    break;
                case "videoTab":
                    tablemodel videomodel = new tablemodel(list);
                    videotable.setModel(videomodel);
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
                    allfilestable.setModel(defaultmodel);
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

    public void setuserinfor() {
        String user = currentuser.getUsername();
        String job = currentuser.getJob();
        ImageIcon photo = currentuser.getPhoto();
        setusername.setText(user);
        setuserjob.setText(job);
        userphoto.setText("");
        Image img = photo.getImage();
        Image newimg = img.getScaledInstance(113, 117, java.awt.Image.SCALE_SMOOTH);
        photo = new ImageIcon(newimg);
        userphoto.setIcon(photo);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel allfilespanel;
    private javax.swing.JTable allfilestable;
    private javax.swing.JButton attach;
    private javax.swing.JPanel compressedpanel;
    private javax.swing.JTable compressedtable;
    private javax.swing.JScrollPane df;
    private javax.swing.JScrollPane df1;
    private javax.swing.JPanel documentspanel;
    private javax.swing.JTable documentstable;
    private javax.swing.JButton download;
    private javax.swing.JPanel exepanel;
    private javax.swing.JTable exetable;
    private javax.swing.JTextField inputsearch;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton logout;
    private javax.swing.JTextArea msghistory;
    private javax.swing.JTextArea msgsent;
    private javax.swing.JPanel otherspanel;
    private javax.swing.JTable otherstable;
    private javax.swing.JButton refresh;
    private javax.swing.JButton search;
    private static javax.swing.JComboBox selectonlinefriend;
    private javax.swing.JButton send;
    private javax.swing.JTextField servertime;
    private javax.swing.JTextField setfileid;
    private javax.swing.JTextField setfilename;
    private javax.swing.JLabel setfilephoto;
    private javax.swing.JTextField setfilesize;
    private javax.swing.JTextField setfiletype;
    private javax.swing.JTextField setpublisher;
    private javax.swing.JTextField setuserjob;
    private javax.swing.JTextField setusername;
    private javax.swing.JButton upload;
    private javax.swing.JLabel userphoto;
    private javax.swing.JPanel videopanel;
    private javax.swing.JTable videotable;
    // End of variables declaration//GEN-END:variables
}
