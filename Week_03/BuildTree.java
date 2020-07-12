package Week_03;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pre_start, int pre_end, int[] inorder, int in_start, int in_end) {
        if (pre_start == pre_end) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pre_start]);
        int i_root_idx = map.get(preorder[pre_start]);
        int leftNum = i_root_idx - in_start;
        root.left = buildTreeHelper(preorder, pre_start + 1, pre_start + leftNum + 1, inorder, in_start, i_root_idx);
        root.right = buildTreeHelper(preorder, pre_start + leftNum + 1, pre_end, inorder, i_root_idx + 1, in_end);
        return root;
    }

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
