package id.umm.uts.io;

import id.umm.uts.ds.DynamicArray;
import id.umm.uts.model.Putusan;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class CsvImporter {

    public static DynamicArray<Putusan> importCsv(String filePath) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();
        int skipCount = 0;

        // Formatter untuk tanggal bahasa Indonesia (contoh: 30 Agustus 2022)
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("id", "ID"));

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            boolean isFirstLine = true;

            while ((line = br.readLine()) != null) {
                // Lewati header
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                // Lewati baris kosong
                if (line.trim().isEmpty()) {
                    continue;
                }

                try {
                    // Regex untuk split koma, TAPI abaikan koma di dalam tanda kutip
                    String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                    // Pastikan minimal ada 10 kolom
                    if (data.length < 10) {
                        skipCount++;
                        continue;
                    }

                    // Bersihkan tanda kutip dan spasi di ujung teks
                    for (int i = 0; i < data.length; i++) {
                        data[i] = data[i].replaceAll("^\"|\"$", "").trim();
                    }

                    Putusan p = new Putusan();

                    // Mapping Kolom sesuai dataset Anda
                    p.setCaseId("P" + data[0]);
                    p.setNomorPerkara(data[1]);

                    // Parsing Tanggal (Anti Gagal)
                    try {
                        p.setTanggalPutusan(LocalDate.parse(data[2], formatter));
                    } catch (Exception e) {
                        p.setTanggalPutusan(LocalDate.now()); // Jika gagal, pakai tanggal hari ini
                    }

                    p.setTerdakwaKode(data[3]);
                    p.setPengadilan("PN Mgt");
                    p.setJenisNarkotika("Sabu"); // Hardcode
                    p.setPasalDakwaan(data[5]);
                    p.setPasalTerbukti(data[5]);
                    p.setBarangBukti(data[7]);

                    // Parsing Angka Vonis & Berat (Anti Gagal & Anti Kosong)
                    try {
                        String vonisStr = data[8].isEmpty() ? "0" : data[8];
                        p.setVonisBulan((int) Double.parseDouble(vonisStr));
                    } catch (Exception e) {
                        p.setVonisBulan(0);
                    }

                    try {
                        String beratStr = data[9].isEmpty() ? "0.0" : data[9].replace(",", ".");
                        p.setBeratBarangBuktiGram(Double.parseDouble(beratStr));
                    } catch (Exception e) {
                        p.setBeratBarangBuktiGram(0.0);
                    }

                    // Atribut default lainnya
                    p.setTuntutanBulan(0);
                    p.setDendaRupiah(0);
                    p.setKeadaanMemberatkan("-");
                    p.setKeadaanMeringankan("-");
                    p.setSourcePages("-");

                    // Masukkan ke DynamicArray
                    hasil.add(p);

                } catch (Exception e) {
                    skipCount++;
                }
            }
        } catch (Exception e) {
            System.err.println("Gagal membuka file: " + e.getMessage());
        }

        System.out.println("=== IMPORT SELESAI ===");
        System.out.println("Berhasil masuk: " + hasil.size() + " data.");
        System.out.println("Gagal/Skip: " + skipCount + " baris.");
        return hasil;
    }
}