package fastcampus.codingpackage.part1.ch08;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Ex11728 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arrA = new int[n];
        int[] arrB = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        int aIndex = 0;
        int bIndex = 0;

        while (aIndex < n && bIndex < m) {
            if (arrA[aIndex] < arrB[bIndex]) {
                bw.write(arrA[aIndex] + " ");
                aIndex++;
            } else {
                bw.write(arrB[bIndex] + " ");
                bIndex++;
            }
        }

        while (aIndex < n) {
            bw.write(arrA[aIndex++] + " ");
        }

        while (bIndex < m) {
            bw.write(arrB[bIndex++] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

}

/*
    풀이

    public static void main (String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[M];
        for (int i = 0; i < N; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < M; i++)
            b[i] = sc.nextInt();

        int[] ans = new int[N + M];
        int indexA = 0;
        int indexB = 0;
        int indexAnswer = 0;
        while (indexA < N && indexB < M) {
            if (a[indexA] < b[indexB])
                ans[indexAnswer++] = a[indexA++];
            else ans[indexAnswer++] = b[indexB++];
        }
        while (indexA < N) {
            ans[indexAnswer++] = a[indexA++];
        }
        while(indexB < M) {
            ans[indexAnswer++] = b[indexB++];
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int x : ans)
            bw.write(x + " ");
        bw.write("\n");
        bw.flush();
    }
 */
