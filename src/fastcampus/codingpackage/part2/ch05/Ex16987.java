package fastcampus.codingpackage.part2.ch05;

import java.util.Scanner;

/*
  풀이
  - 각 위치의 계란을 한 번씩 들고, 다른 계란을 하나 골라 부딪히는 모든 경우를 탐색하는 완전탐색 문제
  - pick번째 계란을 들었을 때, 아직 깨지지 않은 다른 계란들에 대해 하나씩 충돌을 시도하고 재귀적으로 진행한다
  - 충돌 후 durability를 감소시키고, 재귀 호출이 끝나면 원상복구하여(backtracking) 모든 경우를 탐색한다
  - 모든 계란을 다 시도(pick == n)하면 깨진 계란의 개수를 세어 최대값을 갱신한다
*/
class Ex16987 {

    public static int n;
    public static Egg[] eggs;
    public static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
            eggs[i] = new Egg(sc.nextInt(), sc.nextInt());
        }
        solve(0);
        System.out.println(answer);
    }

    static void solve(int pick) {
        // base case: 모든 계란을 한 번씩 들었을 때
        if (pick == n) {
            int broken = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i].durability <= 0) broken++;
            }
            answer = Math.max(answer, broken);
            return;
        }

        // 현재 들 계란이 깨지지 않은 경우
        if (eggs[pick].durability > 0) {
            boolean hitTarget = false;

            // 다른 계란들을 대상으로 충돌 시도
            for (int target = 0; target < n; target++) {
                if (target == pick) continue;
                if (eggs[target].durability > 0) {
                    hitTarget = true;

                    eggs[pick].fight(eggs[target]);   // 충돌
                    solve(pick + 1);                  // 다음 계란으로
                    eggs[pick].restore(eggs[target]); // 백트래킹
                }
            }

            // 충돌할 상대가 없으면 그냥 다음으로 진행
            if (!hitTarget) solve(pick + 1);

        } else {
            // 깨진 계란이면 그냥 패스
            solve(pick + 1);
        }
    }

    static class Egg {
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }

        // 충돌 시 내구도 감소
        public void fight(Egg other) {
            this.durability -= other.weight;
            other.durability -= this.weight;
        }

        // 원상 복구 (백트래킹)
        public void restore(Egg other) {
            this.durability += other.weight;
            other.durability += this.weight;
        }
    }

}


