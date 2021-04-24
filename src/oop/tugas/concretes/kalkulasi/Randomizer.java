package oop.tugas.concretes.kalkulasi;

import java.util.Random;

public class Randomizer {
    private static final Random random = new Random();
    public static int get(int min, int max) {return random.nextInt(max - min) + min;}
    public static boolean get() {return random.nextBoolean();}
    public static double get(double min, double max) {return random.nextDouble()*(max-min) + min;}
}
