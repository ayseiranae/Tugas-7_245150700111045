abstract class ArchanaBakery {

    String nama;
    double harga;

    abstract double hitungHarga();

    public String jadiString() {
        return nama + "," + hitungHarga();
    }
}

class KuePesanan extends ArchanaBakery {

    public KuePesanan(String namaKP, double beratKP, double hargaKP) {
        this.nama = namaKP;
        this.berat = beratKP;
        this.harga = hargaKP;
    }

    double berat;

    double hitungHarga() {
        return harga * berat;
    }

    public String jadiString() {
        return nama + "," + hitungHarga();
    }

    public double getBerat() {
        return this.berat;
    }
}

class KueJadi extends ArchanaBakery {

    public KueJadi(String namaKJ, double jumlahKJ, double hargaKJ) {
        this.nama = namaKJ;
        this.jumlah = jumlahKJ;
        this.harga = hargaKJ;
    }

    double jumlah;

    double hitungHarga() {
        double a = harga * jumlah * 2;
        return a;
    }

    public String jadiString() {
        return nama + "," + hitungHarga();
    }

    public double getJumlah() {
        return this.jumlah;
    }
}

class Typography {

    public void justify(String label, String value) {
        int width = 50;
        int separator = 20;
        System.out.print(String.format("%-" + separator + "s: %" + (width - separator - 2) + "s\n", label, value));
    }

    public static void center(String text) {
        int tengah = (50 - text.length()) / 2;
        for (int i = 0; i < tengah; i++) {
            System.out.print(" ");
        }
        System.out.println(text);
    }
}

class Main {

    ArchanaBakery[] kue = new ArchanaBakery[20];

    public static void main(String[] args) {
        Main program = new Main();
        program.createObj();
        program.showAllCake();

        System.out.println("");
        System.out.printf("\nTotal harga semua jenis kue: " + program.totalPrice() + "\n\n");
        System.out.printf("Total Harga Kue Pesanan: " + program.totalKP(true) + "\nTotal Berat Kue Pesanan: " + program.totalKP(false) + "\n\n");
        System.out.printf("Total Harga Kue Jadi: " + program.totalKJ(true) + "\nTotal Jumlah Kue Jadi: " + program.totalKJ(false) + "\n\n");
        program.shortingDescending();
    }

    public void createObj() {
        kue[0] = new KuePesanan("Croissant", 0.5, 12000);
        kue[1] = new KueJadi("Eclair", 3, 10000);
        kue[2] = new KuePesanan("Pain au Chocolat", 0.7, 15000);
        kue[3] = new KueJadi("Macaron", 5, 5000);
        kue[4] = new KuePesanan("Danish Strawberry", 0.6, 13000);
        kue[5] = new KueJadi("Canelé", 4, 8000);
        kue[6] = new KuePesanan("Apple Turnover", 1.0, 11000);
        kue[7] = new KueJadi("Tartlet Lemon", 2, 14000);
        kue[8] = new KuePesanan("Palmier", 0.4, 7000);
        kue[9] = new KueJadi("Choux Cream", 6, 6000);
        kue[10] = new KuePesanan("Galette", 1.3, 9000);
        kue[11] = new KueJadi("Mille-Feuille", 2, 16000);
        kue[12] = new KuePesanan("Kouign-Amann", 0.8, 17000);
        kue[13] = new KueJadi("Tiramisu Cup", 3, 15000);
        kue[14] = new KuePesanan("Madeleine", 0.9, 5000);
        kue[15] = new KueJadi("Opera Slice", 1, 20000);
        kue[16] = new KuePesanan("Financier", 0.6, 6500);
        kue[17] = new KueJadi("Churros Mini", 7, 3000);
        kue[18] = new KuePesanan("Scone", 1.2, 8000);
        kue[19] = new KueJadi("Strudel", 1, 18000);
    }

    public void showAllCake() {
        Typography t = new Typography();

        Typography.center("Welcome to Archana Bakery\n");
        Typography.center("Price List Kue Jadi\n");
        for (int i = 0; i < kue.length; i++) {
            if (i % 2 != 0) {
                t.justify(kue[i].nama, "Rp " + kue[i].hitungHarga());
            }
        }

        System.out.println();
        Typography.center("Price List Kue Pesanan\n");
        for (int i = 0; i < kue.length; i++) {
            if (i % 2 == 0) {
                t.justify(kue[i].nama, "Rp " + kue[i].hitungHarga());
            }
        }
    }

    public double totalPrice() {
        double totalPrice = totalKP(true) + totalKJ(true);
        return totalPrice;
    }

    public double totalKP(boolean category) {
        double totalHarga = 0;
        double totalBerat = 0;

        for (int i = 0; i < kue.length; i++) {
            if (kue[i] instanceof KuePesanan) {
                KuePesanan kp = (KuePesanan) kue[i];
                totalHarga += kp.hitungHarga();
                totalBerat += kp.getBerat();
            }
        }

        if (category == true) {
            return totalHarga;
        } else {
            return totalBerat;
        }
    }

    public double totalKJ(boolean category) {
        double totalHarga = 0;
        double totalJumlah = 0;

        for (int i = 0; i < kue.length; i++) {
            if (kue[i] instanceof KueJadi) {
                KueJadi kj = (KueJadi) kue[i];
                totalHarga += kj.hitungHarga();
                totalJumlah += kj.getJumlah();
            }
        }

        if (category == true) {
            return totalHarga;
        } else {
            return totalJumlah;
        }
    }

    public void shortingDescending() {
        ArchanaBakery[] sortedKue = new ArchanaBakery[kue.length];
        System.arraycopy(kue, 0, sortedKue, 0, kue.length);

        // Sorting pakai bubble sort dari harga tertinggi ke terendah
        for (int i = 0; i < sortedKue.length - 1; i++) {
            for (int j = 0; j < sortedKue.length - i - 1; j++) {
                if (sortedKue[j].hitungHarga() < sortedKue[j + 1].hitungHarga()) {
                    ArchanaBakery temp = sortedKue[j];
                    sortedKue[j] = sortedKue[j + 1];
                    sortedKue[j + 1] = temp;
                }
            }
        }

        Typography t = new Typography();
        Typography.center("\nDaftar Kue Urut Harga Tertinggi ke Terendah\n");
        for (int i = 0; i < sortedKue.length; i++) {
            t.justify(sortedKue[i].nama, "Rp " + sortedKue[i].hitungHarga());
        }
    }
}
