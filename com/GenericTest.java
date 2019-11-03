package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-10 15:51
 **/
public class GenericTest {
    public static void main(String[] args) {
        Pair<String>[] table = (Pair<String>[]) new Pair<?>[1];
        String str = min (new String[]{"s","2"});
        System.out.println (str);

        List li = new ArrayList ();
        List<?> list = li ;

    }

    public static <T extends Comparable<? extends T>> T min(T[] a) {
        return a[0];
    }
}

class Pair<T> {
    private T first;
    private T second;

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }


    public void setSecond(T second) {
        this.second = second;
    }


}
