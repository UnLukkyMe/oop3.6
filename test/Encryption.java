package test;

import java.util.HashMap;
import java.util.Map;

public class Encryption {
    
    private String alphabet;
    private char[][] matrix; //zu testzwecken public
    private String ignore=".:,;!§$%&/()=?`´'\\{}[]-_\"#'+*@~^°<>|0123456789 ";
    private Map<Character, Integer> map;
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
        //Fill map for quick alphabet access
        map= new HashMap<Character, Integer>();
        for(int i=0; i<alphabet.length(); i++){
            map.put(alphabet.charAt(i), i);
        }
    }

    //muss noch lernen relevante zeichen zu ignorieren
    public String decrypt(String verschluesselt, String key){
        String klartext="";
        int j=-1;
        for(int i=0; i<verschluesselt.length();i++){
            j++;
            char verschluesseltChar=verschluesselt.charAt(i);
            while(ignore.indexOf(verschluesseltChar)!=-1 && i<verschluesselt.length()){
                if(i==verschluesselt.length()-1){
                    klartext+=verschluesseltChar;
                    return klartext;
                }
                i++;
                klartext+=verschluesseltChar;
                verschluesseltChar=verschluesselt.charAt(i);
            }

            char keyChar=key.charAt(j);
            int posVerschluesselt=0, posKey=0;

            while(matrix[posKey][0]!=keyChar){
                posKey++;
            }
            while(matrix[posKey][posVerschluesselt]!=verschluesseltChar){
                posVerschluesselt++;
            }

            klartext+=alphabet.charAt(posVerschluesselt);

            if(j==key.length()-1){j=-1;}
            
        }

        return klartext;
    }

    public String encrypt(String klartext, String key){
        String verschluesselt="";
        int j=-1;
        for (int i = 0; i < klartext.length(); i++) {
            j++;
            char klartextChar=klartext.charAt(i);
            while(ignore.indexOf(klartextChar)!=-1 && i<klartext.length()){
                if(i==klartext.length()-1){
                    verschluesselt+=klartextChar; 
                    return verschluesselt;
                }
                i++;
                verschluesselt+=klartextChar;
                klartextChar=klartext.charAt(i);
            }

            verschluesselt +=matrix[map.get(klartextChar)][map.get(key.charAt(j))];
            //verschluesselt += matrix[alphabet.indexOf(klartextChar)][alphabet.indexOf(key.charAt(j))];
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

    public String getMatrixAsString(){
        String out="";

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                out+=matrix[i][j];
            }
            out+="_";
        }
        
        return out;
    }

    public String shiftString(String s){
        s=s.substring(1, s.length()) + s.charAt(0);
        return s;
    }
}
