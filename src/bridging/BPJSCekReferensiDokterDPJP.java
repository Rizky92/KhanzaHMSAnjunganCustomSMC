/*
  Dilarang keras menggandakan/mengcopy/menyebarkan/membajak/mendecompile 
  Software ini dalam bentuk apapun tanpa seijin pembuat software
  (Khanza.Soft Media). Bagi yang sengaja membajak softaware ini ta
  npa ijin, kami sumpahi sial 1000 turunan, miskin sampai 500 turu
  nan. Selalu mendapat kecelakaan sampai 400 turunan. Anak pertama
  nya cacat tidak punya kaki sampai 300 turunan. Susah cari jodoh
  sampai umur 50 tahun sampai 200 turunan. Ya Alloh maafkan kami 
  karena telah berdoa buruk, semua ini kami lakukan karena kami ti
  dak pernah rela karya kami dibajak tanpa ijin.
 */
package bridging;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import fungsi.WarnaTable;
import fungsi.batasInput;
import fungsi.koneksiDB;
import java.awt.Dimension;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import fungsi.validasi;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;

/**
 *
 * @author dosen
 */
public final class BPJSCekReferensiDokterDPJP extends javax.swing.JDialog {

    private final DefaultTableModel tabMode;
    private final validasi Valid = new validasi();
    private final ApiBPJS api = new ApiBPJS();
    private final BPJSCekReferensiPoli spesialis = new BPJSCekReferensiPoli(null, false);
    private final ObjectMapper mapper = new ObjectMapper();
    private int i = 0;
    private String url = "", utc = "";
    private HttpEntity requestEntity;
    private JsonNode root, metadata, response;

    /**
     * Creates new form DlgKamar
     *
     * @param parent
     * @param modal
     */
    public BPJSCekReferensiDokterDPJP(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setLocation(10, 2);
        setSize(628, 674);

        tabMode = new DefaultTableModel(null, new String[] {"No.", "Kode Dokter", "Nama Dokter"}) {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        tbKamar.setModel(tabMode);

        //tbKamar.setDefaultRenderer(Object.class, new WarnaTable(panelJudul.getBackground(),tbKamar.getBackground()));
        tbKamar.setPreferredScrollableViewportSize(new Dimension(500, 500));
        tbKamar.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < 3; i++) {
            TableColumn column = tbKamar.getColumnModel().getColumn(i);
            if (i == 0) {
                column.setPreferredWidth(40);
            } else if (i == 1) {
                column.setPreferredWidth(140);
            } else if (i == 2) {
                column.setPreferredWidth(470);
            }
        }
        tbKamar.setDefaultRenderer(Object.class, new WarnaTable());

        Dokter.setDocument(new batasInput((byte) 100).getKata(Dokter));

        if (koneksiDB.CARICEPAT().equals("aktif")) {
            Dokter.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    if (Dokter.getText().length() > 2) {
                        tampil(Dokter.getText());
                    }
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    if (Dokter.getText().length() > 2) {
                        tampil(Dokter.getText());
                    }
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    if (Dokter.getText().length() > 2) {
                        tampil(Dokter.getText());
                    }
                }
            });
        }

        spesialis.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (spesialis.getTable().getSelectedRow() != -1) {
                    KdSep.setText(spesialis.getTable().getValueAt(spesialis.getTable().getSelectedRow(), 1).toString());
                    NmSep.setText(spesialis.getTable().getValueAt(spesialis.getTable().getSelectedRow(), 2).toString());
                    KdSep.requestFocus();
                }
            }
        });

        spesialis.getTable().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    spesialis.dispose();
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        internalFrame1 = new widget.InternalFrame();
        Scroll = new widget.ScrollPane();
        tbKamar = new widget.Table();
        panelGlass6 = new widget.panelisi();
        jLabel15 = new widget.Label();
        DTPCari1 = new widget.Tanggal();
        jLabel14 = new widget.Label();
        KdSep = new widget.TextBox();
        NmSep = new widget.TextBox();
        BtnPropinsi = new widget.Button();
        jLabel16 = new widget.Label();
        Dokter = new widget.TextBox();
        BtnCari = new widget.Button();
        jLabel17 = new widget.Label();
        BtnKeluar = new widget.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setIconImages(null);
        setUndecorated(true);
        setResizable(false);

        internalFrame1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(240, 245, 235)), "::[ Pencarian Data Referensi Dokter DPJP VClaim ]::", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 11), new java.awt.Color(50, 50, 50))); // NOI18N
        internalFrame1.setName("internalFrame1"); // NOI18N
        internalFrame1.setLayout(new java.awt.BorderLayout(1, 1));

        Scroll.setName("Scroll"); // NOI18N
        Scroll.setOpaque(true);

        tbKamar.setName("tbKamar"); // NOI18N
        tbKamar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKamarMouseClicked(evt);
            }
        });
        Scroll.setViewportView(tbKamar);

        internalFrame1.add(Scroll, java.awt.BorderLayout.CENTER);

        panelGlass6.setName("panelGlass6"); // NOI18N
        panelGlass6.setPreferredSize(new java.awt.Dimension(44, 54));
        panelGlass6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 5, 9));

        jLabel15.setText("Tanggal Pelayanan :");
        jLabel15.setName("jLabel15"); // NOI18N
        jLabel15.setPreferredSize(new java.awt.Dimension(110, 23));
        panelGlass6.add(jLabel15);

        DTPCari1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "30-12-2024" }));
        DTPCari1.setDisplayFormat("dd-MM-yyyy");
        DTPCari1.setName("DTPCari1"); // NOI18N
        DTPCari1.setOpaque(false);
        DTPCari1.setPreferredSize(new java.awt.Dimension(150, 23));
        panelGlass6.add(DTPCari1);

        jLabel14.setText("Poli / Spesialis");
        jLabel14.setName("jLabel14"); // NOI18N
        jLabel14.setPreferredSize(new java.awt.Dimension(125, 23));
        panelGlass6.add(jLabel14);

        KdSep.setEditable(false);
        KdSep.setHighlighter(null);
        KdSep.setName("KdSep"); // NOI18N
        KdSep.setPreferredSize(new java.awt.Dimension(60, 23));
        panelGlass6.add(KdSep);

        NmSep.setEditable(false);
        NmSep.setName("NmSep"); // NOI18N
        NmSep.setPreferredSize(new java.awt.Dimension(200, 23));
        panelGlass6.add(NmSep);

        BtnPropinsi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/190.png"))); // NOI18N
        BtnPropinsi.setMnemonic('3');
        BtnPropinsi.setToolTipText("ALt+3");
        BtnPropinsi.setName("BtnPropinsi"); // NOI18N
        BtnPropinsi.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnPropinsi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnPropinsiActionPerformed(evt);
            }
        });
        panelGlass6.add(BtnPropinsi);

        jLabel16.setText("Dokter :");
        jLabel16.setName("jLabel16"); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(50, 23));
        panelGlass6.add(jLabel16);

        Dokter.setName("Dokter"); // NOI18N
        Dokter.setPreferredSize(new java.awt.Dimension(310, 23));
        Dokter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DokterKeyPressed(evt);
            }
        });
        panelGlass6.add(Dokter);

        BtnCari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/accept.png"))); // NOI18N
        BtnCari.setMnemonic('6');
        BtnCari.setToolTipText("Alt+6");
        BtnCari.setName("BtnCari"); // NOI18N
        BtnCari.setPreferredSize(new java.awt.Dimension(28, 23));
        BtnCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnCariActionPerformed(evt);
            }
        });
        BtnCari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnCariKeyPressed(evt);
            }
        });
        panelGlass6.add(BtnCari);

        jLabel17.setName("jLabel17"); // NOI18N
        jLabel17.setPreferredSize(new java.awt.Dimension(30, 23));
        panelGlass6.add(jLabel17);

        BtnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/picture/exit.png"))); // NOI18N
        BtnKeluar.setMnemonic('K');
        BtnKeluar.setText("Keluar");
        BtnKeluar.setToolTipText("Alt+K");
        BtnKeluar.setName("BtnKeluar"); // NOI18N
        BtnKeluar.setPreferredSize(new java.awt.Dimension(100, 30));
        BtnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnKeluarActionPerformed(evt);
            }
        });
        BtnKeluar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                BtnKeluarKeyPressed(evt);
            }
        });
        panelGlass6.add(BtnKeluar);

        internalFrame1.add(panelGlass6, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(internalFrame1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKeluarActionPerformed
        dispose();
    }//GEN-LAST:event_BtnKeluarActionPerformed

    private void BtnKeluarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnKeluarKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            dispose();
        } else {
            Valid.pindah(evt, BtnCari, BtnKeluar);
        }
    }//GEN-LAST:event_BtnKeluarKeyPressed

    private void DokterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DokterKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            BtnCariActionPerformed(null);
            BtnCari.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            BtnCariActionPerformed(null);
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            BtnKeluar.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            tbKamar.requestFocus();
        }
    }//GEN-LAST:event_DokterKeyPressed

    private void BtnCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnCariActionPerformed
        if (KdSep.getText().trim().equals("") || NmSep.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan pilih spesialis dulu..!!");
            BtnPropinsi.requestFocus();
        } else {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            tampil(Dokter.getText());
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_BtnCariActionPerformed

    private void BtnCariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_BtnCariKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE) {
            BtnCariActionPerformed(null);
        } else {
            Valid.pindah(evt, Dokter, BtnKeluar);
        }
    }//GEN-LAST:event_BtnCariKeyPressed

    private void BtnPropinsiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnPropinsiActionPerformed
        spesialis.setSize(internalFrame1.getWidth() - 20, internalFrame1.getHeight() - 20);
        spesialis.setLocationRelativeTo(internalFrame1);
        spesialis.setVisible(true);
    }//GEN-LAST:event_BtnPropinsiActionPerformed

    private void tbKamarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKamarMouseClicked
        if (evt.getClickCount() == 1) {
            dispose();
        }
    }//GEN-LAST:event_tbKamarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            BPJSCekReferensiDokterDPJP dialog = new BPJSCekReferensiDokterDPJP(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private widget.Button BtnCari;
    private widget.Button BtnKeluar;
    private widget.Button BtnPropinsi;
    private widget.Tanggal DTPCari1;
    private widget.TextBox Dokter;
    private widget.TextBox KdSep;
    private widget.TextBox NmSep;
    private widget.ScrollPane Scroll;
    private widget.InternalFrame internalFrame1;
    private widget.Label jLabel14;
    private widget.Label jLabel15;
    private widget.Label jLabel16;
    private widget.Label jLabel17;
    private widget.panelisi panelGlass6;
    private widget.Table tbKamar;
    // End of variables declaration//GEN-END:variables

    public void tampil(String poli) {
        Valid.tabelKosong(tabMode);
        try {
            url = koneksiDB.URLAPIBPJS() + "/referensi/dokter/pelayanan/2/tglPelayanan/" + Valid.getTglSmc(DTPCari1) + "/Spesialis/" + KdSep.getText();
            root = mapper.readTree(api.getRest().exchange(url, HttpMethod.GET, requestEntity, String.class).getBody());
            metadata = root.path("metaData");
            System.out.println("code : " + metadata.path("code").asText());
            System.out.println("message : " + metadata.path("message").asText());
            if (metadata.path("code").asText().equals("200")) {
                response = mapper.readTree(api.Decrypt(root.path("response").asText(), utc));
                if (response.path("list").isArray()) {
                    i = 0;
                    for (JsonNode list : response.path("list")) {
                        if (list.path("kode").asText().toLowerCase().contains(poli.toLowerCase()) ||
                            list.path("nama").asText().toLowerCase().contains(poli.toLowerCase())
                        ) {
                            tabMode.addRow(new String[] {(++i) + ".", list.path("kode").asText(), list.path("nama").asText()});
                        }
                    }
                }
            } else {
                if (!metadata.path("code").asText().equals("201")) {
                    JOptionPane.showMessageDialog(null, metadata.path("message").asText());
                }
            }
        } catch (Exception ex) {
            System.out.println("Notifikasi : " + ex);
            if (ex.toString().contains("UnknownHostException")) {
                JOptionPane.showMessageDialog(rootPane, "Koneksi ke server BPJS terputus...!");
            }
        }
    }

    public void setPoli(String KodePoli, String NamaPoli) {
        KdSep.setText(KodePoli);
        NmSep.setText(NamaPoli);
    }

    public JTable getTable() {
        return tbKamar;
    }

    public void carinamadokter(String kodepoli, String namapoli) {
        KdSep.setText(kodepoli);
        NmSep.setText(namapoli);
        BtnCariActionPerformed(null);
    }
}
