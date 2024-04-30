package test;

public class main {
    public static void main(String[] args) {
        Encryption encryption = new Encryption("abcdefghijklmnopqrstuvwxyz");
        String klartext = "aarondugeilerficker";
        String key = "zibbidizap";
        String verschluesselt = "";

       verschluesselt=encryption.encrypt(klartext, key);


        System.out.println("Klartext: \"" + klartext + "\" Verschlüsselt mit Key: \"" + key + "\" wird zu => \"" + verschluesselt+ "\"");
        System.out.println();
        String klartextrück=encryption.decrypt(verschluesselt, key);
        System.out.println("Verschlüsselt: \"" + verschluesselt + "\" Rücktransformiert mit Key: \"" + key + "\" wird zu => \"" + klartextrück + "\"");
        System.out.println();

        InputHandler handler = new InputHandler();

        handler.readTextFromFile("probedatei.txt");
        System.out.println(handler.toString());
        handler.editString();
        System.out.println(handler.toString());

    }

    

}
