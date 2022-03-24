package com.summer.leetCode.binaryTree;

import com.summer.until.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 *  二叉树的最大深度
 * @author wenjunpu
 * @Date 2022/03/24/23:07
 * @Description
 */
public class LeetCode104_MaxDepth {


    public int maxDepth(TreeNode root) {
        //如果该节点是null，返回
        if (root == null){
            return 0;
        }
        //计算左树或右树的高度，+1是因为要加当前节点
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }
}
