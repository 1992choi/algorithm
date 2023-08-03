package inflearn.lecture01.ex06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ex06_07 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        solution(n, arr);
    }

    public static void solution(int n, int[][] arr) {
        List<Coordinate> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coordinates.add(new Coordinate(arr[i][0], arr[i][1]));
        }

        Collections.sort(coordinates);

        // print
        for (Coordinate coordinate : coordinates) {
            System.out.println(coordinate.getX() + " " + coordinate.getY());
        }
    }

    static class Coordinate implements Comparable<Coordinate> {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public int compareTo(Coordinate o) {
            if (o.getX() != getX()) {
                return getX() - o.getX();
            } else {
                return getY() - o.getY();
            }
        }
    }

}