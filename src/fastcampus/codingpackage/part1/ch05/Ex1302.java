package fastcampus.codingpackage.part1.ch05;

import java.util.*;

public class Ex1302 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Map<String, Integer> map = new HashMap<>();
        int maxSellCount = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int sellCount = map.getOrDefault(name, 0) + 1;
            map.put(name, sellCount);

            maxSellCount =  Math.max(maxSellCount, sellCount);
        }

        List<String> bestSeller = new ArrayList<>();
        for (String name : map.keySet()) {
            if (map.get(name) == maxSellCount) {
                bestSeller.add(name);
            };
        }

        bestSeller.sort(Comparator.naturalOrder());

        System.out.println(bestSeller.get(0));
    }

}