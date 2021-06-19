package networking;

import subject.Stock;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class FileHandler {

    HashMap readFile() throws FileNotFoundException {

        File file = new File("src/input.txt");

        Scanner scanner = new Scanner(file);

        HashMap<String, Stock> stocks = new HashMap<>();

        while(scanner.hasNextLine())
        {
            String text = scanner.nextLine();

            StringTokenizer stringTokenizer = new StringTokenizer(text," ");
            Vector<String>tokens = new Vector<>();
            while (stringTokenizer.hasMoreTokens())
            {
                tokens.add(stringTokenizer.nextToken());
            }

            String name = tokens.elementAt(0);
            Integer count = Integer.parseInt(tokens.elementAt(1));
            Float cost = Float.parseFloat(tokens.elementAt(2));

            stocks.put(name,new Stock(name,count,cost));
        }

        return stocks;
    }
}
