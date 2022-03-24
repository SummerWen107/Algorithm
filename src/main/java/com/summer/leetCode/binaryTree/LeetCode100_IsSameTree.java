package com.summer.leetCode.binaryTree;

import com.summer.until.TreeNode;

/**
 * https://leetcode-cn.com/problems/same-tree/
 *  相同的树
 * @author wenjunpu
 * @Date 2022/03/24/21:51
 * @Description
 */
public class LeetCode100_IsSameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        //异或 只要p和q中有一个是null而另一个不是null，那么这两棵树一定不相同
        if (p == null ^ q == null) {
            return false;
        }
        //如果p和q都是null，那么说明走到最后了，并且都是null，返回true
        if (p == null && q == null) {
            return true;
        }
        //递归，当前值相同，并且左数都相同，并且右树都相同
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
