import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Menu extends JFrame{
    public static void main(String[] args) {
        // buat object window
        Menu window = new Menu();

        // atur ukuran window
        window.setSize(1024,768);

        // letakkan window di tengah layar
        window.setLocationRelativeTo(null);

        // isi window
        window.setContentPane(window.mainPanel);

        // ubah warna background
        window.getContentPane().setBackground(new Color(0, 60, 0));

        window.setForeground(Color.white);

        // tampilkan window
        window.setVisible(true);

        // agar program ikut berhenti saat window diclose
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    // index baris yang diklik
    private int selectedIndex = -1;
    // list untuk menampung semua mahasiswa
    private ArrayList<Mahasiswa> listMahasiswa;

    private JPanel mainPanel;
    private JTextField nimField;
    private JTextField namaField;
    private JTable mahasiswaTable;
    private JButton addUpdateButton;
    private JButton cancelButton;
    private JComboBox jenisKelaminComboBox;
    private JButton deleteButton;
    private JLabel titleLabel;
    private JLabel nimLabel;
    private JLabel namaLabel;
    private JLabel jenisKelaminLabel;
    private JLabel prodiLabel;
    private JRadioButton pendidikanIlmuKomputerRadioButton;
    private JRadioButton ilmuKomputerRadioButton;
    private JTextField prodiField;



    // constructor
    public Menu() {
        // inisialisasi listMahasiswa
        listMahasiswa = new ArrayList<>();

        nimLabel.setForeground(Color.white);
        namaLabel.setForeground(Color.white);
        jenisKelaminLabel.setForeground(Color.white);
        prodiLabel.setForeground(Color.white);

        // isi listMahasiswa
        populateList();
        //asdsda
        // isi tabel mahasiswa
        mahasiswaTable.setModel(setTable());

        // ubah styling title
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20f));
        titleLabel.setForeground(Color.white);

        // atur isi combo box
        String[] jenisKelaminData = {"", "Laki-Laki", "Perempuan"};
        jenisKelaminComboBox.setModel(new DefaultComboBoxModel(jenisKelaminData));

        ButtonGroup prodiGroup = new ButtonGroup();
        prodiGroup.add(ilmuKomputerRadioButton);
        prodiGroup.add(pendidikanIlmuKomputerRadioButton);
        prodiGroup.clearSelection();

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // saat tombol add/update ditekan
        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex == -1)
                {
                    insertData();
                }
                else
                {
                    updateData();
                }
            }
        });
        // saat tombol delete ditekan
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedIndex >= 0) {
                    int confirm = JOptionPane.showConfirmDialog(
                            null,
                            "Apakah Anda yakin ingin menghapus data ini?",
                            "Konfirmasi Hapus",
                            JOptionPane.YES_NO_OPTION
                    );

                    if (confirm == JOptionPane.YES_OPTION) {
                        deleteData();
                    }
                }
            }
        });
        // saat tombol cancel ditekan
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
        // saat salah satu baris tabel ditekan
        mahasiswaTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // ubah selectedIndex menjadi baris tabel yang diklik
                selectedIndex = mahasiswaTable.getSelectedRow();

                // simpan value textfield dan combo box
                String selectedNim = mahasiswaTable.getModel().getValueAt(selectedIndex, 1).toString();
                String selectedNama = mahasiswaTable.getModel().getValueAt(selectedIndex, 2).toString();
                String selectedJenisKelamin = mahasiswaTable.getModel().getValueAt(selectedIndex, 3).toString();
                String selectedProdi = mahasiswaTable.getModel().getValueAt(selectedIndex, 4).toString();

                // ubah isi textfield dan combo box
                nimField.setText(selectedNim);
                namaField.setText(selectedNama);
                jenisKelaminComboBox.setSelectedItem(selectedJenisKelamin);
                if (prodiField != null) prodiField.setText(selectedProdi);

                // Ubah isi radio button sesuai data yang dipilih
                if (selectedProdi.equals("Ilmu Komputer")) {
                    ilmuKomputerRadioButton.setSelected(true);
                } else if (selectedProdi.equals("Pendidikan Ilmu Komputer")) {
                    pendidikanIlmuKomputerRadioButton.setSelected(true);
                }

                // ubah button "Add" menjadi "Update"
                addUpdateButton.setText("Update");

                // tampilkan button delete
                deleteButton.setVisible(true);
            }
        });
    }

    public final DefaultTableModel setTable() {
        // tentukan kolom tabel
        Object[] column = {"No", "NIM", "Nama", "Jenis Kelamin", "Prodi"};


        // buat objek tabel dengan kolom yang sudah dibuat
        DefaultTableModel temp = new DefaultTableModel(null, column);

        // isi tabel dengan listMahasiswa
        for (int i = 0; i < listMahasiswa.size(); i++) {
            Object[] row = new Object[5];
            row[0] = i + 1;
            row[1] = listMahasiswa.get(i).getNim();
            row[2] = listMahasiswa.get(i).getNama();
            row[3] = listMahasiswa.get(i).getJenisKelamin();
            row[4] = listMahasiswa.get(i).getProdi();

            temp.addRow(row);
        }

        mahasiswaTable.setModel(temp);

        mahasiswaTable.getColumnModel().getColumn(0).setPreferredWidth(50);
        mahasiswaTable.getColumnModel().getColumn(1).setPreferredWidth(100);
        mahasiswaTable.getColumnModel().getColumn(2).setPreferredWidth(200);
        mahasiswaTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        mahasiswaTable.getColumnModel().getColumn(4).setPreferredWidth(200);

        mahasiswaTable.setFont(new Font("Arial", Font.PLAIN, 14));

        mahasiswaTable.setForeground(Color.BLACK);

        mahasiswaTable.setBackground(Color.LIGHT_GRAY);

        mahasiswaTable.setSelectionBackground(Color.BLUE);
        mahasiswaTable.setSelectionForeground(Color.WHITE);

        mahasiswaTable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 16));

        mahasiswaTable.getTableHeader().setBackground(Color.DARK_GRAY);

        mahasiswaTable.getTableHeader().setForeground(Color.WHITE);

        return temp; // return juga harus diganti
    }

    public void insertData() {
        // ambil value dari textfield dan combobox
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
        String prodi = (prodiField != null) ? prodiField.getText() : "";

        if (ilmuKomputerRadioButton.isSelected()) {
            prodi = "Ilmu Komputer";
        } else if (pendidikanIlmuKomputerRadioButton.isSelected()) {
            prodi = "Pendidikan Ilmu Komputer";
        }

        // tambahkan data ke dalam list
        listMahasiswa.add(new Mahasiswa(nim, nama, jenisKelamin, prodi));

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();


        // feedback
        System.out.println("Insert Berhasil");
        JOptionPane.showMessageDialog(null, "Data berhasil ditambahkan");

    }

    public void updateData() {
        // ambil data dari form
        String nim = nimField.getText();
        String nama = namaField.getText();
        String jenisKelamin = jenisKelaminComboBox.getSelectedItem().toString();
//        String prodi = prodiField.getText();
        String prodi = (prodiField != null) ? prodiField.getText() : "";

        if (ilmuKomputerRadioButton.isSelected()) {
            prodi = "Ilmu Komputer";
        } else if (pendidikanIlmuKomputerRadioButton.isSelected()) {
            prodi = "Pendidikan Ilmu Komputer";
        }

        // ubah data mahasiswa di list
        listMahasiswa.get(selectedIndex).setNim(nim);
        listMahasiswa.get(selectedIndex).setNama(nama);
        listMahasiswa.get(selectedIndex).setJenisKelamin(jenisKelamin);
        listMahasiswa.get(selectedIndex).setProdi(prodi);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Update Berhasil");
        JOptionPane.showMessageDialog(null, "Data berhasil diubah");

    }

    public void deleteData() {
        // hapus data dari list
        listMahasiswa.remove(selectedIndex);

        // update tabel
        mahasiswaTable.setModel(setTable());

        // bersihkan form
        clearForm();

        // feedback
        System.out.println("Delete Berhasil");
        JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

    }

    public void clearForm() {
        // kosongkan semua texfield dan combo box
        nimField.setText("");
        namaField.setText("");
        jenisKelaminComboBox.setSelectedItem("");
//        prodiField.setText("");
        if (prodiField != null) {
            prodiField.setText("");
        }


        // ubah button "Update" menjadi "Add"
        addUpdateButton.setText("Add");

        // sembunyikan button delete
        deleteButton.setVisible(false);

        // ubah selectedIndex menjadi -1 (tidak ada baris yang dipilih)
        selectedIndex = -1;
    }

    private void populateList() {
        listMahasiswa.add(new Mahasiswa("2203999", "Amelia Zalfa Julianti", "Perempuan", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2202292", "Muhammad Iqbal Fadhilah", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2202346", "Muhammad Rifky Afandi", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2210239", "Muhammad Hanif Abdillah", "Laki-laki", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2202046", "Nurainun", "Perempuan", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2205101", "Kelvin Julian Putra", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2200163", "Rifanny Lysara Annastasya", "Perempuan", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2202869", "Revana Faliha Salma", "Perempuan", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2209489", "Rakha Dhifiargo Hariadi", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2203142", "Roshan Syalwan Nurilham", "Laki-laki", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2200311", "Raden Rahman Ismail", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2200978", "Ratu Syahirah Khairunnisa", "Perempuan", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2204509", "Muhammad Fahreza Fauzan", "Laki-laki", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2205027", "Muhammad Rizki Revandi", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2203484", "Arya Aydin Margono", "Laki-laki", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2200481", "Marvel Ravindra Dioputra", "Laki-laki", "Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2209889", "Muhammad Fadlul Hafiizh", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2206697", "Rifa Sania", "Perempuan", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2207260", "Imam Chalish Rafidhul Haque", "Laki-laki", "Pendidikan Ilmu Komputer"));
        listMahasiswa.add(new Mahasiswa("2204343", "Meiva Labibah Putri", "Perempuan", "Ilmu Komputer"));
    }
}
