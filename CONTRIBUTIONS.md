# Dokumentasi Rinci Pembagian Kontribusi & Tanggung Jawab Tim (CONTRIBUTIONS.md)

* **Mata Kuliah:** Struktur Data
* **Proyek:** Sistem Indeks dan Pencarian Data 50 Putusan Pengadilan Negeri (Studi Kasus PN Magetan)
* **Institusi:** Universitas Muhammadiyah Malang

---

## 1. Latar Belakang & Rasionalitas Strategi Pembagian Kerja Tim

Dalam pelaksanaan proyek tugas besar mata kuliah Struktur Data ini, tim pengembang yang beranggotakan **David Agil Firmansyah** (NIM: `202510370110122`) dan **Calvin Satria Ardiansyah Aji Sumarsono** (NIM: `202510370110128`) menerapkan model pembagian kerja fungsional yang terstruktur (*Functional Specialization & Modular Task Delegation*).

Keputusan untuk mendelegasikan penulisan kode dasar/awal struktur data (*base scaffolding*) secara mandiri kepada satu pihak (David Agil Firmansyah), sementara pihak lain (Calvin Satria Ardiansyah Aji Sumarsono) mengambil alih secara penuh pengkodean lanjutan, restrukturisasi total kelas utama (`main`), manajemen indeks data, dan seluruh dokumentasi wajib, didasarkan pada pertimbangan rekayasa perangkat lunak yang matang:

* **Mitigasi Konflik Penulisan (*Merge Conflict & Code Divergence*):** Berdasarkan analisis alur kerja kolaboratif, penulisan kode sumber dasar secara bersamaan dalam siklus awal oleh dua orang dengan gaya penulisan (*coding style*) yang berbeda memiliki risiko tinggi memicu inkonsistensi struktur logika penyimpanan data, tabrakan direktori, dan galat sintaks (*syntax error*) yang berpotensi melumpuhkan progres tenggat waktu (*deadline*).
* **Efisiensi Siklus Hidup Perangkat Lunak (*SDLC Optimization*):** Dengan adanya pembagian yang tegas, tahap awal difokuskan untuk membangun kerangka dasar fungsional (*initial working draft*), yang kemudian langsung dilanjutkan dengan tahap *refactoring*, penyempurnaan antarmuka konsol (UI/UX), validasi dataset hukum 50 putusan PN Magetan, serta pemenuhan seluruh instrumen administratif-teknis penilaian secara komprehensif.
* **Keseimbangan Beban Kerja (*Equitable Workload Distribution*):** Meskipun pembagian kode dasar dilakukan secara terpisah di awal, akumulasi seluruh tugas pengembangan inti lanjutan, perbaikan algoritma, pengelolaan data provenance, pengujian stabilitas, hingga penyusunan seluruh portofolio dokumentasi pendukung dikerjakan secara penuh dan berimbang, sehingga total proporsi kontribusi akhir dipastikan imbang dan setara secara objektif (50% : 50%).

---

## 2. Matriks Rincian Pembagian Peran & Kontribusi Fungsional

### A. David Agil Firmansyah (NIM: 202510370110122) — Kontribusi: 50%
* **Peran Utama:** *Base Scaffolding & Initial Code Architecture Developer*
* **Rincian Tugas & Aktivitas yang Dikerjakan:**
  * Melakukan inisialisasi awal repositori lokal dan menghubungkannya dengan kontrol versi Git di platform GitHub.
  * Merancang struktur direktori dasar proyek (folder `src/`, konfigurasi Maven `pom.xml`, dan penentuan *ignore files* dasar).
  * Menuliskan kerangka kode sumber dasar (*base code*) dalam bahasa Java yang mencakup struktur kelas fundamental untuk membaca baris data teks dan menampung objek putusan di tahap awal.
  * Melakukan uji coba kompilasi sintaks awal (*initial syntax compilation*) guna memastikan lingkungan pengembangan lokal dapat mengeksekusi berkas Java tanpa kendala kompiler utama.
  * Menyediakan fondasi logika mentah yang menjadi acuan dasar bagi pengembangan modul pencarian dan pemrosesan data selanjutnya.

### B. Calvin Satria Ardiansyah Aji Sumarsono (NIM: 202510370110128) — Kontribusi: 50%
* **Peran Utama:** *Core Refinement, UI/UX Enhancer, Data Curator & Documentation Lead*
* **Rincian Tugas & Aktivitas yang Dikerjakan:**
  * **Restrukturisasi & Perombakan Total Kelas Utama (*Main Class Refactoring*):**
    * Mengambil alih kode dasar yang telah tersedia, lalu melakukan evaluasi mendalam dan perombakan total pada struktur kelas utama (`Main`).
    * Mengoptimalkan implementasi struktur data untuk proses pengindeksan dan pencarian (*searching/indexing*) dari 50 data putusan agar berjalan efisien.
    * Mengubah alur interaksi pengguna di terminal agar lebih interaktif, rapi, dan memiliki standar antarmuka (UI/UX) konsol yang nyaman digunakan.
    * Mengoptimalkan algoritma pemanggilan data, penanganan eksepsi (*exception handling*), serta pembersihan memori saat program melakukan operasi pencarian kata kunci.
  * **Kurasi & Manajemen Dataset Hukum (Studi Kasus PN Magetan):**
    * Menentukan arah studi kasus nyata menggunakan 50 dokumen putusan resmi dari Pengadilan Negeri (PN Magetan).
    * Melakukan pembersihan data (*data cleaning*) pada format CSV utama (`data/putusan-50.csv`) agar struktur kolom baris terindeks secara presisi.
    * Mengelola pemetaan direktori *cloud* Google Drive dan menyusun file pelacak metadata sumber (`docs/data-provenance.csv`).
  * **Penyusunan Seluruh Portofolio Dokumentasi Wajib Penilaian:**
    * Merancang dan menyusun file dokumentasi utama (`README.md`) yang memuat identitas lengkap pengembang (NIM: 202510370110128), struktur direktori, prasyarat sistem, hingga panduan *build, test, and run*.
    * Menuliskan dokumen arsitektur sistem (*Architecture Decision Records* / ADR di folder `docs/adr/`) yang memuat catatan keputusan pemilihan struktur data dan strategi pencarian efisien.
    * Menyusun file transparansi kebijakan kecerdasan buatan (`docs/AI_USAGE.md`) secara rinci, profesional, dan akademik.
    * Menyusun draf catatan kontribusi ini (`docs/CONTRIBUTIONS.md`) guna mendokumentasikan dinamika kolaborasi tim secara transparan.
  * **Pengujian Integrasi & Kontrol Kualitas Akhir (*Quality Assurance*):**
    * Melakukan serangkaian pengujian fungsional secara berkala terhadap seluruh fitur pencarian di terminal untuk memastikan tidak ada *bug* atau *null pointer exception*.
    * Memastikan seluruh dokumen dan kode tersinkronisasi dengan sempurna ke dalam repositori publik GitHub sebelum batas waktu pengumpulan tugas besar.

---

## 3. Riwayat Tautan Aktivitas & Kontribusi Git (GitHub Activity Log)

Berikut adalah rekam jejak tautan spesifik (*direct link*) ke aktivitas *commit, pull request, code review*, dan *issue* pada repositori publik GitHub:

| Pengembang | Jenis Aktivitas | Deskripsi Aktivitas | Tautan Spesifik Aktivitas GitHub |
| :--- | :--- | :--- | :--- |
| **David Agil Firmansyah** | Commit Utama (*Base Scaffolding*) | Inisialisasi awal repositori, konfigurasi Maven (`pom.xml`), dan penulisan struktur kode dasar Java. | [Lihat Commit Dasar](https://github.com/sheeper494-beep/Tugas_struktur_data/commits) |
| **Calvin Satria Ardiansyah** | Commit Utama (*Refactoring & UI/UX*) | Perombakan total kelas `Main`, optimalisasi logika pencarian struktur data, dan perapian interaksi konsol. | [Lihat Commit Utama](https://github.com/sheeper494-beep/Tugas_struktur_data/commits) |
| **Tim Kolaborasi** | Pull Request & Review | Pengajuan PR integrasi kode dasar dengan hasil perombakan lanjutan, disertai catatan review kode. | [Lihat Pull Request & Review](https://github.com/sheeper494-beep/Tugas_struktur_data/pulls) |
| **Tim Kolaborasi** | Issue Tracking | Pelacakan kendala struktur direktori file CSV, pemetaan *path*, dan koordinasi penyelesaian tugas. | [Lihat Isu Terlacak (Issue)](https://github.com/sheeper494-beep/Tugas_struktur_data/issues) |

---

## 4. Pernyataan Penutup & Validasi Tim

Seluruh rangkaian proses pengembangan, baik dari tahap penulisan kode dasar oleh David Agil Firmansyah maupun perombakan total, pengelolaan struktur data, dan dokumentasi lengkap oleh Calvin Satria Ardiansyah Aji Sumarsono, telah melalui proses diskusi intensif, evaluasi bersama, dan pembagian porsi kerja yang adil (**50% : 50%**). Masing-masing pengembang memahami secara utuh keseluruhan isi kode program dan siap mempertanggungjawabkannya dalam sesi evaluasi akademik.
