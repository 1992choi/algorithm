package basic.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListNCopiesEx {

    public static void main(String[] args) {
        // list에 n번 값을 담을 때
        int n = 5;

        // case 1
        List<String> case1 = new ArrayList<>(n);
        for (int i = 0; i < n; i++){
            case1.add("value");
        }
        System.out.println(case1); // [value, value, value, value, value]

        // case 1
        List<String> case2 = new ArrayList<>(n);
        case2.addAll(Collections.nCopies(n, "value"));
        System.out.println(case2); // [value, value, value, value, value]
    }

}
