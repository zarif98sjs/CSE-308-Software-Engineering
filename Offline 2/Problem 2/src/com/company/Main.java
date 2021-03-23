package com.company;

import editor.Editor;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Editor editor = Editor.getInstance();

        while(true)
        {
            System.out.println("Choose Language :");
            System.out.println("C , CPP or Pythpn");

            Scanner sc= new Scanner(System.in);
            String file_type = sc.next();
            editor.setLanguage(file_type);
            System.out.println(editor+"\n");
        }


    }
}
