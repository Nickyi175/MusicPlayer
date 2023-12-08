package Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import javax.swing.DefaultListModel;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import javax.swing.JFileChooser;
import javax.swing.Timer;
import javax.swing.filechooser.FileNameExtensionFilter;
import javazoom.jl.player.Player;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class MusicPlayer extends javax.swing.JFrame {

    private DefaultListModel<String> playlist;
    private Player player;
    private boolean rep = false;
    private int segundos;
    private int indiceActual = -1;
    private String name;
    private boolean pausado;
    private FileInputStream fis;
    private long pauseLocation;
    private long songTotalLength;
    public Timer timer;

    public MusicPlayer() {
        initComponents();
        player = null;
        segundos = 0;
        name = "";
        pauseLocation = 0;
        songTotalLength = 0;
        pausado = false;
        indiceActual = -1;
        playlist = new DefaultListModel<>();
        playlist.addElement("Solas.mp3");
        playlist.addElement("Sunflower.mp3");
        lista.setModel(playlist);
        segundos = 0;

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                actLabelTIME();
                if (player != null && player.isComplete()) {
                    timer.stop();
                }
            }
        });

    }

    private void actLabelTIME() {
        int minutos = segundos / 60;
        int segundosRestantes = segundos % 60;
        String tiempoFormateado = String.format("%02d:%02d", minutos, segundosRestantes);
        tiempo.setText(tiempoFormateado);
        double total = palBar(name);
        int bankai = (int) ((segundos * 100.0) / total);
        barra.setValue(bankai);
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

    private String duracionToda(String rutaArchivo) {
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
        antes = new javax.swing.JButton();
        barra = new javax.swing.JProgressBar();
        tiempo = new javax.swing.JLabel();
        duracion = new javax.swing.JLabel();
        siguiente = new javax.swing.JButton();
        stop_play = new javax.swing.JButton();
        add = new javax.swing.JButton();
        nombre = new javax.swing.JLabel();
        resetList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Music Player E");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lista);

        antes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        antes.setText("<<");
        antes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                antesMouseClicked(evt);
            }
        });

        barra.setBackground(new java.awt.Color(0, 51, 255));

        tiempo.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        tiempo.setForeground(new java.awt.Color(255, 255, 255));
        tiempo.setText("00:00");

        duracion.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        duracion.setForeground(new java.awt.Color(255, 255, 255));
        duracion.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        duracion.setText("00:00");
        duracion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        siguiente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        siguiente.setText(">>");
        siguiente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                siguienteMouseClicked(evt);
            }
        });

        stop_play.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        stop_play.setText("ll");
        stop_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                stop_playMouseClicked(evt);
            }
        });

        add.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add.setText("Añadir");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });

        nombre.setBackground(new java.awt.Color(0, 204, 51));
        nombre.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nombre.setForeground(new java.awt.Color(255, 255, 255));
        nombre.setOpaque(true);

        resetList.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        resetList.setText("Reset");
        resetList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                resetListMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(resetList, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(antes, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(115, 115, 115)
                                    .addComponent(stop_play, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(134, 134, 134)
                                    .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(666, 666, 666)
                        .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(228, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(145, 145, 145)
                        .addComponent(tiempo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(antes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(stop_play, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(31, 31, 31))
                                    .addComponent(barra, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addComponent(duracion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(resetList, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaMouseClicked

        int elegida = lista.getSelectedIndex();
        if (elegida >= 0) {
            System.out.println("elegida");
            String eCancion = playlist.getElementAt(elegida);
            nombre.setText(eCancion);
            name = eCancion;
            if (player != null) {
                player.close();
            }
            stop_play.setText("ll");
            new Thread() {
                public void run() {
                    try {
                        timer.stop();
                        segundos = 0;
                        actLabelTIME();
                        timer.start();
                        String duracio = duracionToda(eCancion);
                        duracion.setText("" + duracio);
                        fis = new FileInputStream(eCancion);
                        songTotalLength = fis.available();
                        player = new Player(fis);
                        System.out.println("playing");
                        player.play();

                    } catch (Exception e) {
                    }
                }
            }.start();
        }

    }//GEN-LAST:event_listaMouseClicked


    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("."));
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("MP3 files", "mp3");
        fileChooser.setFileFilter(fnef);
        int song = fileChooser.showOpenDialog(null);

        if (song == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String fileName = selectedFile.getName();
            System.out.println("Selected File: " + selectedFile.getAbsolutePath());
            playlist.addElement(fileName);
            lista.setModel(playlist);
        }

    }//GEN-LAST:event_addMouseClicked

    private void stop_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_stop_playMouseClicked
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");
            return;
        }
        if (player != null) {
            if (pausado) {
                pausado = false;
                timer.start();
                stop_play.setText("ll");
                try {
                    fis = new FileInputStream(name);
                    fis.skip(songTotalLength - pauseLocation);
                    player = new Player(fis);
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
                    stop_play.setText(">");
                    pauseLocation = fis.available();
                    player.close();
                    fis.close();
                    timer.stop();
                    pausado = true;
                } catch (Exception e) {
                }
            }
        } else {

        }

    }//GEN-LAST:event_stop_playMouseClicked

    private void siguienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_siguienteMouseClicked
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");//para timer y turno
            return;
        }
        if (player != null) {
            player.close();
            pausado = false;
        }
        if (indiceActual == -1) {
            indiceActual = 0;
        } else {
            indiceActual++;
            if (indiceActual >= playlist.getSize()) {
                indiceActual = 0;
            }
        }
        String siguienteCancion = playlist.getElementAt(indiceActual);
        nombre.setText(siguienteCancion);
        name = siguienteCancion;
        songTotalLength = 0;
        stop_play.setText("ll");
        new Thread() {
            public void run() {
                try {

                    timer.stop();
                    segundos = 0;
                    actLabelTIME();
                    timer.start();
                    String duracio = duracionToda(siguienteCancion);
                    duracion.setText("" + duracio);
                    fis = new FileInputStream(siguienteCancion);
                    songTotalLength = fis.available();
                    player = new Player(fis);
                    player.play();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }//GEN-LAST:event_siguienteMouseClicked

    private void antesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_antesMouseClicked
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");//para timer y turno
            return;
        }
        if (player != null) {
            player.close();
            pausado = false;
        }
        if (indiceActual == -1) {
            indiceActual = playlist.getSize() - 1;
        } else {
            if (indiceActual == 0) {
                indiceActual = playlist.getSize() - 1;
            } else {
                indiceActual--;
            }
        }
        String cancionAntes = playlist.getElementAt(indiceActual);
        nombre.setText(cancionAntes);
        name = cancionAntes;
        songTotalLength = 0;
        stop_play.setText("ll");
        new Thread() {
            public void run() {
                try {
                    timer.stop();
                    segundos = 0;
                    actLabelTIME();
                    timer.start();
                    String duracio = duracionToda(cancionAntes);
                    duracion.setText("" + duracio);
                    fis = new FileInputStream(cancionAntes);
                    songTotalLength = fis.available();
                    player = new Player(fis);
                    player.play();

                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }.start();
    }//GEN-LAST:event_antesMouseClicked

    private void resetListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_resetListMouseClicked
        if (playlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO HAY CANCIONES");
            return;
        }
        if (player != null) {
            player.close();
            pausado = false;
        }
        timer.stop();
        stop_play.setText("ll");
        barra.setValue(0);
        nombre.setText("");
        tiempo.setText("00:00");
        duracion.setText("00:00");
        playlist.clear();
        lista.setModel(playlist);


    }//GEN-LAST:event_resetListMouseClicked

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
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MusicPlayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MusicPlayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton antes;
    private javax.swing.JProgressBar barra;
    private javax.swing.JLabel duracion;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lista;
    private javax.swing.JLabel nombre;
    private javax.swing.JButton resetList;
    private javax.swing.JButton siguiente;
    private javax.swing.JButton stop_play;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables
}
