package oop.tugas.concretes.main;

import oop.tugas.concretes.kalkulasi.Randomizer;
import oop.tugas.concretes.kalkulasi.UkuranTumbuh;
import oop.tugas.concretes.pohon.PohonDurian;
import oop.tugas.concretes.pohon.PohonRambutan;

public class Pertanian {
    public static void main(String[] args) throws InterruptedException {
        var iterateHari = Integer.parseInt(args[0]);
        PohonDurian durianMonthong = new PohonDurian(
            new UkuranTumbuh(10,0,0.5), //batangPokok
            new UkuranTumbuh(2, 0, 1), //daun
            Randomizer.get(5200, 30000),
            30,
            "Durian Monthong");
        durianMonthong.setHarga(50000);
        PohonRambutan rambutanAceh = new PohonRambutan(
            new UkuranTumbuh(5,0,0.3), //batangPokok
            new UkuranTumbuh(3, 0, 1), //daun
            Randomizer.get(3600, 26000),
            10,
            "Rambutan Aceh");
        rambutanAceh.setHarga(15000);
        for(int a = 0; a < iterateHari ; a++){
            double indexCo2 = Randomizer.get(0.0, 1.0);
            if(durianMonthong.fotosintesis(indexCo2)) durianMonthong.print();
            else System.out.println(durianMonthong.getName() + " sudah Mati");
            if(rambutanAceh.fotosintesis(indexCo2)) rambutanAceh.print();
            else System.out.println(rambutanAceh.getName() + " sudah Mati");
            Thread.sleep(50);
        }
    }
}

