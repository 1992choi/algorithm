package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_11_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] student = new int[count][5];

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 5; j++) {
                student[i][j] = in.nextInt();
            }
        }

        System.out.println(solution(count, student));
    }

    public static int solution(int count, int[][] student) {
        int[] sameCount = new int[count]; // 다른 학생이랑 같은 반이 된적이 있는지 카운트하는 배열(1 ~ N번째 학생)

        for (int i = 0; i < count; i++) { // 기준 학생
            for (int j = 0; j < count; j++) { // 비교 학생
                if (i == j) { // 자기 자신과 비교 skip
                    continue;
                }

                for (int k = 0; k < 5; k++) { // 학년
                    if (student[i][k] == student[j][k]) {
                        sameCount[i]++;
                        break; // 비교 학생과 몇 번 같은 반이 되었는지 카운트하는 것이 아니라 된적이 있는지 카운트하는 것이므로, 한 번이라도 같은 반이 되었다면 break;
                    }
                }
            }
        }

        int maxIdx = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            if (sameCount[i] > maxValue) {
                maxValue = sameCount[i];
                maxIdx = i;
            }
        }

        return maxIdx + 1; // 문제는 1번째 학생부터 시작하므로 +1하여 리턴
    }

}