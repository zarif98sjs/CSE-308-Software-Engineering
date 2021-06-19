package com.company;

import mediator.JCC;
import service.*;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {

        Wrapper wrapper = null;

        while (true)
        {
            Scanner sc = new Scanner(System.in);
            String msg = sc.nextLine();

            if(msg.equals("Init"))
            {
                if(wrapper == null) wrapper = new Wrapper();
            }
            else
            {
                StringTokenizer stringTokenizer = new StringTokenizer(msg, " ");
                Vector<String> tokens = new Vector<>();

                while (stringTokenizer.hasMoreTokens()) {
                    tokens.add(stringTokenizer.nextToken());
                }

                String first = tokens.elementAt(0);
                String second = tokens.elementAt(1);

                wrapper.process(first,second);

            }
        }
    }

}

