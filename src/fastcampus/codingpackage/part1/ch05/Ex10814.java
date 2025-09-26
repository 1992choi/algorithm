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