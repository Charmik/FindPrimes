package main.ru.ifmo.ctdev.lovkov;


/**
 * Created by charm on 12/28/14.
 */
public class FindPrimers {

    public int getPrimes(int start, int finish) {
        int cntOfPrimes = 0;
        for (int i = start; i <= finish; i++) {
            if (IsPrime.check(i)) {
                cntOfPrimes++;
            }
        }
        return cntOfPrimes;
    }



}
