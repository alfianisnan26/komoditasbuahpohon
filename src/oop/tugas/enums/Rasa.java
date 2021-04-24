package oop.tugas.enums;

public enum Rasa {
    MANIS("Manis"),
    PAHIT("Pahit"),
    ASAM("Asam"),
    ASIN("Asin"),
    NETRAL("Netral");
    private String rasa;
    private Rasa(String rasa){ this.rasa = rasa; }
    @Override
    public String toString() {
        return rasa;
    }
}
