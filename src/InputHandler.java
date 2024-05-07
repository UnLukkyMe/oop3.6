package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The InputHandler class provides methods for reading text from files and printing text to the console.
 */
public class InputHandler {
    private StringBuilder strBuilder;
    private String linebreakstring="_";

    /**
     * Constructs a new InputHandler object.
     */
    public InputHandler() {
        strBuilder = new StringBuilder();
    }

    /**
     * Reads text from the specified file.
     *
     * @param fileName The name of the file to read text from.
     */
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

    /**
     * Prints text from the specified file to the console.
     *
     * @param fileName The name of the file to print text from.
     */
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

    /**
     * Returns the text read from the file as a string.
     *
     * @return The text read from the file.
     */
    public String toString() {
        return strBuilder.toString();
    }

}

