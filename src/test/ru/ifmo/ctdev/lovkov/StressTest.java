/**
 * Created by Charm on 04.01.2015.
 */
package test.ru.ifmo.ctdev.lovkov;

import junit.framework.TestCase;
import main.ru.ifmo.ctdev.lovkov.FindPrimersMultiThreading;

import java.util.Random;

public class StressTest extends TestCase {

    FindPrimersMultiThreading findPrimersMultiThreading = new FindPrimersMultiThreading();
    Random random = new Random(System.currentTimeMillis());
    private static int maxValue = 10000000;
    private static int cntIteration = 10;


    public void testStressRandom() {
        for (int i = 0; i < cntIteration; i++) {
            int start = Math.abs(random.nextInt() % maxValue);
            int finish = Math.abs(random.nextInt() % maxValue);
            if (start > finish) {
                int tmp = start;
                start = finish;
                finish = tmp;
            }
            long startOfFindPrimers = System.currentTimeMillis();
            int cntOfFindPrimers = findPrimersMultiThreading.getPrimes(start, finish,2);
            long timeOfFindPrimers = System.currentTimeMillis() - startOfFindPrimers;

            long startOfFindPrimersMultiThreading = System.currentTimeMillis();
            int cntOfFindPrimersMultiThreading = findPrimersMultiThreading.getPrimes(start, finish,4);
            long timeOfFindPrimersMultiThreading = System.currentTimeMillis() - startOfFindPrimersMultiThreading;
            if (timeOfFindPrimersMultiThreading > timeOfFindPrimers) {
                //System.out.println(finish + " " + start);
            }
            System.out.println("TEST " + i + " 2 threads: " + timeOfFindPrimers + "  4 threads: " + timeOfFindPrimersMultiThreading);
            assertEquals(cntOfFindPrimers, cntOfFindPrimersMultiThreading);
        }
    }



}
