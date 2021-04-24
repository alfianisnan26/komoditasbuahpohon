package oop.tugas.enums;

public enum UmurBuah {
    MUDA("Muda"),
    MATANG("Matang"),
    BUSUK("Busuk");
    private String rasa;
    private UmurBuah(String rasa){ this.rasa = rasa; }
    @Override
    public String toString() {
        return rasa;
    }
}
