package fastcampus.codingpackage.part1.ch05;

import java.io.*;
import java.util.*;

public class Ex18870 {

    public static void main(String[] args) throws IOException {
        // BufferedReader, BufferedWriter 사용 (Scanner 및 sysout 시 시간 초과 났음)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] coordinate = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> coordinateSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            coordinate[i] = Integer.parseInt(st.nextToken());
            coordinateSet.add(coordinate[i]);
        }

        int count = 0;
        Map<Integer, Integer> coordinateMap = new HashMap<>();
        for (Integer integer : coordinateSet) {
            coordinateMap.put(integer, count++);
        }

        // 출력
        for (int i = 0; i < n; i++) {
            bw.write(coordinateMap.get(coordinate[i]) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

}
/*
    풀이

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] inputs = br.readLine().split(" ");
    int[] xs = new int[N];
    Set<Integer> setX = new TreeSet<>();
    for (int i = 0; i < N; i++) {
        xs[i] = Integer.parseInt(inputs[i]);
        setX.add(xs[i]);
    }

    Map<Integer, Integer> sortedIndex = new HashMap<>();
    int idx = 0;
    for (int x : setX)
        sortedIndex.put(x, idx++);

    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    for (int i = 0; i < N; i++)
        bw.write(sortedIndex.get(xs[i]) + " ");
    bw.flush();
 */