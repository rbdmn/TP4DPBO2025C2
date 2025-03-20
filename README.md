# **JANJI**
 Saya Abdurrahman Rauf Budiman dengan NIM 2301102 mengerjakan Tugas Praktikum 4 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

# **Desain Program**
Pada Tugas Praktikum ke 4 kali ini yaitu mencoba untuk membuat aplikasi GUI menggunakan Intellij IDEA (Community Version) dengan bahasa Java Swing. Berikut desain dan komponen utamanya pada program ini:

### **Struktur GUI**
Aplikasi ini menggunakan Java Swing dengan tampilan utama berupa JFrame yang berfungsi sebagai jendela utama. Isinya seperti:
- Ukuran: 1024x768 (Ukuran windownya dibesarkan supaya lebih jelas dan kelihatan semua datanya)
- Warna latar: Hijau tua (Hijau tua meresemblance dengan KEMAKOM)
- Konten Pane Utama: mainPanel

Lalu ada yang namanya mainPanel. Nah mainPanel ini berfungsi sebagai wadah utama untuk semua komponen GUI. Panel ini berisi form input, tabel data, serta tombol aksi yang digunakan untuk mengelola data mahasiswa.

### **Atribut:**
| Komponen       | Deskripsi                              |
|----------------|----------------------------------------|
| `JTextField nimField`  | Input NIM                  |
| `JTextField namaField`        | Input Nama     |
| `JComboBox jenisKelaminComboBox	`        | Pilihan jenis kelamin   |
| `JTextField prodiField	`        | Pilihan prodi: Ilmu Komputer                        |
| `JRadioButton ilmuKomputerRadioButton	`        | Pilihan prodi: Pendidikan Ilmu Komputer    |
| `JRadioButton pendidikanIlmuKomputerRadioButton	`         | Merk dari baju                      |
