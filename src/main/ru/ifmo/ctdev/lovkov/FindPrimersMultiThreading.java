package main.ru.ifmo.ctdev.lovkov;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by charm on 12/28/14.
 */
public class FindPrimersMultiThreading {




    public int getPrimes(int start, int finish, int cntOfThreads) {


        int prevIndex = start - 1;

        ArrayList<Thread> arrayListOfThreads = new ArrayList<Thread>();
        ArrayList<GetPrimes> arrayListOfGetPrimes = new ArrayList<GetPrimes>();

        for (int i = 1; i <= cntOfThreads; i++) {
            int index = ((finish - start) * i) / cntOfThreads + start;

            GetPrimes getPrimes = new GetPrimes(prevIndex + 1, index);

            Thread thread = new Thread(getPrimes);
            arrayListOfThreads.add(thread);
            arrayListOfGetPrimes.add(getPrimes);
            thread.start();
            prevIndex = index;
        }
        for (int i = 0; i < arrayListOfThreads.size(); i++) {
            try {
                arrayListOfThreads.get(i).join();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("InterruptedException");
            }
        }
        int cntOfPrimes = 0;
        for (int i = 0; i < arrayListOfGetPrimes.size(); i++) {
            cntOfPrimes += arrayListOfGetPrimes.get(i).getCntOfPrimes();
        }


        return cntOfPrimes;
    }


    private class GetPrimes implements Runnable {
        private int start, finish;
        private AtomicInteger cntOfPrimes;

        GetPrimes(int start, int finish) {
            this.start = start;
            this.finish = finish;
            this.cntOfPrimes = new AtomicInteger(0);
        }

        public int getCntOfPrimes() {
            return cntOfPrimes.get();
        }

        @Override
        public void run() {
            for (int i = start; i <= finish; i++) {
                if (IsPrime.check(i)) {
                    cntOfPrimes.incrementAndGet();
                }
            }
        }


    }

}

