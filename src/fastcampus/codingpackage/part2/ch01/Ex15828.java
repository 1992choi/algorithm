package fastcampus.codingpackage.part2.ch01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Ex15828 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> queue = new LinkedList<>();
        int n = sc.nextInt();

        while (true) {
            int num = sc.nextInt();
            if (num == -1) {
                break;
            }

            if (num == 0) {
                queue.poll();
            } else {
                if (queue.size() < n) {
                    queue.offer(num);
                }
            }
        }

        if (queue.isEmpty()) {
            System.out.println("empty");
        } else {
            while (!queue.isEmpty()) {
                System.out.print(queue.poll() + " ");
            }
        }
    }

}

/*
    풀이
    -  LinkedBlockingQueue를 사용하면, 버퍼 사이즈를 고정할 수 있기 때문에 사이즈 체크로직을 생략할 수 있다.
      - if (queue.size() < n) 생략 가능

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Queue<Integer> router = new LinkedBlockingQueue<>(N);
        while (true) {
            int cmd = sc.nextInt();
            if (cmd > 0) router.offer(cmd);
            else if (cmd == 0) router.poll();
            else break;
        }

        if (router.isEmpty())
            System.out.println("empty");
        else System.out.println(router.stream()
                .map(Object::toString)
                .collect(Collectors.joining(" ")));
    }
 */