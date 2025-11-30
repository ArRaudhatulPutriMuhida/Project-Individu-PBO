import java.util.ArrayList;
import java.util.List;

public class Bus {
    // Atribut Penampung Penumpang (Menggunakan ArrayList)
    private List<Penumpang> penumpangBiasa;     // maksimal 16 kursi 
    private List<Penumpang> penumpangPrioritas; // maksimal 4 kursi 
    private List<Penumpang> penumpangBerdiri;   // maksimal 20 orang 

    // Konstanta dan Atribut Bus
    public static final int KAPASITAS_KURSI_BIASA = 16;
    public static final int KAPASITAS_KURSI_PRIORITAS = 4;
    public static final int KAPASITAS_BERDIRI = 20;
    public static final int KAPASITAS_TOTAL = 40; // Maksimal kapasitas bus adalah 40 orang
    
    // ONGKOS BUS [cite: 24, 47] - static dan final 
    private static final int ONGKOS_BUS = 2000;
    
    // totalPendapatan [cite: 25]
    private int totalPendapatan; // total pendapatan bus per hari bermula dari nilai 0

    // Constructor
    public Bus() { // + Bus() 
        this.penumpangBiasa = new ArrayList<>();
        this.penumpangPrioritas = new ArrayList<>();
        this.penumpangBerdiri = new ArrayList<>();
        this.totalPendapatan = 0;
    }

        //Accessor Methods (Getter)

    public List<Penumpang> getPenumpangBiasa() { // + getPenumpang Biasa(): Penumpang[] 
        return penumpangBiasa;
    }

    public List<Penumpang> getPenumpangPrioritas() { // + getPenumpang Prioritas(): Penumpang[] 
        return penumpangPrioritas;
    }

    public List<Penumpang> getPenumpangBerdiri() { // + getPenumpang Berdiri(): Penumpang[] 
        return penumpangBerdiri;
    }

    public int getJumlahPenumpangBiasa() { // + getJumlahPenumpang Biasa(): int 
        return penumpangBiasa.size();
    }

        public int getJumlahPenumpangPrioritas() { // + getJumlah Penumpang Prioritas(): int 
        return penumpangPrioritas.size();
    }

    public int getJumlahPenumpangBerdiri() { // + getJumlah Penumpang Berdiri(): int 
        return penumpangBerdiri.size();
    }

    public int getJumlahSemuaPenumpang() {
        return getJumlahPenumpangBiasa() + getJumlahPenumpangPrioritas() + getJumlahPenumpangBerdiri();
    }

    public int getTotalPendapatan() {
        return totalPendapatan;
    }

    // + naikkan Penumpang (penumpang: Penumpang): Boolean [cite: 33]
    public boolean naikkanPenumpang(Penumpang penumpang) {
        
        // Cek kapasitas total bus 
        if (getJumlahSemuaPenumpang() >= KAPASITAS_TOTAL) {
            System.out.println("Gagal Naik: Bus sudah penuh (Kapasitas Maksimal: " + KAPASITAS_TOTAL + " orang).");
            return false;
        }

        // Cek saldo penumpang 
        if (penumpang.getSaldo() < ONGKOS_BUS) {
            System.out.println("Gagal Naik: Saldo tidak mencukupi (Sisa: Rp" + penumpang.getSaldo() + ". Ongkos: Rp" + ONGKOS_BUS + ").");
            return false;
        }

        boolean berhasilDuduk = false;

        if (penumpang.isPrioritas()) {
            // Logika Penumpang Prioritas: Boleh duduk di Prioritas atau Biasa
            
            // 1. Coba kursi Prioritas
            if (getJumlahPenumpangPrioritas() < KAPASITAS_KURSI_PRIORITAS) {
                penumpangPrioritas.add(penumpang);
                System.out.println(" " + penumpang.getNama() + " berhasil duduk di Kursi Prioritas.");
                berhasilDuduk = true;
            }
            // 2. Coba kursi Biasa (jika Prioritas penuh)
            else if (getJumlahPenumpangBiasa() < KAPASITAS_KURSI_BIASA) {
                penumpangBiasa.add(penumpang);
                System.out.println(" " + penumpang.getNama() + " berhasil duduk di Kursi Biasa (Prioritas penuh).");
                berhasilDuduk = true;
            }
        } else {
            // Logika Penumpang Biasa: Dilarang duduk di Prioritas
            
            // 1. Coba kursi Biasa
            if (getJumlahPenumpangBiasa() < KAPASITAS_KURSI_BIASA) {
                penumpangBiasa.add(penumpang);
                System.out.println(" " + penumpang.getNama() + " berhasil duduk di Kursi Biasa.");
                berhasilDuduk = true;
            }
        }

        // Jika tidak dapat duduk (berhasilDuduk masih false), cek apakah masih bisa berdiri 
        if (!berhasilDuduk && getJumlahPenumpangBerdiri() < KAPASITAS_BERDIRI) {
            penumpangBerdiri.add(penumpang);
            System.out.println(" " + penumpang.getNama() + " berhasil naik dan BERDIRI (Kursi penuh).");
            berhasilDuduk = true; // Berhasil naik (berdiri)
        }

        // Jika berhasil naik (duduk atau berdiri), proses pembayaran
        if (berhasilDuduk) {
            penumpang.kurangiSaldo(ONGKOS_BUS); // Kurangi saldo
            this.totalPendapatan += ONGKOS_BUS; // Tambah pendapatan
            return true;
        } else {
            // Kondisi ini hanya terjadi jika semua kapasitas sudah penuh (duduk dan berdiri)
            System.out.println("Gagal Naik: Kursi dan tempat berdiri sudah penuh.");
            return false;
        }
    }
