package fastcampus.codingpackage.part1.ch03;

import java.io.*;

public class Ex10989 {

    public static void main(String[] args) throws IOException {
        // 선 강의
        /*
            입력 값이 많기 때문에 단순 정렬로는 시간 및 메모리 제한에 걸린다.
            이 문제의 경우, 오름차순 정렬을 위해 다음과 같은 아이디어를 활용할 수 있다.

            1. 전체 요소를 탐색하며 각 숫자가 몇개가 존재하는지 확인하여 배열에 담는다.
            2. 배열에 접근하여 담긴 숫자만큼 출력한다.

            위와 같은 아이디어로 접근하면, 오름차순을 만족할 수 있다.

            또한 Scanner와 System.out.println()를 사용한 출력은 비용이 많이들기 때문에 기준이 타이트하다면, BufferedReader와 BufferedWriter를 사용하도록 한다.
         */


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }


        int[] count = new int[10_001];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }

        for (int i = 1; i < count.length; i++) {
            while (count[i] > 0) {
                bw.write(i + "\n");
                count[i]--;
            }
        }
        bw.flush();
    }

}