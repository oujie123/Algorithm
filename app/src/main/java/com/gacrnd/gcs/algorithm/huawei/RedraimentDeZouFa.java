package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ103 Redraiment的走法
 *
 * 描述
 * Redraiment是走梅花桩的高手。Redraiment可以选择任意一个起点，从前到后，但只能从低处往高处的桩子走。
 * 他希望走的步数最多，你能替Redraiment研究他最多走的步数吗？
 *
 * 数据范围：每组数据长度满足  ， 数据大小满足
 * 本题含有多组样例输入
 *
 *
 * 输入描述：
 * 输入多组数据，1组有2行，第1行先输入数组的个数，第2行再输入梅花桩的高度
 *
 * 输出描述：
 * 一组输出一个结果
 *
 * @ClassName: Redraiment
 * @Author: JackOu
 * @CreateDate: 2021/12/4 23:04
 */
class RedraimentDeZouFa {

    public static void main(String[] arg) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            scan.nextLine();
            String[] input1 = scan.nextLine().split(" ");
            int[] intArr = Arrays.stream(input1).mapToInt(Integer::parseInt).toArray();
            int[] k=new int[intArr.length];
            for(int j=1;j<intArr.length;j++){
                for(int i=0;i<j;i++){
                    if(intArr[i]<intArr[j]){
                        k[j]=Math.max(k[j],k[i]+1);
                    }
                }
            }
            Arrays.sort(k);
            System.out.println(k[k.length-1]+1);
        }
    }
}
