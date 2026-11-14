package id.umm.uts;

import id.umm.uts.ds.DynamicArray;
import id.umm.uts.model.Putusan;

import java.time.LocalDate;

public final class DataDummy {

    private DataDummy() {
    }

    public static DynamicArray<Putusan> getData() {
        DynamicArray<Putusan> arsip = new DynamicArray<>(50);

        add(arsip, 1, "130/Pid.Sus/2022/PN Mgt", 2022, 8, 30,
                "AFIF KHOIRUL ANWAR Alias KANCIL Bin DANURI", "pasal 114 ayat (2) UURI No", 60, 8.04,
                "5 (lima) plastik klip yang berisi narkotika jenis shabu berat total bruto 8,04 gram, bungkus rokok gudang garam warna merah, kartu ATM BCA");
        add(arsip, 2, "139/Pid.Sus/2022/PN Mgt", 2022, 8, 18,
                "SRI PARJANTO Alias KAWOK Bin Alm S. PARBAL", "pasal 112 ayat (1) Undang-Undang RI", 48, 0.33,
                "1 (satu) plastik klip bening berisi narkotika jenis shabu dengan berat bruto sekitar 0,33 gram");
        add(arsip, 3, "2/Pid.Sus/2023/PN Mgt", 2023, 2, 22,
                "MUHAMMAD", "pasal 112 ayat (1)", 60, 0.27,
                "1 (satu) plastik klip bening berisi narkotika jenis shabu berat bruto sekitar 0,27 gram");
        add(arsip, 4, "13/Pid.Sus/2023/PN Mgt", 2022, 10, 22,
                "JULIUS ANTONIO Alias JULI Bin SARDI", "Pasal 114 ayat (1) Undang-Undang Nomor 35 Tahun 2009 tentang Narkotika", 63, 0.93,
                "1 bungkus plastik minuman serbuk instan yang di dalamnya terdapat 1 (satu) plastik klip bening berisi shabu berat bruto 0,93 gram");
        add(arsip, 5, "10/Pid.Sus/2023/PN Mgt", 2022, 9, 21,
                "AHMAD QODRI Alias KANCIL Bin TARMIN", "pasal 112 ayat (1) Undang-Undang RI Nomor", 78, 1.4,
                "2 (dua) plastik klip bening berisi narkotika jenis shabu dengan berat bruto sekitar 1,4 gram");
        add(arsip, 6, "12/Pid.Sus/2023/PN Mgt", 2023, 3, 31,
                "Nurgiono Alias Kimcil Bin Giman", "Pasal 25)", 54, 1.01,
                "1 (satu) plastik klip bening berisi narkotika jenis shabu berat bruto 1,01 gram");
        add(arsip, 7, "34/Pid.Sus/2023/PN Mgt", 2022, 11, 29,
                "M. Arif Rahman Als Kirun Bin (Alm) Dalkin", "Pasal 114 Ayat (1) Jo Pasal 132", 84, 0.4,
                "1 (satu) bungkus plastik klip bening berisi narkotika jenis sabu berat bruto sekitar 0,4 gram dan 1 (satu) buah pipet kaca");
        add(arsip, 8, "33/Pid.Sus/2023/PN Mgt", 2023, 5, 17,
                "ANDI SUPARMAN Als UNYIL Bin ANDI", "Pasal 114 Ayat (1) Jo Pasal 132", 84, 0.4,
                "1 (satu) bungkus plastik klip bening berisi narkotika jenis sabu dengan berat bruto sekitar 0,4 gram");
        add(arsip, 9, "64/Pid.Sus/2023/PN Mgt", 2023, 1, 26,
                "Bagus Purnomo Aji Als Boboho Bin Gianto", "pasal 114 ayat (1) Undang-", 0, 0,
                "1 (satu) bungkus rokok kosong merk Gudang garam surya yang di dalamnya terdapat 1 (satu) plastik klip bening berisi serbuk putih");
        add(arsip, 10, "98/Pid.Sus/2023/PN Mgt", 2023, 3, 14,
                "ERSA KURNIAWAN Als.ERA Bin. SLAMET", "Pasal 127 Ayat (1) huruf a", 12, 0,
                "1 (satu) buah tas berwarna hitam bermerk (POLO HUMMER), 2.");
        add(arsip, 11, "8/Pid.Sus/2022/PN Mgt", 2022, 7, 28,
                "Puryanto Alias Dalang Poer Bin Umar Jafar", "pasal 127 ayat (1) huruf a Undang-Undang", 18, 3.27,
                "1 (satu) plastik klip berisi narkotika jenis sabu berat bruto 3,27 gram dan berat netto 3,09 gram");
        add(arsip, 12, "132/Pid.Sus/2023/PN Mgt", 2023, 5, 27,
                "SUMARSIH Binti Alm SUKIMUN", "Pasal 127", 18, 0.5,
                "1 (satu) plastik klip bening berisi narkotika jenis sabu dengan berat bruto sekitar 0,50 gram");
        add(arsip, 13, "134/Pid.Sus/2023/PN Mgt", 2023, 6, 26,
                "Girang Kriswahono Bin Alm Christianto", "Pasal 112 Ayat (1) UU RI Nomor 35 Tahun 2009 tentang Narkotika Jo", 48, 0.49,
                "1 (satu) plastik klip bening yang diduga berisi narkotika jenis sabu berat bruto 0,49 gram");
        add(arsip, 14, "133/Pid.Sus/2023/PN Mgt", 2024, 1, 4,
                "FAISAL KURNIAWAN SANDI Als PACUL Bin", "pasal 114 ayat (1) jo pasal 132 ayat (1) UURI No", 54, 0.7,
                "1 plastik klip bening yang diduga berisi narkotika jenis sabu berat bruto 0,70 gram, 1 bungkus rokok Sampoerna Mild warna putih");
        add(arsip, 15, "142/Pid.Sus/2023/PN Mgt", 2024, 1, 17,
                "SATYA PUTRA DEWANTORO Alias TYA Bin", "pasal 127 ayat (1) huruf a Undang-", 78, 0.51,
                "1 (satu) plastik klip bening berisi narkotika jenis shabu dengan berat bruto sekitar 0,51 gram");
        add(arsip, 16, "159/Pid.Sus/2023/PN Mgt", 2024, 1, 16,
                "Nurul Ngaini Alias lavus Bin (Alm) Ikhsan Udin", "Pasal 112 Ayat (1) UU RI Nomor 35 Tahun 2009 tentang Narkotika Jo", 48, 1.3,
                "1 (satu) buah plastik klip bening berisi narkotika jenis sabu berat bruto ± 1,30 gram");
        add(arsip, 17, "16/Pid/2024/PN Mgt", 2023, 10, 7,
                "WAHYUDIONO Alias CUYEK Bin (Alm) SURAJI", "Pasal 112 Ayat (1) UU RI Nomor 35 Tahun 2009 tentang Narkotika jo", 66, 0.39,
                "1 (satu) plastik klip bening berisi narkotika jenis sabu berat bruto ± 0,39 gram");
        add(arsip, 18, "64/Pid.Sus/2021/PN Mgt", 2021, 2, 15,
                "Gilang Bintang Mahardika Bin Winarno", "pasal 114 ayat (1) jo pasal 132 ayat (1) UURI No", 48, 0.56,
                "1 (satu) plastik klip bening yang diduga berisi narkotika jenis shabu, berat 0,56 gram, 1 lembar tisu warna putih, 1 buah jaket warna hitam, 1 buah HP");
        add(arsip, 19, "134/Pid.Sus/2021/PN Mgt", 2021, 6, 28,
                "Agus Pujiono Alias Peyok Bin Alm Suwolo", "Pasal 112 Ayat (1) Jo Pasal 132 ayat (1) Undang-", 12, 0.41,
                "1 (satu) plastik klip berisi narkotika jenis sabu dengan berat bruto sekitar 0,41 gram");
        add(arsip, 20, "118/Pid.Sus/2021/PN Mgt", 2021, 6, 27,
                "Sujono Bin Sumadi", "pasal 112 ayat (2) Undang-Undang RI Nomor 35 tahun 2009 tentang", 96, 11.36,
                "11,36 (sebelas koma tiga enam) gram sabu yang dibungkus plastik warna putih bening");
        add(arsip, 21, "121/P21/PN", 2021, 5, 6,
                "SLAMET WIDODO Alias KADUT Bin KUSNI", "Pasal 114 Ayat (1)", 84, 0,
                "1 (satu) unit handphone merk Oppo Joy warna putih dengan nomor SIM card");
        add(arsip, 22, "9/Pid.Sus/2022/PN Mgt", 2022, 3, 17,
                "IDA MIFTAQUL HUDA Binti SUWANTO", "Pasal 112 ayat (1)", 54, 0.51,
                "1 (satu) plastik klip bening berisi narkotika jenis sabu berat bruto kurang lebih 0,51 gram, 1 lembar tissue warna putih");
        add(arsip, 23, "123/P21/PN", 2021, 5, 26,
                "BUDI AGUNG NUGROHO Als. BAJEL Bin", "Pasal 114 Ayat (1)", 60, 0,
                "5 (lima) buah handphone merk Samsung dengan nomor IMEI dirampas untuk dimusnahkan");
        add(arsip, 24, "55/Pid.Sus/2024/PN Mgt", 2023, 12, 5,
                "WANCIN ARJULI Alias CORO Bin LOSO", "Pasal 31 ayat (1) Undang-Undang Nomor 35 Tahun 2009 tentang", 12, 1.34,
                "1 (satu) plastik klip bening diduga narkotika jenis sabu berat bruto kurang lebih 1,34 gram");
        add(arsip, 25, "54/Pid.Sus/2024/PN Mgt", 2024, 3, 19,
                "ALDYNNO BIMA PUTRA SYAMSUDIN Alias", "Pasal 112 ayat (1) Undang", 84, 1.35,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto 1,35 gram");
        add(arsip, 26, "67/Pid.Sus/2024/PN Mgt", 2024, 5, 28,
                "Fery Dianto Alias Ndelo Bin Subandi", "pasal 127 Undang-undang Nomor 35 Tahun 2009 tentang Narkotika", 12, 0,
                "1 (satu) buah pipet kaca bening diduga berisi narkotika jenis sabu, 1 (satu) buah alat bong");
        add(arsip, 27, "89/Pid.Sus/2024/PN Mgt", 2024, 6, 2,
                "Agus Riyanto Alias Paito Bin (Alm) Kamsu", "Pasal 112 Ayat (2)", 96, 2.95,
                "1 (satu) buah plastik klip bening berisi narkotika jenis shabu berat bruto 2,95 gram");
        add(arsip, 28, "1/Pid.Sus/2025/PN Mgt", 2024, 8, 19,
                "HARI SURYANTI Binti SUNARI", "Pasal 114 Ayat (2) Undang-Undang RI", 126, 0,
                "1 (satu) kotak brankas kecil");
        add(arsip, 29, "27/Pid.Sus/2025/PN Mgt", 2024, 10, 30,
                "Andik Setiyono Bin Alm Marto Gimin", "pasal 127 ayat (1) huruf a", 0, 0,
                "2 (dua) buah alat bong");
        add(arsip, 30, "28/Pid.Sus/2025/PN Mgt", 2024, 10, 30,
                "Vindi Mayangsukma Als. Kurus Binti Agus", "Pasal 114 Ayat (1) UU Nomor 35 Tentang Narkotika", 60, 0,
                "1 (satu) buah hand phone merk Samsung type A40S warna hitam");
        add(arsip, 31, "15/Pid.Sus/2025/PN Mgt", 2024, 10, 30,
                "Haris Ahmadi Alias Gembor Bin Alm. Ahmad", "Pasal 127 Ayat (1) huruf a Undang-undang RI No", 24, 0.24,
                "1 (satu) buah plastik klip bening berisi narkotika jenis sabu berat bruto ± 0,24 gram");
        add(arsip, 32, "84/Pid.Sus/2025/PN Mgt", 2025, 4, 13,
                "BAGUS SETIAWAN Alias BONENG Bin (Alm)", "Pasal 114 ayat (2) UU RI No", 96, 8.93,
                "1 (satu) plastik klip bening diduga narkotika jenis sabu berat bruto 8,93 gram");
        add(arsip, 33, "5/Pid.Sus/2022/PN Mgt", 2022, 4, 13,
                "Trisa Wahyu Sudama Als. Panut Bin Untung", "pasal 114 ayat (2) jo", 84, 15.42,
                "1 (satu) klip plastik berisi kristal putih yang berisi shabu berat bruto 15,42 gram, berat netto 14,90 gram bertanda X1");
        add(arsip, 34, "81/Pid.Sus/2025/PN Mgt", 2025, 3, 6,
                "AGUS KARYONO Bin (Alm) MARIMIN", "Pasal 114 ayat (1) Undang-Undang RI Nomor 35", 54, 1.59,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto ± 1,59 gram dengan berat netto ± 1,41 gram");
        add(arsip, 35, "91/Pid.Sus/2025/PN Mgt", 2025, 4, 20,
                "STANLEY NICHOLAS BROOMHAM Alias BULE", "Pasal 111 ayat (1) jo Pasal 132 ayat (1) Undang-Undang RI Nomor 35 Tahun 2009", 48, 0.99,
                "1 (satu) buah plastik klip bening berisi tembakau sintetis berat bruto ± 0,99 gram");
        add(arsip, 36, "105/Pid.Sus/2025/PN Mgt", 2025, 5, 15,
                "DARMAWAN Alias CARANG Bin SENO", "Pasal 112 ayat (1) Jo Pasal 132 Undang-Undang Nomor 35 Tahun 2009 tentang", 60, 1.25,
                "1 (satu) plastik klip bening berisi narkotika jenis shabu dengan berat bruto ± 1,25 gram");
        add(arsip, 37, "104/Pid.Sus/2025/PN Mgt", 2025, 6, 5,
                "SAPTONO DWI PRASETIYO ALIAS SAPTO BIN", "Pasal 112 (1) Juncto Pasal 132 ayat (1) Undang-Undang RI Nomor 35 Tahun", 1, 0.6,
                "1 (satu) plastik klip bening berisi narkotika jenis sabu berat bruto ± 0,60 gram, 1 potongan sedotan plastik warna merah");
        add(arsip, 38, "7/Pid.Sus/2026/PN Mgt", 2025, 9, 7,
                "LUKI BASUKI Alias LUKEN/BAKEN Bin (Alm)", "Pasal 165 Ayat (2) KUHAP Pengadilan Negeri Magetan yang", 108, 0,
                "1 (satu) buah alat bong, 1 (satu) buah pipet kaca bening bekas pakai, 1 (satu) buah hand phone merk Samsung Galaxy A11");
        add(arsip, 39, "5/Pid.Sus/2026/PN Mgt", 2025, 9, 7,
                "NARWITO Alias NAR Bin (Alm) MARTO WIYONO", "Pasal 165 ayat (2) KUHAP (Undang-Undang Nomor 20 Tahun 2025), maka", 108, 0.35,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto ± 0,35 gram");
        add(arsip, 40, "8/Pid.Sus/2026/PN Mgt", 2025, 9, 7,
                "HERIYANTO Alias HERI Bin (Alm) TOHERAN", "Pasal 165 Ayat (2) KUHAP Pengadilan Negeri Magetan yang berwenang", 96, 0,
                "1 (satu) buah alat bong");
        add(arsip, 41, "22/Pid.Sus/2026/PN Mgt", 2025, 11, 10,
                "AHMAD BIMANTORO BIN ENDRIYONO", "Pasal 114 ayat (2) Undang-Undang Nomor 35 Tahun", 12, 0.44,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto ± 0,44 gram");
        add(arsip, 42, "21/Pid.Sus/2026/PN Mgt", 2025, 11, 10,
                "MUKTI EKO BUDIARTO BIN YUDI PRASETYO", "Pasal 114 ayat (1) Undang-Undang Nomor 35 Tahun 2009", 24, 0.44,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto ± 0,44 gram");
        add(arsip, 43, "20/Pid.Sus/2026/PN Mgt", 2025, 11, 7,
                "MUHAMMAD FATQUR ROHMAN ALIAS PATOK BIN", "Pasal 114 ayat (1) Undang-Undang Nomor 35 Tahun 2009", 24, 0.44,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto ± 0,44 gram");
        add(arsip, 44, "6/Pid.Sus/2022/PN Mgt", 2019, 2, 1,
                "SRIYATIN Alias ATIN Binti SAUJI", "Pasal 114 ayat (1) Undang-Undang Nomor 35 Tahun 2009 tentang Narkotika", 66, 0,
                "");
        add(arsip, 45, "51/Pid.Sus/2026/PN Mgt", 2026, 2, 24,
                "TRISA WAHYU SUDAMA Alias PANUT Bin", "Pasal 114 ayat (1) Undang-Undang Nomor 35 Tahun 2009", 96, 0.7,
                "1 (satu) buah plastik klip bening diduga narkotika jenis sabu berat bruto ± 0,70 gram");
        add(arsip, 46, "46/Pid.Sus/2022/PN Mgt", 2021, 11, 8,
                "Gunawan Alias Gundul Bin Gudel", "Pasal 112 ayat (1) Undang-", 84, 1.98,
                "1 (satu) buah plastik klip bening berisi narkotika jenis shabu berat bruto kurang lebih 1,98 gram, 1 buah plastik warna hijau");
        add(arsip, 47, "72/Pid.Sus/2022/PN Mgt", 2022, 1, 23,
                "Hafid Slamet Riadi Bin Saimi", "pasal 114 ayat (1) UURI No", 48, 0,
                "3 (tiga) buah pipet kaca, 1 (satu) buah alat hisap (bong), 2 (dua) buah plastik klip bening");
        add(arsip, 48, "91/Pid.Sus/2022/PN Mgt", 2022, 5, 17,
                "Iwan Yanani Alias Pethik Bin (Alm) Udin", "pasal 114 ayat (1) UURI No", 48, 0.38,
                "1 plastik klip bening berisi narkotika dengan berat sekitar 0,38 gram dan bungkus rokok Sampoerna Mild");
        add(arsip, 49, "95/Pid.Sus/2022/PN Mgt", 2022, 9, 27,
                "MINTO ADISAPUTRO Bin Alm SUPARDI", "Pasal 127 Ayat (1) huruf a Undang-Undang Republik", 48, 0.23,
                "1 (satu) plastik klip bening berisi narkotika jenis sabu berat bruto 0,23 gram, 1 (satu) buah alat hisap (BONG)");
        add(arsip, 50, "105/Pid.Sus/2022/PN Mgt", 2022, 6, 1,
                "Endro Purwanto Alias Galiyok Bin Suparno", "pasal 127 ayat (1) huruf a Undang-Undang RI Nomor 35 tahun 2009", 6, 0.33,
                "1 (satu) plastik klip bening berisi narkotika jenis sabu berat bruto sekitar 0,33 gram, 1 bungkus rokok Marlboro");

        return arsip;
    }

    private static void add(
            DynamicArray<Putusan> arsip,
            int id,
            String nomorPerkara,
            int year,
            int month,
            int day,
            String terdakwa,
            String pasal,
            int vonisBulan,
            double beratGram,
            String barangBukti) {
        arsip.add(new Putusan(
                "P" + id,
                nomorPerkara,
                "PN Mgt",
                LocalDate.of(year, month, day),
                terdakwa,
                "Sabu",
                beratGram,
                pasal,
                pasal,
                0,
                vonisBulan,
                0,
                barangBukti,
                "-",
                "-",
                "-"));
    }
}
