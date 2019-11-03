package _2019秋招笔试题.iqiyi_0908;

import java.util.Scanner;

/**
 * 有一个非常经典的概率问题，是一个袋子里面有若干个红球和若干个蓝球，
 * 两个人轮流取出一个球，谁先取到红球谁就赢了，当人的先后顺序和球的数量确定时，
 * 双方的胜率都可以由计算得到，这个问题显然是很简单的。
 * <p>
 * 现在有一个进阶版的问题，同样是一个袋子里面有n个红球和m个蓝球，
 * 共有A，B，C三人参与游戏，三人按照A，B，C的顺序轮流操作，
 * 在每一回合中，A，B，C都会随机从袋子里面拿走一个球，然而真正分出胜负的只有A，B两个人，
 * 没错，C就是来捣乱的，他除了可以使得袋子里面减少一个球，没有其他任何意义，
 * 而A，B谁 先拿到红球就可以获得胜利，但是由于C的存在，两人可能都拿不到红球，此时B获得胜利。
 *
 * @version 1.0
 * @created by bill
 * @on 2019-09-08 16:02
 **/
public class Main2 {
    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        int t = n + m;
        double fenmu = fact (n + m);
        double fenzi = 0;
        int i = 1;
        while (i <= t) {
            fenzi += fact (t - i);
            i += 3;
        }

        System.out.println (fenzi / fenmu);
    }

    static int fact(int n) {
        if (n <= 2) return n;
        return n * fact (n - 1);
    }
}
