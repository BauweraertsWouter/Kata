package com.wouter.kata.karatechop;

/*import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Assert;*/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for KarateChop.
 */
public class KarateChopTest {

    KarateChop chop;

    @Before
    public void init(){
        chop = new KarateChop();
    }

    @Test
    public void searchTestEmpty(){
        assertEquals(-1, chop.search(3, new int[]{}));
    }

    @Test
    public void searchSingleElementPresent(){
        assertEquals(0, chop.search(1, new int[]{1}));
    }

    @Test
    public void searchSingleElementAbsent(){
        assertEquals(-1, chop.search(1, new int[]{3}));
    }

    @Test
    public void searchMultiElementPresentUneven(){
        assertEquals(1,chop.search(3, new int[] {1,3,5}));
    }

    @Test
    public void searchMultiElementAbsentUneven(){
        assertEquals(-1, chop.search(2, new int[] {1,3,5}));
    }

    @Test
    public void searchMultiElementPresentEven(){
        assertEquals(2,chop.search(5, new int[] {1,3,5,6}));
    }

    @Test
    public void searchMultiElementAbsentEven(){
        assertEquals(-1, chop.search(2, new int[] {1,3}));
    }
}
