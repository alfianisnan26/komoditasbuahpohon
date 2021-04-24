package oop.tugas.abstracts;

import oop.tugas.concretes.kalkulasi.UkuranTumbuh;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public abstract class Tumbuhan <M extends Buah> {
    private static int idCounter = 0;
    private static int getIdCounter(){return Tumbuhan.idCounter++; }

    protected ArrayList<M> fruits = new ArrayList<>();
    /**
     * Ukuran batangPokok dalam cm
     */
    protected final UkuranTumbuh batangPokok;
    protected final UkuranTumbuh daun;
    private final int kematian;
    private String name;
    private int id;
    public int totalOksigen;
    public int totalKarbondioksida;
    private double indeksFotosintesis;
    /**
     * Umur dalam integer hari
     */
    protected int umur = 0;

    public Tumbuhan(UkuranTumbuh batangPokok, UkuranTumbuh daun, int kematian, String name){
        this.kematian = kematian;
        this.batangPokok = batangPokok;
        this.daun = daun;
        this.id = Tumbuhan.getIdCounter();
        this.name = name;
    }
    public String getName() {return name;}
    public boolean tumbuh(double indexTumbuh){
        umur ++;
        if(umur<kematian){
            batangPokok.tumbuh(indexTumbuh);
            daun.tumbuh(indexTumbuh);
            return true;
        }
        else return false;
    }

    public ArrayList<M> petikBuah(Predicate<M> pred){
        return fruits.stream().filter(pred).collect(Collectors.toCollection(ArrayList::new));
    }

    public abstract void generateBuah(int min, int max);
    public abstract void print();
}