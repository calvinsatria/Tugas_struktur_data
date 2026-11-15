# ADR 002: Pemilihan Strategi Pencarian, Pemfilteran, dan Pengurutan Berbasis Algoritma Sekuensial & Komparatif

* **Status:** Diterima & Disetujui 
* **Tanggal:** November 2026

## 1. Konteks & Latar Belakang Masalah
Sistem Arsip Putusan Narkotika dan Perkara Pengadilan memerlukan mekanisme fungsional yang handal agar pengguna (operator/peneliti hukum) dapat mengeksplorasi, menyaring, dan menemukan dokumen putusan tertentu secara cepat dari kumpulan 50 data PN Magetan. Tantangan utamanya adalah bagaimana merancang algoritma pencarian dan pengurutan yang ringan, mudah dirawat (*maintainable*), namun tetap memenuhi kriteria ketat penilaian logika pemrograman terstruktur.

## 2. Keputusan Arsitektur (Architectural Decision)
Diputuskan untuk mengimplementasikan tiga strategi operasional utama yang berjalan secara sinkron pada struktur penyimpanan `DynamicArray`:

1. **Strategi Pencarian Sekuensial Berbasis Atribut (*Sequential ID & Keyword Search*):**
   * Pencarian dilakukan dengan menelusuri elemen `DynamicArray` satu per satu untuk mencocokkan atribut kunci seperti *Case ID* atau nomor perkara dengan normalisasi huruf besar-kecil (*case-insensitive*).
   * Sistem secara otomatis mencatat jejak langkah pencarian (*search steps tracking*) guna memberikan transparansi diagnostik kepada pengguna.
2. **Strategi Pemfilteran Multikondisi (*Compound Filtering Strategy*):**
   * Menggabungkan parameter filter ganda secara simultan—meliputi filter jenis zat/perkara tertentu dan batasan minimal durasi vonis dalam bulan—untuk menyaring data secara presisi tanpa harus mengubah struktur data utama di memori.
3. **Strategi Pengurutan Berbasis Komparasi Nilai (*Comparative Sorting Strategy*):**
   * Menerapkan algoritma *Insertion Sort* internal berbasis perbandingan nilai numerik atribut vonis (`vonisBulan`) secara langsung di dalam struktur `DynamicArray` untuk menyusun ulang urutan tampilan arsip dari durasi hukuman terendah ke tertinggi maupun sebaliknya.

## 3. Analisis Konsekuensi & Dampak (Consequences)

### A. Kelebihan (Pros)
* **Ketepatan Logika & Prediktabilitas:** Algoritma sekuensial dan *Insertion Sort* komparatif sangat mudah diverifikasi kebenarannya, bebas dari *bug pointer* yang kompleks, serta menjamin bahwa tidak ada data putusan yang terlewat saat proses filter dijalankan.
* **Responsivitas Antarmuka Pengguna (GUI Responsiveness):** Dengan jumlah data uji sebanyak 50 entitas, proses iterasi filter dan pengurutan selesai dalam kurun waktu mikrodetik, menciptakan pengalaman pengguna yang mulus pada aplikasi berbasis Java Swing.
* **Transparansi Diagnostik:** Fitur rekam jejak langkah pencarian memperkuat aspek akuntabilitas logika pemrograman sesuai standar evaluasi tugas besar.

### B. Kekurangan & Mitigasi (Cons & Mitigations)
* **Kekurangan:** Pendekatan pencarian sekuensial dan pengurutan berbasis *Insertion Sort* memiliki kompleksitas terburuk $O(n^2)$.
* **Mitigasi:** Pada batasan beban kerja 50 data, kompleksitas $O(n^2)$ hanya memproses beberapa ribu instruksi mikro, yang mana perbedaan performa tersebut sama sekali tidak kasat mata dan berjalan instan bagi pengguna akhir.
