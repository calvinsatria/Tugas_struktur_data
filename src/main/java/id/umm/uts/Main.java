package id.umm.uts;

import com.formdev.flatlaf.FlatLightLaf;
import id.umm.uts.ds.DynamicArray;
import id.umm.uts.io.CsvExporter;
import id.umm.uts.io.CsvImporter;
import id.umm.uts.model.Putusan;
import id.umm.uts.service.PutusanService;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.Box;
import javax.swing.BoxLayout;

public class Main extends JFrame {

    private static final String ALL_TYPES = "Semua jenis";

    private final PutusanService service = new PutusanService();
    private final JTextArea textArea = new JTextArea();
    private final JTextField caseIdField = new JTextField(12);
    private final JTextField minSentenceField = new JTextField(7);
    private final JComboBox<String> typeFilter = new JComboBox<>();

    public Main() {
        super("Aplikasi Arsip Putusan");
        initUI();

        DynamicArray<Putusan> dataAwal = DataDummy.getData();
        for (int i = 0; i < dataAwal.size(); i++) {
            service.tambahPutusan(dataAwal.get(i));
        }
        refreshTypeChoices();
        tampilkanDataKeLayar();
    }

    private void initUI() {
        setSize(1100, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel header = new JPanel(new BorderLayout());
        header.setBorder(BorderFactory.createEmptyBorder(18, 22, 14, 22));
        JLabel title = new JLabel("Sistem Arsip Putusan Narkotika");
        title.setFont(new Font("Segoe UI", Font.BOLD, 22));
        header.add(title, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);

        JPanel sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setBackground(new Color(242, 244, 247));
        sidebar.setBorder(BorderFactory.createEmptyBorder(16, 12, 16, 12));
        sidebar.setPreferredSize(new Dimension(190, 0));
        addButton(sidebar, "Impor CSV", this::importCsv);
        addButton(sidebar, "Ekspor CSV", this::exportCsv);
        addButton(sidebar, "Tampilkan Data", this::tampilkanDataKeLayar);
        addButton(sidebar, "Tambah Data", this::tambahData);
        addButton(sidebar, "Hapus Data", this::hapusData);
        addButton(sidebar, "Urutkan Vonis", this::urutkanData);
        addButton(sidebar, "Agregasi", () -> textArea.setText(service.ringkasanAgregasi()));
        addButton(sidebar, "Riwayat Audit", () -> textArea.setText(service.ringkasanRiwayatAudit()));
        add(sidebar, BorderLayout.WEST);

        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(Color.WHITE);
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JPanel content = new JPanel(new BorderLayout());
        content.setBorder(BorderFactory.createEmptyBorder(0, 4, 0, 14));
        content.add(new JScrollPane(textArea), BorderLayout.CENTER);
        add(content, BorderLayout.CENTER);

        JPanel controls = new JPanel(new GridLayout(2, 1, 0, 4));
        controls.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createEmptyBorder(8, 14, 14, 14),
                BorderFactory.createTitledBorder("Pencarian dan Filter")));
        JPanel searchControls = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        JButton searchButton = new JButton("Cari");
        searchButton.addActionListener(event -> runSafely(this::cariData));
        caseIdField.putClientProperty("JTextField.placeholderText", "Cari Case ID...");
        searchControls.add(new JLabel("Case ID:"));
        searchControls.add(caseIdField);
        searchControls.add(searchButton);

        JPanel filterControls = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 4));
        JButton filterButton = new JButton("Filter");
        filterButton.addActionListener(event -> runSafely(this::filterData));
        minSentenceField.putClientProperty("JTextField.placeholderText", "Minimal vonis");
        filterControls.add(new JLabel("Jenis narkotika:"));
        filterControls.add(typeFilter);
        filterControls.add(new JLabel("Vonis minimum (bulan):"));
        filterControls.add(minSentenceField);
        filterControls.add(filterButton);
        controls.add(searchControls);
        controls.add(filterControls);
        add(controls, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    private void addButton(JPanel panel, String label, Runnable action) {
        JButton button = new JButton(label);
        button.addActionListener(event -> runSafely(action));
        button.setAlignmentX(LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        button.setPreferredSize(new Dimension(166, 40));
        panel.add(button);
        panel.add(Box.createVerticalStrut(8));
    }

    private void importCsv() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Pilih file CSV untuk diimpor");
        chooser.setFileFilter(new FileNameExtensionFilter("CSV (*.csv)", "csv"));
        if (chooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        DynamicArray<Putusan> dataBaru =
                CsvImporter.importCsv(chooser.getSelectedFile().getAbsolutePath());
        for (int i = 0; i < dataBaru.size(); i++) {
            service.tambahPutusan(dataBaru.get(i));
        }
        refreshTypeChoices();
        tampilkanDataKeLayar();
        JOptionPane.showMessageDialog(this,
                dataBaru.size() + " data berhasil diimpor.",
                "Impor CSV", JOptionPane.INFORMATION_MESSAGE);
    }

    private void exportCsv() {
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Simpan data sebagai CSV");
        chooser.setFileFilter(new FileNameExtensionFilter("CSV (*.csv)", "csv"));
        if (chooser.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        File selected = chooser.getSelectedFile();
        String path = selected.getAbsolutePath();
        if (!path.toLowerCase().endsWith(".csv")) {
            path += ".csv";
        }
        CsvExporter.exportCsv(service.getArsipUtama(), path);
        JOptionPane.showMessageDialog(this, "Data berhasil diekspor ke:\n" + path);
    }

    private void tambahData() {
        JTextField caseId = new JTextField();
        JTextField nomorPerkara = new JTextField();
        JTextField jenisNarkotika = new JTextField();
        JTextField vonisBulan = new JTextField();

        JPanel form = new JPanel(new GridLayout(0, 2, 8, 8));
        form.add(new JLabel("CaseId:"));
        form.add(caseId);
        form.add(new JLabel("Nomor perkara:"));
        form.add(nomorPerkara);
        form.add(new JLabel("Jenis narkotika:"));
        form.add(jenisNarkotika);
        form.add(new JLabel("Vonis (bulan):"));
        form.add(vonisBulan);

        int result = JOptionPane.showConfirmDialog(
                this, form, "Tambah Putusan", JOptionPane.OK_CANCEL_OPTION);
        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String id = caseId.getText().trim();
        if (id.isEmpty()) {
            throw new IllegalArgumentException("CaseId wajib diisi.");
        }
        if (!id.startsWith("P")) {
            id = "P" + id;
        }
        int sentence = parseRequiredInteger(vonisBulan.getText(), "Vonis");
        Putusan putusan = new Putusan(
                id,
                nomorPerkara.getText().trim(),
                "PN Mgt",
                null,
                "",
                jenisNarkotika.getText().trim(),
                0.0,
                "-",
                "-",
                0,
                sentence,
                0,
                "",
                "-",
                "-",
                "-");
        service.tambahPutusan(putusan);
        refreshTypeChoices();
        tampilkanDataKeLayar();
    }

    private void hapusData() {
        String caseId = JOptionPane.showInputDialog(this, "Masukkan CaseId yang akan dihapus:");
        if (caseId == null || caseId.trim().isEmpty()) {
            return;
        }
        String normalizedId = caseId.trim();
        if (!normalizedId.startsWith("P")) {
            normalizedId = "P" + normalizedId;
        }
        Putusan found = service.cariBerdasarkanCaseId(normalizedId);
        if (found == null) {
            JOptionPane.showMessageDialog(this, "Putusan tidak ditemukan.");
            return;
        }

        DynamicArray<Putusan> archive = service.getArsipUtama();
        for (int i = 0; i < archive.size(); i++) {
            if (archive.get(i) == found) {
                service.hapusPutusan(i);
                refreshTypeChoices();
                tampilkanDataKeLayar();
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "Putusan tidak ditemukan di arsip.");
    }

    private void cariData() {
        String id = caseIdField.getText().trim();
        if (!id.isEmpty() && !id.startsWith("P")) {
            id = "P" + id;
        }
        Putusan found = service.cariBerdasarkanCaseId(id);
        if (found == null) {
            textArea.setText("Putusan dengan CaseId " + id + " tidak ditemukan."
                    + "\nLangkah pencarian: " + service.getLastSearchSteps());
            return;
        }
        textArea.setText("Hasil pencarian:\n" + formatPutusan(found)
                + "\nLangkah pencarian: " + service.getLastSearchSteps());
    }

    private void filterData() {
        String selectedType = (String) typeFilter.getSelectedItem();
        String jenis = ALL_TYPES.equals(selectedType) ? "" : selectedType;
        String minText = minSentenceField.getText().trim();
        int minVonis = minText.isEmpty() ? 0 : parseRequiredInteger(minText, "Vonis minimum");
        DynamicArray<Putusan> results = service.filterGabungan(jenis, 0, 0, minVonis, 0);
        tampilkanDaftar("Hasil filter: " + results.size() + " data", results);
    }

    private void urutkanData() {
        service.urutkanBerdasarkanVonis();
        tampilkanDataKeLayar();
    }

    private void refreshTypeChoices() {
        String selected = (String) typeFilter.getSelectedItem();
        typeFilter.removeAllItems();
        typeFilter.addItem(ALL_TYPES);
        DynamicArray<Putusan> archive = service.getArsipUtama();
        for (int i = 0; i < archive.size(); i++) {
            String type = archive.get(i).getJenisNarkotika();
            if (type != null && !type.isBlank() && !containsType(type)) {
                typeFilter.addItem(type);
            }
        }
        if (selected != null) {
            typeFilter.setSelectedItem(selected);
        }
    }

    private boolean containsType(String candidate) {
        for (int i = 1; i < typeFilter.getItemCount(); i++) {
            if (candidate.equalsIgnoreCase(typeFilter.getItemAt(i))) {
                return true;
            }
        }
        return false;
    }

    private void tampilkanDataKeLayar() {
        tampilkanDaftar("Total data: " + service.getArsipUtama().size(),
                service.getArsipUtama());
    }

    private void tampilkanDaftar(String heading, DynamicArray<Putusan> data) {
        StringBuilder text = new StringBuilder(heading).append('\n')
                .append("=".repeat(Math.max(heading.length(), 20))).append('\n');
        if (data.isEmpty()) {
            text.append("Tidak ada data.");
        } else {
            for (int i = 0; i < data.size(); i++) {
                text.append(i + 1).append(". ").append(formatPutusan(data.get(i))).append('\n');
            }
        }
        textArea.setText(text.toString());
        textArea.setCaretPosition(0);
    }

    private String formatPutusan(Putusan putusan) {
        return String.format("%s | %s | %s | %s | vonis %d bulan | %.2f gram",
                putusan.getCaseId(),
                putusan.getNomorPerkara(),
                putusan.getTerdakwaKode(),
                putusan.getJenisNarkotika(),
                putusan.getVonisBulan(),
                putusan.getBeratBarangBuktiGram());
    }

    private int parseRequiredInteger(String value, String fieldName) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(fieldName + " harus berupa bilangan bulat.");
        }
    }

    private void runSafely(Runnable action) {
        try {
            action.run();
        } catch (RuntimeException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(),
                    "Operasi gagal", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
