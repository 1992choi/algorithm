package inflearn.lecture01.ex07;

import java.util.LinkedList;
import java.util.Queue;

public class Ex07_10_02 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        System.out.println(bfs(root)); // 1
    }

    public static int bfs(Node node) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.lt == null && current.rt == null) {
                    return answer;
                }

                if (current.lt != null) {
                    queue.offer(current.lt);
                }
                if (current.rt != null) {
                    queue.offer(current.rt);
                }
            }

            answer++;
        }

        return answer;
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

