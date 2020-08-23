package Week_09;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ReverseWords {
    public  String reverseWords(String s) {
        s = s.trim();
        List<String> strList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(strList);
        return String.join(" ", strList);
    }
}
