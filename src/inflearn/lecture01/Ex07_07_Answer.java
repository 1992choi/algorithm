package inflearn.lecture01;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_07_Answer {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        BFS(root);

        /*
            ========== 트리 형태 ==========
                        1
                  2           3
               4     5     6     7
         */
    }

    public static void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print("level = " + level + " : ");
            for (int i = 0; i < len; i++) {
                Node currentNode = queue.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.lt != null) {
                    queue.offer(currentNode.lt);
                }
                if (currentNode.rt != null) {
                    queue.offer(currentNode.rt);
                }
            }
            level++;
            System.out.println();
        }

        /*
            ====== 실행결과  ======
            level = 0 : 1
            level = 1 : 2 3
            level = 2 : 4 5 6 7
         */
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

