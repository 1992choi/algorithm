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
