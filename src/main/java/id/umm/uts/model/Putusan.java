package id.umm.uts.model;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Model satu putusan pengadilan narkotika.
 * Atribut mengikuti skema minimum pada panduan UTS Bagian 2.2.
 *
 * Catatan: class ini murni POJO. Tidak menyimpan referensi ke struktur data.
 */
public class Putusan {

    private String caseId;                 // kode unik internal, mis. P001
    private String nomorPerkara;           // nomor perkara asli
    private String pengadilan;             // nama Pengadilan Negeri
    private LocalDate tanggalPutusan;      // tanggal putusan diucapkan
    private String terdakwaKode;           // kode anonim, bukan nama asli
    private String jenisNarkotika;         // jenis zat / daftar zat
    private double beratBarangBuktiGram;   // berat netto (gram)
    private String pasalDakwaan;
    private String pasalTerbukti;
    private int tuntutanBulan;             // tuntutan penjara (bulan)
    private int vonisBulan;                // vonis penjara (bulan)
    private long dendaRupiah;
    private String barangBukti;
    private String keadaanMemberatkan;
    private String keadaanMeringankan;
    private String sourcePages;            // halaman sumber per kelompok atribut

    public Putusan() {
        // konstruktor kosong untuk importer
    }

    public Putusan(String caseId, String nomorPerkara, String pengadilan,
                   LocalDate tanggalPutusan, String terdakwaKode,
                   String jenisNarkotika, double beratBarangBuktiGram,
                   String pasalDakwaan, String pasalTerbukti,
                   int tuntutanBulan, int vonisBulan, long dendaRupiah,
                   String barangBukti, String keadaanMemberatkan,
                   String keadaanMeringankan, String sourcePages) {
        this.caseId = caseId;
        this.nomorPerkara = nomorPerkara;
        this.pengadilan = pengadilan;
        this.tanggalPutusan = tanggalPutusan;
        this.terdakwaKode = terdakwaKode;
        this.jenisNarkotika = jenisNarkotika;
        this.beratBarangBuktiGram = beratBarangBuktiGram;
        this.pasalDakwaan = pasalDakwaan;
        this.pasalTerbukti = pasalTerbukti;
        this.tuntutanBulan = tuntutanBulan;
        this.vonisBulan = vonisBulan;
        this.dendaRupiah = dendaRupiah;
        this.barangBukti = barangBukti;
        this.keadaanMemberatkan = keadaanMemberatkan;
        this.keadaanMeringankan = keadaanMeringankan;
        this.sourcePages = sourcePages;
    }

    // ===== Getter & Setter =====
    public String getCaseId() { return caseId; }
    public void setCaseId(String caseId) { this.caseId = caseId; }

    public String getNomorPerkara() { return nomorPerkara; }
    public void setNomorPerkara(String nomorPerkara) { this.nomorPerkara = nomorPerkara; }

    public String getPengadilan() { return pengadilan; }
    public void setPengadilan(String pengadilan) { this.pengadilan = pengadilan; }

    public LocalDate getTanggalPutusan() { return tanggalPutusan; }
    public void setTanggalPutusan(LocalDate tanggalPutusan) { this.tanggalPutusan = tanggalPutusan; }

    public String getTerdakwaKode() { return terdakwaKode; }
    public void setTerdakwaKode(String terdakwaKode) { this.terdakwaKode = terdakwaKode; }

    public String getJenisNarkotika() { return jenisNarkotika; }
    public void setJenisNarkotika(String jenisNarkotika) { this.jenisNarkotika = jenisNarkotika; }

    public double getBeratBarangBuktiGram() { return beratBarangBuktiGram; }
    public void setBeratBarangBuktiGram(double beratBarangBuktiGram) { this.beratBarangBuktiGram = beratBarangBuktiGram; }

    public String getPasalDakwaan() { return pasalDakwaan; }
    public void setPasalDakwaan(String pasalDakwaan) { this.pasalDakwaan = pasalDakwaan; }

    public String getPasalTerbukti() { return pasalTerbukti; }
    public void setPasalTerbukti(String pasalTerbukti) { this.pasalTerbukti = pasalTerbukti; }

    public int getTuntutanBulan() { return tuntutanBulan; }
    public void setTuntutanBulan(int tuntutanBulan) { this.tuntutanBulan = tuntutanBulan; }

    public int getVonisBulan() { return vonisBulan; }
    public void setVonisBulan(int vonisBulan) { this.vonisBulan = vonisBulan; }

    public long getDendaRupiah() { return dendaRupiah; }
    public void setDendaRupiah(long dendaRupiah) { this.dendaRupiah = dendaRupiah; }

    public String getBarangBukti() { return barangBukti; }
    public void setBarangBukti(String barangBukti) { this.barangBukti = barangBukti; }

    public String getKeadaanMemberatkan() { return keadaanMemberatkan; }
    public void setKeadaanMemberatkan(String keadaanMemberatkan) { this.keadaanMemberatkan = keadaanMemberatkan; }

    public String getKeadaanMeringankan() { return keadaanMeringankan; }
    public void setKeadaanMeringankan(String keadaanMeringankan) { this.keadaanMeringankan = keadaanMeringankan; }

    public String getSourcePages() { return sourcePages; }
    public void setSourcePages(String sourcePages) { this.sourcePages = sourcePages; }

    /** Dua putusan dianggap sama jika caseId-nya sama (identitas unik internal). */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Putusan)) return false;
        Putusan p = (Putusan) o;
        return Objects.equals(caseId, p.caseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(caseId);
    }

    /** Ringkasan satu baris untuk tampilan CLI. */
    public String ringkas() {
        return String.format("%s | %s | %s | vonis=%d bln | denda=Rp%,d",
                caseId, nomorPerkara, jenisNarkotika, vonisBulan, dendaRupiah);
    }

    @Override
    public String toString() {
        return "Putusan{" + ringkas() + "}";
    }
}