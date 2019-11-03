package jvm;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-10-09 22:20
 **/
public class Parameter {
    public static final byte[] bytes = new byte[10 * 1024 * 1024];
    public static void main(String[] args) {
        long maxMem = Runtime.getRuntime ().maxMemory ();
        long totalMem = Runtime.getRuntime ().totalMemory ();
//        System.out.println ("TotalMem = " + totalMem + "K  / " + totalMem / 1024 / 1024 + "M");
//        System.out.println ("MaxMem = " + maxMem + "K / " + maxMem / 1024 / 1024 / 1024 + "G");

//        System.out.println ("***hello GC***");

        String s1 = new String ("ab");
        System.out.println (s1 == s1.intern ());
        String s2 = "ab";
        System.out.println (s2 == s2.intern ());
        System.out.println (s1 == s2.intern ());
        byte[] bytes = new byte[20 * 1024 * 1024];
        int i = 1;

        while(true){

        }
    }


}
