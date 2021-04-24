package oop.tugas.interfaces;

public interface Penghijauan{
    default boolean defaultPenghijauan(){
        return true;
    }
    /**
     *
     * @param indexCo2 nilai index keberadaan CO2 {0 <= indexCo2 <= 1}
     * @return
     */
    boolean fotosintesis(double indexCo2);
    void tumbuhDaun(double indexTumbuh);
    void rontokDaun(double indexRontok);
}