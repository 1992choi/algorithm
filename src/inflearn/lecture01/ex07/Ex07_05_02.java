package inflearn.lecture01.ex07;

public class Ex07_05_02 {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);

        System.out.println("=== 전위 순회 ===");
        dfs("preorder", root);

        System.out.println("\n\n=== 중위 순회 ===");
        dfs("inorder", root);

        System.out.println("\n\n=== 후위 순회 ===");
        dfs("postorder", root);
    }

    public static void dfs(String type, Node root) {
        if (root == null) {
            return;
        } else {
            if ("preorder".equals(type)) { // 전위 순회
                System.out.print(root.data + " ");
                dfs(type, root.lt);
                dfs(type, root.rt);
            } else if ("inorder".equals(type)) { // 중위 순회
                dfs(type, root.lt);
                System.out.print(root.data + " ");
                dfs(type, root.rt);
            } else if ("postorder".equals(type)) { // 후위 순회
                dfs(type, root.lt);
                dfs(type, root.rt);
                System.out.print(root.data + " ");
            }
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

