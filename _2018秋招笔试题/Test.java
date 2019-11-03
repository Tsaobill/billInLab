package _2018秋招笔试题;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version 1.0
 * @created by bill
 * @on 2018-10-14 下午7:18
 **/
public class Test {
    public static void main(String[] args) {
//        String[] array = new String[]{"BZ", "A", "BA", "D"};
//
//        TreeMap<String, Integer> treem = new TreeMap<> ();
//        putValues (array,treem);
//        LinkedHashMap<String,Integer> linkedHashMap =new LinkedHashMap<> ();
//        putValues (array,linkedHashMap);
//
//        listKeys (treem);
//        System.out.print ("----");
//        listKeys (linkedHashMap);
//        System.out.println (Math.round (11.45));
//
//        Test t=new Test ();
//        t.method (null);

int a=1;
long b=2;
        sum (a,b);

    }
//long 类型变量 匹配float
    public static void sum(int a,float b){
        System.out.println ("float"+(a+b));
    }
    public static void sum(int a,double b){
        System.out.println ("dou"+(a+b));

    }
    public static void sum(int a,int b){
        System.out.println ("int"+(a+b));

    }
    private void method(Object o){
        System.out.println ("o");
    }
////    private void method(String s){
////        System.out.println ("s");
////    }
    private void method(Integer i){
        System.out.println ("i");
    }
    private static void putValues(String[] array, Map<String,Integer> map){
        for (int i = 0; i < array.length; i++) {
            map.put (array[i],i);
        }
    }

    private static void listKeys(Map<String ,Integer> map){
        int size =map.size ();
        int i =0;
        for (Map.Entry<String ,Integer> entry: map.entrySet ()
             ) {
            if (i==size-1){
                System.out.print (entry.getKey ());
            }else System.out.print (entry.getKey ()+",");
            i++;
        }
    }
}
