package _2019秋招笔试题.weipinhui_0915;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-09-15 19:00
 **/
public class Main2LFU {
    public static void main(String[] args) {

    }

    int cnt = 0;
    int size;
    Map<Integer, Node> map;
    PriorityQueue<Node> queue;

    public Main2LFU(int capacity) {

        this.size = capacity;
        this.map = new HashMap<> (capacity);
        this.queue = new PriorityQueue<> (capacity);
    }

    public int get(int key) {
        if (map.containsKey (key)) {
            Node node = map.get (key);
            node.time += 1;
            cnt++;
            node.count = cnt;
            queue.remove (node);
            queue.offer (node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey (key)) {
            Node node = map.get (key);
            node.time += 1;
            cnt++;
            node.count = cnt;
            node.val = value;
            queue.remove (node);
            queue.offer (node);
        } else {
            if (map.size () == this.size) {
                Node n = queue.poll ();
                map.remove (n.key);
            }
            Node node = new Node (value, key, 1, ++cnt);
            queue.offer (node);
            map.put (key, node);
        }
    }
}

class Node implements Comparable<Node> {
    int val;
    int key;
    int time;
    int count;

    public Node(int val, int key, int time, int count) {
        this.val = val;
        this.key = key;
        this.time = time;
        this.count = count;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time == 0 ? this.count - o.count : this.time - o.time;
    }
}
