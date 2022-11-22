package com.poc.spellChecker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.withSettings;
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AdminTest extends MockBloomFilterService{
    @Mock
    private Admin admin;

    @Test
    public void  testInsertStringInSuccess(){
        admin= Mockito.mock(Admin.class,withSettings().useConstructor("Test",bloomFilterService));
        List<String> input=new ArrayList<>();
        admin.load(input);
    }
}
