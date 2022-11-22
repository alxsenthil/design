package com.poc.spellChecker;

import java.util.List;

public class BloomFilterServiceImpl implements BloomFilterService{
    private final boolean[] bloomFilterArray;
    private Hashing hashing;
    public BloomFilterServiceImpl(int bloomFilterSize,Hashing hashing){
        bloomFilterArray=new boolean[bloomFilterSize];
        this.hashing=hashing;
        this.hashing.setBloomfilterSize(bloomFilterSize);
    }
    @Override
    public boolean lookup(String input) {
        List<Integer> listOfHashValues=hashing.getHashValues(input);
        long countValue=listOfHashValues.stream().filter(hashValue->{
            if(bloomFilterArray[hashValue]){
                return true;
            }
            return false;
        }).count();
        if(countValue==listOfHashValues.size()){
            return true;
        }
        return false;
    }

    @Override
    public boolean insert(String input) {
        List<Integer> listOfHashValues=hashing.getHashValues(input);
        listOfHashValues.stream().forEach(value->{
              bloomFilterArray[value]=true;
        });
        return true;
    }
}
