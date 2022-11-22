package com.poc.spellChecker;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Hashing {
    private int noOfHashing=0;
    private int bloomfilterSize=0;

    public Hashing(int noOfHashing){
        this.noOfHashing=noOfHashing;
    }

    public List<Integer> getHashValues(String input){
        List<Integer> listOfHashValues=new ArrayList<>();
        for(int i=0;i<noOfHashing;i++){
            listOfHashValues.add(getHashValue(i,input));
        }
        return listOfHashValues;
    }
    public int getHashValue(int algId, String input){
        int algValue=(int)Math.pow(2,algId);
        return (Math.abs(algValue+Math.abs(input.hashCode())))%bloomfilterSize;
    }
    public void setBloomfilterSize(int bloomfilterSize){
        this.bloomfilterSize=bloomfilterSize;
    }
}
