package com.summer;

import java.sql.Timestamp;
import java.util.HashMap;

/**
 * 类描述
 *
 * @author wenjunpu
 * @Date 2022/03/08/17:46
 * @Description
 */
public class ExpireHashMap<K, V> extends HashMap<K, V> {
    private HashMap<K,Timestamp> expireTable = new HashMap<>();
    //清理周期
    private static long CLEAR_PERIODICITY;

    @Override
    public V get(Object key) {
        if (ifExist((K)key)){
            return super.get(key);
        }
        return null;

    }

    public boolean ifExist(K key){
        //先判断过期列表中有没有
        if (expireTable.get(key) == null){
            return super.get(key) != null;
        }else {
            Long timestamp = expireTable.get(key).getTime();
            Long newTime = System.currentTimeMillis();
            if (timestamp.compareTo(newTime)>0){
                return true;
            }else {
                deleteExpireKey(key);
                expireTable.remove(key);
                return false;
            }
        }
    }

    public void deleteExpireKey(K key){
        super.remove(key);
    }

    public Long getTTL(K key){
        return expireTable.get(key).getTime()-System.currentTimeMillis();
    }

    //public Long getExpireAt(K key){
    //    return expireTable.get(key);
    //}

    /**
     * 设置Key并设置key的过期时间
     * @param key
     * @param value
     * @param second 秒
     * @return
     */
    public V putAndSetExpire(K key, V value, long second){
        expireTable.put(key,new Timestamp(System.currentTimeMillis()+second));
        return super.put(key, value);
    }

    ///**
    // * 设置Key并设置key的过期时间
    // * @param key
    // * @param value
    // * @param milliSecond    毫秒
    // * @return
    // */
    //public V putAndSetExpireAt(K key, V value, Long milliSecond){
    //    expireTable.put(key,milliSecond);
    //    return super.put(key, value);
    //}

    ///**
    // * 指定时间后过期
    // * @param key
    // * @param value
    // * @param milliSecond 时间戳
    // * @return
    // */
    //public V putAndSetPExpire(K key, V value, Timestamp secondTime){
    //    expireTable.put(key,secondTime);
    //    return super.put(key, value);
    //}
    //public V putAndSetPExpireAt(K key, V value, Timestamp milliSecondTime){
    //    expireTable.put(key,milliSecondTime);
    //    return super.put(key, value);
    //}


    public static void main(String[] args) {
        ExpireHashMap<String, String> expireHashMap = new ExpireHashMap<>();
        expireHashMap.put("a","a");
        expireHashMap.putAndSetExpire("b","b",1000);
        try {
            Thread.sleep(500);
            System.out.println(expireHashMap.getTTL("b"));
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(expireHashMap.get("b"));
        System.out.println(expireHashMap.get("a"));
    }



}
