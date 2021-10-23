package ThirdWeek_Work;
/**
 * 第三周作业题
 * 姓名：辛逸杰
 * 学号：G20210760020092
 * 题目：106. 从中序与后序遍历序列构造二叉树
 */


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
        if (inorder == null || postorder == null) return null;
        return buildTreeHelper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode buildTreeHelper (int[] inorder, int[] postorder, int i_lo, int i_hi, int p_lo, int p_hi) {
        if (i_lo>i_hi || p_lo>p_hi) return null;
        TreeNode root = new TreeNode(postorder[p_hi]);
        int root_num = postorder[p_hi];
        int root_index = findRoot(inorder, i_lo, i_hi, root_num);
        root.left = buildTreeHelper(inorder, postorder, i_lo, root_index-1, p_lo, root_index-i_lo+p_lo-1);
        root.right = buildTreeHelper(inorder, postorder, root_index+1, i_hi, root_index-i_lo+p_lo, p_hi-1);
        return root;
    }

    public int findRoot(int[] order, int lo, int hi, int root_num){
        int i;
        for(i=lo; i<=hi; i++){
            if (order[i]==root_num){
                break;
            }
        }
        return i;
    }
}
