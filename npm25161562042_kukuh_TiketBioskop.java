public class npm25161562042_kukuh_TiketBioskop {

    // === BAGIAN 1: Deklarasi Stack ===
    // stack[]: menyimpan nama tiket & film
    // hargaTiket[]: menyimpan angka harga untuk dijumlahkan
    static String[] stack = new String[10];
    static int[] hargaTiket = new int[10]; 
    static int top = -1;

    // === BAGIAN 2: Operasi Stack ===

    // Method push() untuk menambah data (nama tiket dan harganya)
    static void push(String tiket, int harga) {
        if (top < stack.length - 1) {
            top++;
            stack[top] = tiket;
            hargaTiket[top] = harga;
        }
    }

    // Method pop() untuk mengambil/membatalkan data paling atas
    static String pop() {
        if (top >= 0) {
            String namaTiket = stack[top];
            int harga = hargaTiket[top];
            top--;
            return namaTiket + " Rp" + String.format("%,d", harga).replace(',', '.');
        }
        return "Stack Kosong";
    }

    // === TUGAS BONUS: Method Hitung Total ===
    // Menelusuri seluruh stack dan menjumlahkan semua hargaTiket yang ada
    static void hitungTotal() {
        int total = 0;
        for (int i = 0; i <= top; i++) {
            total += hargaTiket[i];
        }
        // Format agar angka 140000 menjadi 140.000
        System.out.println("Total transaksi: Rp" + String.format("%,d", total).replace(',', '.'));
    }

    // Method untuk menampilkan isi stack dengan format tabel sesuai gambar
    static void tampilkanStack() {
        System.out.println("=== Isi Stack (TOP -> BOTTOM) ===");
        if (top >= 0) {
            for (int i = top; i >= 0; i--) {
                System.out.println("| " + stack[i] + " Rp" + String.format("%,d", hargaTiket[i]).replace(',', '.') + " |");
            }
        }
        System.out.println("=================================");
    }

    // === BAGIAN 3: Eksekusi Program (Main) ===
    public static void main(String[] args) {
        // 1. Memasukkan data tiket (Push)
        push("Tiket-A01: Avengers", 50000);
        push("Tiket-B02: Interstellar", 45000);
        push("Tiket-C03: Inception", 45000);

        // 2. Tampilkan isi tumpukan awal
        tampilkanStack();
        
        // 3. Panggil method bonus untuk hitung total harga
        hitungTotal();
        
        // 4. Keterangan sesuai format gambar
        System.out.println("\nTiket terakhir masuk: " + stack[top] + " Rp" + String.format("%,d", hargaTiket[top]).replace(',', '.'));
        System.out.println("Tiket dibatalkan: " + pop());

        // 5. Tampilkan isi tumpukan akhir setelah pop
        tampilkanStack();
    }
}