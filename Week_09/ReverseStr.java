package Week_09;

public class ReverseStr {
    public String reverseStr(String s, int k) {
        char[] charArray = s.toCharArray();
        for (int start = 0; start < charArray.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, charArray.length - 1);
            while (i < j) {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i ++;
                j --;
            }
        }
        return new String(charArray);
    }
}
