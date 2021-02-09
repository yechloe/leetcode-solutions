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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = postorder.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(postorder[0]);
        }
        int rootVal = postorder[len -1];
        int rootIdxInorder = indexOf(inorder, rootVal);
        int[] leftInoder = Arrays.copyOfRange(inorder, 0, rootIdxInorder);
        int[] rightInoder = Arrays.copyOfRange(inorder, rootIdxInorder + 1, len);
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, rootIdxInorder);
        int[] rightPostorder = Arrays.copyOfRange(postorder, rootIdxInorder, len-1);
        TreeNode root = new TreeNode(rootVal, 
                                     buildTree(leftInoder, leftPostorder), 
                                     buildTree(rightInoder, rightPostorder));
        return root;
    }
    private int indexOf(int[] inorder, int val) {
        for(int i = 0; i < inorder.length; i++) {
            if(inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }
}