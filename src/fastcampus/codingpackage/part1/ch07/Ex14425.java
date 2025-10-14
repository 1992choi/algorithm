package fastcampus.codingpackage.part1.ch07;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex14425 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.next());
        }

        String[] arr = new String[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.next();
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if (set.contains(arr[i])) {
                count++;
            }
        }

        System.out.println(count);
    }

}

/*
    풀이 (이분탐색으로 풀이)
    - 문자열을 정렬 후 이분탐색으로 해답을 구한다.
    - 이분탐색은 직접구현하지 않고 Arrays.binarySearch을 사용할 수도 있다.
      Ex) if (Arrays.binarySearch(arr, x) >= 0) {
              count++;
          }

    static boolean isExist(String[] arr, String x) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int compareResult = arr[m].compareTo(x);
            if (compareResult < 0) l = m + 1;           // arr[m] < x : x는 더 오른쪽에 있으므로, 왼쪽 포인터를 m+1로 이동
            else if (compareResult > 0) r = m - 1;      // arr[m] > x : x는 더 왼쪽에 있으므로, 오른쪽 포인터를 m-1로 이동
            else return true;
        }
        return false;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] arr = new String[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.next();

        Arrays.sort(arr); // 정렬

        int count = 0;
        while (M-- > 0) {
            String x = sc.next();
            if (isExist(arr, x))
                count++;
        }
        System.out.println(count);
    }

 */