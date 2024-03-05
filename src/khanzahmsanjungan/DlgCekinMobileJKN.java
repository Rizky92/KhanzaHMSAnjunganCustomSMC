/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

 /*
 * DlgAdmin.java
 *
 * Created on 04 Des 13, 12:59:34
 */
package khanzahmsanjungan;

import fungsi.sekuel;
import java.awt.Cursor;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author Kode
 */
public class DlgCekinMobileJKN extends javax.swing.JDialog {
    
    private final sekuel Sequel = new sekuel();
    private final DlgRegistrasiSEPMobileJKN form = new DlgRegistrasiSEPMobileJKN(null, false);

    /**
     * Creates new form DlgAdmin
     *
     * @param parent
     * @param id
     */
    public DlgCekinMobileJKN(java.awt.Frame parent, boolean id) {
        super(parent, id);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        PanelWall = new usu.widget.glass.PanelGlass();
        jPanel1 = new component.Panel();
        NoRMPasien = new component.TextBox();
        jLabel28 = new component.Label();
        BtnTutup = new widget.ButtonBig();
        BtnKonfirmasi = new widget.ButtonBig();
        jPanel3 = new javax.swing.JPanel();
        btnAngka8 = new javax.swing.JButton();
        btnAngka7 = new javax.swing.JButton();
        btnAngka9 = new javax.swing.JButton();
        btnAngka4 = new javax.swing.JButton();
        btnAngka5 = new javax.swing.JButton();
        btnAngka6 = new javax.swing.JButton();
        btnAngka2 = new javax.swing.JButton();
        btnAngka1 = new javax.swing.JButton();
        btnAngka3 = new javax.swing.JButton();
        btnAngka0 = new javax.swing.JButton();
        btnAngkaHps = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new java.awt.BorderLayout(1, 1));

        jPanel2.setBackground(new java.awt.Color(238, 238, 255));
        jPanel2.setForeground(new java.awt.Color(238, 238, 255));

        PanelWall.setBackground(new java.awt.Color(238, 238, 255));
        PanelWall.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/48x48/mobilejkn.png"))); // NOI18N
        PanelWall.setForeground(new java.awt.Color(238, 238, 255));
        PanelWall.setPreferredSize(new java.awt.Dimension(500, 150));
        PanelWall.setRound(false);
        PanelWall.setWarna(new java.awt.Color(238, 238, 255));

        javax.swing.GroupLayout PanelWallLayout = new javax.swing.GroupLayout(PanelWall);
        PanelWall.setLayout(PanelWallLayout);
        PanelWallLayout.setHorizontalGroup(
            PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        PanelWallLayout.setVerticalGroup(
            PanelWallLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );

        jPanel2.add(PanelWall);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(238, 238, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 215, 255)), "::[ Cek Data Pasien!!! ]::", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Inter", 0, 30), new java.awt.Color(0, 131, 62))); // NOI18N
        jPanel1.setForeground(new java.awt.Color(0, 131, 62));
        jPanel1.setPreferredSize(new java.awt.Dimension(400, 70));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        NoRMPasien.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 131, 62), 2, true));
        NoRMPasien.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NoRMPasien.setFont(new java.awt.Font("Inter", 0, 36)); // NOI18N
        NoRMPasien.setPreferredSize(new java.awt.Dimension(350, 75));
        NoRMPasien.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                NoRMPasienKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(NoRMPasien, gridBagConstraints);

        jLabel28.setForeground(new java.awt.Color(0, 131, 62));
        jLabel28.setText("No. RM / No. Kartu BPJS : ");
        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel28.setPreferredSize(new java.awt.Dimension(500, 75));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.ipady = 5;
        jPanel1.add(jLabel28, gridBagConstraints);

        BtnTutup.setBackground(new java.awt.Color(255, 255, 255));
        BtnTutup.setForeground(new java.awt.Color(51, 51, 51));
        BtnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/exit.png"))); // NOI18N
        BtnTutup.setMnemonic('U');
        BtnTutup.setToolTipText("Alt+U");
        BtnTutup.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        BtnTutup.setHorizontalTextPosition(javax.swing.SwingConstants.TRAILING);
        BtnTutup.setIconTextGap(2);
        BtnTutup.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnTutup.setPreferredSize(new java.awt.Dimension(100, 75));
        BtnTutup.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BtnTutup.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnTutupActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 13;
        jPanel1.add(BtnTutup, gridBagConstraints);

        BtnKonfirmasi.setBackground(new java.awt.Color(255, 255, 255));
        BtnKonfirmasi.setForeground(new java.awt.Color(51, 51, 51));
        BtnKonfirmasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/konfirmasi.png"))); // NOI18N
        BtnKonfirmasi.setMnemonic('U');
        BtnKonfirmasi.setToolTipText("Alt+U");
        BtnKonfirmasi.setFont(new java.awt.Font("Inter", 1, 11)); // NOI18N
        BtnKonfirmasi.setIconTextGap(0);
        BtnKonfirmasi.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnKonfirmasi.setPreferredSize(new java.awt.Dimension(100, 75));
        BtnKonfirmasi.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        BtnKonfirmasi.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                BtnKonfirmasiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 13;
        jPanel1.add(BtnKonfirmasi, gridBagConstraints);

        jPanel3.setBackground(new java.awt.Color(238, 238, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(294, 402));

        btnAngka8.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka8.setText("8");
        btnAngka8.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka8ActionPerformed(evt);
            }
        });

        btnAngka7.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka7.setText("7");
        btnAngka7.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka7ActionPerformed(evt);
            }
        });

        btnAngka9.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka9.setText("9");
        btnAngka9.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka9ActionPerformed(evt);
            }
        });

        btnAngka4.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka4.setText("4");
        btnAngka4.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka4ActionPerformed(evt);
            }
        });

        btnAngka5.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka5.setText("5");
        btnAngka5.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka5ActionPerformed(evt);
            }
        });

        btnAngka6.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka6.setText("6");
        btnAngka6.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka6ActionPerformed(evt);
            }
        });

        btnAngka2.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka2.setText("2");
        btnAngka2.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka2ActionPerformed(evt);
            }
        });

        btnAngka1.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka1.setText("1");
        btnAngka1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka1ActionPerformed(evt);
            }
        });

        btnAngka3.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka3.setText("3");
        btnAngka3.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka3ActionPerformed(evt);
            }
        });

        btnAngka0.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnAngka0.setText("0");
        btnAngka0.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngka0ActionPerformed(evt);
            }
        });

        btnAngkaHps.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 36)); // NOI18N
        btnAngkaHps.setText("<-");
        btnAngkaHps.setToolTipText("");
        btnAngkaHps.setMaximumSize(new java.awt.Dimension(75, 75));
        btnAngkaHps.setMinimumSize(new java.awt.Dimension(75, 75));
        btnAngkaHps.setPreferredSize(new java.awt.Dimension(75, 75));
        btnAngkaHps.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnAngkaHpsActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Segoe UI SemiBold", 0, 48)); // NOI18N
        btnClear.setText("C");
        btnClear.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAngka4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAngka1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngkaHps, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnAngka7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAngka9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAngka7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngka8, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngka9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAngka4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngka5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngka6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAngka3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngka2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngka1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAngka0, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAngkaHps, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        btnAngkaHps.getAccessibleContext().setAccessibleName("Backspace");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jPanel3, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NoRMPasienKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_NoRMPasienKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
            if (NoRMPasien.getText().isBlank()) {
                JOptionPane.showMessageDialog(rootPane, "Isian masih kosong..!!");
                this.setCursor(Cursor.getDefaultCursor());
                return;
            }

            if (Sequel.cariBooleanSmc("select * from referensi_mobilejkn_bpjs where nomorkartu = ? and tanggalperiksa = current_date() and status != 'Batal'", NoRMPasien.getText())) {
                form.tampil(NoRMPasien.getText());
                form.setSize(this.getWidth(), this.getHeight());
                form.setLocationRelativeTo(jPanel1);
                form.setVisible(true);
                this.dispose();
                this.setCursor(Cursor.getDefaultCursor());
            } else if (Sequel.cariBooleanSmc("select * from referensi_mobilejkn_bpjs where norm = ? and tanggalperiksa = current_date() and status != 'Batal'", NoRMPasien.getText())) {
                form.tampil(Sequel.cariIsi("select nomorkartu from referensi_mobilejkn_bpjs where norm = ? and tanggalperiksa = current_date() and status != 'Batal'", NoRMPasien.getText()));
                form.setSize(this.getWidth(), this.getHeight());
                form.setLocationRelativeTo(jPanel1);
                form.setVisible(true);
                this.dispose();
                this.setCursor(Cursor.getDefaultCursor());
            } else {
                JOptionPane.showMessageDialog(rootPane, "Data Booking MobileJKN tidak ditemukan. ");
                this.setCursor(Cursor.getDefaultCursor());
            }
        }
    }//GEN-LAST:event_NoRMPasienKeyPressed

    private void BtnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnTutupActionPerformed
        dispose();
    }//GEN-LAST:event_BtnTutupActionPerformed

    private void BtnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnKonfirmasiActionPerformed
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        if (NoRMPasien.getText().isBlank()) {
            JOptionPane.showMessageDialog(rootPane, "Isian masih kosong..!!");
            this.setCursor(Cursor.getDefaultCursor());
            return;
        }
        
        if (Sequel.cariBooleanSmc("select * from referensi_mobilejkn_bpjs where nomorkartu = ? and tanggalperiksa = current_date() and status != 'Batal'", NoRMPasien.getText())) {
            form.tampil(NoRMPasien.getText());
            form.setSize(this.getWidth(), this.getHeight());
            form.setLocationRelativeTo(jPanel1);
            form.setVisible(true);
            this.dispose();
            this.setCursor(Cursor.getDefaultCursor());
        } else if (Sequel.cariBooleanSmc("select * from referensi_mobilejkn_bpjs where norm = ? and tanggalperiksa = current_date() and status != 'Batal'", NoRMPasien.getText())) {
            form.tampil(Sequel.cariIsi("select nomorkartu from referensi_mobilejkn_bpjs where norm = ? and tanggalperiksa = current_date() and status != 'Batal'", NoRMPasien.getText()));
            form.setSize(this.getWidth(), this.getHeight());
            form.setLocationRelativeTo(jPanel1);
            form.setVisible(true);
            this.dispose();
            this.setCursor(Cursor.getDefaultCursor());
        } else {
            JOptionPane.showMessageDialog(rootPane, "Data Booking MobileJKN tidak ditemukan. ");
            this.setCursor(Cursor.getDefaultCursor());
        }
    }//GEN-LAST:event_BtnKonfirmasiActionPerformed

    private void btnAngka8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka8ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "8");
    }//GEN-LAST:event_btnAngka8ActionPerformed

    private void btnAngka7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka7ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "7");
    }//GEN-LAST:event_btnAngka7ActionPerformed

    private void btnAngka9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka9ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "9");
    }//GEN-LAST:event_btnAngka9ActionPerformed

    private void btnAngka4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka4ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "4");
    }//GEN-LAST:event_btnAngka4ActionPerformed

    private void btnAngka5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka5ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "5");
    }//GEN-LAST:event_btnAngka5ActionPerformed

    private void btnAngka6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka6ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "6");
    }//GEN-LAST:event_btnAngka6ActionPerformed

    private void btnAngka2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka2ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "2");
    }//GEN-LAST:event_btnAngka2ActionPerformed

    private void btnAngka1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka1ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "1");
    }//GEN-LAST:event_btnAngka1ActionPerformed

    private void btnAngka3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka3ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "3");
    }//GEN-LAST:event_btnAngka3ActionPerformed

    private void btnAngka0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngka0ActionPerformed
        NoRMPasien.setText(NoRMPasien.getText() + "0");
    }//GEN-LAST:event_btnAngka0ActionPerformed

    private void btnAngkaHpsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAngkaHpsActionPerformed
        int length = NoRMPasien.getText().length();
        int number = NoRMPasien.getText().length() - 1;
        String store;
        if (length > 0) {
            StringBuilder back = new StringBuilder(NoRMPasien.getText());
            back.deleteCharAt(number);
            store = back.toString();
            NoRMPasien.setText(store);
        }
    }//GEN-LAST:event_btnAngkaHpsActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        int length = NoRMPasien.getText().length();
        if (length > 0) {
            NoRMPasien.setText("");
        }
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            DlgCekinMobileJKN dialog = new DlgCekinMobileJKN(new javax.swing.JFrame(), true);
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
    private widget.ButtonBig BtnKonfirmasi;
    private widget.ButtonBig BtnTutup;
    private component.TextBox NoRMPasien;
    private usu.widget.glass.PanelGlass PanelWall;
    private javax.swing.JButton btnAngka0;
    private javax.swing.JButton btnAngka1;
    private javax.swing.JButton btnAngka2;
    private javax.swing.JButton btnAngka3;
    private javax.swing.JButton btnAngka4;
    private javax.swing.JButton btnAngka5;
    private javax.swing.JButton btnAngka6;
    private javax.swing.JButton btnAngka7;
    private javax.swing.JButton btnAngka8;
    private javax.swing.JButton btnAngka9;
    private javax.swing.JButton btnAngkaHps;
    private javax.swing.JButton btnClear;
    private component.Label jLabel28;
    private component.Panel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
