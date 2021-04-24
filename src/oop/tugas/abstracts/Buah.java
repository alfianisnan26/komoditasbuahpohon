package oop.tugas.abstracts;

import oop.tugas.concretes.kalkulasi.UkuranTumbuh;
import oop.tugas.enums.Rasa;
import oop.tugas.enums.UmurBuah;

public abstract class Buah {
    /**
     * Berat Buah dalam Gram
     */
    public final UkuranTumbuh beratBuah;
    public final int kematian;
    public Rasa rasa = Rasa.NETRAL;
    public UmurBuah umurBuah = UmurBuah.MUDA;
    /**
     * Umur dalam integer Hari
     */
    protected int umur = 0;

    abstract public Rasa ubahRasa();
    abstract public UmurBuah ubahUmurBuah();

    public Buah(UkuranTumbuh beratBuah, int kematian){
        this.beratBuah = beratBuah;
        this.kematian = kematian;
    }

    public UkuranTumbuh tumbuh(double indexTumbuh){
        umur ++;
        ubahRasa();
        ubahUmurBuah();
        return beratBuah.tumbuh(indexTumbuh);
    }
}