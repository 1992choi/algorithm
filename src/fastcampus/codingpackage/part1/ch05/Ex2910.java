package fastcampus.codingpackage.part1.ch05;

import java.util.*;

public class Ex2910 {

    public static void main(String[] args) {
        // 메모리 초과
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c = sc.nextInt();

        int[] counts = new int[c + 1];
        int[] index = new int[c + 1];
        Arrays.fill(index, Integer.MAX_VALUE);
        List<Message> messages = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            counts[num]++;
            index[num] = Math.min(index[num], i);
            messages.add(new Message(num, 0, index[num]));
        }

        for (int i = 0; i < n; i++) {
            messages.get(i).count = counts[messages.get(i).num];
        }

        Collections.sort(messages);

        for (Message message : messages) {
            System.out.print(message.num + " ");
        }
    }

    static class Message implements Comparable<Message> {
        int num;
        int count;
        int minIndex;

        public Message(int num, int count, int index) {
            this.num = num;
            this.count = count;
            this.minIndex = index;
        }

        @Override
        public int compareTo(Message o) {
            if (this.count == o.count) {
                return this.minIndex - o.minIndex;
            }

            return o.count - this.count;
        }
    }

}