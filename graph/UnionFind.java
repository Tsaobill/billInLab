package graph;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-21 14:26
 **/
public class UnionFind {
    int[] pre;
    int[] num;

    // 递归
    int unionfind(int ele) {
        return ele == pre[ele] ? ele : (pre[ele] = unionfind (pre[ele]));
    }

    // 非递归
    int unionfindIter(int ele) {
        while (ele != pre[ele]) {
            pre[ele] = pre[pre[ele]];
            ele = pre[ele];
        }
        return ele;
    }

    void join(int a, int b) {
        int x = unionfind (a);
        int y = unionfind (b);
        if (x != y) {
            pre[x] = y;
            num[y] += num[x];
        }
    }

    // 带删除功能的并查集初始化 和 删除函数
    int index;   //存放盒子节点使用到哪一个了

    void init(int n) {
        index = n;
        for (int i = 0; i < n; i++)     //普通节点指向他的盒子节点
            pre[i] = index++;
        for (int i = n; i < 2 * n; i++)   //盒子节点指向自己就像一般的并查集一样
            pre[i] = i;
    }

    void del(int n) {
        pre[n] = index;   //将要删除的节点重新指向一个新的盒子
        pre[index] = index++;   //盒子节点指向自己
    }
}
