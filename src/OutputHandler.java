package src;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * The OutputHandler class provides methods for writing text to files.
 */
public class OutputHandler {
    
    private static String linebreakstring="_";
    private static StringBuilder strBuilder;

    /**
     * Constructs a new OutputHandler object.
     */
    public OutputHandler(){
       strBuilder = new StringBuilder();
    }

    /**
     * Writes text to the specified file.
     *
     * @param filename The name of the file to write text to.
     * @param text The text to write to the file.
     */
    public static void writeTextToFile(String filename, String text){

        String[] lines = text.split(linebreakstring);
        File file = new File(".\\outputfiles\\"+filename);

        try(
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        ){
            for(String line : lines){
                pw.println(line);
            }            

        }catch (FileNotFoundException fnfEx){
            System.out.println("File: " + file + " not found");
        }  catch (IOException ioEx) {
            System.out.println("Error occured while writing in: " + filename);
        } 
    }
}
