package Week_02;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        healper(resList, root);
        return resList;
    }

    public void healper(List<Integer> resList, TreeNode root) {
        if (root != null) {
            resList.add(root.val);
            if (root.left != null) {
                healper(resList, root.left);
            }
            if (root.right != null) {
                healper(resList, root.right);
            }
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
