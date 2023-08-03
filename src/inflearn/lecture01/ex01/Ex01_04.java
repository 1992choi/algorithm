package inflearn.lecture01.ex01;

import java.util.Scanner;

public class Ex01_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.nextLine());

        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            arr[i] = in.nextLine();
        }

        solution(num, arr);
    }

    public static void solution(int num, String[] arr) {
        for (int i = 0; i < num; i++) {
            StringBuffer sb = new StringBuffer(arr[i]);
            System.out.println(sb.reverse());
        }
    }

}
