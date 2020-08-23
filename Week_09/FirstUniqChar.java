package Week_09;

import java.util.Calendar;
import java.util.HashMap;

public class FirstUniqChar {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> charMap = new HashMap<>();
        char[] charArray = s.toCharArray();
        for (char cha : charArray) {
            charMap.put(cha, charMap.getOrDefault(cha, 0) + 1);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charMap.get(charArray[i]) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("ass");
    }
}
