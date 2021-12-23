package Utilities;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;


public class readInTxt{
    private Scanner file;
    private BufferedReader read;
    private String [][] fields;
    private int totalValue;
   

    public Boolean fileRead(String FilePath) throws FileNotFoundException{
        read = new BufferedReader(new FileReader(FilePath));
        file = new Scanner(new File(FilePath));
        return true;
    }

    public Boolean fillFromFile() throws ArrayIndexOutOfBoundsException, IOException{
        if(file == null || read == null) return false;
        while (read.readLine() != null) totalValue++; read.close();
        fields = new String[totalValue][];
        for(int i =0; i < totalValue; i++) { fields[i] = file.nextLine().split("\\:");}
        return true;
    }

    public String getField(int x, int y) throws ArrayIndexOutOfBoundsException{
        return fields[x][y];
    }

    public void fileClose() {
        file.close();
    }

}



