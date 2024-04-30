package test;

public class main {
    public static void main(String[] args) {
        Encryption encryption = new Encryption("abcdefghijklmnopqrstuvwxyz");
        String klartext = "polymorphismus";
        String key = "scheune";
        String verschluesselt = "";

       verschluesselt=encryption.encrypt(klartext, key);

        System.out.println("Klartext: \"" + klartext + "\" Verschlüsselt mit Key: \"" + key + "\" wird zu => \"" + verschluesselt+ "\"");
        System.out.println();
        String klartextrück=encryption.decrypt(verschluesselt, key);
        System.out.println("Verschlüsselt: \"" + verschluesselt + "\" Rücktransformiert mit Key: \"" + key + "\" wird zu => \"" + klartextrück + "\"");

        /**
         RÜCKWÄRTSTRANSFORMATION
        int p=0;
        while(encryption.matrix[p][0]!='s'){
            p++;
        }
        int k=0;
        while(encryption.matrix[p][k]!='h'){

            k++;
        }
        System.out.println(encryption.matrix[p][0]);
        System.out.println(encryption.matrix[p][k]);
        System.out.println(encryption.alphabet.charAt(k));
        
        RÜCKWÄRTSTRANSOFORMATION
        **/


    }

    

}
