package _2018秋招笔试题;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @version 1.0
 * @created by bill
 * @on 2018-10-31 下午7:35
 **/
public class TreeHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int i = scanner.nextInt ();
        //   long l = System.currentTimeMillis ();
        //初始化二叉树
        Tree[] trees = new Tree[i];
        //parent为父节点
        int parent = 0;
        for (int j = 0; j < trees.length; j++) {
            if (j == 0) {
                //如果是顶层节点的二叉树
                trees[j] = new Tree (parent, j);
            } else {
                trees[j] = new Tree (parent, j);
                parent = j % 2 == 0 ? parent + 1 : parent;
            }
        }
//        for (int j = 0; j < trees.length; j++) {
//            System.out.println (trees[j]);
//        }
        System.out.println (getLength (trees));
        //long m = System.currentTimeMillis ();
        //System.out.println (m - l);
    }

    public static int getLength(Tree[] trees) {
        //其实二叉树的层数 就是二叉树节点个数的二进制表示的长度
        int nums = trees == null ? 0 : trees.length;
        return Integer.toBinaryString (nums).length ();
    }
}

class Tree {
    private int parentNum;
    private int myNum;

    public Tree() {
        super ();    // TODO Auto-generated constructor stub
    }

    public Tree(int parentNum, int myNum) {
        super ();
        this.parentNum = parentNum;
        this.myNum = myNum;
    }

    public int getParentNum() {
        return parentNum;
    }

    public void setParentNum(int parentNum) {
        this.parentNum = parentNum;
    }

    public int getMyNum() {
        return myNum;
    }

    public void setMyNum(int myNum) {
        this.myNum = myNum;
    }

    @Override
    public String toString() {
        return parentNum + " " + myNum;
    }
}

