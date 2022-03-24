package com.summer.factorial;

/**
 * 求    1!+2!+3!+...+N! 的和
 *
 * @author wenjunpu
 * @Date 2022/03/17/17:03
 * @Description
 */
public class Code01_SumOfFactorial {


    private static long f1(int N){
        long ans = 0;
        for (int i = 1; i <= N; i++) {
            ans += factorial(i);
        }
        return ans;
    }
    private static long factorial(int N){
        long ans = 1;
        for (int i = 1; i <= N; i++) {
            ans = ans*i;
        }
        return ans;
    }
    /**
     * 举例：
     * 1! = 1
     * 2! = 1!*2
     * 3! = 2!*3
     * .....
     * n! = (n-1)!*n
     * ----->推出，我用一个临时的变量，存储上次的结果，然后再×我当前的位置即可
     * @param N
     * @return
     */
    private static long f2(int N){
        //累加和
        long ans = 0;
        //上一次的结果
        long current = 1;
        for (int i = 1; i <= N; i++) {
            //用上一次的结果，* 当前数字
            current = current*i;
            ans = current+ans;
        }
        return ans;
    }
}
