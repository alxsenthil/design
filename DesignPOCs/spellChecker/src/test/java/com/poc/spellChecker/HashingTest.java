package com.poc.spellChecker;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalMatchers;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class HashingTest {

    private Hashing hashing;

    @BeforeEach
    public void setup(){
        hashing = Mockito.mock(Hashing.class,Mockito.withSettings().useConstructor(10));
        List<Integer> list=new ArrayList<>();
        list.add(1234567);
        list.add(5234567);
        list.add(5234567);
        Mockito.when(hashing.getHashValues(Mockito.eq("welcome"))).thenReturn(list);
        Mockito.when(hashing.getHashValues(Mockito.eq("welcome1"))).thenReturn(new ArrayList<Integer>());

    }

    @Test
    public void testHashing(){
        List<Integer> list=hashing.getHashValues("welcome1");
        System.out.println(list);
    }
}
