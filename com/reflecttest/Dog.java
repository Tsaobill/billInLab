package com.reflecttest;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-01 15:46
 **/
public class Dog implements Animal {
    @Override
    public void bark() {
        System.out.println ("<<<<<<dog is barking");
    }

    @Override
    public void watch() {
        System.out.println ("<<<<<Dog is Watching");
    }

    @Override
    public void eat(String str) {
        System.out.println ("<<<<< dog is eating " + str);
    }
}
