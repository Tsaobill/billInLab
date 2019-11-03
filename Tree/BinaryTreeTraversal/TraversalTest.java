/**
 * 上海大学
 * FileName: TraversalTest
 * Author:   bill
 * Date:     2018/11/30 20:07
 * Description: 测试类
 * History:
 */
package Tree.BinaryTreeTraversal;

import Tree.BTN;

public class TraversalTest {
    public static void main(String[] args) {
        BTN a = new BTN(1);
        BTN b = new BTN(3);
        BTN c = new BTN(5);
        BTN d = new BTN(7);
        BTN e = new BTN(2,a,b);
        BTN f = new BTN(6,c,d);
        BTN g = new BTN(4,e,f);

        BTNTraversal.preOrderTraInRec(g);
        System.out.println();
        BTNTraversal.inOrderTraInRec(g);
        System.out.println();
        BTNTraversal.postOrderTraInRec(g);
        System.out.println();

        BTNTraversal.inOrderTraNoRec1(g);
        System.out.println();
        BTNTraversal.postOrderTraNoRec1(g);
        System.out.println();
        BTNTraversal.preOrderTraNoRec2(g);
        System.out.println();
        BTNTraversal.lvOrderTra(g);
        System.out.println();
        BTNTraversal.lvOrderTra2(g);



    }

}