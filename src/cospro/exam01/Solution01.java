package cospro.exam01;

public class Solution01 {

    public long solution(long num) {
        num++;
        long digit = 1;
        while (num / digit % 10 == 0) {
            num += digit;
            digit *= 10;
        }
        return num;
    }

    public static void main(String[] args) {
        Solution01 sol = new Solution01();
        long num = 9949999;
        System.out.println(sol.solution(num)); // 9951111
    }

}
