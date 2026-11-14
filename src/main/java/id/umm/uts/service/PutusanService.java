package id.umm.uts.service;

import id.umm.uts.ds.AuditStack;
import id.umm.uts.ds.DynamicArray;
import id.umm.uts.model.Putusan;

public class PutusanService {

    private final DynamicArray<Putusan> arsipUtama;
    private final AuditStack<String> riwayatAudit;
    private int lastSearchSteps;

    public PutusanService() {
        arsipUtama = new DynamicArray<>();
        riwayatAudit = new AuditStack<>();
    }

    public DynamicArray<Putusan> getArsipUtama() {
        return arsipUtama;
    }

    public void tampilSemua() {
        if (arsipUtama.isEmpty()) {
            System.out.println("Arsip masih kosong.");
            return;
        }
        for (int i = 0; i < arsipUtama.size(); i++) {
            System.out.println((i + 1) + ". " + arsipUtama.get(i).ringkas());
        }
    }

    public void tambahPutusan(Putusan p) {
        arsipUtama.add(p);
        riwayatAudit.add("Tambah putusan: " + p.getCaseId());
    }

    public void hapusPutusan(int index) {
        Putusan removed = arsipUtama.remove(index);
        riwayatAudit.add("Hapus putusan: " + removed.getCaseId());
    }

    public Putusan cariBerdasarkanCaseId(String caseId) {
        int steps = 0;
        lastSearchSteps = 0;
        for (int i = 0; i < arsipUtama.size(); i++) {
            steps++;
            Putusan putusan = arsipUtama.get(i);
            String currentCaseId = putusan.getCaseId();
            if (caseId == null ? currentCaseId == null : caseId.equals(currentCaseId)) {
                lastSearchSteps = steps;
                riwayatAudit.add("Cari caseId " + caseId + ": ditemukan");
                System.out.println("Pencarian caseId " + caseId + " membutuhkan " + steps + " langkah.");
                return putusan;
            }
        }
        lastSearchSteps = steps;
        riwayatAudit.add("Cari caseId " + caseId + ": tidak ditemukan");
        System.out.println("Pencarian caseId " + caseId + " membutuhkan " + steps + " langkah; data tidak ditemukan.");
        return null;
    }

    public int getLastSearchSteps() {
        return lastSearchSteps;
    }

    public DynamicArray<Putusan> filterGabungan(
            String jenisNarkotika,
            double minBerat,
            double maxBerat,
            int minVonis,
            int maxVonis) {
        DynamicArray<Putusan> hasil = new DynamicArray<>();
        boolean filterJenis = jenisNarkotika != null && !jenisNarkotika.trim().isEmpty();

        for (int i = 0; i < arsipUtama.size(); i++) {
            Putusan putusan = arsipUtama.get(i);
            if (filterJenis && (putusan.getJenisNarkotika() == null
                    || !jenisNarkotika.equalsIgnoreCase(putusan.getJenisNarkotika()))) {
                continue;
            }
            double berat = putusan.getBeratBarangBuktiGram();
            if (minBerat != 0 && berat < minBerat) {
                continue;
            }
            if (maxBerat != 0 && berat > maxBerat) {
                continue;
            }
            int vonis = putusan.getVonisBulan();
            if (minVonis != 0 && vonis < minVonis) {
                continue;
            }
            if (maxVonis != 0 && vonis > maxVonis) {
                continue;
            }
            hasil.add(putusan);
        }
        riwayatAudit.add("Filter putusan: jenis="
                + (jenisNarkotika == null || jenisNarkotika.isBlank() ? "semua" : jenisNarkotika)
                + ", vonis=" + minVonis + "-" + maxVonis
                + ", hasil=" + hasil.size());
        return hasil;
    }

    public void tampilkanAgregasi() {
        System.out.println(ringkasanAgregasi());
    }

    public String ringkasanAgregasi() {
        int totalPerkara = arsipUtama.size();
        long totalVonis = 0;
        long totalDenda = 0;
        String[] jenis = new String[totalPerkara];
        int[] frekuensi = new int[totalPerkara];
        int jumlahJenis = 0;

        for (int i = 0; i < totalPerkara; i++) {
            Putusan putusan = arsipUtama.get(i);
            totalVonis += putusan.getVonisBulan();
            totalDenda += putusan.getDendaRupiah();

            String namaJenis = putusan.getJenisNarkotika();
            int indexJenis = 0;
            while (indexJenis < jumlahJenis
                    && !(namaJenis == null
                    ? jenis[indexJenis] == null
                    : namaJenis.equals(jenis[indexJenis]))) {
                indexJenis++;
            }
            if (indexJenis == jumlahJenis) {
                jenis[jumlahJenis] = namaJenis;
                jumlahJenis++;
            }
            frekuensi[indexJenis]++;
        }

        double rataRataVonis = totalPerkara == 0 ? 0.0 : (double) totalVonis / totalPerkara;
        StringBuilder output = new StringBuilder();
        output.append("Total perkara: ").append(totalPerkara)
                .append("\nRata-rata vonis: ").append(rataRataVonis).append(" bulan")
                .append("\nTotal denda: Rp").append(totalDenda)
                .append("\nDistribusi jenis narkotika:");
        if (jumlahJenis == 0) {
            output.append("\n- Tidak ada data");
        }
        for (int i = 0; i < jumlahJenis; i++) {
            String nama = jenis[i] == null || jenis[i].isEmpty() ? "Tidak diketahui" : jenis[i];
            output.append("\n- ").append(nama).append(": ").append(frekuensi[i]);
        }
        return output.toString();
    }

    public void urutkanBerdasarkanVonis() {
        for (int i = 1; i < arsipUtama.size(); i++) {
            Putusan current = arsipUtama.get(i);
            int j = i - 1;
            while (j >= 0 && arsipUtama.get(j).getVonisBulan() > current.getVonisBulan()) {
                arsipUtama.set(j + 1, arsipUtama.get(j));
                j--;
            }
            arsipUtama.set(j + 1, current);
        }
        riwayatAudit.add("Urutkan putusan berdasarkan vonis");
    }

    public void tampilkanRiwayatAudit() {
        System.out.println(ringkasanRiwayatAudit());
    }

    public String ringkasanRiwayatAudit() {
        if (riwayatAudit.isEmpty()) {
            return "Riwayat audit masih kosong.";
        }
        StringBuilder output = new StringBuilder("Riwayat audit (terlama ke terbaru):");
        for (int i = riwayatAudit.size() - 1; i >= 0; i--) {
            output.append("\n- ").append(riwayatAudit.getFromTop(i));
        }
        return output.toString();
    }
}
