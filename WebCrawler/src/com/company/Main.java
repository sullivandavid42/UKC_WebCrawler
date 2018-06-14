package com.company;
import Dom_Interactions.Dom_Opening;


public class Main {

    public static void main(String[] args) {
        Dom_Opening dom_reader = new Dom_Opening();
        try {
        dom_reader.Fetch_URL(); } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
