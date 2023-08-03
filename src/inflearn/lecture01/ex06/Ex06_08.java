package inflearn.lecture01.ex06;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Ex06_08 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            set.add(in.nextInt());
        }

        solution(n, m, set);
    }

    public static void solution(int n, int m, Set<Integer> set) {
        int count = 0;
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            count++;
            if (iterator.next() == m) {
                System.out.println(count);
                break;
            }
        }
    }

}