package fastcampus.codingpackage.part2.ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Ex5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Deque<Integer> deque = new LinkedList<>();
            boolean isLeftFront = true;

            char[] actions = br.readLine().toCharArray();
            int arrLength = Integer.parseInt(br.readLine());

            // 입력받은 배열을 큐로 변환
            String arrStr = br.readLine();
            if (arrLength > 0) {
                String[] arr = arrStr.substring(1, arrStr.length() - 1).split(",");
                for (String s : arr) {
                    deque.add(Integer.valueOf(s));
                }
            }

            // 입력 액션에 따른 큐 제어
            boolean hasError = false;
            for (int j = 0; j < actions.length; j++) {
                if (actions[j] == 'R') {
                    isLeftFront = !isLeftFront;
                } else if (actions[j] == 'D') {
                    if (isLeftFront) {
                        if (deque.pollFirst() == null) {
                            hasError = true;
                            break;
                        }
                    } else {
                        if (deque.pollLast() == null) {
                            hasError = true;
                            break;
                        }
                    }
                }
            }

            if (hasError) {
                sb.append("error\n");
                continue;
            }

            // 출력 부분
            sb.append("[");
            if (isLeftFront) {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollFirst());
                    if (!deque.isEmpty()) sb.append(",");
                }
            } else {
                while (!deque.isEmpty()) {
                    sb.append(deque.pollLast());
                    if (!deque.isEmpty()) sb.append(",");
                }
            }
            sb.append("]\n");
        }

        System.out.print(sb);
    }
}

/*
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            char[] cmds = sc.next().toCharArray();
            int N = sc.nextInt();
            StringTokenizer st = new StringTokenizer(sc.next(), "[,]");
            Deque<String> dq = new LinkedList<>();
            for (int i = 0; i < N; i++)
                dq.offerLast(st.nextToken());

            boolean isFlipped = false;
            boolean isValid = true;
            for (char cmd : cmds) {
                if (cmd == 'D') {
                    if (dq.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    if (isFlipped) dq.pollLast();
                    else dq.pollFirst();
                }
                else isFlipped = !isFlipped;
            }

            if (isValid) {
                StringBuilder sb = new StringBuilder();
                while (!dq.isEmpty()) {
                    sb.append(isFlipped ? dq.pollLast() : dq.pollFirst());
                    if (!dq.isEmpty()) sb.append(",");
                }
                System.out.println("[" + sb + "]");
            }
            else System.out.println("error");
        }
    }
 */