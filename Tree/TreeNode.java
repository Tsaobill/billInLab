/**
 * 上海大学
 * FileName: TreeNode
 * Author:   bill
 * Date:     2018/11/30 19:52
 * Description: 树节点
 * History:
 */
package Tree;

public class TreeNode {
    public Object val;
    public TreeNode firstChild;
    public TreeNode nextRightBrother;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Object val, TreeNode firstChild, TreeNode nextRightBrother) {
        this.val = val;
        this.firstChild = firstChild;
        this.nextRightBrother = nextRightBrother;
    }

    public TreeNode(Object val) {
        this.val = val;
    }
}