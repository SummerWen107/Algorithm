package com.summer.leetCode.binaryTree;

import com.summer.until.TreeNode;

/**
 * https://leetcode-cn.com/problems/symmetric-tree/
 * 对称二叉树
 *
 * @author wenjunpu
 * @Date 2022/03/24/23:00
 * @Description
 */
public class LeetCode101_IsSymmetric {

    public static boolean isSymmetric(TreeNode root){
        return isMirror(root,root);
    }
    public static boolean isMirror(TreeNode h1,TreeNode h2){
        if (h1 == null ^ h2 == null){
            return false;
        }
        if (h1 == null && h2 == null){
            return true;
        }
        return h1.val == h2.val && isMirror(h1.left,h2.right) && isMirror(h1.right,h2.left);
    }
}
