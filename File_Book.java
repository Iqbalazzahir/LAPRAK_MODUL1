class Buku {
    String judul;
    String[] penulis;
    String kategori;
    String sinopsis;

    // Constructor untuk semua atribut
    public Buku(String judul, String[] penulis, String kategori, String sinopsis) {
        this.judul = judul;
        this.penulis = penulis;
        this.kategori = kategori;
        this.sinopsis = sinopsis;
    }

    // Method untuk menampilkan informasi buku
    void displayBuku() {
        System.out.println("Judul    : " + judul);
        System.out.print("Penulis  : ");
        for (int i = 0; i < penulis.length; i++) {
            System.out.print(penulis[i]);
            if (i < penulis.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("\nKategori : " + kategori);
        System.out.println("Sinopsis : " + sinopsis);
        System.out.println("-------------------------");
    }

    // Method untuk menghitung jumlah kata dalam sinopsis
    int hitungJumlahKataSinopsis() {
        if (sinopsis == null || sinopsis.isEmpty()) {
            return 0;
        }
        String[] kata = sinopsis.split("\\s+"); // Memisahkan kata berdasarkan spasi
        return kata.length;
    }

    // Method untuk mengecek tingkat kesamaan dengan objek lain
    double cekTingkatKesamaan(Buku bukuLain) {
        int kesamaan = 0;
        int totalAtribut = 4; // Judul, penulis, kategori, sinopsis

        if (this.judul.equalsIgnoreCase(bukuLain.judul)) {
            kesamaan++;
        }
        if (String.join(", ", this.penulis).equalsIgnoreCase(String.join(", ", bukuLain.penulis))) {
            kesamaan++;
        }
        if (this.kategori.equalsIgnoreCase(bukuLain.kategori)) {
            kesamaan++;
        }
        if (this.sinopsis.equalsIgnoreCase(bukuLain.sinopsis)) {
            kesamaan++;
        }

        return (kesamaan / (double) totalAtribut) * 100;
    }

    // Method untuk membuat salinan objek
    Buku copy() {
        return new Buku(this.judul, this.penulis, this.kategori, this.sinopsis);
    }

    // Method hitungRoyalti dengan 1 parameter (10% dari penjualan)
    double hitungRoyalti(double hargaBuku) {
        return 0.10 * hargaBuku; // 10% dari harga buku
    }

    // Method hitungRoyalti dengan 2 parameter (persentase custom dari penjualan)
    double hitungRoyalti(double hargaBuku, double persenRoyalti) {
        return (persenRoyalti / 100) * hargaBuku; // Persentase royalti dari harga buku
    }
}

// Entitas Kategori
class Kategori {
    String namaKategori;
    Buku[] daftarBuku;

    // Constructor
    public Kategori(String namaKategori, Buku[] daftarBuku) {
        this.namaKategori = namaKategori;
        this.daftarBuku = daftarBuku;
    }

    // Method untuk menampilkan semua buku dalam kategori
    void displayKategori() {
        System.out.println("\nKategori: " + namaKategori);
        System.out.println("-------------------------");
        for (Buku buku : daftarBuku) {
            buku.displayBuku();
        }
    }
}

// Entitas BukuFile (untuk menyimpan daftar kategori)
class File_Book {
    static Kategori[] daftarKategori;

    // Method untuk menginisialisasi data
    static void initData() {
        // Data buku untuk setiap kategori
        Buku[] teknologiBuku = {
            new Buku("Pengantar Pemrograman Java", new String[]{"David Flanagan"}, "Teknologi", "Buku ini membahas dasar-dasar pemrograman Java."),
            new Buku("Python untuk Pemula", new String[]{"Mark Lutz"}, "Teknologi", "Buku ini memberikan dasar pemrograman Python bagi pemula."),
            new Buku("Penerapan Machine Learning", new String[]{"Sebastian Raschka"}, "Teknologi", "Buku ini membahas penerapan machine learning."),
            new Buku("Prinsip Keamanan Informasi", new String[]{"William Stallings"}, "Teknologi", "Menjelaskan dasar-dasar keamanan informasi."),
            new Buku("Teknologi Blockchain", new String[]{"Andreas Antonopoulos"}, "Teknologi", "Bagaimana teknologi blockchain mengubah industri."),
            new Buku("Pemrograman Java", new String[]{"James Gosling"}, "Teknologi", "Buku ini membahas dasar-dasar pemrograman Java dengan contoh kode yang jelas dan mudah dipahami."),
            new Buku("Artificial Intelligence", new String[]{"Stuart Russell"}, "Teknologi", "Buku ini mengupas konsep kecerdasan buatan dari dasar hingga penerapannya dalam berbagai aspek kehidupan."),
            new Buku("Sistem Operasi", new String[]{"Abraham Silberschatz"}, "Teknologi", "Buku ini menjelaskan konsep dasar sistem operasi mulai dari manajemen memori hingga sistem file."),
            new Buku("Cyber Security Handbook", new String[]{"Bruce Schneier"}, "Teknologi", "Buku panduan ini membahas langkah-langkah untuk melindungi data dari ancaman siber."),
            new Buku("Blockchain Revolution", new String[]{"Don Tapscott"}, "Teknologi", "Buku ini membahas bagaimana teknologi blockchain dapat mengubah industri keuangan, bisnis, dan masyarakat.")
        };
        
        Buku[] filsafatBuku = {
            new Buku("Pemikiran Filsuf Yunani", new String[]{"Bertrand Russell"}, "Filsafat", "Buku ini membahas pemikiran filsuf-filsuf Yunani."),
            new Buku("Pemahaman Eksistensialis", new String[]{"Albert Camus"}, "Filsafat", "Membahas eksistensialisme dalam filsafat."),
            new Buku("Prinsip Etika", new String[]{"Peter Singer"}, "Filsafat", "Buku ini menjelaskan prinsip-prinsip etika."),
            new Buku("Filsafat Asia", new String[]{"Confucius"}, "Filsafat", "Menggali pemikiran filsafat dari Asia."),
            new Buku("Pemikiran Kritis Modern", new String[]{"Friedrich Nietzsche"}, "Filsafat", "Membahas kritik Nietzsche terhadap pemikiran modern."),
            new Buku("Filsafat Ilmu", new String[]{"Jujun S. Suriasumantri"}, "Filsafat", "Buku ini membahas dasar-dasar filsafat ilmu dalam memahami metode ilmiah dan epistemologi."),
            new Buku("Dunia Sophie", new String[]{"Jostein Gaarder"}, "Filsafat", "Novel yang menjelaskan sejarah filsafat dari zaman Yunani kuno hingga modern dengan cara menarik."),
            new Buku("Kritik Akal Murni", new String[]{"Immanuel Kant"}, "Filsafat", "Karya fundamental dalam filsafat yang membahas batasan rasionalitas dan pengalaman manusia."),
            new Buku("Republik", new String[]{"Plato"}, "Filsafat", "Buku yang membahas konsep keadilan, negara ideal, dan peran filsuf dalam pemerintahan."),
            new Buku("Being and Time", new String[]{"Martin Heidegger"}, "Filsafat", "Karya besar Heidegger yang membahas eksistensi manusia dan konsep waktu.")
        };
        
        Buku[] sejarahBuku = {
            new Buku("Peradaban Dunia", new String[]{"Yuval Noah Harari"}, "Sejarah", "Membahas sejarah peradaban manusia."),
            new Buku("Peradaban Islam", new String[]{"Tariq Ramadan"}, "Sejarah", "Buku ini membahas perkembangan Islam."),
            new Buku("Kisah Perang Dunia", new String[]{"Stephen Ambrose"}, "Sejarah", "Menganalisis strategi perang dunia."),
            new Buku("Era Revolusi Industri", new String[]{"Eric Hobsbawm"}, "Sejarah", "Dampak revolusi industri terhadap ekonomi."),
            new Buku("Biografi Napoleon", new String[]{"Andrew Roberts"}, "Sejarah", "Kehidupan dan karier Napoleon Bonaparte."),
            new Buku("Sejarah Peradaban Dunia", new String[]{"Will Durant"}, "Sejarah", "Buku ini menggambarkan perkembangan peradaban manusia dari zaman kuno hingga modern."),
            new Buku("Sejarah Islam", new String[]{"Karen Armstrong"}, "Sejarah", "Buku ini membahas perjalanan Islam dari masa Nabi Muhammad hingga era modern."),
            new Buku("Sejarah Revolusi Industri", new String[]{"Robert Allen"}, "Sejarah", "Buku ini menjelaskan dampak revolusi industri terhadap ekonomi dan masyarakat."),
            new Buku("Napoleon: A Biography", new String[]{"Frank McLynn"}, "Sejarah", "Membahas biografi lengkap tentang kehidupan dan karier militer Napoleon Bonaparte."),
            new Buku("Sejarah Perang Dunia II", new String[]{"Antony Beevor"}, "Sejarah", "Analisis mendalam tentang peristiwa dan strategi dalam Perang Dunia II.")
        };
        
        Buku[] agamaBuku = {
            new Buku("Islam di Era Modern", new String[]{"Hamka"}, "Agama", "Buku ini membahas perkembangan Islam modern."),
            new Buku("Pemahaman Kristiani", new String[]{"C.S. Lewis"}, "Agama", "Penjelasan mendalam tentang ajaran Kristiani."),
            new Buku("Tafsir Bhagavad Gita", new String[]{"Swami Vivekananda"}, "Agama", "Buku tafsir tentang Bhagavad Gita."),
            new Buku("Ajaran Talmud", new String[]{"Adin Steinsaltz"}, "Agama", "Mengenal ajaran dalam kitab Talmud."),
            new Buku("Filosofi Buddha", new String[]{"Dalai Lama"}, "Agama", "Konsep dan ajaran dalam filosofi Buddha."),
            new Buku("Islam dan Sains", new String[]{"Harun Yahya"}, "Agama", "Buku ini membahas hubungan antara Islam dan sains dalam perspektif modern."),
            new Buku("Tafsir Al-Misbah", new String[]{"Quraish Shihab"}, "Agama", "Membahas tafsir Alquran yang menjelaskan ayat-ayat dengan pendekatan kontekstual."),
            new Buku("Buddhism: A Very Short Introduction", new String[]{"Damien Keown"}, "Agama", "Buku ini memberikan pengantar singkat tentang ajaran dan sejarah agama Buddha."),
            new Buku("The Bible", new String[]{"Various Authors"}, "Agama", "Buku suci umat Kristen yang terdiri dari Perjanjian Lama dan Perjanjian Baru."),
            new Buku("Hinduism: Beliefs and Practices", new String[]{"Klaus K. Klostermaier"}, "Agama", "Buku ini membahas tentang ajaran dan praktik dalam agama Hindu.")
        };
        
        Buku[] psikologiBuku = {
            new Buku("Teori Kepribadian", new String[]{"Carl Jung"}, "Psikologi", "Menganalisis berbagai teori kepribadian."),
            new Buku("Dinamika Sosial", new String[]{"Malcolm Gladwell"}, "Psikologi", "Bagaimana interaksi sosial memengaruhi masyarakat."),
            new Buku("Mengelola Emosi", new String[]{"Martin Seligman"}, "Psikologi", "Strategi untuk mengelola emosi dengan baik."),
            new Buku("Dasar Behaviorisme", new String[]{"Ivan Pavlov"}, "Psikologi", "Buku ini menjelaskan konsep behaviorisme."),
            new Buku("Pengembangan Kognitif", new String[]{"Steven Pinker"}, "Psikologi", "Membahas perkembangan kognitif manusia."),
            new Buku("Psikologi Sosial", new String[]{"David Myers"}, "Psikologi", "Buku ini menjelaskan bagaimana manusia berinteraksi dan mempengaruhi satu sama lain."),
            new Buku("The Interpretation of Dreams", new String[]{"Sigmund Freud"}, "Psikologi", "Freud menjelaskan teori tentang makna dan interpretasi mimpi dalam psikoanalisis."),
            new Buku("Thinking, Fast and Slow", new String[]{"Daniel Kahneman"}, "Psikologi", "Buku ini membahas bagaimana manusia berpikir secara intuitif dan rasional."),
            new Buku("The Power of Habit", new String[]{"Charles Duhigg"}, "Psikologi", "Buku ini menjelaskan tentang bagaimana kebiasaan terbentuk dan bagaimana mengubahnya."),
            new Buku("Drive", new String[]{"Daniel Pink"}, "Psikologi", "Buku ini mengungkap motivasi manusia dan faktor yang mendorong kesuksesan.")
        };
        
        Buku[] politikBuku = {
            new Buku("Sistem Demokrasi", new String[]{"Alexis de Tocqueville"}, "Politik", "Menganalisis sistem demokrasi di dunia."),
            new Buku("Seni Strategi Politik", new String[]{"Sun Tzu"}, "Politik", "Strategi dalam dunia politik."),
            new Buku("Tatanan Dunia", new String[]{"Henry Kissinger"}, "Politik", "Buku ini membahas tatanan politik dunia."),
            new Buku("Teori Politik Kritis", new String[]{"Noam Chomsky"}, "Politik", "Buku ini menganalisis teori politik kritis."),
            new Buku("Perubahan Sosial", new String[]{"Antonio Gramsci"}, "Politik", "Perubahan sosial dalam politik global."),
            new Buku("Das Kapital", new String[]{"Karl Marx"}, "Politik", "Buku ini mengupas tentang teori ekonomi politik dari perspektif Marxis."),
            new Buku("The Prince", new String[]{"Niccolò Machiavelli"}, "Politik", "Buku ini membahas panduan klasik tentang kekuasaan dan strategi politik."),
            new Buku("Democracy in America", new String[]{"Alexis de Tocqueville"}, "Politik", "Membahas analisis mendalam tentang demokrasi di Amerika pada abad ke-19."),
            new Buku("The Republic", new String[]{"Plato"}, "Politik", "Membahas diskusi tentang negara ideal dan keadilan dalam filsafat politik."),
            new Buku("The Communist Manifesto", new String[]{"Karl Marx & Friedrich Engels"}, "Politik", "Buku ini menceritakan tentang dokumen fundamental dalam gerakan sosialis dan komunis.")
        };
        
        Buku[] fiksiBuku = {
            new Buku("Sekolah Sihir", new String[]{"Neil Gaiman"}, "Fiksi", "Cerita fantasi tentang dunia sihir."),
            new Buku("Petualangan Fantasi", new String[]{"George R.R. Martin"}, "Fiksi", "Kisah petualangan dalam dunia fantasi."),
            new Buku("Ekspedisi Ruang Angkasa", new String[]{"Isaac Asimov"}, "Fiksi", "Cerita tentang eksplorasi luar angkasa."),
            new Buku("Kisah Detektif", new String[]{"Agatha Christie"}, "Fiksi", "Novel misteri yang penuh intrik."),
            new Buku("Masa Depan Distopia", new String[]{"Margaret Atwood"}, "Fiksi", "Membahas dunia dystopian di masa depan."),
            new Buku("To Kill a Mockingbird", new String[]{"Harper Lee"}, "Fiksi", "Novel klasik yang mengangkat isu rasial dan keadilan di Amerika."),
            new Buku("The Great Gatsby", new String[]{"F. Scott Fitzgerald"}, "Fiksi", "Novel ini membahas tentang impian Amerika dan kehidupan sosial tahun 1920-an."),
            new Buku("Pride and Prejudice", new String[]{"Jane Austen"}, "Fiksi", "Menceritakan kisah romantis yang menggambarkan kehidupan masyarakat Inggris abad ke-19."),
            new Buku("Moby-Dick", new String[]{"Herman Melville"}, "Fiksi", "Sebuah novel petualangan tentang perburuan paus raksasa oleh Kapten Ahab."),
            new Buku("War and Peace", new String[]{"Leo Tolstoy"}, "Fiksi", "Mengisahkan epos sejarah yang menggambarkan Rusia pada masa Perang Napoleon.")
        };
        
        // Data kategori
        daftarKategori = new Kategori[]{
            new Kategori("Teknologi", teknologiBuku),
            new Kategori("Filsafat", filsafatBuku),
            new Kategori("Sejarah", sejarahBuku),
            new Kategori("Agama", agamaBuku),
            new Kategori("Psikologi", psikologiBuku),
            new Kategori("Politik", politikBuku),
            new Kategori("Fiksi", fiksiBuku)
        };
    }
}