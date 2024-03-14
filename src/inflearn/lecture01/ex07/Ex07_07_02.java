package inflearn.lecture01.ex07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_07_02 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        bfs(root);
    }

    public static void bfs(Node root) {
        int level = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            System.out.print("[" + level + "] ");
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");

                if (currentNode.lt != null) {
                    queue.offer(currentNode.lt);
                }
                if (currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }
            }
            System.out.println();
            level++;
        }
    }

    static class Node {

        int data;
        Node lt;
        Node rt;

        public Node(int val) {
            data = val;
            lt = null;
            rt = null;
        }

    }

}

