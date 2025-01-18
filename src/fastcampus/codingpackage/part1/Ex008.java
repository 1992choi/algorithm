package fastcampus.codingpackage.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.acmicpc.net/problem/10431
public class Ex008 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int p = Integer.parseInt(sc.nextLine()); // 테스트케이스 수
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            String line = sc.nextLine();
            String[] numberStrings = line.split(" ");
            Integer[] numbers = new Integer[20]; // 20개로 고정
            for (int j = 1; j < numberStrings.length; j++) {
                numbers[j - 1] = Integer.parseInt(numberStrings[j]);
            }
            list.add(numbers);
        }

        for (int i = 0; i < p; i++) { // 집단 반복
            int moveCount = 0;

            // 아무나 한 명을 뽑아 줄의 맨 앞에 세우기 (가장 처음으로 입력받은 학생으로 선택)
            List<Integer> students = new ArrayList<>();
            students.add(list.get(i)[0]);

            for (int j = 1; j < 20; j++) { // 집단 내 정렬
                students.add(list.get(i)[j]); // 다음 학생 줄세우기

                // 맨뒤로 세운 학생과 이전에 줄 서 있던 학생과 비교
                int maxIndex = j; // 자기 위치를 기본 인덱스로 설정
                for (int k = 0; k < j; k++) {
                    if (students.get(k) > students.get(j)) {
                        maxIndex = k;
                        break;
                    }
                }

                // 자기보다 큰 학생 중 가장 앞에 있는 학생의 앞에 서기 & 한 칸씩 뒤로 밀기
                int currentStudent = students.get(students.size() - 1);
                for (int k = students.size() - 1; k > maxIndex; k--) {
                    students.set(k, students.get(k - 1));
                    moveCount++;
                }
                students.set(maxIndex, currentStudent);
            }

            System.out.println((i + 1) + " " + moveCount);
        }
    }

}
// 풀이
/*
class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int P = sc.nextInt();
        while (P-- > 0) {
            int T = sc.nextInt();
            int[] h = new int[20];
            for (int i = 0; i < 20; i++)
                h[i] = sc.nextInt();

            int cnt = 0;
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < i; j++) {
                    if (h[j] > h[i]) {
                        int myH = h[i];
                        for (int k = i; k > j; k--) {
                            h[k] = h[k - 1];
                            cnt++;
                        }
                        h[j] = myH;
                        break;
                    }
                }
            }
            System.out.println(T + " " + cnt);
        }
    }
}
 */