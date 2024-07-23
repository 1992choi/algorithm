package basic;

public class Combination {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3}; //조합을 만들 배열
        boolean[] visited = new boolean[arr.length]; //조합에 뽑혔는지를 확인하기 위한 배열

        for (int r = 1; r <= arr.length; r++) {
            System.out.println(arr.length + "개 중에 " + r + "개 뽑기");
            combi(arr, visited, 0, r);
            System.out.println();
        }
    }

    public static void combi(int[] arr, boolean[] visited, int depth, int r) {
        if (r == 0) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();

            return;
        }

        if (depth == arr.length) {
        } else {
            visited[depth] = true;
            combi(arr, visited, depth + 1, r - 1);

            visited[depth] = false;
            combi(arr, visited, depth + 1, r);
        }
    }

}
