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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        List<TreeNode> rootList = new ArrayList<>();
        if (root != null) {
            rootList.add(root);
            orderthisLevel(rootList, result);
        }
        return result;
        
    }
    static private void orderthisLevel(List<TreeNode> listsOfthislevel, List<List<Integer>> result) {
        List<Integer> resultOfThisLevel = new ArrayList<>();
        List<TreeNode> listOfNextLevel = new ArrayList<>();
        for (TreeNode node : listsOfthislevel) {
            resultOfThisLevel.add(node.val);
            if (node.left != null) {
                listOfNextLevel.add(node.left);
            }
            if (node.right != null){
                listOfNextLevel.add(node.right);
            }
        }
        result.add(resultOfThisLevel);
        if (!listOfNextLevel.isEmpty()) {        
            orderthisLevel(listOfNextLevel, result);
        }
    }
}