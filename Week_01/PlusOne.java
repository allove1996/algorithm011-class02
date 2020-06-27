package Week_01;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--){
            digits[i] ++;
            if (digits[i] < 10) {
                return digits;
            }
            digits[i] = 0;
        }
        int[] temp = new int[digits.length + 1];
        temp[0] = 1;
        return temp;
    }
}
