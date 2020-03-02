package baekjoon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Base2 {
    public static String firstUniqueProduct(String[] products) {
        HashSet<String> uniqueSet = new HashSet<>();
        HashSet<String> overlapSet = new HashSet<>();

        for (String product : products) {
            if (!overlapSet.contains(product) && uniqueSet.contains(product)) {
                uniqueSet.remove(product);
                overlapSet.add(product);
            } else {
                uniqueSet.add(product);
            }
        }

        List<String> stringList = new ArrayList<>(uniqueSet);
        return stringList.size() != 0 ? stringList.get(0) : null;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqueProduct(new String[]{"Apple", "Computer", "Apple", "Bag"}));
    }
}
