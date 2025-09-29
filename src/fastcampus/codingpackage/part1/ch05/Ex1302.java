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

/*
    풀이
    - 책 제목을 정렬한 후 카운트를 센다.
      - 이미 오름차순으로 정렬되어 있으므로 동일 카운트에서는 사전 순으로 가장 앞서는 제목이 무엇인지 추가로 찾을 필요가 없다.
      - 정렬이 되었으므로, 동일한 제목의 책이 연속적으로 있기 때문에 누적 카운트를 활용하여 최댓값을 쉽게 구할 수 있다.

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[] titles = new String[N];
    for (int i = 0; i < N; i++)
        titles[i] = sc.next();

    Arrays.sort(titles);

    String maxTitle = titles[0];
    int maxCount = 1;
    int currentCount = 1;
    for (int i = 1; i < N; i++) {
        if (!titles[i].equals(titles[i - 1]))
            currentCount = 0;
        currentCount++;
        if (maxCount < currentCount ||
                (maxCount == currentCount && titles[i].compareTo(maxTitle) < 0)) {
            maxCount = currentCount;
            maxTitle = titles[i];
        }
    }
    System.out.println(maxTitle);
 */