package src;

import java.util.Scanner;

/**
 * The main class contains the main method which provides a command-line interface for encrypting and decrypting text files using the Vigenère cipher.
 */
public class main {
    
    /**
     * The main method allows the user to interactively encrypt or decrypt text files using the Vigenère cipher.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        boolean ver;
        String key="";
        String filenametoread="";
        String filenametowrite="";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        Scanner scanner = new Scanner(System.in);
        System.out.println("Möchtest du einen Text Ver- oder Entschlüsseln?: (1|0)");
        String in=scanner.nextLine();
        if(in.equals("1") || in.equals("verschlüsseln")|| in.equals("Verschlüsseln")|| in.equals("ver")){
            ver=true;
        }else{
            ver=false;
        }

        System.out.println("\nWie lautet der Schlüssel? ");
        key=scanner.nextLine();

        if(ver){
            System.out.println("\nGib nun den Dateinamen der zu verschlüsselnden Datei im Ordner \"inputfiles\" an:");
            filenametoread=scanner.nextLine();
            System.out.println("\nNun den Namen der output-Datei im ordner \"outputfiles\"");
            filenametowrite=scanner.nextLine();
        }else{
            System.out.println("\nGib nun den Dateinamen der zu entschlüsselnden Datei im Ordner \"inputfiles\" an:");
            filenametoread=scanner.nextLine();
            System.out.println("\nNun den Namen der output-Datei im ordner \"outputfiles\"");
            filenametowrite=scanner.nextLine();
        }

        System.out.println("\nVerschlüsseln? " + ver + "\nSchlüssel: " + key + "\nDateiname: " + filenametoread);

        Encryption encrypter = new Encryption(alphabet);

        String klartext="";
        String verschluesselt="";
        String output="";

        InputHandler ihandler = new InputHandler();
        ihandler.readTextFromFile(filenametoread);
        if(ver){
            klartext=ihandler.toString();
            klartext=StringEditor.editStringForEncryption(klartext);
            
            verschluesselt=encrypter.encrypt(klartext, key);

            output+=">Klartext:_";
            output+=klartext;
            output+="_>Verschluesselt mit Key \"" + key + "\":_";
            output+=verschluesselt;

            

        }else{
            verschluesselt=ihandler.toString();
            klartext=encrypter.decrypt(verschluesselt, key);
            //klartext=StringEditor.editStringAfterDecryption(klartext);

            output+=">Verschluesselt:_";
            output+=verschluesselt;
            output+="_>Entschluesselt mit Key \"" + key + "\":_";
            output+=klartext;

        }

        output+="_>Verschluesselungsmatrix:_";
        output+=encrypter.getMatrixAsString();
        OutputHandler.writeTextToFile(filenametowrite, output);
        
        if (ver) {
            System.out.println();
            ihandler.printTextFromWrittenFile(filenametowrite);
        }else{
            System.out.println();
            ihandler.printTextFromWrittenFile(filenametowrite);
        }
    }
}

