package inflearn.lecture02;

import java.util.ArrayList;

public class Ex06_01_Answer {

    static int answer, target, m;
    static ArrayList<Integer> nums;
    static int[] ch;
    static boolean flag;

    public static void main(String[] args) {
        System.out.println(solution(123)); // 132
        System.out.println(solution(321)); // -1
        System.out.println(solution(20573)); // 20735
        System.out.println(solution(27711)); // 71127
        System.out.println(solution(54312)); // 54321
    }

    public static int solution(int n) {
        answer = 0;
        flag = false;
        nums = new ArrayList<>();
        target = n;
        int tmp = n;
        while (tmp > 0) {
            int t = tmp % 10;
            nums.add(t);
            tmp = tmp / 10;
        }
        nums.sort((a, b) -> a - b);
        m = nums.size();
        ch = new int[m];
        DFS(0, 0);
        if (flag == false) return -1;
        return answer;
    }

    public static void DFS(int L, int number) {
        if (flag) return;
        if (L == m) {
            if (number > target) {
                answer = number;
                flag = true;
            }
        } else {
            for (int i = 0; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    DFS(L + 1, number * 10 + nums.get(i));
                    ch[i] = 0;
                }
            }
        }
    }

}