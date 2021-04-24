package oop.tugas.concretes.kalkulasi;

public class Printer {
    public static enum position {
        HEADER, BODY, FOOTER, VERTICAL, HORIZONTAL;
        public static char special(position pos){
            return special(pos, false);
        }
        public static char special(position pos, boolean end) {
            if (pos == HEADER)
                return (end) ? (char)9559 : (char)9556;
            else if (pos == BODY)
                return (end) ? (char)9570 : (char)9567;
            else if (pos == FOOTER)
                return (end) ? (char)9565 : (char)9562;
            else if (pos == VERTICAL)
                return (char)9553;
            return (!end) ? (char)9552 : (char)9472 ;
        }
    }
    private static final int SPACELEN = 50;
    public static void separator(position pos) {
        System.out.print(position.special(pos, false));
        for (int a = 0; a < SPACELEN; a++)
            System.out.print(position.special(position.HORIZONTAL, (pos==position.BODY)?true:false));
        System.out.println(position.special(pos, true));
    }
    public static void header(String name) {
        Printer.separator(position.HEADER);
        System.out.print(position.special(position.VERTICAL));
        for (int a = 0; a < (SPACELEN/2 - (name.length() / 2)); a++)
            System.out.print(' ');
        System.out.print(name);
        for (int a = 0; a < (((name.length() % 2 == 0) ? (SPACELEN/2) : (SPACELEN/2)-1) - (name.length() / 2)); a++)
            System.out.print(' ');
        System.out.println(position.special(position.VERTICAL));
        Printer.separator(position.BODY);
    }

    public static void data(String key, Object value) {
        final int ENDL = 15;
        System.out.print(position.special(position.VERTICAL) + " " + key);
        for (int a = 0; a < ENDL - key.length(); a++)
            System.out.print(' ');
        System.out.print(": " + value);
        for (int a = 0; a < (SPACELEN - (ENDL + 3) - value.toString().length()); a++)
            System.out.print(' ');
        System.out.println(position.special(position.VERTICAL));
    }
}