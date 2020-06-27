package Week_01;

import java.util.Stack;

public class TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;
        int i = 0;
        while(i < height.length) {
            while(!st.empty() && height[i] > height[st.peek()]) {
                int top = st.pop();
                if (st.empty()) break;
                int distance = i - st.peek() - 1;
                int bounded_height = Math.min(height[i], height[st.peek()]) - height[top];
                ans += distance * bounded_height;
            }
            st.push(i++);
        }
        return ans;
    }
}
