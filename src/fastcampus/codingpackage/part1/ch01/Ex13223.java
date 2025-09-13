package fastcampus.codingpackage.part1.ch01;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// https://www.acmicpc.net/problem/13223
public class Ex13223 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fistTime = scanner.nextLine();
        String secondTime = scanner.nextLine();

        LocalTime first = LocalTime.parse(fistTime, DateTimeFormatter.ofPattern("HH:mm:ss"));
        LocalTime second = LocalTime.parse(secondTime, DateTimeFormatter.ofPattern("HH:mm:ss"));

        long betweenSecond;
        // 24시간 차이가 나는 케이스
        if (first.equals(second)) {
            System.out.println("24:00:00");
            return;
        }

        // 그 외 케이스
        if (first.isAfter(second)) {
            betweenSecond = second.toSecondOfDay() - first.toSecondOfDay() + (24 * 60 * 60);
        } else {
            betweenSecond = ChronoUnit.SECONDS.between(first, second);
        }

        LocalTime betweenTime = LocalTime.ofSecondOfDay(betweenSecond);
        System.out.println(betweenTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }

}

// 풀이
/*
class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] current = sc.next().split(":");
        String[] target = sc.next().split(":");

        int currentHour = Integer.parseInt(current[0]);
        int currentMinute = Integer.parseInt(current[1]);
        int currentSecond = Integer.parseInt(current[2]);

        int targetHour = Integer.parseInt(target[0]);
        int targetMinute = Integer.parseInt(target[1]);
        int targetSecond = Integer.parseInt(target[2]);

        int currentSecondAmount = currentHour * 3600 + currentMinute * 60 + currentSecond;
        int targetSecondAmount = targetHour * 3600 + targetMinute * 60 + targetSecond;

        int NeedSecondAmount = targetSecondAmount - currentSecondAmount;
        if (NeedSecondAmount <= 0) NeedSecondAmount += 24 * 3600;

        int needHour = NeedSecondAmount / 3600;
        int needMinute = (NeedSecondAmount % 3600) / 60;
        int needSecond = NeedSecondAmount % 60;

        System.out.println(String.format("%02d:%02d:%02d", needHour, needMinute, needSecond));
    }
}
 */