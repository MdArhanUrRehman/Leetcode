/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    public TreeNode lca(TreeNode root, int n, int m) {
        if (root == null) {
            return null;
        }

        if (root.val > n && root.val > m) {
            return lca(root.left, n, m);
        }

        if (root.val < n && root.val < m) {
            return lca(root.right, n, m);
        }

        return root;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p.val, q.val);
    }
}