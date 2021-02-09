//TODO: optimise perf & mem/

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        if (len == 0) {
            return null;
        }
        if (len == 1) {
            return new TreeNode(preorder[0]);
        }
        int rootVal = preorder[0];
        int rootIdxInorder = indexOf(inorder, rootVal);
        int[] leftInoder = Arrays.copyOfRange(inorder, 0, rootIdxInorder);
        int[] rightInoder = Arrays.copyOfRange(inorder, rootIdxInorder + 1, len);
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, rootIdxInorder+1);
        int[] rightPreorder = Arrays.copyOfRange(preorder, rootIdxInorder+1, len);
        TreeNode root = new TreeNode(rootVal, 
                                     buildTree(leftPreorder, leftInoder), 
                                     buildTree(rightPreorder, rightInoder));
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