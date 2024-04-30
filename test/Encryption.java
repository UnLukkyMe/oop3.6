package test;

public class Encryption {
    
    public String alphabet;
    public char[][] matrix; //zu testzwecken public
    int skipsevery=Integer.MAX_VALUE;
    //Hashmap die buchstaben des alphabets auf nummern mapped, sodass man den string.indexOf zugriff nicht so oft braucht?
    
    public Encryption(String alph){
        alphabet=alph;
        matrix=new char[alphabet.length()][alphabet.length()];
        String shifted=alphabet;

        //Fill Matrix
        for(int i=0; i<alphabet.length(); i++){ 
            for(int j=0; j<alphabet.length(); j++){
                matrix[i][j]=shifted.charAt(j);
            }
            shifted=shiftString(shifted);
        }
    }

    //muss noch lernen relevante zeichen zu ignorieren
    public String decrypt(String verschluesselt, String key){
        String klartext="";
        int j=-1;
        for(int i=0; i<verschluesselt.length();i++){
            j++;
            char verschluesseltChar=verschluesselt.charAt(i);
            char keyChar=key.charAt(j);
            int posVerschluesselt=0, posKey=0;

            while(matrix[posKey][0]!=keyChar){
                posKey++;
            }
            while(matrix[posKey][posVerschluesselt]!=verschluesseltChar){
                posVerschluesselt++;
            }

            klartext+=alphabet.charAt(posVerschluesselt);

            if(i==key.length()-1){j=-1;}
            
        }

        return klartext;
    }

    //muss noch lernen relevante zeichen zu ignorieren
    public String encrypt(String klartext, String key){
        String verschluesselt="";
        int j=-1;
        for (int i = 0; i < klartext.length(); i++) {
            j++;
            verschluesselt += matrix[alphabet.indexOf(klartext.charAt(i))][alphabet.indexOf(key.charAt(j))];
            if(i>0 && i%skipsevery==0){verschluesselt+=" ";}
            if(j==key.length()-1){j=-1;} //resetted key zähler

        }
        return verschluesselt;
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
