package inflearn.lecture01.ex08;

import java.util.*;

public class Ex08_06_02 {

    static int n;
    static int m;
    static int[] arr; // 자연수 배열
    static int[] selectedArr; // n개 중 m개를 선택한 배열
    static boolean[] isUse; // 사용한 숫자 체크
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        // 입력값 셋팅 : n개의 자연수 중 m개 뽑기
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        isUse = new boolean[n];
        selectedArr = new int[m];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        // 탐색 - 순열 구하기
        dfs(0);

        // 정렬 후 출력
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void dfs(int level) {
        if (m == level) {
            StringBuilder str = new StringBuilder();
            for (int value : selectedArr) {
                str.append(value).append(" ");
            }
            list.add(str.toString());
        } else {
            for (int i = 0; i < n; i++) {
                if (!isUse[i]) { // 사용하지 않은 숫자만 뻗어 나가기
                    isUse[i] = true;
                    selectedArr[level] = arr[i]; // 숫자 선택
                    dfs(level + 1);
                    isUse[i] = false;
                }
            }
        }
    }
}
/*
3 2
3 6 9
*/