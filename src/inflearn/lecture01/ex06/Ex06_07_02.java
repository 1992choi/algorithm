package inflearn.lecture01.ex06;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06_07_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Coordinate[] arr = new Coordinate[n];

        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            arr[i] = new Coordinate(x, y);
        }

        solution(arr);
    }

    public static void solution(Coordinate[] arr) {
        Arrays.sort(arr);

        for (Coordinate coordinate : arr) {
            System.out.println(coordinate);
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }

            return this.x - o.x;
        }
    }

}