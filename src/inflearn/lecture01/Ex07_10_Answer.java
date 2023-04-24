package inflearn.lecture01;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_10_Answer {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        /*
            ========== 트리 형태 ==========
                        1
                  2           3
               4     5
         */

        System.out.println(BFS(root));
    }

    public static int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                if (currentNode.lt == null && currentNode.rt == null) {
                    return level;
                }

                if (currentNode.lt != null) {
                    queue.offer(currentNode.lt);
                }
                if (currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }
            }
            level++;
        }

        return -1;
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

