package inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        List<int[]> student = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = in.nextInt();
            }
            student.add(arr);
        }

        System.out.println(solution(count, student));
    }

    public static int solution(int count, List<int[]> student) {
        int answer = 1;
        int[] sameCount = new int[count];

        for (int i = 0; i < student.size(); i++) {
            int sum = 0;
            int[] currentStudent = student.get(i);
            for (int j = 0; j < student.size(); j++) {
                if (i == j) {
                    continue;
                }

                int[] compareStudent = student.get(j);
                if (currentStudent[0] == compareStudent[0] ||
                        currentStudent[1] == compareStudent[1] ||
                        currentStudent[2] == compareStudent[2] ||
                        currentStudent[3] == compareStudent[3] ||
                        currentStudent[4] == compareStudent[4]) {
                    sum++;
                }
            }
            sameCount[i] = sum;
        }

        int max = 0;
        for (int i = 0; i < count; i++) {
            if (sameCount[i] > max) {
                max = sameCount[i];
                answer = (i + 1);
            }
        }

        return answer;
    }

}