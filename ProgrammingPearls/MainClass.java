package ProgrammingPearls;

/**
 * @version 1.0
 * @created by bill
 * @on 2018-09-29 上午10:35
 **/
public class MainClass {
    public static void main(String[] args) {
        int n=0,a=1;
        while (n<1992){
            a*=1992;
            a%=100;
            n++;
        }
        System.out.println (a);
    }
}
