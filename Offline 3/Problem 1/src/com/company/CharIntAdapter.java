package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharIntAdapter extends IntegerFile{

    CharIntAdapter(File file) throws IOException {
        super(file);
        super.file = charToAscii(file);
    }

    public File charToAscii(File file) throws IOException {
        File temp = new File("src/temp.txt"); //initialize File object and passing path as argument
        temp.createNewFile();

        FileWriter fileWriter = new FileWriter("src/temp.txt");

        Scanner scanner = new Scanner(file);

        while(scanner.hasNext())
        {
            char c = scanner.next().charAt(0);
            int ascii = c;
            System.out.println(c + " || " +ascii);
            fileWriter.write(ascii+" ");
        }

        fileWriter.close();
        return temp;
    }
}
