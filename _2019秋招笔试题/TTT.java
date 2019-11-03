package _2019秋招笔试题;

import java.util.*;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-30 16:01
 **/
public class TTT {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> linkedMap = new LinkedHashMap<> (16,0.75f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, String> eldest) {
                return size () > 16;
            }
        };
    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "[ 姓名：" + this.name + ", 年龄：" + this.age + " ]";
    }
}
