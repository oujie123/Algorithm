package com.gacrnd.gcs.algorithm.huawei;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 *
 * 本题含有多组样例输入。
 *
 * 数据范围：每组输入的字符串长度满足 1<= n <= 1000
 *
 * 输入描述：
 * Lily使用的图片包括"A"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 *
 * 输出描述：
 * Lily的所有图片按照从小到大的顺序输出
 *
 * 输入：
 * Ihave1nose2hands10fingers
 * 输出：
 * 0112Iaadeeefghhinnnorsssv
 *
 * @Description: java类作用描述
 * @Author: JackOu
 * @CreateDate: 2021/11/30 13:38
 */
class PictureSort {

    public static void main(String[] args) {
        String str = "PTNK0ghnc46v498w6T8bW2ceXVm1t88FS815u7i0MUo3vmXPuLafb24siG4576jNOQ5rXddo4FdLgbm2Xr189JzoAg5DA5rsbJ4jtRaQoy19LWmIrP2kk6xC6I9G3i4Zz8Cf2m73P708LFAjb10EuZTaY7BcxejjRu1dzM5A60bVBre4NvX7RdE077xDVT6KsPMFW0I5gAm7b87aVyL5x8ck0Znl09z4ojMd2UC82CemWJLTo4XF0B5A1DC6wV8DlmO7hTCH69gvGI6Nx65cqQYA\n" +
                "h8NuC1jSbhqy9a5T9eJ3Oo3jau8s9BtNGAo5r11FIaz0XpGnZk5Igg7f073RWh1n2LU5D798H30oP1L6dn19wfiNeTa4RmbJ19uLFJ1Swpi5VCVk4VvHYF8F8VLB222f81SWLM968jJcteAUNUAy5w28DL237C5Xl4LktW5Li3O3t65uK6eA94E5bPVC3Rix2O1qkqP0eq3mFG63x4h8Bc5fkDkqt0NXwi03M1ngqa5tsUqCuj2ZQ07nQbfHDtu4E46B3p7uE0P69s6b626tR4Be0d6UO5ohBSV1012ZTs89i57RDI7E1a8Tp7Lj88kP1R9ec58aN9E8E2jN15g2vyOR56sBFHP53wSAS6EDFLtbd7Z158148ai8UIECKvlkFiSwYwW43AijfeRh63";
        List<Character> list = new ArrayList<>(str.length());
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        list.sort(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1 - o2;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
