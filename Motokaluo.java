import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-04-16 15:58
 **/
public class Motokaluo {
    public static void main(String[] args) {
        Random r = new Random ();
        int NUM = 10000000;
        List boxs = new ArrayList ();

        List box1 = new ArrayList ();
        box1.add (new coin (true));
        box1.add (new coin (true));

        List box2 = new ArrayList ();
        box2.add (new coin (true));
        box2.add (new coin (false));

        List box3 = new ArrayList ();
        box3.add (new coin (false));
        box3.add (new coin (false));

        boxs.add (box1);
        boxs.add (box2);
        boxs.add (box3);

        float m = 0f;//选中的盒子中取出一枚硬币为金币的情况出现的次数
        float n = 0f;//选中一个盒子取出一枚硬币为金币时另一枚硬币也是金币出现的次数
        float k = 0f;
        for (int i = 0; i < NUM; i++) {
            int box = r.nextInt (3);
            ArrayList a = (ArrayList) boxs.get (box);
            int idx = r.nextInt (2);
            boolean color = ((coin) (a.get (idx))).property;
            if (color) {
                m++;
                boolean color2 = ((coin) (a.get (1 - idx))).property;
                if (color2) {
                    n++;
                } else {
                    k++;
                }
            }
        }
        System.out.println ("m = " + m);
        System.out.println ("n = " + n);
        System.out.println ("k = " + k);
        System.out.println ("n/m = " + n / m);


        HashMap map = new HashMap ();
    }
}

class coin {
    boolean property;
    public coin(boolean property) {
        this.property = property;
    }
}