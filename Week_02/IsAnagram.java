package Week_02;

public class IsAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] part = new int[26];
        char[] sch = s.toCharArray();
        char[] tch = t.toCharArray();
        for(int i = 0; i < sch.length; i++) {
            part[sch[i] - 'a']++;
            part[tch[i] - 'a']--;
        }

        for(int pa:part) {
            if (pa != 0) {
                return false;
            }
        }
        return true;
    }
}
