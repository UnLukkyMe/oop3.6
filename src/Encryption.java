package src;

import java.util.HashMap;
import java.util.Map;

/**
 * The Encryption class provides methods for encrypting and decrypting text using the Vigenère cipher.
 * It also contains methods for generating the encryption matrix and performing encryption and decryption operations.
 */
public class Encryption {
    
    private String alphabet;
    private char[][] matrix; //zu testzwecken public
    private String ignore=".:,;!§$%&/()=?`´'\\{}[]-_\"#'+*@~^°<>|0123456789 ";
    private Map<Character, Integer> map;
    int skipsevery=Integer.MAX_VALUE;
    
    /**
     * Constructs a new Encryption object with the specified alphabet.
     *
     * @param alph The alphabet to be used for encryption and decryption.
     */
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

    /**
     * Decrypts the provided text using the specified key.
     *
     * @param verschluesselt The text to be decrypted.
     * @param key The key to be used for decryption.
     * @return The decrypted text.
     */
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

    /**
     * Encrypts the provided text using the specified key.
     *
     * @param klartext The text to be encrypted.
     * @param key The key to be used for encryption.
     * @return The encrypted text.
     */
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

    /**
     * Prints the encryption matrix to the console.
     */
    public void printMatrix(){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    /**
     * Returns the encryption matrix as a string.
     *
     * @return The encryption matrix as a string.
     */
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

    private String shiftString(String s){
        s=s.substring(1, s.length()) + s.charAt(0);
        return s;
    }
}

