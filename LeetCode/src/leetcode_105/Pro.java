package leetcode_105;

import com.sun.source.tree.Tree;

/**
 * @author LiYang
 * @Project Name: LeetCode
 * @Package Name: leetcode_105
 * Created by MacBook Air on 2020/05/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */

@SuppressWarnings("all")
class SolutionPro {
    public static void main(String[] args) {
        SolutionPro solution = new SolutionPro();
        int [] preorder = new int[]{3,9,20,15,7};
        int [] inorder = new int[] {9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        TreeNode.Print(treeNode);
        System.out.println();
        TreeNode.Print2(treeNode);
    }
    int findIndex(int[] x, int n) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode helper(int[] preorder, int[] inorder, int lstart, int lend, int rstart, int rend){
        int index = findIndex(inorder, preorder[lstart]);
        if(lstart == lend){
            return null;
        }
        TreeNode treeNode = new TreeNode(preorder[lstart]);
        System.out.println(preorder[lstart]);

        // 左子树  （前序左，中序左） -> 前序
        treeNode.left = helper(preorder, inorder, lstart+1, index -1 - rstart + lstart, rstart, index -1);
        //右子树   （前序有，中序有）
        treeNode.right = helper(preorder, inorder, index - rstart + lstart, lend, index +1, rend);
        return treeNode;
    }

}


