# Dokumentasi Transparansi & Kebijakan Pemanfaatan Asisten AI (AI Usage Policy)

* **Mata Kuliah:** Struktur Data D
* **Proyek:** Sistem Indeks dan Pencarian Data 50 Putusan Pengadilan Negeri (Studi Kasus PN Magetan)
* **Pengembang Utama:** David Agil Firmansyah (NIM: 202510370110122) dan Calvin Satria Ardiansyah Aji Sumarsono (NIM: 202510370110128)
* **Institusi:** Universitas Muhammadiyah Malang

---

## 1. Pernyataan Integritas Akademik & Visi Penggunaan

Dokumen ini disusun sebagai wujud transparansi penuh atas pemanfaatan kecerdasan buatan (*Artificial Intelligence*) dalam siklus hidup pengembangan perangkat lunak (*Software Development Life Cycle* / SDLC) pada tugas besar ini.

Pengembang menegaskan bahwa asisten AI tidak digunakan sebagai alat pengganti proses berpikir (substitusi kognitif), melainkan diposisikan secara proporsional sebagai mitra kolaboratif (*co-pilot* teknis) untuk mempercepat proses *boilerplate*, validasi sintaks, dan penyusunan struktur dokumentasi teknis. Seluruh keputusan arsitektur data, pengujian logika program, mitigasi galat (*debugging*), dan validasi integritas dataset 50 putusan hukum tetap berada di bawah kendali, pemahaman, dan tanggung jawab mutlak pengembang.

---

## 2. Matriks Rincian Pemanfaatan Asisten AI

| Tahapan Pengembangan (SDLC) | Bentuk Bantuan Asisten AI | Batasan & Kontribusi Mandiri Pengembang |
| :--- | :--- | :--- |
| **1. Pengelolaan & Pemetaan Data (Data Provenance)** | Membantu merancang draf skrip otomatisasi berbahasa Python (`generate_provenance.py`) untuk memetakan file PDF putusan ke format `data-provenance.csv`. | Pengembang melakukan verifikasi manual terhadap seluruh *path* direktori Google Drive, struktur kolom CSV, serta validasi jumlah 50 baris data agar akurat sesuai fakta berkas hukum. |
| **2. Perancangan Struktur Direktori & Repositori** | Memberikan rekomendasi standar *best practice* penataan folder proyek (seperti direktori `data/`, `docs/adr/`, dan file konfigurasi pendukung). | Pengembang menyesuaikan tata letak direktori dengan modul spesifik tugas besar universitas dan mengelola kontrol versi Git secara mandiri. |
| **3. Penyusunan Dokumentasi & Standar Penulisan** | Membantu merumuskan kerangka format penulisan file Markdown (`README.md`, `CONTRIBUTIONS.md`, dan *Architecture Decision Records*). | Pengembang menuliskan narasi inti, menyesuaikan identitas akademik secara spesifik, serta memastikan keselarasan informasi dengan kondisi riil pengerjaan. |
| **4. Penyelesaian Kendala Teknis (Debugging)** | Memberikan analisis diagnostik saat terjadi galat *path* direktori di VS Code dan cara mengatasi konfigurasi pemisahan kolom spreadsheet (*Text to Columns*). | Pengembang mengeksekusi solusi, menguji ulang ketepatan sistem, dan memastikan tidak ada kode mentah yang diadopsi tanpa pemahaman logika dasarnya. |

---

## 3. Batasan Etis & Kontrol Kualitas

Guna menjaga kualitas akademik dan bobot profesional proyek, batasan ketat berikut diterapkan selama proses pengerjaan:

1. **Otoritas Logika Inti:** Algoritma pemrosesan struktur data, implementasi kelas Java, serta mekanisme pencarian (*searching/indexing*) dirancang berdasarkan materi perkuliahan dan diimplementasikan secara mandiri.
2. **Validasi Empiris:** Setiap baris kode atau draf dokumentasi yang dihasilkan melalui bantuan AI wajib melalui tahap *peer-review* mandiri, uji coba eksekusi terminal, dan penyesuaian gaya bahasa agar natural serta tidak terdeteksi sebagai artefak otomatis generik yang kaku.
3. **Pertanggungjawaban Ilmiah:** Pengembang siap mempertanggungjawabkan seluruh isi kode program maupun keputusan desain arsitektur yang terlampir di dalam repositori publik GitHub ini dalam sesi evaluasi maupun sidang akademik.
