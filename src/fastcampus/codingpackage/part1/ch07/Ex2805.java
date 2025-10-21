package fastcampus.codingpackage.part1.ch07;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int lt = 0;
        int rt = arr[n - 1];
        int ans = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                if (arr[i] > mid) {
                    sum += arr[i] - mid;
                }
            }

            if (sum >= m) {
                ans = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.flush();
        bw.close();
        br.close();
    }
}

/*
    풀이

    static boolean isPossible(int[] heights, int cutHeight, int thresholdHeight) {
        long sum = 0;
        for (int h : heights)
            if (h > cutHeight) sum += h - cutHeight;
        return sum >= thresholdHeight;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] h = new int[N];
        for (int i = 0; i < N; i++)
            h[i] = sc.nextInt();

        int l = 0, r = 1000000000, ans = -1; // l과 r은 문제에 있는 답의 범위 중 가장 낮은 값과 높은 값으로 설정
        while (l <= r) {
            int m = (l + r) / 2;

            if (isPossible(h, m, M)) { // 원하는만큼 나무를 가져갈 수 있다면 높이를 높인다.
                ans = m;
                l = m + 1;
            } else { // 원하는만큼 가져갈 수 없다면 높이를 낮춰준다.
                r = m - 1;
            }
        }
        System.out.println(ans);
    }
 */
