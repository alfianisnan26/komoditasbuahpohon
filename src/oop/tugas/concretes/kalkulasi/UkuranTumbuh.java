package oop.tugas.concretes.kalkulasi;

public class UkuranTumbuh {
    private double ukuran;
    private double kecepatan;
    private double percepatan;
    public UkuranTumbuh(double initUkuran, double initKecepatan, double percepatan){
        ukuran = initUkuran;
        kecepatan = initKecepatan;
        this.percepatan = percepatan;
    }
    public UkuranTumbuh tumbuh(double indexTumbuh){
        ukuran = ukuran + (kecepatan)*indexTumbuh;
        kecepatan += percepatan;
        if(ukuran<0) ukuran = 0;
        return this;
    }

    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    public void setPercepatan(double percepatan) {
        this.percepatan = percepatan;
    }

    public void setUkuran(double ukuran) {
        this.ukuran = ukuran;
    }

    public double getKecepatan() {
        return kecepatan;
    }

    public double getPercepatan() {
        return percepatan;
    }

    public double getUkuran() {
        return ukuran;
    }
}
