package oop.tugas.concretes.pohon;

import oop.tugas.abstracts.Tumbuhan;
import oop.tugas.concretes.buah.BuahDurian;
import oop.tugas.concretes.kalkulasi.Printer;
import oop.tugas.concretes.kalkulasi.Randomizer;
import oop.tugas.concretes.kalkulasi.UkuranTumbuh;
import oop.tugas.enums.UmurBuah;
import oop.tugas.interfaces.Komoditas;
import oop.tugas.interfaces.Penghijauan;

import java.util.function.Predicate;

public class PohonDurian extends Tumbuhan<BuahDurian> implements Komoditas, Penghijauan {
    private int hargaPerKiloBuah = 0;
    private int indexBuah = 0;

    /**
     *
     * @param batangPokok objek ukuran untuk batang pokok
     * @param daun objek ukuran untuk daun dengan kecepatan normal 1 (nilai negatif menunjukkan keguguran)
     * @param hariKematian hari dimana pohon berakhir
     * @param name nama dari pohon
     * @param indexBuah nilai ini semakin besar, akan semakin susah berbuah
     */
    public PohonDurian(UkuranTumbuh batangPokok, UkuranTumbuh daun, int hariKematian, int indexBuah, String name){
        super(batangPokok, daun, hariKematian, name);
        this.indexBuah = indexBuah;
    }

    @Override
    public int getHarga() {
        Double harga = fruits.stream()
                .filter(e -> e.umurBuah == UmurBuah.MATANG)
                .mapToDouble(b -> ((BuahDurian) b).beratBuah.getUkuran() * hargaPerKiloBuah / 1000
                ).sum();
        return harga.intValue();
    }

    @Override
    public void setHarga(int hargaPerKiloBuah) {
        this.hargaPerKiloBuah = hargaPerKiloBuah;
    }

    @Override
    public boolean fotosintesis(double indexCo2) {
        if(indexCo2 < 0.5) rontokDaun(1-(indexCo2*2));
        else tumbuhDaun((indexCo2-0.5)*2);
        if(super.tumbuh(indexCo2)){
            if(umur>60 && umur%indexBuah==0 && Randomizer.get()) generateBuah(0,5);
            totalKarbondioksida += (int) (indexCo2 * daun.getUkuran());
            totalOksigen += (int) (indexCo2 * daun.getUkuran());
            fruits.forEach(f->f.tumbuh(indexCo2));
            return true;
        }
        return false;
    }

    @Override
    public void tumbuhDaun(double indexTumbuh) {
        daun.setPercepatan(indexTumbuh);
    }

    @Override
    public void rontokDaun(double indexRontok) { daun.setPercepatan(indexRontok); }


    @Override
    public void generateBuah(int min, int max) {
        for(int i=0;i<Randomizer.get(min,max);i++){
            fruits.add(new BuahDurian(
               new UkuranTumbuh(
                       Randomizer.get(1.0, 10.0),
                       Randomizer.get(1.0, 12.0),
                       Randomizer.get(0.001, 1.0)
               ),
               Randomizer.get(200, 800)
            ));
        }
    }

    @Override
    public void print() {
        Printer.header(getName());
        Printer.data("Umur", umur + " Hari");
        Printer.data("Ukuran Batang", String.format("%.2f cm", batangPokok.getUkuran()));
        Printer.data("Buah Muda", petikBuah(f -> f.umurBuah == UmurBuah.MUDA).size());
        Printer.data("Buah Matang", petikBuah(f -> f.umurBuah == UmurBuah.MATANG).size());
        Printer.data("Buah Busuk", petikBuah(f -> f.umurBuah == UmurBuah.BUSUK).size());
        Printer.data("Jumlah Daun", (int)daun.getUkuran());
        Printer.data("Total O2", totalOksigen + " mm^3");
        Printer.data("Total Co2", totalKarbondioksida + " mm^3");
        Printer.data("Ttl Hrg Buah", getHarga() + " rupiah");
        Printer.separator(Printer.position.FOOTER);
    }
}
