package main.ru.ifmo.ctdev.lovkov;


/**
 * Created by Charm on 03.01.2015.
 */
public class IsPrime {
    static public boolean check(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
