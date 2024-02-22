package inflearn.lecture01.ex05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex05_08_02 {

    public static void main(String[] args) {
        /**
         *  문제해법 보고 푼 문제.
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // 환자 수
        int m = in.nextInt(); // m번째 환자
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();

        // 환자 셋팅
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        // 치료
        while (!queue.isEmpty()) {
            Person p = queue.poll(); // 치료 받을 환자

            // 우선 순위가 더 높은 환자가 있는지 판단. 있으면 다시 넣는다.
            if (queue.stream().anyMatch(x -> x.getValue() > p.getValue())) {
                queue.offer(p);
            } else {
                answer++;

                if (p.getId() == m) {
                    return answer;
                }
            }
        }

        return answer;
    }

    static class Person {

        int id;
        int value;

        public Person(int id, int value) {
            this.id = id;
            this.value = value;
        }

        public int getId() {
            return id;
        }

        public int getValue() {
            return value;
        }

    }

}