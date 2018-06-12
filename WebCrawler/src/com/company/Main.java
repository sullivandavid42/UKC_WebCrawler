package com.company;
import Dom_Interactions.Dom_Opening;
import Parser.Parser_URL_Input;


public class Main {

    public static void main(String[] args) {
        Dom_Opening dom_reader = new Dom_Opening();
        try {
        dom_reader.Get_DOM(); } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
