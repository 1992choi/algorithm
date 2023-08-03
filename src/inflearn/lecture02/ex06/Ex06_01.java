package inflearn.lecture02.ex06;

import java.util.ArrayList;
import java.util.List;

public class Ex06_01 {

    static String[] nStr;
    static int[] check;
    static List<String> list = new ArrayList<>();
    static int depth;
    static int answer = 0;
    static int initN = 0;

    public static void main(String[] args) {
        System.out.println(solution(123)); // 132
        System.out.println(solution(321)); // -1
        System.out.println(solution(20573)); // 20735
        System.out.println(solution(27711)); // 71127
        System.out.println(solution(54312)); // 54321
    }

    public static int solution(int n) {
        // 답을 최대값으로 초기화()
        answer = Integer.MAX_VALUE;
        initN = n;

        // n을 문자열 배열로 치환
        nStr = String.valueOf(n).split("");

        // 방문한 노드를 체크하기 위한 배열 생성
        check = new int[nStr.length + 1];

        // 깊이 우선 탐색 시, 종료를 위한 깊이 생성
        depth = nStr.length;

        // 깊이우선 탐색 시작
        dfs();

        // 답 도출
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void dfs() {
        if (list.size() == depth) {
            int num = Integer.parseInt(String.join("", list));
            if (num > initN) { // 입력 값보다 큰 값 중에 최소값 선택
                answer = Math.min(answer, num);
            }
        } else {
            for (int i = 0; i < nStr.length; i++) {
                if (check[i] == 0) {
                    // 선택한 숫자 체크 및 리스트에 담기
                    check[i] = 1;
                    list.add(nStr[i]);

                    // 재귀
                    dfs();

                    // 재귀가 끝났으면 원복
                    check[i] = 0;
                    list.remove(list.size() - 1);
                }
            }
        }
    }

}



/*
              1             2            3
            2   3         1   3        1   2
           3     2       3     1      2     1

 */