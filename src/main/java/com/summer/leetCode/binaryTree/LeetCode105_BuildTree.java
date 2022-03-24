package com.summer.leetCode.binaryTree;

import com.summer.until.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder和inorder均 无重复 元素
 * inorder均出现在preorder
 * preorder保证 为二叉树的前序遍历序列
 * inorder保证 为二叉树的中序遍历序列
 * @author wenjunpu
 * @Date 2022/03/24/23:37
 * @Description
 */
public class LeetCode105_BuildTree {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //边界值判断
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        return f(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public static TreeNode f(int[] pre ,int L1,int R1,int[] in, int L2,int R2){
        if (L1>R1){
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1){
            return head;
        }
        int find = L2;
        while (in[L2] != pre[L1]){
            L2++;
        }
        head.left = f(pre,L1+1,find-L2+L1,in,L2,find-1);
        head.right = f(pre,find-L2+L1 +1 ,R1,in,find+1,R2);
        return head;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        //边界值判断
        if (preorder == null || inorder == null || preorder.length != inorder.length){
            return null;
        }
        HashMap<Integer, Integer> arrIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            arrIndexMap.put(inorder[i],i);
        }
        return g(preorder,0,preorder.length-1,inorder,0,inorder.length-1,arrIndexMap);
    }

    /**
     * 主要是通过先序遍历找到头，再通过头在中序数组中找到头所在的下标，根据中序数组推断出左树和右树的长度
     * 再根据左树和右树的长度，在先序数组中找到对应的子数组，
     * 总体就是
     * 根据先序中的左树和中序中的左树递归生成左树
     * 根据先序中的右树和中序中的右树递归生成右树
     * @param pre   先序数组
     * @param L1    先序数组完整树的头节点所在位置
     * @param R1    先序数据完整树的尾节点所在的位置
     * @param in    中序数组
     * @param L2    中序数组完整树的头结点所在的位置
     * @param R2    中序数组完整树的头结点所在的位置
     * @param arrIndexMap   中序数组需要找到头结点对应的位置，为了减少时间，使用Map存储数值与位置的关系
     * @return
     */
    public static TreeNode g(int[] pre , int L1, int R1, int[] in, int L2, int R2, HashMap<Integer,Integer> arrIndexMap){
        if (L1>R1){
            return null;
        }
        TreeNode head = new TreeNode(pre[L1]);
        if (L1 == R1){
            return head;
        }
        int find = arrIndexMap.get(pre[L1]);
        head.left = g(pre,L1+1,find-L2+L1,in,L2,find-1,arrIndexMap);
        head.right = g(pre,find-L2+L1 +1 ,R1,in,find+1,R2,arrIndexMap);
        return head;
    }
}
