# ADR 001: Implementasi dan Pemilihan Struktur Data Kustom Berbasis Dynamic Array untuk Pengindeksan Arsip Putusan

* **Status:** Diterima & Disetujui 
* **Tanggal:** November 2026

## 1. Konteks & Latar Belakang Masalah
Dalam pengembangan sistem pengarsipan dan pencarian data putusan Pengadilan Negeri (PN Magetan) yang memuat 50 entitas data putusan pengadilan, arsitek perangkat lunak dihadapkan pada kebutuhan penyimpanan data di dalam memori utama (*in-memory storage*). Sistem memerlukan struktur data yang tidak hanya mampu menampung objek entitas hukum secara terstruktur, tetapi juga harus selaras dengan materi inti mata kuliah Struktur Data—khususnya konsep Generics, pengelolaan Array, serta struktur data dinamis (*Dynamic List*) yang dipelajari pada Modul 1 dan Modul 2 di praktikum i-Lab Universitas Muhammadiyah Malang.

Penggunaan struktur data primitif atau *array* statis bawaan Java (`new Putusan[50]`) dinilai memiliki kelemahan fatal, yaitu ukuran yang kaku (*fixed-size*) dan ketidakmampuan untuk mengakomodasi penambahan data secara dinamis apabila di kemudian hari dataset putusan bertambah saat proses impor CSV berkala.

## 2. Keputusan Arsitektur (Architectural Decision)
Diputuskan untuk merancang dan menggunakan kelas struktur data kustom `DynamicArray<Putusan>` yang menerapkan prinsip Generics dan manajemen memori berbasis *Dynamic Array*:
* **Abstraksi Objek Entitas:** Setiap baris data teks dari file `putusan-50.csv` diparsing secara utuh dan dienkapsulasi ke dalam objek berorientasi objek kelas `Putusan`.
* **Alokasi Memori Dinamis (*Dynamic Resizing*):** Struktur `DynamicArray` dirancang untuk mengelola kapasitas internal memori secara otomatis. Ketika jumlah elemen melebihi kapasitas awal, struktur ini melakukan realokasi memori (*array doubling*) di latar belakang tanpa mengganggu integritas data yang sudah tersimpan.
* **Indeksasi Berurutan (*Sequential Indexing*):** Mempertahankan indeks berbasis angka *integer* ($0$ sampai $n-1$) guna mempermudah proses iterasi linear, pengurutan, dan pemanggilan data spesifik secara instan.

## 3. Analisis Konsekuensi & Dampak (Consequences)

### A. Kelebihan (Pros)
* **Kepatuhan Akademis & Kontekstual Modul:** Sangat merefleksikan pemahaman mendalam terhadap materi Modul 1 (Generics Java) dan Modul 2 (Array List & Linked List), menunjukkan bahwa tim pengembang memahami cara kerja internal struktur data alih-alih sekadar menggunakan pustaka instan.
* **Skalabilitas & Fleksibilitas Tinggi:** Sistem menjadi kebal terhadap galat `IndexOutOfBounds` ketika terjadi penambahan data baru secara dinamis melalui antarmuka pengguna (UI).
* **Efisiensi Akses Memori:** Karena berbasis *array* kontigu di dalam memori RAM, akses pembacaan data secara sekuensial memiliki performa yang sangat cepat (*cache locality* yang baik).

### B. Kekurangan & Mitigasi (Cons & Mitigations)
* **Kekurangan:** Operasi pencarian linear (*sequential search*) memiliki kompleksitas waktu terburuk sebesar $O(n)$.
* **Mitigasi:** Mengingat skala dataset proyek ini dibatasi pada 50 data putusan, kompleksitas waktu $O(n)$ tetap menghasilkan waktu eksekusi di bawah 1 milidetik, sehingga tidak memberikan dampak negatif terhadap responsivitas antarmuka aplikasi berbasis Swing.
