package inflearn.lecture01.ex07;

public class Ex07_09_02 {

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);

        dfs(root, 0);
        System.out.println(answer); // 1
    }

    public static void dfs(Node node, int level) {
        if (node.lt == null && node.rt == null) {
            answer = Math.min(answer, level);
        } else {
            dfs(node.lt, level + 1);
            dfs(node.rt, level + 1);
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

