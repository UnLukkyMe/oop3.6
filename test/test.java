package test;

class test{
    public static char[][] crypt;
    public static void main(String[] args) {
        String alphabet= "abcdefghijklmnopqrstuvwxyz";

        crypt = new char[26][26];
        String shifted=alphabet;

        for(int i=0; i<alphabet.length(); i++){
            
            for(int j=0; j<alphabet.length(); j++){
                crypt[i][j]=shifted.charAt(j);
            }
            shifted=shiftString(shifted);
        }
        
        printMatrix(crypt);


    }

    public static void printMatrix(char[][] matrix){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static String shiftString(String s){
        s=s.substring(1, s.length()) + s.charAt(0);
        return s;
    }
}