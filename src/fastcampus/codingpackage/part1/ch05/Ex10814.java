package fastcampus.codingpackage.part1.ch05;

import java.util.Arrays;
import java.util.Scanner;

public class Ex10814 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Account[] accounts = new Account[n];

        for (int i = 0; i < n; i++) {
            accounts[i] = (new Account(i, sc.nextInt(), sc.next()));
        }

        Arrays.sort(accounts);

        for (int i = 0; i < n; i++) {
            System.out.println(accounts[i].age + " " + accounts[i].name);
        }
    }

    static class Account implements Comparable<Account> {
        int idx;
        int age;
        String name;

        public Account(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Account o) {
            if (this.age == o.age) {
                return this.idx - o.idx;
            }

            return this.age - o.age;
        }
    }

}

/*
    풀이
      - 객체를 정렬하면 Tim sort가 사용되는데, Tim sort는 안정 정렬(stable sort) 특징을 가지고 있다.
        안정 정렬(stable sort)이란 정렬 기준 키가 같은 원소들은 입력 순서를 보장한다는 뜻이다.
        따라서 입력된 순서를 별도의 index와 같은 값을 사용하지 않아도 입력 순서가 보장되기 때문에 age로만 비교를 해도 답을 구할 수 있다.

    class Member implements Comparable<Member> {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            return this.age - o.age;
        }
    }

    class Main {
        public static void main (String[] args) {
            Scanner sc = new Scanner(System.in);

            int N = sc.nextInt();
            Member[] members = new Member[N];
            for (int i = 0; i < N; i++)
                members[i] = new Member(sc.nextInt(), sc.next(), i);

            Arrays.sort(members);

            for (Member member : members)
                System.out.println(member.age + " " + member.name);
        }
    }
 */