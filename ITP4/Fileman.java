package ITP4;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Fileman {
    public static void main(String[] args){
        try{
            Files.write(Paths.get("ITP4\\text2.txt"), Files.readAllBytes(Paths.get("ITP4\\text1.txt")));
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + e.getMessage());
        } catch (AccessDeniedException acc){
            System.out.println("Invalid access");
            acc.printStackTrace();
        } catch (IOException exception){
            exception.printStackTrace();;
        } 
    }
}
