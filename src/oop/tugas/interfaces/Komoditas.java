package oop.tugas.interfaces;

import java.util.function.Predicate;

public interface Komoditas{
    default boolean defaultKomoditas(){
        return true;
    }
    int getHarga();
    void setHarga(int hargaPerKiloBuah);
}