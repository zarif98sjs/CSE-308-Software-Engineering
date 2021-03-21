package com.company;

import editor.Editor;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Editor editor = Editor.getInstance();
        editor.setLanguage("CPP");

        System.out.println(editor);
    }
}
