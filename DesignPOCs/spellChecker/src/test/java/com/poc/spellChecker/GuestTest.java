package com.poc.spellChecker;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.withSettings;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class GuestTest extends MockBloomFilterService {

    private Guest guest;

    @Test
    public void testLookupInFailure() {
        guest = Mockito.mock(Guest.class, withSettings().useConstructor("Test", bloomFilterService));
        boolean status = guest.validate("welcome1");
        assertEquals(false, status);
    }
}
