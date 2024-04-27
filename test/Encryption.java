package test;

public class Encryption {
    
    private String alphabet;
    public char[][] matrix; //zu testzwecken public
    
    public Encryption(String alph){
        alphabet=alph;
        matrix=new char[alphabet.length()][alphabet.length()];
        String shifted=alphabet;

        for(int i=0; i<alphabet.length(); i++){
            
            for(int j=0; j<alphabet.length(); j++){
                matrix[i][j]=shifted.charAt(j);
            }
            shifted=shiftString(shifted);
        }
    }

    public void printMatrix(){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public String shiftString(String s){
        s=s.substring(1, s.length()) + s.charAt(0);
        return s;
    }
}
