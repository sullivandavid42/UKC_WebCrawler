package com.company;
import Parser.Parser_URL_Input;


public class Main {

    public static void main(String[] args) {
	    System.out.println("test");
        Parser.Parser_URL_Input tt = new Parser_URL_Input();

        try {
        tt.file_input(); } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
