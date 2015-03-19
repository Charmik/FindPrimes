package main.ru.ifmo.ctdev.lovkov;

public class Main {

    public static void main(String[] args) {

        int start = 13;
        int finish = 10000;

        FindPrimers findPrimers = new FindPrimers();

        int cntOfPrimes = findPrimers.getPrimes(start,finish);
        System.out.println(cntOfPrimes);

        FindPrimersMultiThreading findPrimersMultiThreading = new FindPrimersMultiThreading();
        int cntOfPrimesFromMultiThreading = findPrimersMultiThreading.getPrimes(start,finish,4);
        System.out.println(cntOfPrimesFromMultiThreading);

    }
}
