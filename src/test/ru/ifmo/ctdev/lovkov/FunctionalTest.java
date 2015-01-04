/**
 * Created by Charm on 04.01.2015.
 */
package test.ru.ifmo.ctdev.lovkov;

import junit.framework.TestCase;
import main.ru.ifmo.ctdev.lovkov.FindPrimers;
import main.ru.ifmo.ctdev.lovkov.FindPrimersMultiThreading;

import java.util.Random;

public class FunctionalTest extends TestCase {

    FindPrimers findPrimers = new FindPrimers();
    FindPrimersMultiThreading findPrimersMultiThreading = new FindPrimersMultiThreading();
    Random random = new Random(System.currentTimeMillis());

    private boolean equals(int start, int finish) {
        return findPrimers.getPrimes(start,finish) ==  findPrimersMultiThreading.getPrimes(start,finish,4);
    }

    public void testZeroPrimers() {
        assertEquals(findPrimers.getPrimes(0,0), 0);
        assertEquals(findPrimersMultiThreading.getPrimes(0,0,4), 0);
    }

    public void testRandom() {
        int start = Math.abs(random.nextInt()) % 1000;
        int finish = Math.abs(random.nextInt()) % 1000;
        if (start > finish) {
            int tmp = start;
            start = finish;
            finish = tmp;
        }
        assertTrue(equals(start,finish));
    }

    public void testStressRandom() {
        for (int i = 0; i < 1000; i++) {
            testRandom();
        }
    }



}
