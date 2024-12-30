/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fungsi;

import java.awt.Desktop;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Properties;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.JTextComponent;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimplePrintServiceExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;
import uz.ncipro.calendar.JDateTimePicker;
import widget.ComboBox;
import widget.Tanggal;

/**
 *
 * @author Owner
 */
public final class validasi {

    private final String PEMBULATANHARGAOBAT = koneksiDB.PEMBULATANHARGAOBAT();
    private final Connection koneksi = koneksiDB.condb();
    private final sekuel Sequel = new sekuel();
    private final java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
    private final Calendar now = Calendar.getInstance();
    private final int year = (now.get(Calendar.YEAR));
    private final DecimalFormat df2 = new DecimalFormat("###,###,###,###,###,###,###"),
        df3 = new DecimalFormat("######"),
        df4 = new DecimalFormat("###,###,###,###,###,###,###.#################"),
        df5 = new DecimalFormat("###,###,###,###,###,###,###.##"),
        df6 = new DecimalFormat("######.###"),
        df7 = new DecimalFormat("######.#");
    private int a, j, i, result = 0;
    private String s, s1, auto;
    private PreparedStatement ps;
    private ResultSet rs;

    public validasi() {
        super();
    }

    public void autonomorSmc(JTextComponent komponen, String prefix, String separator, String table, String kolom, int panjang, String pad, String tanggal, int next) {
        komponen.setText(Sequel.autonomorSmc(prefix, separator, table, kolom, panjang, pad, tanggal, next));
    }

    public void autonomorSmc(JTextComponent komponen, String prefix, String separator, String table, String kolom, int panjang, String pad, Tanggal tanggal, int next) {
        autonomorSmc(komponen, prefix, separator, table, kolom, panjang, pad, getTglSmc(tanggal), next);
    }

    public void autonomorSmc(JTextComponent komponen, String prefix, String separator, String table, String kolom, int panjang, String pad, String tanggal) {
        komponen.setText(Sequel.autonomorSmc(prefix, separator, table, kolom, panjang, pad, tanggal));
    }

    public void autonomorSmc(JTextComponent komponen, String prefix, String separator, String table, String kolom, int panjang, String pad, Tanggal tanggal) {
        autonomorSmc(komponen, prefix, separator, table, kolom, panjang, pad, getTglSmc(tanggal));
    }

    public void autonomor1Smc(JTextComponent komponen, String prefix, String table, String kolom, int panjang, String pad, Tanggal tanggal) {
        autonomorSmc(komponen, prefix, "", table, kolom, panjang, pad, getTglSmc(tanggal));
    }

    public String getTglSmc(Tanggal tanggal) {
        return new SimpleDateFormat("yyyy-MM-dd").format(tanggal.getDate());
    }

    public String getJamSmc(ComboBox jam, ComboBox menit, ComboBox detik) {
        return jam.getSelectedItem() + ":" + menit.getSelectedItem() + ":" + detik.getSelectedItem();
    }

    public String getTglJamSmc(Tanggal tanggal, ComboBox jam, ComboBox menit, ComboBox detik) {
        return getTglSmc(tanggal) + " " + getJamSmc(jam, menit, detik);
    }

    public String getTglJamSmc(Tanggal tgljam) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tgljam.getDate());
    }

    public String setTglSmc(Date tgl) {
        return new SimpleDateFormat("dd-MM-yyyy").format(tgl);
    }

    public String setTglSmc(String tgl) {
        return tgl.substring(8, 10) + "-" + tgl.substring(5, 7) + "-" + tgl.substring(0, 4);
    }

    public String setTglJamSmc(Date tgljam) {
        return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(tgljam);
    }

    public void reportSmc(String reportName, String reportDirName, String judul, Map reportParams, String sql, String... values) {
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            for (int i = 0; i < values.length; i++) {
                ps.setString(i + 1, values[i]);
            }
            JasperViewer jasperViewer = new JasperViewer(JasperFillManager.fillReport("./" + reportDirName + "/" + reportName, reportParams, new JRResultSetDataSource(ps.executeQuery())), false);
            jasperViewer.setTitle(judul);
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            jasperViewer.setSize(screen.width - 50, screen.height - 50);
            jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
            jasperViewer.setLocationRelativeTo(null);
            jasperViewer.setVisible(true);
        } catch (Exception e) {
            System.out.println("Notif : " + e);
            JOptionPane.showMessageDialog(null, "Report can't view because : " + e);
        }
    }

    public void reportSmc(String reportName, String reportDirName, String judul, Map reportParams) {
        try {
            JasperViewer jv = new JasperViewer(JasperFillManager.fillReport("./" + reportDirName + "/" + reportName, reportParams, koneksi), false);
            jv.setTitle(judul);
            Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
            jv.setSize(screen.width - 50, screen.height - 50);
            jv.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
            jv.setLocationRelativeTo(null);
            jv.setVisible(true);
        } catch (Exception e) {
            System.out.println("Notif : " + e);
            JOptionPane.showMessageDialog(null, "Report can't view because : " + e);
        }
    }

    public void printReportSmc(String reportName, String reportDirName, String judul, Map reportParams, int jumlah, String namaPrinter) {
        try {
            PrintService printService = null;
            for (PrintService currentPrintService : PrintServiceLookup.lookupPrintServices(null, null)) {
                if (currentPrintService.getName().equals(namaPrinter)) {
                    System.out.println("Printer ditemukan: " + currentPrintService.getName());
                    printService = currentPrintService;
                    break;
                }
            }
            if (printService == null) {
                JOptionPane.showMessageDialog(null, "Printer tidak ditemukan!");
                return;
            }

            PrintRequestAttributeSet pra = new HashPrintRequestAttributeSet();
            pra.add(new Copies(jumlah));

            SimplePrintServiceExporterConfiguration config = new SimplePrintServiceExporterConfiguration();
            config.setPrintService(printService);
            config.setPrintRequestAttributeSet(pra);
            config.setPrintServiceAttributeSet(printService.getAttributes());
            config.setDisplayPageDialog(false);
            config.setDisplayPrintDialog(false);

            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            exporter.setExporterInput(new SimpleExporterInput(JasperFillManager.fillReport("./" + reportDirName + "/" + reportName, reportParams, koneksi)));
            exporter.setConfiguration(config);
            exporter.exportReport();
        } catch (Exception e) {
            System.out.println("Notif : " + e);
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada saat melakukan cetak otomatis!");
        }
    }

    public void autoNomer(DefaultTableModel tabMode, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        s = Integer.toString(tabMode.getRowCount() + 1);
        j = s.length();
        s1 = "";
        for (i = 1; i <= pnj - j; i++) {
            s1 = s1 + "0";
        }
        teks.setText(strAwal + s1 + s);
    }

    public void autoNomer(String tabel, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        try {
            ps = koneksi.prepareStatement("select * from " + tabel);
            try {
                rs = ps.executeQuery();
                rs.last();
                s = Integer.toString(rs.getRow() + 1);
                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                teks.setText(strAwal + s1 + s);
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public void autoNomer2(String sql, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        try {
            ps = koneksi.prepareStatement(sql);
            try {
                rs = ps.executeQuery();
                rs.last();
                s = Integer.toString(rs.getRow() + 1);
                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                teks.setText(strAwal + s1 + s);
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public void autoNomer3(String sql, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        try {
            ps = koneksi.prepareStatement(sql);
            try {
                rs = ps.executeQuery();
                s = "1";
                while (rs.next()) {
                    s = Integer.toString(Integer.parseInt(rs.getString(1)) + 1);
                }

                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                teks.setText(strAwal + s1 + s);
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public void autoNomer4(String sql, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        try {
            ps = koneksi.prepareStatement(sql);
            try {
                rs = ps.executeQuery();
                s = "1";
                while (rs.next()) {
                    s = Integer.toString(Integer.parseInt(rs.getString(1)) + 1);
                }

                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                teks.setText((strAwal + s1 + s).substring(4, 6) + (strAwal + s1 + s).substring(2, 4) + (strAwal + s1 + s).substring(0, 2));
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public void autoNomer5(String sql, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        try {
            ps = koneksi.prepareStatement(sql);
            try {
                rs = ps.executeQuery();
                s = "1";
                while (rs.next()) {
                    s = Integer.toString(Integer.parseInt(rs.getString(1)) + 1);
                }

                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                teks.setText((strAwal + s1 + s).substring(2, 4) + (strAwal + s1 + s).substring(0, 2) + (strAwal + s1 + s).substring(4, 6));
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public void autoNomer6(String sql, String strAwal, Integer pnj, javax.swing.JTextField teks) {
        try {
            ps = koneksi.prepareStatement(sql);
            try {
                rs = ps.executeQuery();
                s = "1";
                while (rs.next()) {
                    s = Integer.toString(Integer.parseInt(rs.getString(1)) + 1);
                }

                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                teks.setText(s1 + s + strAwal);
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public String autoNomer(String tabel, String strAwal, Integer pnj) {
        try {
            auto = "";
            ps = koneksi.prepareStatement("select * from " + tabel);
            try {
                rs = ps.executeQuery();
                rs.last();
                s = Integer.toString(rs.getRow() + 1);
                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                auto = strAwal + s1 + s;
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }

        return auto;
    }

    public String autoNomer3(String sql, String strAwal, Integer pnj) {
        try {
            auto = "";
            ps = koneksi.prepareStatement(sql);
            try {
                rs = ps.executeQuery();
                s = "1";
                while (rs.next()) {
                    s = Integer.toString(Integer.parseInt(rs.getString(1)) + 1);
                }

                j = s.length();
                s1 = "";
                for (i = 1; i <= pnj - j; i++) {
                    s1 = s1 + "0";
                }
                auto = strAwal + s1 + s;
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
                JOptionPane.showMessageDialog(null, "Maaf, Query tidak bisa dijalankan...!!!!");
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }

        return auto;
    }

    public void editTable(DefaultTableModel tabMode, String table, String field_acuan, JTextField nilai_field, String update) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        } else if (nilai_field.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        } else if (!nilai_field.getText().trim().equals("")) {
            Sequel.mengedit(table, field_acuan + "='" + nilai_field.getText() + "'", update);
        }
    }

    public void editTable(String table, String field_acuan, JTextField nilai_field, String update) {
        if (nilai_field.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        } else if (!nilai_field.getText().trim().equals("")) {
            Sequel.mengedit(table, field_acuan + "='" + nilai_field.getText() + "'", update);
        }
    }

    public void editTable(DefaultTableModel tabMode, String table, String field_acuan, String nilai_field, String update, int i, String[] a) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
        } else if (nilai_field.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        } else if (!nilai_field.trim().equals("")) {
            Sequel.mengedit(table, field_acuan + "=" + nilai_field, update, i, a);
        }
    }

    public void editTable(DefaultTableModel tabMode, String table, String field_acuan, JComboBox nilai_field, String update) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        } else if (nilai_field.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        } else if (nilai_field.getSelectedItem() != "") {
            Sequel.mengedit(table, field_acuan + "='" + nilai_field.getSelectedItem() + "'", update);

        }
    }

    public void editTable(DefaultTableModel tabMode, String table, String field_acuan, JLabel nilai_field, String update) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        } else if (nilai_field.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal mengedit. Pilih dulu data yang mau diedit.\nKlik data pada table untuk memilih...!!!!");
        } else if (!nilai_field.getText().trim().equals("")) {
            Sequel.mengedit(table, field_acuan + "='" + nilai_field.getText() + "'", update);

        }
    }

    public void fillData(DefaultTableModel model, JTable table, File file) {
        try {
            WritableWorkbook workbook1 = Workbook.createWorkbook(file);
            WritableSheet sheet1 = workbook1.createSheet("First Sheet", 0);
            model = (DefaultTableModel) table.getModel();

            for (i = 0; i < model.getColumnCount(); i++) {
                Label column = new Label(i, 0, model.getColumnName(i));
                sheet1.addCell(column);
            }
            for (i = 0; i < model.getRowCount(); i++) {
                for (j = 0; j < model.getColumnCount(); j++) {
                    Label row = new Label(j, i + 1,
                        model.getValueAt(i, j).toString());
                    sheet1.addCell(row);
                }
            }
            workbook1.write();
            workbook1.close();
        } catch (IOException | WriteException ex) {
            System.out.println("Notifikasi : " + ex);
        }
    }

    public void hapusTable(DefaultTableModel tabMode, JTextField nilai_field, String table, String field) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        } else if (nilai_field.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        } else if (!nilai_field.getText().trim().equals("")) {
            Sequel.meghapus(table, field, nilai_field.getText());

        }
    }

    public void hapusTable(DefaultTableModel tabMode, JComboBox nilai_field, String table, String field) {
        if (tabMode.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Maaf, data sudah habis...!!!!");
            nilai_field.requestFocus();
        } else if (nilai_field.getSelectedItem().equals("")) {
            JOptionPane.showMessageDialog(null, "Maaf, Gagal menghapus. Pilih dulu data yang mau dihapus.\nKlik data pada table untuk memilih...!!!!");
        } else if (nilai_field.getSelectedItem() != "") {
            String data = nilai_field.getSelectedItem().toString();
            Sequel.meghapus(table, field, data);
        }
    }

    public void loadCombo(JComboBox cmb, String field, String table) {
        cmb.removeAllItems();
        try {
            ps = koneksi.prepareStatement("select " + field + " from " + table + " order by " + field);
            try {
                rs = ps.executeQuery();
                while (rs.next()) {
                    String item = rs.getString(1);
                    cmb.addItem(item);
                    a++;
                }
            } catch (Exception e) {
                System.out.println("Notifikasi : " + e);
            } finally {
                if (rs != null) {
                    rs.close();
                }

                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
        }
    }

    public void LoadTahun(JComboBox cmb) {
        cmb.removeAllItems();
        for (i = (year + 1); i >= 1980; i--) {
            cmb.addItem(i);
        }
        cmb.setSelectedItem(year);
    }

    public void LoadTahunAkd(JComboBox cmb) {
        cmb.removeAllItems();
        for (i = 1950; i <= year; i++) {
            cmb.addItem(i + "1");
            cmb.addItem(i + "2");
        }
        cmb.setSelectedItem(year + "1");
    }

    @SuppressWarnings("empty-statement")
    public void MyReport(String reportName, String reportDirName, String judul, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);

        File fileRpt;
        String fullPath = "";
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jasper ada
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
            try (Statement stm = koneksi.createStatement()) {
                try {

                    String namafile = "./" + reportDirName + "/" + reportName;
                    JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, koneksi);

                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                    jasperViewer.setTitle(judul);
                    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                    jasperViewer.setSize(screen.width - 50, screen.height - 50);
                    jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
                    jasperViewer.setLocationRelativeTo(null);
                    jasperViewer.setVisible(true);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : " + rptexcpt);
                    JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("empty-statement")
    public void MyReportPDF(String reportName, String reportDirName, String judul, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);

        File fileRpt;
        String fullPath = "";
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jasper ada
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
            try (Statement stm = koneksi.createStatement()) {
                try {
                    File f = new File("./" + reportDirName + "/" + reportName.replaceAll("jasper", "pdf"));
                    String namafile = "./" + reportDirName + "/" + reportName;
                    JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, koneksi);
                    JasperExportManager.exportReportToPdfFile(jasperPrint, "./" + reportDirName + "/" + reportName.replaceAll("jasper", "pdf"));
                    Desktop.getDesktop().open(f);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : " + rptexcpt);
                    JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @SuppressWarnings("empty-statement")
    public void MyReport2(String reportName, String reportDirName, String judul, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);

        File fileRpt;
        String fullPath = "";
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jasper ada
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
            try (Statement stm = koneksi.createStatement()) {
                try {

                    String namafile = "./" + reportDirName + "/" + reportName;
                    JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, koneksi);

                    JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                    jasperViewer.setTitle(judul);
                    Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                    jasperViewer.setSize(screen.width - 50, screen.height - 50);
                    jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
                    jasperViewer.setLocationRelativeTo(null);
                    jasperViewer.setVisible(true);
                } catch (Exception rptexcpt) {
                    System.out.println("Report Can't view because : " + rptexcpt);
                    JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void MyReportqry(String reportName, String reportDirName, String judul, String qry, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);

        File fileRpt;
        String fullPath = "";
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jrxml ada
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
            System.out.println("masuk sini");
            ps = koneksi.prepareStatement(qry);
            try {
                String namafile = "./" + reportDirName + "/" + reportName;
                rs = ps.executeQuery();
                JRResultSetDataSource rsdt = new JRResultSetDataSource(rs);

                JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, rsdt);

                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);
                jasperViewer.setTitle(judul);
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                jasperViewer.setSize(screen.width - 50, screen.height - 50);
                jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
                jasperViewer.setLocationRelativeTo(null);
                jasperViewer.setVisible(true);
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
                JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void MyReportqryabdul(String reportName, String reportDirName, String judul, String qry, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);
//        System.out.println(currentDir);

        File fileRpt;
        String fullPath = "";
//        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
//                System.out.println(fileRpt);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jrxml ada
                    System.out.println("mencari report");
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
            ps = koneksi.prepareStatement(qry);
            try {
                String namafile = "./" + reportDirName + "/" + reportName;
                rs = ps.executeQuery();
                JRResultSetDataSource rsdt = new JRResultSetDataSource(rs);
                JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, rsdt);
                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

                jasperViewer.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowOpened(java.awt.event.WindowEvent windowEvent) {
                        // Close the viewer after a delay (adjust the sleep time as needed)
                        try {
                            Thread.sleep(10000); // 5000 milliseconds = 5 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        jasperViewer.setVisible(false); // Hide the viewer
                        jasperViewer.dispose(); // Dispose of resources
                    }
                });

                PrinterJob printerJob = PrinterJob.getPrinterJob();
//                printerJob.setPrintService(printerJob.getPrintService());
                PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
                printRequestAttributeSet.add(new Copies(1));
                JRPrintServiceExporter exporter = new JRPrintServiceExporter();

                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
                exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printerJob.getPrintService());
                exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, false);
                exporter.exportReport();

                jasperViewer.setTitle(judul);
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                jasperViewer.setSize(screen.width - 50, screen.height - 50);
                jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
                jasperViewer.setLocationRelativeTo(null);
                jasperViewer.setVisible(true);
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
                JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void MyReportqryabdulAntrian(String reportName, String reportDirName, String judul, String qry, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);
//        System.out.println(currentDir);

        File fileRpt;
        String fullPath = "";
//        System.out.println(dir);
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
//                System.out.println(fileRpt);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jrxml ada
                    System.out.println("mencari report");
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
//            ps = connect.prepareStatement(qry);
            try {
                String namafile = "./" + reportDirName + "/" + reportName;
//                rs = ps.executeQuery();
//                JRResultSetDataSource rsdt = new JRResultSetDataSource(rs);
                JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, new JREmptyDataSource());
                JasperViewer jasperViewer = new JasperViewer(jasperPrint, false);

                jasperViewer.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowOpened(java.awt.event.WindowEvent windowEvent) {
                        // Close the viewer after a delay (adjust the sleep time as needed)
                        try {
                            Thread.sleep(3000); // 5000 milliseconds = 5 seconds
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        jasperViewer.setVisible(false); // Hide the viewer
                        jasperViewer.dispose(); // Dispose of resources
                    }
                });
                PrinterJob printerJob = PrinterJob.getPrinterJob();
//                printerJob.setPrintService(printerJob.getPrintService());
                PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
                printRequestAttributeSet.add(new Copies(1));
                JRPrintServiceExporter exporter = new JRPrintServiceExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
                exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
                exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, printerJob.getPrintService());
                exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, false);
                exporter.exportReport();

                jasperViewer.setTitle(judul);
                Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
                jasperViewer.setSize(500, 700);
//                jasperViewer.setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
                jasperViewer.setLocationRelativeTo(null);
                jasperViewer.setVisible(true);
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
                JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void MyReportqrypdf(String reportName, String reportDirName, String judul, String qry, Map parameters) {
        Properties systemProp = System.getProperties();

        // Ambil current dir
        String currentDir = systemProp.getProperty("user.dir");

        File dir = new File(currentDir);

        File fileRpt;
        String fullPath = "";
        if (dir.isDirectory()) {
            String[] isiDir = dir.list();
            for (String iDir : isiDir) {
                fileRpt = new File(currentDir + File.separatorChar + iDir + File.separatorChar + reportDirName + File.separatorChar + reportName);
                if (fileRpt.isFile()) { // Cek apakah file RptMaster.jrxml ada
                    fullPath = fileRpt.toString();
                    System.out.println("Found Report File at : " + fullPath);
                } // end if
            } // end for i
        } // end if

        try {
            ps = koneksi.prepareStatement(qry);
            try {
                String namafile = "./" + reportDirName + "/" + reportName;
                File f = new File("./" + reportDirName + "/" + reportName.replaceAll("jasper", "pdf"));
                rs = ps.executeQuery();
                JRResultSetDataSource rsdt = new JRResultSetDataSource(rs);
                JasperPrint jasperPrint = JasperFillManager.fillReport(namafile, parameters, rsdt);
                JasperExportManager.exportReportToPdfFile(jasperPrint, "./" + reportDirName + "/" + reportName.replaceAll("jasper", "pdf"));
                Desktop.getDesktop().open(f);
            } catch (Exception rptexcpt) {
                System.out.println("Report Can't view because : " + rptexcpt);
                JOptionPane.showMessageDialog(null, "Report Can't view because : " + rptexcpt);
            } finally {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void MyReport(String reportName, Map parameters, String title) {
        try {
            JasperViewer jasperViewer = new JasperViewer(JasperFillManager.fillReport("./report/" + reportName, parameters, koneksi), false);
            jasperViewer.setTitle(title);
            jasperViewer.setLocationRelativeTo(null);
            jasperViewer.setVisible(true);
            //JasperViewer.viewReport(JasperFillManager.fillReport(JasperCompileManager.compileReport("./report/"+reportName),parameters,connect),false);
        } catch (Exception ex) {
            System.out.println("Notifikasi : " + ex);
        }
    }

    public void MyReportSilentPrint(String reportName, Map parameters, String title) {
        try {
            JasperViewer jasperViewer = new JasperViewer(JasperFillManager.fillReport("./report/" + reportName, parameters, koneksi), false);
            JasperPrint jasperPrint = JasperFillManager.fillReport("./report/" + reportName, parameters, koneksi);
//            jasperViewer.setTitle(title);
//            jasperViewer.setLocationRelativeTo(null);
//            jasperViewer.setVisible(true);

            PrinterJob printerJob = PrinterJob.getPrinterJob();
            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            int selectedService = 0;

            for (int i = 0; i < services.length; i++) {
//                System.out.println(services[i].getName().toString());
                if ((services[i].getName().toString().toLowerCase().contains("zebra")) || (services[i].getName().toString().toLowerCase().contains("gt800"))) {
                    /*If the service is named as what we are querying we select it */
                    System.out.println("Daftar printer dipilih: " + services[i].getName().toString());
                    selectedService = i;
                    System.out.println("index printer dipilih : " + i);
                }
            }
            printerJob.setPrintService(services[selectedService]);
            PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
            printRequestAttributeSet.add(new Copies(3));
            JRPrintServiceExporter exporter = new JRPrintServiceExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services[selectedService]);
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services[selectedService].getAttributes());
            exporter.setParameter(JRPrintServiceExporterParameter.PRINT_REQUEST_ATTRIBUTE_SET, printRequestAttributeSet);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
            exporter.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);
            exporter.exportReport();
            //JasperViewer.viewReport(JasperFillManager.fillReport(JasperCompileManager.compileReport("./report/"+reportName),parameters,connect),false);
        } catch (Exception ex) {
            System.out.println("Notifikasi : " + ex);
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JTextField kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JCheckBox kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JTextField kanan, JTextField bawah) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            bawah.requestFocus();
        }
    }

    public void pindah2(java.awt.event.KeyEvent evt, JTextField kiri, JTextField kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah2(java.awt.event.KeyEvent evt, JTextField kiri, JComboBox kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JTextArea kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextArea kiri, JTextArea kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(KeyEvent evt, JComboBox kiri, JTextArea kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JButton kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JButton kanan, JTextField bawah) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            bawah.requestFocus();
        }
    }

    public void pindah2(java.awt.event.KeyEvent evt, JTextField kiri, JButton kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_PAGE_DOWN) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JButton kiri, JTextField kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JButton kiri, JButton kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextField kiri, JComboBox kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JTextArea kiri, JComboBox kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JComboBox kiri, JTextField kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JComboBox kiri, JDateTimePicker kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JCheckBox kiri, JDateTimePicker kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JDateTimePicker kiri, JTextField kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JComboBox kiri, JComboBox kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(java.awt.event.KeyEvent evt, JComboBox kiri, JButton kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(KeyEvent evt, JButton kiri, JComboBox kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(KeyEvent evt, JTextArea kiri, JButton kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void pindah(KeyEvent evt, JTextArea kiri, JTextField kanan) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            kanan.requestFocus();
        } else if (evt.getKeyCode() == KeyEvent.VK_PAGE_UP) {
            kiri.requestFocus();
        }
    }

    public void panggilUrl(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try {
            Properties prop = new Properties();
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + "http://" + koneksiDB.HOSTHYBRIDWEB() + ":" + prop.getProperty("PORTWEB") + "/" + prop.getProperty("HYBRIDWEB") + "/" + url);
            } else if (os.contains("mac")) {
                rt.exec("open " + "http://" + koneksiDB.HOSTHYBRIDWEB() + ":" + prop.getProperty("PORTWEB") + "/" + prop.getProperty("HYBRIDWEB") + "/" + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                String[] browsers = {"x-www-browser", "epiphany", "firefox", "mozilla", "konqueror", "chrome", "chromium", "netscape", "opera", "links", "lynx", "midori"};
                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                StringBuilder cmd = new StringBuilder();
                for (i = 0; i < browsers.length; i++) {
                    cmd.append(i == 0 ? "" : " || ").append(browsers[i]).append(" \"").append("http://").append(koneksiDB.HOSTHYBRIDWEB() + ":" + prop.getProperty("PORTWEB")).append("/").append(prop.getProperty("HYBRIDWEB")).append("/").append(url).append("\" ");
                }
                rt.exec(new String[] {"sh", "-c", cmd.toString()});
            }
        } catch (Exception e) {
            System.out.println("Notif Browser : " + e);
        }
    }

    public void panggilUrl2(String url) {
        String os = System.getProperty("os.name").toLowerCase();
        Runtime rt = Runtime.getRuntime();
        try {
            Properties prop = new Properties();
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            if (os.contains("win")) {
                rt.exec("rundll32 url.dll,FileProtocolHandler " + url);
            } else if (os.contains("mac")) {
                rt.exec("open " + url);
            } else if (os.contains("nix") || os.contains("nux")) {
                String[] browsers = {"x-www-browser", "epiphany", "firefox", "mozilla", "konqueror", "chrome", "chromium", "netscape", "opera", "links", "lynx", "midori"};
                // Build a command string which looks like "browser1 "url" || browser2 "url" ||..."
                StringBuilder cmd = new StringBuilder();
                for (i = 0; i < browsers.length; i++) {
                    cmd.append(i == 0 ? "" : " || ").append(browsers[i]).append(" \"").append(url).append("\" ");
                }
                rt.exec(new String[] {"sh", "-c", cmd.toString()});
            }
        } catch (Exception e) {
            System.out.println("Notif Browser : " + e);
        }
    }

    public void printUrl(String url) throws URISyntaxException {
        try {
            Properties prop = new Properties();
            prop.loadFromXML(new FileInputStream("setting/database.xml"));
            desktop.print(new File(new java.net.URI("http://" + koneksiDB.HOSTHYBRIDWEB() + ":" + prop.getProperty("PORTWEB") + "/" + url)));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void SetTgl(DefaultTableModel tabMode, JTable table, JDateTimePicker dtp, int i) {
        j = table.getSelectedRow();
        try {
            Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(tabMode.getValueAt(j, i).toString());
            dtp.setDate(dtpa);
        } catch (ParseException ex) {
            dtp.setDate(new Date());
        }
    }

    public String SetTgl(String original) {
        s = "";
        try {
            s = original.substring(6, 10) + "-" + original.substring(3, 5) + "-" + original.substring(0, 2);
        } catch (Exception e) {
        }
        return s;
    }

    public String SetTgl3(String original) {
        s = "";
        try {
            s = original.substring(8, 10) + "-" + original.substring(5, 7) + "-" + original.substring(0, 4);
        } catch (Exception e) {
        }
        return s;
    }

    public String MaxTeks(String original, int max) {
        if (original.length() >= max) {
            s = original.substring(0, (max - 1));
        } else {
            s = original;
        }
        return original;
    }

    public void SetTgl(JDateTimePicker dtp, String tgl) {
        try {
            Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
            dtp.setDate(dtpa);
        } catch (ParseException ex) {
            dtp.setDate(new Date());
        }
    }

    public void SetTgl2(JDateTimePicker dtp, String tgl) {
        try {
            Date dtpa = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(tgl);
            dtp.setDate(dtpa);
        } catch (ParseException ex) {
            dtp.setDate(new Date());
        }
    }

    public Date SetTgl2(String tgl) {
        try {
            Date dtpa = new SimpleDateFormat("yyyy-MM-dd").parse(tgl);
            return dtpa;
        } catch (ParseException ex) {
            return new Date();
        }
    }

    public void textKosong(JTextField teks, String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }

    public void textKosong(JTextArea teks, String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }

    public void textKosong(JButton teks, String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }

    public void tabelKosong(DefaultTableModel tabMode) {
        j = tabMode.getRowCount();
        for (i = 0; i < j; i++) {
            tabMode.removeRow(0);
        }
    }

    public void textKosong(JComboBox teks, String pesan) {
        JOptionPane.showMessageDialog(null, "Maaf, " + pesan + " tidak boleh kosong...!!!");
        teks.requestFocus();
    }

    public String SetAngka(double nilai) {
        return df2.format(nilai);
    }

    public String SetAngka3(double nilai) {
        return df4.format(nilai);
    }

    public String SetAngka4(double nilai) {
        return df5.format(nilai);
    }

    public String SetAngka2(double nilai) {
        return df3.format(nilai);
    }

    public String SetAngka5(double nilai) {
        return df6.format(nilai);
    }

    public String SetAngka6(double nilai) {
        return df7.format(nilai);
    }

    public double SetAngka7(double nilai) {
        return Double.parseDouble(df7.format(nilai));
    }

    public double SetAngka8(double value, int places) {
        return new BigDecimal(value).setScale(places, RoundingMode.HALF_UP).doubleValue();
    }

    public double SetAngka(String txt) {
        double x;
        try {
            if (txt.equals("")) {
                x = 0;
            } else {
                x = Double.parseDouble(txt);
            }
        } catch (Exception e) {
            x = 0;
        }

        return x;
    }

    public double roundUp(double number, int multiple) {
        if (PEMBULATANHARGAOBAT.equals("yes")) {
            result = multiple;
            if (number % multiple == 0) {
                return (int) number;
            }

            if (number % multiple != 0) {
                int division = (int) ((number / multiple) + 1);
                result = division * multiple;
            }
            return result;
        } else {
            return Math.round(number);
        }
    }

    public boolean ValidasiRegistrasi(String kodepoli, String kodedokter, String norm, String tglperiksa, String kodepj) {
        try {
            if (Sequel.cariInteger("select count(reg_periksa.no_rm) from reg_periksa where reg_periksa.kd_poli='" + kodepoli + "' and reg_periksa.kd_dokter='" + kodedokter + "' and reg_periksa.no_rkm_medis='" + norm + "' and reg_periksa.tgl_registrasi='" + tglperiksa + "' reg_periksa.kd_pj='" + kodepj + "'") > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Notifikasi : " + e);
            return false;
        }
    }

}
