package test;

public class main {
    public static void main(String[] args) {
        Encryption encryption = new Encryption("abcdefghijklmnopqrstuvwxyz");
        String klartext = "bebi";
        String key = "scheuna";
        String verschluesselt = "";

       verschluesselt=encryption.encrypt(klartext, key);

        System.out.println("Klartext: " + klartext + "\nVerschlüsselt: " + verschluesselt);

    }

    

}
