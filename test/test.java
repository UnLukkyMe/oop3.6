package test;

class test{
    public static void main(String[] args) {
    /* InputHandler test
    
    InputHandler h = new InputHandler();
    h.strBuilder.append("Mein String ist täll\n ö. ä. ü. ");
    System.out.println(h.toString());
    h.editString();
    System.out.println(h.toString());
 */
    String alphabet="abcdefghijklmnopqrstuvwxyz";    
    String str2="Ha llo o: ä. ü. ö. ß. meine Freunde";
    String str="polya+#.lpha_betisch.";
    /*
    System.out.println(str);
    String edited = StringEditor.editStringForEncryption(str);
    System.out.println(edited);
    String output = StringEditor.editStringAfterDecryption(edited);
    System.out.println(output);
    */

    System.out.println("Original: "  +str);
    String edited=StringEditor.editStringForEncryption(str);
    System.out.println("Editiert: "+edited);
    Encryption encrypter = new Encryption(alphabet);
    String verschluesselt = encrypter.encrypt(edited, "scheune");
    System.out.println("Verschlüsselt: " + verschluesselt);
    String entschluesselt= encrypter.decrypt(verschluesselt, "scheune");
    System.out.println("Entschlüsselt: "+ entschluesselt);
    
    OutputHandler.writeTextToFile("testschreiben.txt", str);

    }

    

}