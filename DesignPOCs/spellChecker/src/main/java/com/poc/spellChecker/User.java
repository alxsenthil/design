package com.poc.spellChecker;

public abstract class User {
    public String userName;
    public String id;
    public BloomFilterService bloomFilterService;

    public abstract String getUserName();


}
