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
