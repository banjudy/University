package util;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<Integer> prepareIntegerListFromString(List<String> list) {
        List<Integer> intList = new ArrayList<>();
        for (String str : list) {
            intList.add(Integer.parseInt(str));
        }
        return intList;
    }
}
