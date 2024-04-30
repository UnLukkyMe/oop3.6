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

    String str="Ha llo o: ä. ü. ö. ß. meine Freunde";
    System.out.println(str);
    String edited = StringEditor.editStringForEncryption(str);
    System.out.println(edited);
    String output = StringEditor.editStringAfterDecryption(edited);
    System.out.println(output);
    }
}