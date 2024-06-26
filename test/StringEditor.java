package test;

public class StringEditor {
    private static StringBuilder strBuilder = new StringBuilder();

    public static String editStringAfterDecryption(String str){
        strBuilder.setLength(0);
        strBuilder.append(str);
        //ein replace von "ae" zusammenhängend funktioniert nicht da indexOf nur nach dem ertsen buchstaben sucht -> in repalceall nach substring suchen
        replaceAllWindowSearch("ae", "ã¤");//ä");
        replaceAllWindowSearch("oe", "ã¶");//ö");
        replaceAllWindowSearch("ue", "ã¼");//ü");
        return strBuilder.toString();
    }

    public static String editStringForEncryption(String str){
        strBuilder.setLength(0);
         strBuilder.append(str);
        //replaceAllWindowSearch(" ", "");

        //PROBLEM: nach dem einlesen einer txt, schein "ä" als "ã¤" gelesen zu werden somit wird kein "ä" gefunden -> replace auch "ã¤"
        replaceAllWindowSearch("ä", "ae");
        replaceAllWindowSearch("ã¤", "ae");
        replaceAllWindowSearch("ã„", "ae");
        //replaceAllWindowSearch("¤", "");

        replaceAllWindowSearch("ö", "oe");
        replaceAllWindowSearch("ã¶", "oe");
        //replaceAllWindowSearch("¶", "");

        replaceAllWindowSearch("ü", "ue");
        replaceAllWindowSearch("ã¼", "ue");
        replaceAllWindowSearch("ãœ", "ue");
        //replaceAllWindowSearch("¼", "");

        replaceAllWindowSearch("ß", "ss");
        replaceAllWindowSearch("ãÿ", "ss");
        //replaceAllWindowSearch("ÿ", "");
        
        return strBuilder.toString();
    }

    public static String editTest(String str){
        strBuilder.append(str);
        replaceAllWindowSearch("llo", "sos");
        return strBuilder.toString();
    }

    private static void replaceAllWindowSearch(String toReplace, String newString){ 
        while(stringContains(toReplace, strBuilder.toString())!=-1){
            int k=stringContains(toReplace, strBuilder.toString());
            strBuilder.replace(k, k+toReplace.length(), newString);
        }
    }

    private static int stringContains(String toFind, String originalString){ 
        int i=0;
        int j=i+toFind.length();

        while(j<=originalString.length()){
            if(originalString.substring(i, j).equals(toFind)){
                return i;
            }

            i++;
            j++;
        }

        return -1;
    }


}
