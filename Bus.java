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
