package fastcampus.codingpackage.part1.ch07;

import java.util.Scanner;

public class Ex6263 {

    static boolean isPossible(int[] useAmounts, int drawAmount, int maxDrawCount) {
        int drawCount = 1; // 첫날에는 무조건 한 번 인출해야 하므로 1부터 시작
        int currentAmount = drawAmount; // 첫날에 출금한 금액으로 시작

        for (int useAmount : useAmounts) {
            if (useAmount > drawAmount) { // 하루 사용 금액이 인출 금액보다 크면 불가능
                return false;
            }

            if (currentAmount < useAmount) { // 현재 금액이 부족하면 인출 필요
                if (drawCount == maxDrawCount) { // 이미 M번 인출했으면 더 이상 인출 불가 → 실패
                    return false;
                }
                drawCount++;
                currentAmount = drawAmount; // 새로 인출한 금액으로 갱신
            }
            currentAmount -= useAmount; // 하루 사용 금액 차감
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] useAmounts = new int[N];
        for (int i = 0; i < N; i++) {
            useAmounts[i] = sc.nextInt();
        }

        int l = 1, r = N * 10000, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (isPossible(useAmounts, m, M)) { // 해당 금액으로 M번 이하로 출금할 수 있다면 인출액을 줄인다.
                ans = m;
                r = m - 1;
            } else { // M번 이하로 출금하는게 불가능하다면 인출액을 늘린다.
                l = m + 1;
            }
        }
        System.out.println(ans);
    }

}
