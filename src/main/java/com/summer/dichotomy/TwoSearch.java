package com.summer.dichotomy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/03/07/17:11
 * @Description
 */
public class TwoSearch {
    private final static int Array_Size = 10;
    private final static int RandomInt = 10000;
    private static Integer[] array;
    public static void main(String[] args) {
        HashSet<Integer> integers = new HashSet<>();
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            integers.add(random.nextInt(RandomInt));
        }
        array= new ArrayList<>(integers).toArray(array);
        //array = Arrays.stream(array).sorted().toArray();

        int randomIndex = random.nextInt(Array_Size);
        System.out.println("randomIndex:"+randomIndex);
        int i = array[randomIndex];
        System.out.println("要找的值"+i);
        int twoSearchIndex = twoSearch(i);
        System.out.println(twoSearchIndex);
    }

    /**
     * 1,2,3,4,5,6,7,8,9
     * 找2
     * 第一次找到5,5不合适，5>2，向左查询，1234就是lenth-1
     * 找8
     * 第一次找到，5不合适，5<8，向右查询6789就是lenth+1
     *
     * 二分查找，找i在array中的位置，第几个，不是索引
     * @param i 要找到的数据
     * @return
     */
    private static int twoSearch(int i){
        long begin = System.nanoTime();
        int low = 0;
        int high = array.length-1;
        int centre;
        while (low<=high){
            centre = (low+high)/2;
            //如果等于该值
            if (array[centre]==i){
                System.out.println("查找结束");
                System.out.println("用时："+(System.nanoTime()-begin));
                return centre;
                //如果小于该值，说明在右侧
            }else if (array[centre]<i){
                low=centre+1;
            }else {

                high = centre-1;
            }
        }
        return -1;
    }
}
