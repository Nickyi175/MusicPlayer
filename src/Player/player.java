package Player;

import jaco.mp3.player.MP3Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.player.Player;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javazoom.jl.decoder.JavaLayerException;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;

public class player extends javax.swing.JFrame {

    public Timer timer;
    private Player player;
    private boolean paused;
    //boolean playing=false;
    private int sec, indiceActual = -1;
    private String name;
    private FileSystemView fsv;
    private FileInputStream FileInput;
    private ObjectInputStream ObjInput;
    FileOutputStream FileOutput;
    ObjectOutputStream ObjOutput;
    private DefaultListModel<String> canciones;
    private long pauseLocation, SongLength;
    JFileChooser ArchivoSeleccionado = new JFileChooser();
    ArrayList ArregloCanciones = new ArrayList();
    MP3Player songPlayer;
    

    /*
    FileOutputStream FileOutput;
    ObjectOutputStream ObjOutput;
    FileInputStream FileInput;
    ObjectInputStream ObjInput;
    JFileChooser ArchivoSeleccionado = new JFileChooser();
    ArrayList ArregloCanciones = new ArrayList();

    public void addSong(JFrame frame) {
        ArchivoSeleccionado.setMultiSelectionEnabled(true);
        int fileValid = ArchivoSeleccionado.showOpenDialog(frame);

        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;

        } else if (fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {

            File[] file = ArchivoSeleccionado.getSelectedFiles();
            ArregloCanciones.addAll(Arrays.asList(file));
        }
    }
     */
    public player() {
        initComponents();
        canciones = new DefaultListModel<>();
        canciones.addElement("Solas.mp3");
        player = null;
        sec = 0;
        name = "";
        pauseLocation = 0;
        SongLength = 0;
        paused = false;
        indiceActual = -1;
        
        lista.setModel(canciones);
        sec = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sec++;
                actLabelTIME();
                if (player != null && player.isComplete()) {
                    timer.stop();
                }
            }
        });

    }

    private void actLabelTIME() {
        int minutos = sec / 60;
        int segundosRestantes = sec % 60;
        String tiempoFormateado = String.format("%02d:%02d", minutos, segundosRestantes);
        tiempo.setText(tiempoFormateado);
        double total = palBar(name);
        int bankai = (int) ((sec * 100.0) / total);
        bar.setValue(bankai);
    }

    private double palBar(String rutaArchivo) {
        try {
            AudioFile audioFile = AudioFileIO.read(new File(rutaArchivo));
            int sec = audioFile.getAudioHeader().getTrackLength();
            return sec;
        } catch (Exception e) {
            System.out.println(e);
            return 1600;
        }
    }

    private String FullTime(String rutaArchivo) {
        try {
            AudioFile audioFile = AudioFileIO.read(new File(rutaArchivo));
            int sec = audioFile.getAudioHeader().getTrackLength();
            int min = sec / 60;
            int segundos = sec % 60;
            return String.format("%02d:%02d", min, segundos);
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lista = new javax.swing.JList<>();
        back = new javax.swing.JButton();
        bar = new javax.swing.JProgressBar();
        tiempo = new javax.swing.JLabel();
        duracion = new javax.swing.JLabel();
        next = new javax.swing.JButton();
        p_p = new javax.swing.JButton();
        add = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        down = new javax.swing.JButton();
        up = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        img = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        stop = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Music Player E");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        lista.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        back.setForeground(new java.awt.Color(0, 102, 153));
        back.setText("Back");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        bar.setBackground(new java.awt.Color(255, 255, 255));

        tiempo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tiempo.setForeground(new java.awt.Color(0, 102, 153));
        tiempo.setText("00:00");

        duracion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        duracion.setForeground(new java.awt.Color(0, 102, 153));
        duracion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        duracion.setText("00:00");
        duracion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        next.setBackground(new java.awt.Color(255, 255, 255));
        next.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        next.setForeground(new java.awt.Color(0, 102, 153));
        next.setText("Next");
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
        });
        next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextActionPerformed(evt);
            }
        });

        p_p.setBackground(new java.awt.Color(255, 255, 255));
        p_p.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        p_p.setForeground(new java.awt.Color(0, 102, 153));
        p_p.setText("Play");
        p_p.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_pMouseClicked(evt);
            }
        });
        p_p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                p_pActionPerformed(evt);
            }
        });

        add.setBackground(new java.awt.Color(0, 102, 153));
        add.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        add.setForeground(new java.awt.Color(204, 204, 204));
        add.setText("Add");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        nombre.setBackground(new java.awt.Color(204, 204, 204));
        nombre.setFont(new java.awt.Font("Segoe UI Black", 0, 16)); // NOI18N
        nombre.setForeground(new java.awt.Color(0, 0, 0));
        nombre.setOpaque(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Current Song:");

        down.setBackground(new java.awt.Color(255, 255, 255));
        down.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        down.setForeground(new java.awt.Color(0, 102, 153));
        down.setText("Volume Down");
        down.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downActionPerformed(evt);
            }
        });

        up.setBackground(new java.awt.Color(255, 255, 255));
        up.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        up.setForeground(new java.awt.Color(0, 102, 153));
        up.setText("Volume Up");
        up.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(img, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(img, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Song");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Autor");

        stop.setBackground(new java.awt.Color(0, 102, 153));
        stop.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        stop.setForeground(new java.awt.Color(204, 204, 204));
        stop.setText("Stop");
        stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(103, 103, 103)
                                        .addComponent(back)
                                        .addGap(82, 82, 82)
                                        .addComponent(p_p)
                                        .addGap(72, 72, 72)
                                        .addComponent(next)))
                                .addGap(18, 18, 18)
                                .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(stop)
                    .addComponent(down))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(up))
                .addGap(245, 245, 245))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {down, up});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {add, stop});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_p, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(next, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stop))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(down)
                    .addComponent(up))
                .addGap(248, 248, 248))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {down, up});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {add, stop});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 465, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked

        int elegida = lista.getSelectedIndex();
        if (elegida >= 0) {
            String SongElegida = canciones.getElementAt(elegida);
            System.out.println("Ruta del archivo seleccionado: " + SongElegida);
            nombre.setText(SongElegida);
            name = SongElegida;
            if (player != null) {
                player.close();
            }
            p_p.setText("Play");
            new Thread() {
                public void run() {
                    try {
                        File selectedFile = new File(SongElegida);
                        if(selectedFile.exists()){
                        
                        timer.stop();
                        sec = 0;
                        actLabelTIME();
                        timer.start();
                        System.out.println(SongElegida+" 2");
                        String time = FullTime(SongElegida);
                        duracion.setText("" + time);
                        //FileInput = new FileInputStream(SongElegida);
                        FileInput = new FileInputStream(SongElegida);
                        System.out.println(FileInput);
                        SongLength = FileInput.available();
                        player = new Player(FileInput);
                        player.play();
                        }
//                        }else{
//                            System.out.println("El archivo no existe en la ruta especificada.");
//
//                        }
                        
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                }
            }.start();
        }

    }//GEN-LAST:event_listaMouseClicked


    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        JFileChooser choose = new JFileChooser();
        //choose.setCurrentDirectory(new File("."));
        choose.setCurrentDirectory(new File(System.getProperty("user.dir")));
        FileNameExtensionFilter fileNameExt = new FileNameExtensionFilter("MP3 files", "mp3");
        choose.setFileFilter(fileNameExt);
        try{
        int song = choose.showOpenDialog(null);

        if (song == JFileChooser.APPROVE_OPTION) {
            File selectedFile = choose.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
            String fileName = selectedFile.getName();
            System.out.println("Ruta del archivo seleccionado: " + selectedFile.getAbsolutePath());

            canciones.addElement(filePath);
            lista.setModel(canciones);
        }
        }catch(Exception e){
            e.printStackTrace();
        }
        /*
        ArchivoSeleccionado.setMultiSelectionEnabled(true);
        int fileValid = ArchivoSeleccionado.showOpenDialog(frame);

        if (fileValid == javax.swing.JFileChooser.CANCEL_OPTION) {
            return;

        } else if (fileValid == javax.swing.JFileChooser.APPROVE_OPTION) {

            File[] file = ArchivoSeleccionado.getSelectedFiles();
            ArregloCanciones.addAll(Arrays.asList(file));
        }
         */
    }//GEN-LAST:event_addMouseClicked

    private void p_pMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_pMouseClicked
        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");
            return;
        }
        if (player != null) {
            if (paused) {
                paused = false;
                timer.start();
                p_p.setText("Pause");
                try {
                    FileInput = new FileInputStream(name);
                    //BufferedInputStream songg = new BufferedInputStream(FileInput);
//                Player = new javazoom.jl.player.Player(songg);
//                pl=new javazoom.jl.player.advanced.AdvancedPlayer(songg);
                    FileInput.skip(SongLength - pauseLocation);
                    player = new Player(FileInput);
                    fsv = FileSystemView.getFileSystemView();
                //ImageIcon fileIcon = (ImageIcon) fsv.getSystemIcon(FileInput);
                //img.setIcon(fileIcon);
                    new Thread() {
                        public void run() {
                            try {
                                player.play();
                            } catch (Exception e) {
                            }
                        }
                    }.start();
                } catch (Exception e) {
                }
            } else {
                try {
                    p_p.setText("Play");
                    pauseLocation = FileInput.available();
                    player.close();
                    FileInput.close();
                    timer.stop();
                    paused = true;
                } catch (Exception e) {
                }
            }
        } else {

        }
//    if (playing) {
//            playing = false;
//            p_p.setText("PLAY");
//            
//            songPlayer.pause();
//        } else {
//        try {
//            playing = true;
//            p_p.setText("PAUSE");
//        
//            player.play();
//        } catch (JavaLayerException ex) {
//            Logger.getLogger(player.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        }

    }//GEN-LAST:event_p_pMouseClicked

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");//para timer y turno
            return;
        }
        if (player != null) {
            player.close();
            paused = false;
        }
        if (indiceActual == -1) {
            indiceActual = 0;
        } else {
            indiceActual++;
            if (indiceActual >= canciones.getSize()) {
                indiceActual = 0;
            }
        }
        String siguienteCancion = canciones.getElementAt(indiceActual);
        nombre.setText(siguienteCancion);
        name = siguienteCancion;
        SongLength = 0;
        p_p.setText("Play");
        new Thread() {
            public void run() {
                try {

                    timer.stop();
                    sec = 0;
                    actLabelTIME();
                    timer.start();
                    String time = FullTime(siguienteCancion);
                    duracion.setText("" + time);
                    FileInput = new FileInputStream(siguienteCancion);
                    SongLength = FileInput.available();
                    player = new Player(FileInput);
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }//GEN-LAST:event_nextMouseClicked

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        if (canciones.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");//para timer y turno
            return;
        }
        if (player != null) {
            player.close();
            paused = false;
        }
        if (indiceActual == -1) {
            indiceActual = canciones.getSize() - 1;
        } else {
            if (indiceActual == 0) {
                indiceActual = canciones.getSize() - 1;
            } else {
                indiceActual--;
            }
        }
        String cancionAntes = canciones.getElementAt(indiceActual);
        System.out.println(cancionAntes);
        nombre.setText(cancionAntes);
        name = cancionAntes;
        SongLength = 0;
        p_p.setText("Play");
        new Thread() {
            public void run() {
                try {
                    timer.stop();
                    sec = 0;
                    actLabelTIME();
                    timer.start();
                    String time = FullTime(cancionAntes);
                    duracion.setText("" + time);
                    FileInput = new FileInputStream(cancionAntes);
                    SongLength = FileInput.available();
                    player = new Player(FileInput);
                    player.play();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }//GEN-LAST:event_backMouseClicked

    private void volumeDownControl(Double valueToPlusMinus) {

        Mixer.Info[] mixers = AudioSystem.getMixerInfo();

        for (Mixer.Info mixerInfo : mixers) {

            Mixer mixer = AudioSystem.getMixer(mixerInfo);

            Line.Info[] lineInfos = mixer.getTargetLineInfo();

            for (Line.Info lineInfo : lineInfos) {

                Line line = null;

                boolean opened = true;

                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;

                    if (!opened) {

                        line.open();
                    }

                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);

                    float currentVolume = volControl.getValue();

                    Double volumeToCut = valueToPlusMinus;

                    float changedCalc = (float) ((float) currentVolume - (double) volumeToCut);

                    volControl.setValue(changedCalc);

                } catch (LineUnavailableException lineException) {
                } catch (IllegalArgumentException illException) {
                } finally {

                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }

    private void volumeUpControl(Double valueToPlusMinus) {

        Mixer.Info[] mixers = AudioSystem.getMixerInfo();

        for (Mixer.Info mixerInfo : mixers) {

            Mixer mixer = AudioSystem.getMixer(mixerInfo);

            Line.Info[] lineInfos = mixer.getTargetLineInfo();

            for (Line.Info lineInfo : lineInfos) {

                Line line = null;

                boolean opened = true;

                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;

                    if (!opened) {

                        line.open();
                    }

                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);

                    float currentVolume = volControl.getValue();

                    Double volumeToCut = valueToPlusMinus;

                    float changedCalc = (float) ((float) currentVolume + (double) volumeToCut);

                    volControl.setValue(changedCalc);

                } catch (LineUnavailableException lineException) {
                } catch (IllegalArgumentException illException) {
                } finally {

                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }

    private void volumeControl(Double valueToPlusMinus) {

        Mixer.Info[] mixers = AudioSystem.getMixerInfo();

        for (Mixer.Info mixerInfo : mixers) {

            Mixer mixer = AudioSystem.getMixer(mixerInfo);

            Line.Info[] lineInfos = mixer.getTargetLineInfo();

            for (Line.Info lineInfo : lineInfos) {

                Line line = null;

                boolean opened = true;

                try {
                    line = mixer.getLine(lineInfo);
                    opened = line.isOpen() || line instanceof Clip;

                    if (!opened) {

                        line.open();
                    }

                    FloatControl volControl = (FloatControl) line.getControl(FloatControl.Type.VOLUME);

                    float currentVolume = volControl.getValue();

                    Double volumeToCut = valueToPlusMinus;

                    float changedCalc = (float) ((double) volumeToCut);

                    volControl.setValue(changedCalc);

                } catch (LineUnavailableException lineException) {
                } catch (IllegalArgumentException illException) {
                } finally {

                    if (line != null && !opened) {
                        line.close();
                    }
                }
            }
        }
    }
    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addActionPerformed

    private void p_pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_p_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_p_pActionPerformed

    private void downActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downActionPerformed
        volumeDownControl(0.1);
    }//GEN-LAST:event_downActionPerformed

    private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
        volumeUpControl(0.1);
    }//GEN-LAST:event_upActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

    private void nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextActionPerformed

    private void stopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopActionPerformed
        if (player != null) {
            player.close();
          paused = false;
        }
        timer.stop();
        p_p.setText("Play");
        bar.setValue(0);
        nombre.setText("");
        tiempo.setText("00:00");
        duracion.setText("00:00");
    }//GEN-LAST:event_stopActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(player.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new player().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton back;
    private javax.swing.JProgressBar bar;
    private javax.swing.JButton down;
    private javax.swing.JLabel duracion;
    private javax.swing.JLabel img;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    private javax.swing.JButton next;
    private javax.swing.JLabel nombre;
    private javax.swing.JButton p_p;
    private javax.swing.JButton stop;
    private javax.swing.JLabel tiempo;
    private javax.swing.JButton up;
    // End of variables declaration//GEN-END:variables
}
