package inflearn.lecture01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Ex04_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String str = in.next();

        System.out.println(solution(n, str));
    }

    public static String solution(int n, String str) {
        String answer = "";
        String[] arr = str.split("");
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int count = map.getOrDefault(arr[i], 0) + 1;
            map.put(arr[i], count);
        }

        int max = Integer.MIN_VALUE;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next().toString();
            int value = map.get(key);

            if (value > max) {
                max = value;
                answer = key;
            }
        }

        return answer;
    }

}