package com.poc.spellChecker;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        int bloomFilterArraySize=100;
        int numberOfHashingAlgorithm=4;
        Hashing hashing =new Hashing(numberOfHashingAlgorithm);
        BloomFilterService bloomFilterService = new BloomFilterServiceImpl(bloomFilterArraySize, hashing);
        Guest guest = new Guest("Guest 1", bloomFilterService);
        Admin admin = new Admin("Admin 1", bloomFilterService);
        String listOfWords[] = {"abound", "abounds", "abundance",
                "abundant", "accessible", "bloom",
                "blossom", "bolster", "bonny",
                "bonus", "bonuses", "coherent",
                "cohesive", "colorful", "comely",
                "comfort", "gems", "generosity",
                "generous", "generously", "genial",
                "bluff", "cheater", "hate",
                "war", "humanity", "racism",
                "hurt", "nuke", "gloomy",
                "facebook", "geeksforgeeks", "twitter"};
        admin.load(Arrays.asList(listOfWords));
        System.out.println(guest.validate("facebook"));;
        System.out.println(guest.validate("facebook-1"));;



    }


}
