package com.summer.sort;

/**
 * 选择排序
 *
 * @author wenjunpu
 * @Date 2022/03/17/21:00
 * @Description
 */
public class Code02_SelectionSort {


    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    /**
     * 交换值，将i和j进行交换
     *
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 3, 6, 8, 9, 2, 7};
        printArr(arr);
        //selectionSore(arr);
        //printArr(arr);
        insertSort(arr);
        printArr(arr);
    }

    /**
     * 选择排序
     * [3, 1, 5, 3, 6, 8, 9, 2, 7]  长度为n
     * 1、0~n-1  找到最小值放到0
     * 2、1~n-1  找到最小值放到1
     * 3、2~n-1  找到最小值放到2
     * 。。。。。。。。。。
     * n次、
     *
     * @param arr
     */
    public static void selectionSore(int[] arr) {
        //先处理临界状态
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        for (int i = 0; i < arr.length; i++) {
            //我从i开始找，所以默认最小的值假设在i位置
            //后续只要发现有比arr[min]位置小的数，那就把min指向那个更小的位置
            int minValueIndex = i;
            for (int j = i + 1; j < n; j++) {
                //每次拿当前位置的数去和最小的位置中的数作比较，如果比之前最小的位置中的数还小，那就把最小指向当前
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }
    }


    /**
     * 冒泡排序
     * [3, 1, 5, 3, 6, 8, 9, 2, 7]  长度为n
     * 第一次：索引0和索引1对比，如果前面的值大于后面的值，那么进行交换
     * 再用索引1和索引2对比
     * 。。。
     * 直到n-1与n-2对比并交换完成之后，最大值就放到了索引为n的位置了
     * 第二次：步骤不变，不过是从0~n-2
     * 第三次：步骤不变，不过是从0~n-3
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        //
        int n = arr.length;
        //end是为了定义数组的最后一个位置
        //先定义本次循环的范围，找到本次循环的最后一个值的索引
        //初始值为n-1，为最后一个值的索引，后面每次--，意思是尾部向前走
        for (int end = n - 1; end >= 0; end--) {
            //在确定了数组长度之后，从0开始，与下一个进行对比，如果前面的比后面的大则交换，直到把最大的放到最后一个
            //second是为了对比当前和下一个位置 最后一个对比的就是end和end的前一个
            for (int second = 1; second <= end; second++) {
                //如果第1个大于第2个，那么交换
                //01 12 23 ..... end-1 end
                if (arr[second - 1] > arr[second]) {
                    swap(arr, second, second - 1);
                }
            }
            //for (int current = 0; current < end; current++) {
            //    //如果第1个大于第2个，那么交换
            //    if (arr[current] > arr[current+1]) {
            //        swap(arr, current, current + 1);
            //    }
            //}
        }

    }

    /**
     * 插入排序
     * [3, 1, 5, 3, 6, 8, 9, 2, 7]  长度为n
     * [1, 3, 5, 3, 6, 8, 9, 2, 7]
     *
     * [1, 3, 3, 5, 6, 8, 9, 2, 7]
     * [1, 3, 3, 5, 6, 8, 2, 9, 7]
     * [1, 3, 3, 5, 6, 2, 8, 9, 7]
     * [1, 3, 3, 5, 2, 6, 8, 9, 7]
     * [1, 3, 3, 2, 5, 6, 8, 9, 7]
     * [1, 3, 2, 3, 5, 6, 8, 9, 7]
     * [1, 2, 3, 3, 5, 6, 8, 9, 7]
     *
     *
     * [1, 2, 3, 1, 5, 6, 8, 9, 7]
     * 先保证0~0有序     这个不需要保证，本来就一个
     * 再保证0~1有序     1位置需要和0位置进行比较，把小的放到前面
     * 再保证0~2有序     2位置需要和1位置比较，如果小就交换，再和0位置进行比较，
     * 在保证0~n-1有序
     * 整体就是第i位置的和i前面的对比，直到发现到了第一个位置或者发现前面的值比自己小就停止
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        //长度为n
        int N = arr.length;
        //从1位置开始，最后就是走到数组的最后一个位置，即N-1
        for (int end = 1; end <= N - 1; end++) {
            int newNumIndex = end;
            while (newNumIndex - 1 >= 0 && arr[newNumIndex] < arr[newNumIndex - 1]) {
                swap(arr, newNumIndex, newNumIndex - 1);
                //只要交换，那一定是和前面的值进行了交换
                //那就要把索引向前移一位
                newNumIndex--;
            }
        }
    }
}

/**
 *
 BCDETILBYADJUSTACCOUNT	账号调整
 BCDETILBYADJUSTPOWER	权限变更
 BCDETILBYADJUSTSPL		审批流变更
 BCDETILBYRESETPASSWORD	重置密码
 BCDETILBYBILLDATESTART	账期开启
 */
