package com.company;
import Dom_Interactions.Dom_Opening;
import Parser.Parser_URL_Input;


public class Main {

    public static void main(String[] args) {
	    System.out.println("test");
       // Parser.Parser_URL_Input tt = new Parser_URL_Input();
        Dom_Opening dom_reader = new Dom_Opening();
        try {
        dom_reader.Get_DOM(); } catch (Exception e) {
            e.printStackTrace();
        }

       /* try {
        tt.file_input(); } catch (Exception e) {
            e.printStackTrace();
        } */
    }
}
