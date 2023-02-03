package inflearn;

public class Ex07_09_Answer {

    public static void main(String[] args) {
        /*
            Ex07_05_Answer.java 파일에 선언되어 있음

            class Node {

                int data;
                Node lt;
                Node rt;

                public Node(int val) {
                    data = val;
                    lt = null;
                    rt = null;
                }

            }
         */
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

        System.out.println(DFS(0, root));
    }

    public static int DFS(int level, Node root) {
        if (root.lt == null && root.rt == null) {
            return level;
        } else {
            return Math.min(DFS(level + 1, root.lt), DFS(level + 1, root.rt));
        }
    }

}

