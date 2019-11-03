/**
 * 上海大学
 * FileName: AvlTree
 * Author:   bill
 * Date:     2018/12/2 19:36
 * Description: Avl树数据结构的实现
 * History:
 */
package Tree.AvTree;

public class AvlTree<T> {
    private static class AvlNode<T> {
        //Constructors
        AvlNode(T element) {
            this.element = element;
        }

        AvlNode(T element, AvlNode<T> left, AvlNode<T> right, int height) {
            this(element);
            this.left = left;
            this.right = right;
            this.height = height;
        }

        T element;
        AvlNode<T> left;
        AvlNode<T> right;
        int height;
    }

    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }
}