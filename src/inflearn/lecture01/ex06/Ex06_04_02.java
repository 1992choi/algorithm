package inflearn.lecture01.ex06;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex06_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt(); // 캐시 크기
        int n = in.nextInt(); // 작업의 개수
        int[] arr = new int[n]; // 작업번호
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        solution(s, n, arr);
    }

    public static void solution(int s, int n, int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (Integer num : arr) {
            // 이미 캐시에 존재하는 작업이면 삭제
            if (list.contains(num)) {
                list.remove(num);
            }

            // 앞에부터 넣기
            list.add(0, num);

            // 캐시 크기를 초과했다면 마지막 항목 제거
            if (list.size() > s) {
                list.remove(list.size() - 1);
            }
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }

}