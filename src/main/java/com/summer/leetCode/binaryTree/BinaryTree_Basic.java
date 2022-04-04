package com.summer.leetCode.binaryTree;

import com.summer.until.TreeNode;

/**
 * 二叉树的遍历
 *
 * @author wenjunpu
 * @Date 2022/03/25/15:02
 * @Description
 */
public class BinaryTree_Basic {


    public static void f(TreeNode head){
        if (head == null){
            return;
        }
        //这里打印时先序
        f(head.left);
        //这里打印时中序
        f(head.right);
        //这里打印时后序
    }

    /**
     * 先序遍历
     * @param head
     */
    public static void pro(TreeNode head){
        if (head == null){
            return;
        }
        System.out.println(head.val);
        pro(head.left);
        pro(head.right);
    }

    /**
     * 中序遍历
     * @param head
     */
    public static void in(TreeNode head){
        if (head == null){
            return;
        }
        in(head.left);
        System.out.println(head.val);
        in(head.right);
    }

    /**
     * 后序遍历
     * @param head
     */
    public static void pos(TreeNode head){
        if (head == null){
            return;
        }
        pos(head.left);
        pos(head.right);
        System.out.println(head.val);
    }

    public static void main(String[] args) {
        String billCode = "TYZZBZD20231216001037";
        String substring = billCode.substring(billCode.length() - 14,billCode.length() - 6);
        System.out.println(substring);
        for (int i = 0; i < 12; i++) {
            //System.out.println("delete from fsbzdj2021"+String.format("%02d",i+1)+";");
            //System.out.println("delete from fsbzdj2022"+String.format("%02d",i+1)+";");
            //System.out.println("delete from fsbzdj2023"+String.format("%02d",i+1)+";");
            // System.out.println("select count(*) from fsbzdj2021"+String.format("%02d",i+1)+";");
            //System.out.println("select count(*) from fsbzdj2022"+String.format("%02d",i+1)+";");
            //System.out.println("select count(*) from fsbzdj2023"+String.format("%02d",i+1)+";");

        }

    }

}
