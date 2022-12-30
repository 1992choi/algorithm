package cospro.exam04;

import java.util.ArrayList;

public class Solution08 {

    ArrayList<Integer> num_list = new ArrayList<Integer>();

    public int[] func_a(int[] card) {
        int card_count[] = new int[10];
        for (int i = 0; i < card.length; i++) {
            card_count[card[i]]++;
        }
        return card_count;
    }

    public void func_b(int level, int max_level, int num, int[] current_count, int[] max_count) {
        if (level == max_level) {
            num_list.add(num);
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (current_count[i] < max_count[i]) {
                current_count[i] += 1;
                func_b(level + 1, max_level, num * 10 + i, current_count, max_count);
                current_count[i] -= 1;
            }
        }
    }

    public int func_c(ArrayList<Integer> list, int n) {
        for (int i = 0; i < list.size(); i++) {
            if (n == list.get(i))
                return i + 1;
        }
        return -1;
    }

    public int solution(int[] card, int n) {
        int[] card_count = func_a(card);
        func_b(0, card.length, 0, new int[10], card_count);
        int answer = func_c(num_list, n);
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Solution08 sol = new Solution08();
        int card1[] = {1, 2, 1, 3};
        int n1 = 1312;
        int ret1 = sol.solution(card1, n1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int card2[] = {1, 1, 1, 2};
        int n2 = 1122;
        int ret2 = sol.solution(card2, n2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }

}
