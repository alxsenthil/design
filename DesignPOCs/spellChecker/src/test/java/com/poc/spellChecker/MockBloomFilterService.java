package com.poc.spellChecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class MockBloomFilterService {
    @Mock
    public BloomFilterService bloomFilterService;
    @Mock
    public Hashing hashing;
    private int bloomFilterSize=100;
    private int numberOfHashingAlg=100;

    @BeforeEach
    public void setup(){
        System.out.println("Running before each");
        hashing = Mockito.mock(Hashing.class,Mockito.withSettings().useConstructor(10));
        List<Integer> list=new ArrayList<>();
        list.add(1234567);
        list.add(5234567);
        list.add(5234567);
        Mockito.when(hashing.getHashValues(Mockito.eq("welcome"))).thenReturn(list);
        Mockito.when(hashing.getHashValues(Mockito.eq("welcome1"))).thenReturn(new ArrayList<Integer>());
        bloomFilterService = Mockito.mock(BloomFilterServiceImpl.class,withSettings().useConstructor(bloomFilterSize,hashing));
        when(bloomFilterService.insert(Mockito.eq("welcome"))).thenReturn(true);
        when(bloomFilterService.lookup(Mockito.eq("welcome"))).thenReturn(true);
        when(bloomFilterService.lookup(Mockito.eq("welcome1"))).thenReturn(false);
    }

}
