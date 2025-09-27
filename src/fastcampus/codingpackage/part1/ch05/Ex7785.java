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