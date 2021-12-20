package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ63 DNA序列
 *
 * 一个 DNA 序列由 A/C/G/T 四个字母的排列组合组成。 G 和 C 的比例（定义为 GC-Ratio ）
 * 是序列中 G 和 C 两个字母的总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。
 * 因为高的 GC-Ratio 可能是基因的起始点。
 *
 * 给定一个很长的 DNA 序列，以及限定的子串长度 N ，请帮助研究人员在给出的 DNA 序列中从左往右找出 GC-Ratio 最高且长度为 N 的第一个子串。
 * DNA序列为 ACGT 的子串有: ACG , CG , CGT 等等，但是没有 AGT ， CT 等等
 *
 * 数据范围：字符串长度满足  ，输入的字符串只包含 A/C/G/T 字母
 * 输入描述：
 * 输入一个string型基因序列，和int型子串的长度
 *
 * 输出描述：
 * 找出GC比例最高的子串,如果有多个则输出第一个的子串
 *
 * 输入：
 * AACTGTGCACGACCTGA
 * 5
 * 输出：
 * GCACG
 * 说明：
 * 虽然CGACC的GC-Ratio也是最高，但它是从左往右找到的GC-Ratio最高的第2个子串，所以只能输出GCACG。
 *
 * @ClassName: DNA
 * @Author: JackOu
 * @CreateDate: 2021/12/4 17:18
 */
class DnaXuLie {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String data = scan.nextLine();
            int len = Integer.parseInt(scan.nextLine());
            double max = 0.0;
            String result = "";
            for (int i = 0; i < data.length() - len + 1; i++) {
                String str = data.substring(i, len + i);
                String str2 = str.replaceAll("[^CG]", "");
                double x = str2.length() * 1.0 / str.length();
                if (x > max) {
                    result = str;
                    max = x;
                    if (x == 1.0) {
                        break;
                    }
                }
            }
            System.out.println(result);
        }
    }
}