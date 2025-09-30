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

/*
    풀이
    - 'key=숫자 / value=빈도수'인 맵을 만들어서 정렬에 이용한다.
      이때, 최초 등장한 index를 관리해야하는데, 빈도수와 index를 갖는 객체를 만들수도 있지만, LinkedHashMap의 특성을 이용하면 index는 관리할 필요가 없다.
      LinkedHashMap은 만들어진 순서가 보장되며, 이를 'Integer[] frequencies'로 만들고 정렬하면 Integer도 Tim sort에 의해 순서가 보장된다.


    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int C = sc.nextInt();
    Map<Integer, Integer> messages = new LinkedHashMap<>();
    for (int i = 0; i < N; i++) {
        int message = sc.nextInt();
        messages.put(message, messages.getOrDefault(message, 0) + 1);
    }

    Integer[] frequencies = messages.keySet().toArray(new Integer[messages.size()]);
    Arrays.sort(frequencies, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return messages.get(o2) - messages.get(o1);
        }
    });

    for (int frequency : frequencies) {
        int count = messages.get(frequency);
        while (count-- > 0)
            System.out.print(frequency + " ");
    }
    System.out.println();
 */