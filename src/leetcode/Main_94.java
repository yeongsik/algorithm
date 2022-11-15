package leetcode;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main_94 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return DFS(root, list);
    }

    static List<Integer> DFS(TreeNode root, List<Integer> list) {
        if (Objects.isNull(root)) {
            return new ArrayList<>();
        }
        if (!Objects.isNull(root.left)) {
            list = DFS(root.left, list);
        }
        list.add(root.val);
        if (!Objects.isNull(root.right)) {
            list = DFS(root.right, list);
        }
        return list;
    }

}
