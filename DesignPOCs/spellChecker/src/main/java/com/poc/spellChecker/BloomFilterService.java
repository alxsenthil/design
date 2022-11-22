package com.poc.spellChecker;

public interface BloomFilterService {
    public boolean lookup(String input);
    public boolean insert(String input);
}
