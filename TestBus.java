import java.util.Scanner;

public class TestBus {
    private static Bus transKoetaradja = new Bus();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextPenumpangId = 1;

    public static void main(String[] args) {
        System.out.println("===== SIMULASI BUS TRANS KOETARADJA =====");
        System.out.println("Ongkos Bus: Rp" + 2000); 

        int pilihan = 0;
        
        do {
            tampilkanMenu();
            System.out.print("Pilihan: ");
            
            String input = scanner.nextLine(); 

            try {
                pilihan = Integer.parseInt(input); 
                prosesPilihan(pilihan);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid. Silakan masukkan angka pilihan (1-4).");
                pilihan = 0; 
            }

        } while (pilihan != 4);

        System.out.println("\nSimulasi selesai. Terima kasih!");
    }

    public static void tampilkanMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Naikkan Penumpang");
        System.out.println("2. Turunkan Penumpang");
        System.out.println("3. Lihat Status Bus");
        System.out.println("4. Keluar");
        System.out.println("============");
    }

    public static void prosesPilihan(int pilihan) {
        switch (pilihan) {
            case 1:
                naikkanPenumpang();
                break;
            case 2:
                turunkanPenumpang();
                break;
            case 3:
                lihatPenumpang();
                break;
            case 4:
                // Keluar
                break;
            default:
                if (pilihan != 0) { 
                     System.out.println("Pilihan tidak ada. Silakan pilih 1-4.");
                }
        }
    }

    private static void naikkanPenumpang() {
        System.out.println("\n--- Input Data Penumpang ---");
        
        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        int umur = -1;
        System.out.print("Umur: ");
        try {
            umur = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Umur harus berupa angka. Pembatalan.");
            return;
        }
        
        int saldoAwal = 0;
        System.out.print("Saldo Awal (Rp): "); // Input Saldo Awal di sini
        try {
            saldoAwal = Integer.parseInt(scanner.nextLine());
            if (saldoAwal < 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Saldo awal harus berupa angka non-negatif. Pembatalan.");
            return;
        }


        System.out.print("Hamil (y/n): ");
        String hamilStr = scanner.nextLine().toLowerCase();
        boolean hamil = hamilStr.startsWith("y");

        // Membuat objek Penumpang menggunakan 5 parameter
        Penumpang newPenumpang = new Penumpang(nextPenumpangId++, nama, umur, hamil, saldoAwal);
        
        System.out.println("Info: Saldo awal " + nama + ": Rp" + newPenumpang.getSaldo());

        // Memanggil method di Class Bus
        if (transKoetaradja.naikkanPenumpang(newPenumpang)) {
            System.out.println("Sisa Saldo " + nama + " setelah naik: Rp" + newPenumpang.getSaldo());
        } 
    }

    private static void turunkanPenumpang() {
        System.out.println("\n--- Turunkan Penumpang ---");
        System.out.print("Nama Penumpang yang Turun: "); 
        String nama = scanner.nextLine();

        if (transKoetaradja.turunkanPenumpang(nama)) {
            System.out.println("Penumpang " + nama + " Berhasil Turun!"); 
        } else {
            System.out.println("Penumpang " + nama + " Tidak ditemukan!");
        }
    }

    private static void lihatPenumpang() {
        System.out.println("\n--- STATUS BUS TRANS KOETARADJA ---");
        System.out.println(transKoetaradja.toString()); 
    }
}
