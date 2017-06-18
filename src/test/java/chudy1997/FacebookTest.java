package chudy1997;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

/**
 * Facebook's testclass
 * Created by Karol on 2017-06-18.
 */

public class FacebookTest {
    @Test
    public void testCompareToWhenEq() throws Exception {
        Facebook prof1, prof2;
        prof1 = Mockito.mock(Facebook.class);
        prof2 = Mockito.mock(Facebook.class);
        when(prof1.getFirstname()).thenReturn("Karol");
        when(prof1.getLastname()).thenReturn("Bartyzel");
        when(prof2.getFirstname()).thenReturn("Karol");
        when(prof2.getLastname()).thenReturn("Bartyzel");
        when(prof1.compareTo(prof2)).thenCallRealMethod();

        Assert.assertTrue(prof1.compareTo(prof2) == 0);
    }

    @Test
    public void testCompareToWhen1stSmaller() throws Exception {
        Facebook prof1, prof2;
        prof1 = Mockito.mock(Facebook.class);
        prof2 = Mockito.mock(Facebook.class);
        when(prof1.getFirstname()).thenReturn("Karol");
        when(prof1.getLastname()).thenReturn("Bartyzel");
        when(prof2.getFirstname()).thenReturn("Karol");
        when(prof2.getLastname()).thenReturn("Lezytrab");
        when(prof1.compareTo(prof2)).thenCallRealMethod();

        Assert.assertTrue(prof1.compareTo(prof2) < 0);
    }

    @Test
    public void testCompareToWhen2ndSmaller() throws Exception {
        Facebook prof1, prof2;
        prof1 = Mockito.mock(Facebook.class);
        prof2 = Mockito.mock(Facebook.class);
        when(prof1.getFirstname()).thenReturn("Lorak");
        when(prof1.getLastname()).thenReturn("Bartyzel");
        when(prof2.getFirstname()).thenReturn("Karol");
        when(prof2.getLastname()).thenReturn("Bartyzel");
        when(prof1.compareTo(prof2)).thenCallRealMethod();

        Assert.assertTrue(prof1.compareTo(prof2) > 0);
    }
}