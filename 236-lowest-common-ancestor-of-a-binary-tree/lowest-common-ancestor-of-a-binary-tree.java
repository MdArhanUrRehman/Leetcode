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

    public boolean getPath(TreeNode root, TreeNode target, ArrayList list) {
        if (root == null) {
            return false;
        }

        list.add(root);

        if (root == target) {
            return true;
        }

        boolean left = getPath(root.left, target, list);
        boolean right = getPath(root.right, target, list);

        if (left || right) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        if(root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left == null){
            return right;
        }

        if(right == null){
            return left;
        }

        return root;

    }
}