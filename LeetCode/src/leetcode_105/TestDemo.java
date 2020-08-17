package leetcode_105;

/**
 * @author LiYang
 * @Project Name: LeetCode
 * @Package Name: leetcode_105
 * Created by MacBook Air on 2020/05/22.
 * Copyright © 2020 LiYang. All rights reserved.
 */
@SuppressWarnings("all")
public class TestDemo {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] preorder = new int[]{3,9,20,15,7};
        int [] inorder = new int[] {9,3,15,20,7};
        TreeNode treeNode = solution.buildTree(preorder, inorder);
        TreeNode.Print(treeNode);
        System.out.println();
        TreeNode.Print2(treeNode);
    }
}



class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }

    static public void Print(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        System.out.print(treeNode.val + "\t");
        Print(treeNode.left);
        Print(treeNode.right);

    }

    static public void Print2(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        Print(treeNode.left);
        System.out.print(treeNode.val + "\t");
        Print(treeNode.right);

    }

}

class Solution {
    int findIndex(int[] x, int n) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] == n) {
                return i;
            }
        }
        return -1;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /* 前序遍历第一个一定是树根*/
        //创建一个根节点

        if (preorder.length != 0) {
            TreeNode treeNode = new TreeNode(preorder[0]);
            int number = findIndex(inorder, preorder[0]);
            int [] preorder_left = cut(preorder, 1,number+1);
            int [] inorder_left = cut(inorder, 0, number);
            treeNode.left = buildTree(preorder_left, inorder_left);


            //右子树

            int[] preorder_right = cut(preorder, number + 1, preorder.length);
            int[] inorder_right = cut(inorder, number + 1, inorder.length);
            treeNode.right = buildTree(preorder_right, inorder_right);
            return treeNode;
        }else{
            return null;
        }
    }

    int [] cut(int [] x, int start, int end){
        int [] n = null;
        if(end - start >=0){
            n = new int [end - start];
            for (int i = 0, j = 0; i<x.length; i++){
                if( i>= start && i < end){
                    n[j] = x[i];
                    j++;
                }
            }
        }
        return n;

    }

    void print(int [] x){
        for (int i = 0; i< x.length ; i++){
            System.out.print(x[i] + "\t");
        }
        System.out.println();

    }
}


