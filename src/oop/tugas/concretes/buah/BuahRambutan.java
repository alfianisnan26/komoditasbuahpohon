package oop.tugas.concretes.buah;

import oop.tugas.abstracts.Buah;
import oop.tugas.concretes.kalkulasi.UkuranTumbuh;
import oop.tugas.enums.Rasa;
import oop.tugas.enums.UmurBuah;

public class BuahRambutan extends Buah {

    public BuahRambutan(UkuranTumbuh beratBuah, int kematian) {
        super(beratBuah, kematian);
    }

    @Override
    public Rasa ubahRasa() {
        if(umur <= 2) return rasa = Rasa.NETRAL;
        else if(umur <= 10) return rasa = Rasa.ASAM;
        else if(umur <= 40) return rasa = Rasa.NETRAL;
        else if(umur <= 100) return rasa = Rasa.MANIS;
        return Rasa.PAHIT;
    }

    @Override
    public UmurBuah ubahUmurBuah(){
        if(umur <= 50) return umurBuah = oop.tugas.enums.UmurBuah.MUDA;
        else if(umur <= 320) return umurBuah = oop.tugas.enums.UmurBuah.MATANG;
        return umurBuah = oop.tugas.enums.UmurBuah.BUSUK;
    }
}
