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
