package com.poc.spellChecker;

public class Guest extends User{

    public Guest(String name,BloomFilterService bloomFilterService){
        this.bloomFilterService=bloomFilterService;
        this.userName=name;
    }
    public boolean validate(String input){
        return bloomFilterService.lookup(input);
    }
    public String getUserName(){
        return this.userName;
    }
}
