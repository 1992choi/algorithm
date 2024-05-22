package programmers.lv2;

// 프로그래머스 Lv2. 예상 대진표 - https://school.programmers.co.kr/learn/courses/30/lessons/12985
public class Ex12985 {

    public static void main(String[] args) {
        System.out.println(solution(8, 4, 7)); // 3
        System.out.println(solution(8, 5, 8)); // 2
    }

    public static int solution(int n, int a, int b) {
        /*
            첫 번째 대진 = 4개의 그룹 : [1 2] [3 4] [5 6] [7 8]
            두 번째 대진 = 2개의 그룹으로 볼 수 있음 : [1 2 3 4] [5 6 7 8]
            세 번째 대진 = 1개의 그룹으로 볼 수 있음 : [1 2 3 4 5 6 7 8]
        */
        int answer = 1;
        int group = 2;

        while (n > 2) {
            int aGroup = a % group == 0 ? a / group : a / group + 1;
            int bGroup = b % group == 0 ? b / group : b / group + 1;
            if (aGroup == bGroup) {
                break;
            }

            n /= 2;
            group *= 2;
            answer++;
        }

        return answer;
    }

}

