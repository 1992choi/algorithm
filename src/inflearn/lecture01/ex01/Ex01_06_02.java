package inflearn.lecture01.ex01;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Ex01_06_02 {

    public static void main(String[] args) {
        // 입력
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        // 풀이
        Set<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }

        Iterator<Character> it = set.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
    }

}
