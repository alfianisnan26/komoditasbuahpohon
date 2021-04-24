package oop.tugas.concretes.buah;

import oop.tugas.abstracts.Buah;
import oop.tugas.concretes.kalkulasi.UkuranTumbuh;
import oop.tugas.enums.Rasa;
import oop.tugas.enums.UmurBuah;

public class BuahDurian extends Buah {

    public BuahDurian(UkuranTumbuh beratBuah, int kematian) {
        super(beratBuah, kematian);
    }

    @Override
    public Rasa ubahRasa() {
        if(umur <= 40){ return rasa = Rasa.NETRAL;}
        else if(umur <= 50) return rasa = Rasa.ASAM;
        else if(umur <= 280) return rasa = Rasa.MANIS;
        else if(umur <= 285) return rasa = Rasa.PAHIT;
        else if(umur <= 320) return rasa = Rasa.MANIS;
        return Rasa.PAHIT;
    }

    @Override
    public UmurBuah ubahUmurBuah(){
        if(umur <= 50) return umurBuah = UmurBuah.MUDA;
        else if(umur <= 320) return umurBuah = UmurBuah.MATANG;
        return umurBuah = UmurBuah.BUSUK;
    }
}
