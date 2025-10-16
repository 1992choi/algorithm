package fastcampus.codingpackage.part1.ch07;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Ex10816 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            bw.write(map.getOrDefault(num, 0) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}

/*
    풀이
    - 맵을 사용할 수도 있지만, 이진탐색을 활용하여 풀 수 있다.
      보통의 이진탐색 문제와 다르게, 일치하는 값이 여러개 존재할 수도 있다.
      때문에 일치하는 값을 찾았을 때 바로 종료하는 것이 아니라 하나씩 이동하며 연속된 동일값을 확인해야한다.

    - 정렬된 배열에서 특정 값 x의 등장 구간(하한, 상한)을 찾는 이진 탐색 메서드들 (두 개의 메서드는 거의 동일하며, if문의 부등호과 포함인지 포함이 아닌지만 다르다.)
         → lowerBound: x 이상이 처음 등장하는 위치
         → upperBound: x 초과가 처음 등장하는 위치
      두 인덱스의 차이를 계산하면 배열 내 x의 등장 횟수를 알 수 있다.


    static int findLowerBoundIndex(int[] arr, int x) {
        // x 이상의 값이 처음으로 나타나는 위치를 찾는다.
        // 즉, arr 배열에서 x보다 크거나 같은 값이 가장 먼저 나오는 인덱스를 반환한다.
        // 만약 배열의 모든 원소가 x보다 작다면 arr.length를 반환한다.
        //
        // 예시:
        //   arr = [1, 2, 2, 2, 3], x = 2 일 때
        //   arr[m] < x 인 동안 왼쪽 포인터(l)를 오른쪽으로 이동시켜 작은 값을 건너뛴다.
        //   결국 x(=2)가 처음 등장하는 인덱스 1을 반환한다.
        //
        // 동작 요약:
        //   - arr[m] < x  → 더 큰 값을 찾기 위해 왼쪽 포인터(l)를 m+1로 이동
        //   - arr[m] >= x → 조건을 만족하므로 위치를 기록하고, 더 왼쪽에도 존재할 수 있어 r = m-1


        int lowerBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] < x) l = m + 1;
            else {
                r = m - 1;
                lowerBoundIndex = m;
            }
        }
        return lowerBoundIndex;
    }

    static int findUpperBoundIndex(int[] arr, int x) {
        int upperBoundIndex = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (arr[m] <= x) l = m + 1;
            else {
                r = m - 1;
                upperBoundIndex = m;
            }
        }
        return upperBoundIndex;
    }

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] cards = new int[N];
        for (int i = 0; i < N; i++)
            cards[i] = sc.nextInt();

        Arrays.sort(cards);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = sc.nextInt();
        while (M-- > 0) {
            int x = sc.nextInt();
            int lowerBoundIndex = findLowerBoundIndex(cards, x);
            int upperBoundIndex = findUpperBoundIndex(cards, x);
            bw.write(upperBoundIndex - lowerBoundIndex + " ");
        }
        bw.write("\n");
        bw.flush();
    }
 */