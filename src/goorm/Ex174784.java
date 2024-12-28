package goorm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

// 밀도정렬
public class Ex174784 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Matter> matters = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matters.add(new Matter(i + 1, sc.nextInt(), sc.nextInt()));
        }

        // 풀이
        Collections.sort(matters);
        System.out.println(matters.get(0).num);
    }

}

class Matter implements Comparable<Matter> {

    int num;
    int weight;
    int volume;

    public Matter(int num, int weight, int volume) {
        this.num = num;
        this.weight = weight;
        this.volume = volume;
    }

    public int getNum() {
        return num;
    }

    @Override
    public int compareTo(Matter o) {
        double resultO = o.weight / (double) o.volume;
        double result = weight / (double) volume;

        if (resultO == result) {
            if (o.weight == weight) {
                return num - o.num;
            }

            return o.weight - weight;
        }

        return Double.compare(resultO, result);
    }

}
