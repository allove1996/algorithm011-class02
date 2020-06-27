package Week_01;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int i = 0; count < nums.length; i ++) {
            int current = i;
            int pre = nums[i];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                current = next;
                count ++;
            } while(i != current);
        }
    }
}
