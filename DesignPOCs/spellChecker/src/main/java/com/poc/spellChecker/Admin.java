package com.poc.spellChecker;

import java.util.List;

public class Admin extends User{
    public Admin(String name,BloomFilterService bloomFilterService){
        this.userName=name;
        this.bloomFilterService=bloomFilterService;
    }
    public void load(List<String> listOfStringToLoad){
          listOfStringToLoad.forEach(word->{
              this.bloomFilterService.insert(word);
          });
    }
    public String getUserName(){
        return this.userName;
    }


}
