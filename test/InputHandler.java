package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//vllt eigene Klasse fürs editen des Strings,w eils ja auch rückwärts aus einer anderen als der einlese klasse gemacht werden muss
//PROBLEM, wie merken wir uns Zeilenumbrüche, beim einlesen der Datei
public class InputHandler {
    public StringBuilder strBuilder;

    public InputHandler() {
        strBuilder = new StringBuilder();
    }

    //macht schon alles kleinbuchstaben 
    //WORKING DIRECTORY MUSS EINS ÜBER DEM FOLDER MIT DATEI SEIN
    public void readTextFromFile(String fileName){

        try(
            FileReader fr = new FileReader(".\\test\\"+fileName);
            BufferedReader br = new BufferedReader(fr);
        ){
            String line="";
            while((line=br.readLine())!=null){
                strBuilder.append(line.toLowerCase());
                //für leerzeichen unique zeichen vereinbaren ,dass von codierung ingnoriert wird um am ende wieder umgebrochen zu werden. BZW leerzeichen einfach beim codieren ignorieren
                strBuilder.append("_"); //zeilenumbruch merken
            }
        }catch(FileNotFoundException fnfEx){
            System.out.println("File: " + fileName + " nicht found");
        }catch(IOException ioEx){
            System.out.println("Error while reading file: " + fileName);
        }


    }

    /* 

    WIRD NACH STRINGEDITOR AUSGELAGERT

    public void editString(){

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
        
    }

    private void replaceAll(String toReplace, String newString){
        while(strBuilder.indexOf(toReplace)!=-1){
            int i=strBuilder.indexOf(toReplace);
            strBuilder.replace(i, i+1, newString);
        }
    }

*/

    public String toString() {
        return strBuilder.toString();
    }

}
