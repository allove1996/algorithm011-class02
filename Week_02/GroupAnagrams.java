package Week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str: strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String str0 = new String(chars);
            if (hashMap.containsKey(str0)) {
                hashMap.get(str0).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(str0, list);
            }
        }

        return new ArrayList<>(hashMap.values());

    }
}
