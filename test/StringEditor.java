package test;

public class StringEditor {
    private static StringBuilder strBuilder = new StringBuilder();

    public static String editStringAfterDecryption(String str){
        strBuilder.append(str);
        //einreplace von "ae" zusammenhängend funktioniert nicht da indexOf nur nach dem ertsen buchstaben sucht -> in repalceall nach substring suchen
        replaceAll("ae", "ä");
        replaceAll("oe", "ö");
        replaceAll("ue", "u");
        return strBuilder.toString();
    }

    public static String editStringForEncryption(String str){
         strBuilder.append(str);
        //replaceAll(" ", "");

        //PROBLEM: nach dem einlesen einer txt, schein "ä" als "ã¤" gelesen zu werden somit wird kein "ä" gefunden -> replace auch "ã¤"
        replaceAll("ä", "ae");
        replaceAll("ã¤", "ae");
        replaceAll("¤", "");

        replaceAll("ö", "oe");
        replaceAll("ã¶", "oe");
        replaceAll("¶", "");

        replaceAll("ü", "ue");
        replaceAll("ã¼", "ue");
        replaceAll("¼", "");

        replaceAll("ß", "ss");
        replaceAll("ãÿ", "ss");
        replaceAll("ÿ", "");
        
        return strBuilder.toString();
    }

    private static void replaceAll(String toReplace, String newString){
        while(strBuilder.indexOf(toReplace)!=-1){
            int i=strBuilder.indexOf(toReplace);
            strBuilder.replace(i, i+1, newString);
        }
    }


}
