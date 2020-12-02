package com.gacrnd.gcs.algorithm.sort;

import java.util.ArrayList;

/**
 * @author Jack_Ou  created on 2020/12/2.
 */
public class BucketSort {

    /**
     * @param array
     * @param bucketSize 每个桶能装多少个不同种类的数值，例如bucketSize=5,即可以装5种数值，每种任意个数
     * @return
     */
    public static ArrayList<Integer> sort(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2) return array;
        int max = array.get(0);
        int min = array.get(0);
        // 找到数值中最大值和最小值，为了分配桶
        for (int i = 0; i < array.size(); i++) {
            if (max < array.get(i)) {
                max = array.get(i);
            }
            if (min > array.get(i)) {
                min = array.get(i);
            }
        }
        // 计算桶的个数
        int bucketCount = (max - min) / bucketSize + 1;
        // 构建桶
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        // 初始化桶
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        // 将数组中的数放入对应的桶中
        for (int i = 0; i < array.size(); i++) {
            // (array.get(i) - min) / bucketSize 计算属于哪个桶
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        // 遍历每个桶，将桶中的数放入到结果数组
        for (int i = 0; i < bucketCount; i++) {
            // 每个桶只装一个元素的时候，就有序了
            if (bucketSize == 1) {
                for(int j = 0;j < bucketArr.get(i).size();j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                // 当一个桶中只有一种元素的时候，直接走到bucketSize=1的情况，把桶中的所有数据写入到resultArr中
                if (bucketCount == 1){
                    bucketSize--;
                }
                /*对桶中的数据再次用桶进行排序*/
                ArrayList<Integer> temp = sort(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++){
                    resultArr.add(temp.get(j));
                }
            }
        }
        return resultArr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(86);
        array.add(11);
        array.add(77);
        array.add(23);
        array.add(32);
        array.add(45);
        array.add(58);
        array.add(63);
        array.add(93);
        array.add(4);
        array.add(37);
        array.add(22);
        array.add(22);
        Utils.printObject(array);
        System.out.println("============================================");
        ArrayList<Integer> dest = BucketSort.sort(array,10);
        Utils.printObject(dest);
    }
}
