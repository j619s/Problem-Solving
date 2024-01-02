package hyperskill;

import java.io.File;
import java.io.IOException;

public class FileManager {
    public static void main(String[] args) {
        File file = new File("D:\\SpringToolSuiteWorkspace\\DSA\\src\\hyperskill\\file.txt");
        File dir = new File("D:\\SpringToolSuiteWorkspace\\DSA\\src\\hyperskill\\testDir");

        try{
            boolean createdNew = file.createNewFile();
            if(createdNew){
                System.out.println("File was successfully createad.");
            } else{
                System.out.println("file already exists");
            }
            

            boolean createdNewDirectory = dir.mkdir();
            if(createdNewDirectory){
                System.out.println("Director created");
            } else {
                System.out.println("Unable to create new directory.");
            }


        } catch (IOException e){
            System.out.println("Cannot create the file. " + file.getPath());
        }
    }
}
