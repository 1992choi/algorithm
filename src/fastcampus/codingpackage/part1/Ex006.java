package fastcampus.codingpackage.part1;

// https://www.acmicpc.net/problem/10158
public class Ex006 {

    public static void main(String[] args) {

    }

}

// 풀이
/*
class Main {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();
        int H = sc.nextInt();
        int P = sc.nextInt();
        int Q = sc.nextInt();
        int T = sc.nextInt();

        int p = (P + T) % (2 * W);
        int q = (Q + T) % (2 * H);
        if (p > W) p = 2 * W - p;
        if (q > H) q = 2 * H - q;
        System.out.println(p + " " + q);
    }
}
 */