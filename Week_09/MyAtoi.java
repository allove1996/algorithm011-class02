package Week_09;

public class MyAtoi {
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0, len = str.length();
        while (index < len && str.charAt(index) == ' ') {
            index ++;
        }
        if (index == len) {
            return 0;
        }
        int sign = 1;
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        int ans = 0;
        while (index < len) {
            int digit = str.charAt(index) - '0';
            if (digit > 9 || digit < 0) {
                break;
            }
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                if (sign > 0) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            ans = ans * 10 + digit;
            index++;
        }

        return ans * sign;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("42"));
    }
}
