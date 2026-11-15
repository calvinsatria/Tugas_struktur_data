DOKUMENTASI UTAMA PROYEK (README.md)
Aplikasi desktop berbasis Java (Java Swing & FlatLaf) yang dirancang untuk memparsing, mengindeks, memfilter, mengurutkan, dan mencari data secara cepat dari kumpulan 50 dokumen putusan Pengadilan Negeri Magetan (PN Magetan). Proyek ini dikembangkan untuk memenuhi Tugas Besar/UTS mata kuliah Struktur Data di Universitas Muhammadiyah Malang (UMM).
1. Identitas Tim Pengembang
Institusi: Program Studi Informatika, Universitas Muhammadiyah Malang
Mata Kuliah: Struktur Data D
Studi Kasus: Putusan Pengadilan Negeri Magetan (PN Magetan)
Nama Lengkap	NIM	Peran Utama	Proporsi Kontribusi
Calvin Satria Ardiansyah Aji Sumarsono	202510370110128	memutuskan pengadilan negri daerah mana yang dipilih, mengumpulkan semua data, Refactoring Inti, Perbaikan UI/UX, perombakan total bagian main, Kurasi Data & membuat seluruh Dokumentasi Lengkap	50%
David Agil Firmansyah	202510370110122	Perancah code Dasar , Setup Proyek Awal & Arsitektur Inti	50%
2. Struktur Direktori & Pilihan Desain Arsitektur
A. Struktur Direktori Proyek
Tugas_struktur_data/
├── data/
│   └── putusan-50.csv                 # Dataset utama 50 putusan PN Magetan (hasil ekstraksi)
├── docs/
│   ├── adr/
│   │   ├── 001-struktur-data.md       # ADR pemilihan struktur data DynamicArray<Putusan>
│   │   └── 002-strategi-pencarian-pengurutan.md # ADR strategi pencarian sekuensial & Insertion Sort
│   ├── AI_USAGE.md                    # Dokumentasi transparansi penggunaan AI
│   ├── CONTRIBUTIONS.md               # Matriks pembagian kerja (50:50) & rekam jejak GitHub
│   └── data-provenance.csv            # Pelacak metadata sumber dokumen asli (Google Drive)
├── src/
│   ├── main/java/id/umm/uts/
│   │   ├── Main.java                  # Entry point & antarmuka GUI (Java Swing)
│   │   ├── DataDummy.java             # Generator data awal saat inisialisasi
│   │   ├── ds/
│   │   │   └── DynamicArray.java      # Implementasi kustom struktur data Dynamic Array (Generics)
│   │   ├── io/
│   │   │   ├── CsvImporter.java       # Modul pembaca dan parser file CSV ke objek Putusan
│   │   │   └── CsvExporter.java       # Modul ekspor arsip data dari memori ke file CSV
│   │   ├── model/
│   │   │   └── Putusan.java           # Kelas entitas/model objek putusan pengadilan
│   │   └── service/
│   │       └── PutusanService.java    # Logika bisnis: pencarian, filter multikondisi, sorting, agregasi
│   └── test/java/id/umm/uts/          # Unit test untuk pengujian struktur data & layanan
├── pom.xml                            # Konfigurasi build & dependensi Apache Maven
└── README.md                          # Dokumentasi utama proyek
B. Ringkasan Pilihan Desain & Struktur Data
1.Struktur Data Utama (DynamicArray<Putusan>): Mengimplementasikan struktur data Dynamic Array berbasis Generics secara kustom (selaras dengan materi Modul 1 dan Modul 2 praktikum i-Lab UMM). Struktur ini menggantikan array statis dengan mekanisme realokasi memori otomatis (array doubling) sehingga mampu menampung penambahan data dari file CSV secara dinamis tanpa risiko IndexOutOfBounds.
2.Strategi Pencarian & Pengurutan:
Pencarian Sekuensial (Sequential Search): Digunakan untuk mencari entitas spesifik berdasarkan Case ID dengan fitur pelacakan jumlah langkah pencarian (search steps tracking).
Pengurutan Komparatif (Insertion Sort): Diterapkan secara internal untuk mengurutkan arsip putusan berdasarkan durasi vonis hukuman (vonisBulan).
Rincian lengkap pertimbangan teknis dapat dilihat pada folder docs/adr/.
3. Prasyarat Sistem (Prerequisites)
Pastikan perangkat lunak berikut sudah terpasang di sistem operasi Anda sebelum melakukan proses build dan eksekusi:
Java Development Kit (JDK): Versi 17 atau lebih baru (java -version).
Apache Maven: Versi 3.8+ (mvn -version) untuk manajemen dependensi (termasuk tema antarmuka FlatLaf) dan proses kompilasi.
Git: Untuk melakukan cloning repositori.
4. Panduan Build, Test, dan Menjalankan Aplikasi
Buka terminal atau Command Prompt pada direktori utama proyek (Tugas_struktur_data/), lalu jalankan perintah berikut secara berurutan:
A. Clone Repositori
git clone https://github.com/sheeper494-beep/Tugas_struktur_data.git
cd Tugas_struktur_data
B. Cara Build (Kompilasi Proyek)
Gunakan Maven untuk mengunduh seluruh dependensi dan mengompilasi kode sumber Java:
mvn clean compile
C. Cara Test (Menjalankan Pengujian Unit)
Untuk memverifikasi bahwa struktur data DynamicArray, proses parsing CSV, dan logika pencarian/pengurutan berjalan tanpa galat:
mvn test
D. Cara Menjalankan Aplikasi (Run)
Jalankan kelas utama id.umm.uts.Main menggunakan plugin eksekusi Maven:
mvn exec:java -Dexec.mainClass="id.umm.uts.Main"
(Alternatif: Anda juga dapat membuka proyek ini di Visual Studio Code atau IntelliJ IDEA, buka file src/main/java/id/umm/uts/Main.java, lalu klik tombol Run di atas method public static void main(String[] args)).
5. Contoh Perintah & Skenario Penggunaan Aplikasi
Setelah jendela antarmuka Sistem Arsip Putusan Narkotika / Pengadilan terbuka, berikut adalah contoh alur perintah dan skenario pengujian fungsional yang dapat langsung dicoba:
3.Memuat Dataset 50 Putusan PN Magetan (Impor CSV)
Langkah: Klik tombol Impor CSV pada panel navigasi kiri (sidebar).
Target File: Arahkan jendela pemilihan file ke folder proyek: data/putusan-50.csv, lalu klik Open.
Hasil: Sistem akan memparsing seluruh 50 baris data putusan ke dalam DynamicArray<Putusan> dan menampilkan notifikasi "50 data berhasil diimpor." beserta daftar lengkap putusan di layar utama.
4.Pencarian Spesifik Berdasarkan Case ID
Contoh Input: Ketik P01 atau cukup angka 01 (sistem otomatis menormalisasi awalan P) pada kolom teks Case ID: di panel bawah.
Langkah: Klik tombol Cari.
Contoh Output di Layar:
Hasil pencarian:
P01 | 123/Pid.Sus/2024/PN Mgt | Terdakwa A | Sabu-sabu | vonis 48 bulan | 0.45 gram
Langkah pencarian: 1
5.Pemfilteran Multikondisi (Compound Filter)
Contoh Input: Pada dropdown Jenis narkotika:, pilih salah satu kategori yang tersedia (misal: Sabu-sabu atau Semua jenis). Pada kolom Vonis minimum (bulan):, ketik 60 (untuk menyaring perkara dengan hukuman minimal 5 tahun).
Langkah: Klik tombol Filter.
Hasil: Layar akan menampilkan jumlah dan daftar putusan yang memenuhi kedua syarat tersebut secara bersamaan.
6.Pengurutan Data Berdasarkan Durasi Vonis
Langkah: Klik tombol Urutkan Vonis di panel kiri.
Hasil: Algoritma pengurutan internal akan menyusun ulang seluruh elemen di dalam DynamicArray berdasarkan lama masa hukuman (vonisBulan) dan langsung memperbarui tampilan layar secara instan.
7.Ekspor & Pemeriksaan Audit
Klik Agregasi untuk melihat ringkasan statistik data putusan yang sedang dimuat di memori.
Klik Riwayat Audit untuk memeriksa log operasi penambahan, penghapusan, atau perubahan data selama sesi berjalan.
Klik Ekspor CSV untuk menyimpan hasil filter atau pengurutan ke dalam berkas .csv baru.
