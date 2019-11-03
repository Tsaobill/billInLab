/**
 * 上海大学
 * FileName: BTN
 * Author:   bill
 * Date:     2018/11/30 19:58
 * Description: 二叉树节点
 * History:
 */
package Tree;

public class BTN {
    public int val;
    public BTN left;
    public BTN right;

    public BTN(int val) {
        this.val = val;
    }

    public BTN(int val, BTN left, BTN right) {
        this(val);
        this.left = left;
        this.right = right;
    }
}