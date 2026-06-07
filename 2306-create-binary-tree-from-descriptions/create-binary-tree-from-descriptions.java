/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        int n = descriptions.length;

        HashMap<Integer, TreeNode> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<n; i++){
            int par = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            if(!map.containsKey(par)){
                map.put(par, new TreeNode(par));
            }

            if(!map.containsKey(child)){
                map.put(child, new TreeNode(child));
            }

            if(isLeft == 1){
                map.get(par).left = map.get(child);
            }else{
                map.get(par).right = map.get(child);
            }

            set.add(child);
        }

        for(int i=0; i<n; i++){
            if(!set.contains(descriptions[i][0])){
                return map.get(descriptions[i][0]);
            }
        }

        return null;
    }
}