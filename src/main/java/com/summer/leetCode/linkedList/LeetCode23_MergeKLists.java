package com.summer.leetCode.linkedList;

import com.summer.until.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/03/24/20:28
 * @Description
 */
public class LeetCode23_MergeKLists {


    //定义比较器
    private static class ListNodeComparator implements Comparator<ListNode>{

        //返回负数就是返回前面的值在前
        //返回正数就是返回后面的值在前
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val- o2.val;
        }
    }


    public static ListNode mergeKLists(ListNode[] lists) {
        //临界值判断
        if (lists == null){
            return null;
        }
        //定义一个优先级队列     小堆队列
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());
        for (int i = 0; i < lists.length; i++) {
            //把每个list元素中链表的头结点加入队列
            if (lists[i] != null){
                heap.add(lists[i]);
            }
        }
        //临界值判断
        if (heap.isEmpty()){
            return null;
        }
        //定义一个要返回的头结点
        ListNode head = heap.poll();
        //定义一个上一个节点
        ListNode pre = head;
        if (pre.next!=null){
            heap.add(pre.next);
        }
        //只要队列元素没空就继续
        while (!heap.isEmpty()){
            //current   当前的链表元素 堆中的最小值
            ListNode cur = heap.poll();
            //把堆中 的最小值连接到上一个元素的next节点中
            pre.next = cur;
            //将上一个节点指向当前
            pre = cur;
            //如果当前节点所在链表还有数据，那就把当前节点所在的链表的下一个节点添加到队列中
            if (cur.next!=null){
                heap.add(cur.next);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        ListNode[] listNodes = {listNode1,listNode2,listNode3};
        ListNode listNode = mergeKLists(listNodes);

        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

}
