package id.umm.uts.io;

import id.umm.uts.ds.DynamicArray;
import id.umm.uts.model.Putusan;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class CsvExporter {

    private static final String HEADER =
            "id,nomor_perkara,tanggal_putus,nama_terdakwa,klasifikasi,pasal,vonis,barang_bukti,"
                    + "vonis_bulan,berat_gram";

    private CsvExporter() {
    }

    public static void exportCsv(DynamicArray<Putusan> data, String filePath) {
        try (BufferedWriter writer = Files.newBufferedWriter(Path.of(filePath))) {
            writer.write(HEADER);
            writer.newLine();

            for (int i = 0; i < data.size(); i++) {
                Putusan putusan = data.get(i);
                List<String> columns = new ArrayList<>(10);
                columns.add(removeCaseIdPrefix(putusan.getCaseId()));
                columns.add(putusan.getNomorPerkara());
                columns.add(putusan.getTanggalPutusan() == null
                        ? null : putusan.getTanggalPutusan().toString());
                columns.add(putusan.getTerdakwaKode());
                columns.add(putusan.getJenisNarkotika());
                columns.add(putusan.getPasalDakwaan());
                columns.add(putusan.getVonisBulan() + " bulan");
                columns.add(putusan.getBarangBukti());
                columns.add(Integer.toString(putusan.getVonisBulan()));
                columns.add(Double.toString(putusan.getBeratBarangBuktiGram()));

                for (int column = 0; column < columns.size(); column++) {
                    if (column > 0) {
                        writer.write(',');
                    }
                    writer.write(escape(columns.get(column)));
                }
                writer.newLine();
            }
        } catch (IOException e) {
            throw new UncheckedIOException("Gagal menulis file CSV: " + filePath, e);
        }
    }

    private static String removeCaseIdPrefix(String caseId) {
        if (caseId != null && caseId.startsWith("P")) {
            return caseId.substring(1);
        }
        return caseId;
    }

    private static String escape(String value) {
        if (value == null) {
            return "";
        }
        if (value.indexOf(',') >= 0 || value.indexOf('"') >= 0
                || value.indexOf('\n') >= 0 || value.indexOf('\r') >= 0) {
            return '"' + value.replace("\"", "\"\"") + '"';
        }
        return value;
    }
}
