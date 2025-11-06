package fastcampus.codingpackage.part2.ch01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ex1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            q.add(i);

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < K; j++) {
                q.add(q.poll());
            }

            ans[i] = q.poll();
        }

        System.out.print("<" +
                Arrays.stream(ans)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                ">");
    }

}
