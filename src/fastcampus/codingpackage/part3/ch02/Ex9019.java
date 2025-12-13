package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    핵심 정리 (불필요한 설명 제외한 최소 핵심만)

    - 이 문제는 0~9999 범위의 정수 상태 공간에서 BFS로 최단 명령어(sequence)를 찾는 문제.
    - 각 상태에서 가능한 연산: D, S, L, R (총 4가지), 즉 그래프의 간선 역할.
    - BFS를 사용하는 이유: "최단 명령어 수"를 찾아야 하므로 레벨 탐색 구조가 필요함.
    - check[ ] 배열로 이미 방문한 숫자는 다시 방문하지 않아야 시간 초과 방지 + 무한 루프 방지.
    - StringBuilder를 매번 복사하며 다음 명령어를 기록하는 구조.
*/
class Ex9019 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int t = 0; t < tc; t++) {
            int in = sc.nextInt();
            int out = sc.nextInt();

            boolean[] check = new boolean[10000];   // 숫자 0~9999 방문 체크
            char[] cmd = {'D', 'S', 'L', 'R'};       // 명령어 대응

            Queue<Register> q = new LinkedList<>();
            q.add(new Register(in, new StringBuilder()));
            check[in] = true;

            while (!q.isEmpty()) {
                Register now = q.poll();

                // 목표 숫자 도달 → BFS이므로 가장 짧은 명령어
                if (now.num == out) {
                    System.out.println(now.cmd);
                    break;
                }

                // 다음 4가지 연산 결과
                int[] next = {now.calcD(), now.calcS(), now.calcL(), now.calcR()};

                for (int i = 0; i < 4; i++) {
                    if (!check[next[i]]) {
                        check[next[i]] = true;
                        q.add(new Register(
                                next[i],
                                new StringBuilder(now.cmd).append(cmd[i]) // 명령어 기록
                        ));
                    }
                }
            }
        }
    }

    static class Register {
        int num;
        StringBuilder cmd;

        Register(int num, StringBuilder cmd) {
            this.num = num;
            this.cmd = cmd;
        }

        public int calcD() {
            return (num * 2) % 10000;
        }

        public int calcS() {
            return (num - 1) < 0 ? 9999 : num - 1;
        }

        public int calcL() {
            return (num % 1000) * 10 + num / 1000;
        }

        public int calcR() {
            return (num % 10) * 1000 + num / 10;
        }
    }
}
