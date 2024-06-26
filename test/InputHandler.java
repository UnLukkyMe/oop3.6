package test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputHandler {
    private StringBuilder strBuilder;
    private String linebreakstring="_";

    public InputHandler() {
        strBuilder = new StringBuilder();
    }

    //macht schon alles kleinbuchstaben 
    //WORKING DIRECTORY MUSS EINS ÜBER DEM FOLDER MIT DATEI SEIN
    public void readTextFromFile(String fileName){

        try(
            FileReader fr = new FileReader(".\\inputfiles\\"+fileName);
            BufferedReader br = new BufferedReader(fr);
        ){
            String line="";
            while((line=br.readLine())!=null){
                strBuilder.append(line.toLowerCase());
                strBuilder.append(linebreakstring); //zeilenumbruch merken
            }
        }catch(FileNotFoundException fnfEx){
            System.out.println("File: " + fileName + " nicht found");
        }catch(IOException ioEx){
            System.out.println("Error while reading file: " + fileName);
        }


    }

    public void printTextFromWrittenFile(String fileName){

        try(
            FileReader fr = new FileReader(".\\outputfiles\\"+fileName);
            BufferedReader br = new BufferedReader(fr);
        ){
            String line="";
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch(FileNotFoundException fnfEx){
            System.out.println("File: " + fileName + " nicht found");
        }catch(IOException ioEx){
            System.out.println("Error while reading file: " + fileName);
        }


    }

    public String toString() {
        return strBuilder.toString();
    }

}
