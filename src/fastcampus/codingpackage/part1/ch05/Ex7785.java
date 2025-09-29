package fastcampus.codingpackage.part1.ch05;

import java.util.*;

public class Ex7785 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<String> employee = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String action = sc.next();

            if ("enter".equals(action)) {
                employee.add(name);
            } else {
                employee.remove(name);
            }
        }

      employee.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

}

/*
    풀이
    - 이름으로 먼저 정렬을 한 후, 조건만 판단하면 간단히 풀 수 있다.
      - 조건 : 현재 레코드가 "enter" 상태이면서, 다음 레코드의 이름과 현재 이름이 다른 경우
        --> 마지막 액션이 enter면 회사에 남아있는 사람이다. (이와 같이 조건을 단순화하여 풀 수 있다.)

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    String[][] records = new String[N][2];
    for (int i = 0; i < N; i++) {
        records[i][0] = sc.next();
        records[i][1] = sc.next();
    }

    Arrays.sort(records, new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            return o2[0].compareTo(o1[0]);
        }
    });

    for (int i = 0; i < N - 1; i++) {
        if (records[i][1].equals("enter") && !records[i][0].equals(records[i + 1][0]))
            System.out.println(records[i][0]);
    }
    if (records[N - 1][1].equals("enter"))
        System.out.println(records[N - 1][0]);
 */