package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculation {

    public int calculateSum(IntegerFile integerFile) throws FileNotFoundException {

        Scanner scanner = new Scanner(integerFile.file);

        int sum = 0;

        while(scanner.hasNextInt())
        {
           sum += scanner.nextInt();
        }

        return sum;
    }
}
