package inflearn.lecture02.ex09;

public class Ex09_05 {

    public static void main(String[] args) {
        /**
         * 문제해법보고 푼 문제.
         */
        // 0번째 인덱스의 값인 0은 1부터 인덱스를 사용하기 위해 임의로 추가한 값
        System.out.println(solution(5, new int[]{0, 1, 2, 3, 4, 2})); // 2
    }

    public static int solution(int count, int[] nums) {
        // dy : i번째부터 j번째까지의 부분수열을 팰린드롬을 만들기 위해 끼워넣어야할 수의 최소 개수
        int[][] dy = new int[count + 1][count + 1];

        /*
            nums를 아래 인덱스의 형태로 탐색
            1) 길이가 1인 부분순열 : 1~2,    2~3,    3~4,    4~5
            2) 길이가 2인 부분순열 : 1~3,    2~4,    3~5
            3) 길이가 3인 부분순열 : 1~4,    2~5
            4) 길이가 4인 부분순열 : 1~5
         */
        for (int i = 1; i <= count - 1; i++) {
            for (int j = 1; j <= count - i; j++) {
                // System.out.println(j + " ~ " + (j + i));
                if (nums[j] == nums[(j + i)]) {
                    /*
                        nums[j]와 nums[j + i]가 같다면(= 부분수열의 가장 앞과 뒤에 숫자가 같다면)
                        안쪽 부분 수열로 팰린드롬을 만들기 위해 필요한 최소 개수와 값이 같음
                        Ex) 2(nums[j]), 3, 4, 2(nums[j + i])일 때,
                            2, 3, 4, 2는 이미 양 끝이 같으므로 3, 4를 가지고 팰린드롬을 만들어야할 때 필요한 최소개수와 동일하게 볼 수 있음
                     */
                    dy[j][j + i] = dy[j + 1][j + i - 1];
                } else {
                    /*
                        nums[j]와 nums[j + i]가 다르다면(= 부분수열의 가장 앞과 뒤에 숫자가 다르다면)
                        nums[j]부터 nums[j + i - 1]까지의 값 + 1만 하면 nums[i] ~ nums[j + i]의 해가 될 수 있음
                        Ex) 1(nums[j]), 2, 3, 4(nums[j + i])일 때,
                            1, 2, 3의 해 +1로 계산하면 됨.
                            왜냐하면 1, 2, 3, 4를 4, 1, 2, 3, 4로 만들면 답을 구할 수 있는 원리이므로 제일 앞에 4를 추가하는 경우의 수가 +1이다.

                        위의 방식만 생각하면 안되고 nums[j + 1]부터 nums[j + i]까지의 값을 가지고 해를 구할 경우의 수도 생각해야한다.
                        Ex) 1(nums[j]), 2, 3, 4(nums[j + i])일 때,
                            2, 3, 4의 해 +1로 계산하는 경우도 생가해야한다.
                            : 즉, 1, 2, 3, 4 -> 1, 2, 3, 4, 1로 만드는 경우.

                        결론적으로 위의 2가지 경우 중 값이 작은걸 채택하면 된다.
                     */
                    dy[j][j + i] = Math.min(dy[j][j + i - 1], dy[j + 1][j + i]) + 1;
                }
                // printDy(dy);
            }
        }

        return dy[1][count];
    }

    static void printDy(int[][] dy) {
        for (int[] i : dy) {
            for (int j : i) {
                System.out.print(j);
            }
            System.out.println();
        }
        System.out.println("------");
    }

}