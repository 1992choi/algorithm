package inflearn;

import java.util.Scanner;

public class Ex004 {

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
            StringBuffer sb = new StringBuffer();
            sb.append(arr[i]);
            System.out.println(sb.reverse());
        }
    }

}
