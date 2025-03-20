# **JANJI**
 Saya Abdurrahman Rauf Budiman dengan NIM 2301102 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# **Desain Program**
Pada Tugas Praktikum ke 4 kali ini yaitu mencoba untuk membuat aplikasi GUI menggunakan Intellij IDEA (Community Version) dengan bahasa Java Swing. Berikut desain dan komponen utamanya pada program ini:

### **1) Struktur GUI**
Aplikasi ini menggunakan Java Swing dengan tampilan utama berupa JFrame yang berfungsi sebagai jendela utama. Isinya seperti:
- Ukuran: 1024x768 (Ukuran windownya dibesarkan supaya lebih jelas dan kelihatan semua datanya)
- Warna latar: Hijau tua (Hijau tua meresemblance dengan KEMAKOM)
- Konten Pane Utama: mainPanel

Lalu ada yang namanya mainPanel. Nah mainPanel ini berfungsi sebagai wadah utama untuk semua komponen GUI. Panel ini berisi form input, tabel data, serta tombol aksi yang digunakan untuk mengelola data mahasiswa.

### **2) Komponen GUI:**
| Komponen       | Deskripsi                              |
|----------------|----------------------------------------|
| `JTextField nimField`  | Input NIM                  |
| `JTextField namaField`        | Input Nama     |
| `JComboBox jenisKelaminComboBox	`        | Pilihan jenis kelamin   |
| `JTextField prodiField	`        | Input prodi (radio button)                        |
| `JRadioButton ilmuKomputerRadioButton	`        | Pilihan prodi: Ilmu Komputer    |
| `JRadioButton pendidikanIlmuKomputerRadioButton	`         | Pilihan prodi: Pendidikan Ilmu Komputer                      |

### **3) Tabel Mahasiswa**
Lalu isi atribut pada class mahasiswa diantaranya adalah:
- nim
- nama
- jenis kelamin
- prodi (atribut tambahan sesuai spesifikasi)

# Alur Program
Untuk Alurnya ialah: 
- User memasukkan data mahasiswa → klik "Add" → data masuk ke tabel.
- User mengklik tabel → data muncul di form → tombol "Add" berubah jadi "Update".
- User mengedit data → klik "Update" → data diperbarui di tabel.
- User menghapus data → klik "Delete" → data dihapus dari tabel.
- User bisa mengosongkan form dengan tombol "Clear"

# Screenshot
Berikut Screenshot halaman utamanya (selebihnya ada di folder Screenshot)
![TampilanDashboard](https://github.com/user-attachments/assets/2174a30b-561b-452f-b552-ec4aa1ac82c8)
