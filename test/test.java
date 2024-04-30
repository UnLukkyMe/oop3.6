package test;

class test{
    public static char[][] crypt;
    public static void main(String[] args) {
    InputHandler h = new InputHandler();
    h.strBuilder.append("Mein String ist täll\n ö. ä. ü. ");
    System.out.println(h.toString());
    h.editString();
    System.out.println(h.toString());

    }


}