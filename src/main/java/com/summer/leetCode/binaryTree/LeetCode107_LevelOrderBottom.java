package com.summer.leetCode.binaryTree;

import com.summer.until.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii/
 * 107. 二叉树的层序遍历 II
 * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * @author wenjunpu
 * @Date 2022/04/04/17:33
 * @Description
 */
public class LeetCode107_LevelOrderBottom {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        //先检查边界值
        if (root == null) {
            return ans;
        }
        //利用队列对存放每一层的节点，每一次只能弹出当前层节点个数个
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        //只要没到最底层，就继续
        while (!queue.isEmpty()) {
            //获取本层 节点的个数
            //必须提前得到本层的节点个数，因为后面还会将孩子节点也放入队列中
            int size = queue.size();
            LinkedList<Integer> curAns = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                //弹出头结点
                TreeNode curNode = queue.poll();
                //取出头结点的值，放入到这一层的list中
                curAns.add(curNode.val);
                //先处理左边
                if (curNode.left != null) {
                    //添加到尾部
                    queue.add(curNode.left);
                }
                //再处理右边
                if (curNode.right != null) {
                    //添加到尾部
                    queue.add(curNode.right);
                }
            }
            //通过每次放到0位置，保证数据最后是尾部在前，根节点在最后
            ans.add(0, curAns);
        }
        return ans;
    }
}
