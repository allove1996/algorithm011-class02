package Week_04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindContentChildren {
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int s1 = 0, g1 = 0, total = 0;
        while (s1 < s.length) {
            if (g1 < g.length && s[s1] >= g[g1]) {
                total += 1;
                s1 += 1;
                g1 += 1;
            } else {
                s1 += 1;
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,2};
        System.out.println(findContentChildren(g, s));
    }
}
