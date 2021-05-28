package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	    // write your code here

        Calculation calculation = new Calculation();

        System.out.println("Choose Type :");
        System.out.println("int or char");

        Scanner sc= new Scanner(System.in);
        String file_type = sc.next();

        IntegerFile integerFile;
        String file_path = "src/input.txt";

        if(file_type.equalsIgnoreCase("int"))
        {
            integerFile = new IntegerFile(new File(file_path));
        }
        else
        {
            integerFile = new CharIntAdapter(new File(file_path));
        }

        System.out.println(calculation.calculateSum(integerFile));

    }
}
