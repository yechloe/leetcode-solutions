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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        orderIt(root, result);
        return result;
    }
    static private void orderIt(TreeNode node, List<Integer> result) {

        if (node == null) return;
        orderIt(node.left, result);
        result.add(node.val);
        orderIt(node.right, result);
    }
        
}