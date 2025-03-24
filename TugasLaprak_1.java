// Main Program
public class TugasLaprak_1{
    public static void main(String[] args) {
        // Inisialisasi data
        File_Book.initData();

        // Menampilkan semua kategori dan bukunya
        for (Kategori kategori : File_Book.daftarKategori) {
            kategori.displayKategori();
        }

        // Contoh penggunaan method tambahan
        Buku buku1 = File_Book.daftarKategori[0].daftarBuku[0]; // Ambil buku pertama dari kategori Teknologi
        Buku buku2 = File_Book.daftarKategori[0].daftarBuku[1]; // Ambil buku kedua dari kategori Teknologi

        // Method hitungJumlahKataSinopsis
        System.out.println("Jumlah kata sinopsis buku 1: " + buku1.hitungJumlahKataSinopsis());

        // Method cekTingkatKesamaan
        System.out.println("Tingkat kesamaan antara buku 1 dan buku 2: " + buku1.cekTingkatKesamaan(buku2) + "%");

        // Method copy
        Buku bukuCopy = buku1.copy();
        System.out.println("Salinan buku 1:");
        bukuCopy.displayBuku();

        // Method hitungRoyalti dengan 1 parameter
        double hargaBuku = 100000; // Harga buku Rp 100.000
        System.out.println("Royalti 10% dari penjualan buku 1: Rp " + buku1.hitungRoyalti(hargaBuku));

        // Method hitungRoyalti dengan 2 parameter
        double persenRoyalti = 15; // 15% royalti
        System.out.println("Royalti " + persenRoyalti + "% dari penjualan buku 1: Rp " + buku1.hitungRoyalti(hargaBuku, persenRoyalti));
    }
}