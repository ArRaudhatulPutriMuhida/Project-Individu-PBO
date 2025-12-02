public class Penumpang {
    // Atribut
    private int id;         
    private String nama;    
    private int umur;       
    private boolean hamil;  
    private int saldo;      // Nilai ini akan diinisialisasi dari input


    // Method Constructor menerima saldoAwal sebagai parameter
    // + Penumpang(id: int, nama: String, umur: int, hamil: boolean, saldoAwal: int)
    public Penumpang(int id, String nama, int umur, boolean hamil, int saldoAwal) {
        this.id = id;
        this.nama = nama;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = saldoAwal; // Saldo diatur berdasarkan input
    }

    // Methods Getter
    public int getID() { 
        return id;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() { 
        return umur;
    }

    public boolean isHamil() { 
        return hamil;
    }

    public int getSaldo() { 
        return saldo;
    }

    // Mutator Methods 
    
    public void tambahSaldo(int saldobaru) {
        if (saldobaru > 0) {
            this.saldo += saldobaru;
        }
    }

    public boolean kurangiSaldo(int ongkos) {
        if (this.saldo >= ongkos) {
            this.saldo -= ongkos;
            return true;
        } else {
            return false;
        }
    }

// Logika Prioritas 
    
    public boolean isPrioritas() {
        return this.umur > 60 || this.umur < 10 || this.hamil;
    }

    // Override toString()
    @Override
    public String toString() {
        String status = isPrioritas() ? " (Prioritas)" : " (Biasa)";
        String hamilStatus = this.hamil ? " - Hamil" : "";
        return this.nama + " (ID: " + this.id + ", Umur: " + this.umur + hamilStatus + status + ")";
    }
}
