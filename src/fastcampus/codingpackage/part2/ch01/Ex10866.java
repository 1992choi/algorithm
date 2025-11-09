package fastcampus.codingpackage.part2.ch01;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Ex10866 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String action = sc.next();

            if ("push_front".equals(action)) {
                int num = sc.nextInt();
                queue.offerFirst(num);
            } else if ("push_back".equals(action)) {
                int num = sc.nextInt();
                queue.offerLast(num);
            } else if ("pop_front".equals(action)) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.pollFirst());
                }
            } else if ("pop_back".equals(action)) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.pollLast());
                }
            } else if ("size".equals(action)) {
                System.out.println(queue.size());
            } else if ("empty".equals(action)) {
                if (queue.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if ("front".equals(action)) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peekFirst());
                }
            } else if ("back".equals(action)) {
                if (queue.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(queue.peekLast());
                }
            }
        }
    }

}

/*
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new LinkedList<>();
        while (N-- > 0) {
            String[] cmd = br.readLine().split(" ");
            if (cmd[0].equals("push_front")) {
                q.offerFirst(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("push_back")) {
                q.offerLast(Integer.parseInt(cmd[1]));
            }
            else if (cmd[0].equals("pop_front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.pollFirst() + "\n");
            }
            else if (cmd[0].equals("pop_back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.pollLast() + "\n");
            }
            else if (cmd[0].equals("size")) {
                bw.write(q.size() + "\n");
            }
            else if (cmd[0].equals("empty")) {
                bw.write(q.isEmpty() ? "1\n" : "0\n");
            }
            else if (cmd[0].equals("front")) {
                bw.write(q.isEmpty() ? "-1\n" : q.peekFirst() + "\n");
            }
            else if (cmd[0].equals("back")) {
                bw.write(q.isEmpty() ? "-1\n" : q.peekLast() + "\n");
            }
        }
        bw.flush();
    }
 */