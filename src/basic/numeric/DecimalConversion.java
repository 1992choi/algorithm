package basic.numeric;

public class DecimalConversion {

    public static void main(String[] args) {
        // 10진수 > N진수 변환
        int num = 11;
        System.out.println("10진수 -> 2진수 : " + Integer.toBinaryString(num));
        System.out.println("10진수 -> 2진수 : " + Integer.toString(num,2));
        System.out.println("10진수 -> 3진수 : " + Integer.toString(num,3));
        System.out.println("10진수 -> 5진수 : " + Integer.toString(num,5));
        System.out.println("10진수 -> 8진수 : " + Integer.toString(num,8));
        System.out.println("10진수 -> 16진수 : " + Integer.toString(num,16));

        // N진수 -> 10진수 변환
        String numStr = "11";
        System.out.println("2진수 -> 10진수 : " + Integer.parseInt(numStr,2));
        System.out.println("3진수 -> 10진수 : " + Integer.parseInt(numStr,3));
        System.out.println("5진수 -> 10진수 : " + Integer.parseInt(numStr,5));
        System.out.println("8진수 -> 10진수 : " + Integer.parseInt(numStr,8));
        System.out.println("16진수 -> 10진수 : " + Integer.parseInt(numStr,16));
    }

}
