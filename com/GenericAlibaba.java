package com;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-07-10 20:42
 **/
public class GenericAlibaba<T, U, S> {
    public <String, T, Alibaba> T get(String str, T t, Alibaba ali) {

        return t;

    }

    public T t;

    public GenericAlibaba(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        Integer integer = 12314;
        Long lo = 345L;
        Double dou = 234.5d;
        String a = "sf";
        GenericAlibaba<Float, String, Integer> ga = new GenericAlibaba<> (123f);
        Float f = ga.t;
        System.out.println (f);
        Long res = ga.get (integer, lo, dou);

        System.out.println (res);
    }
}
