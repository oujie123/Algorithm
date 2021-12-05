package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;

/**
 * HJ64 MP3光标位置
 *
 * MP3 Player因为屏幕较小，显示歌曲列表的时候每屏只能显示几首歌曲，用户要通过上下键才能浏览所有的歌曲。
 * 为了简化处理，假设每屏只能显示4首歌曲，光标初始的位置为第1首歌。
 * 现在要实现通过上下键控制光标移动来浏览歌曲列表，控制逻辑如下：
 * <p>
 * 歌曲总数<=4的时候，不需要翻页，只是挪动光标位置。
 * <p>
 * 光标在第一首歌曲上时，按Up键光标挪到最后一首歌曲；光标在最后一首歌曲时，按Down键光标挪到第一首歌曲。
 *
 * @ClassName: MP3
 * @Author: JackOu
 * @CreateDate: 2021/12/4 17:30
 */
class MP3GuangBiaoWeiZi {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            int n = Integer.parseInt(in.nextLine());//
            String s = in.nextLine();
            solution(n, s);
        }
    }

    public static void solution(int n, String s) {
        int pos = 1;  // 记录当前屏幕显示的index
        int posNum = 1;  // 记录在所有歌曲中的index
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'U') {
                posNum--;
                if (n > 4) {   // 歌曲大于4首歌的情况
                    if (pos != 1) {
                        pos--;
                    }
                    if (posNum < 1) {//特殊反页
                        posNum = n;
                        pos = 4;
                    }
                } else {
                    pos--;
                    if (posNum < 1) {
                        posNum = n;
                        pos = n;
                    }
                }
            } else {
                posNum++;
                if (n > 4) {
                    if (pos != 4) {
                        pos++;
                    }
                } else {
                    pos++;
                }
                if (posNum > n) {//特殊反页
                    posNum = 1;
                    pos = 1;
                }
            }
        }
        int[] nums = new int[4];
        if (n <= 4) {
            for (int i = 1; i < n; i++) {
                System.out.print(i + " ");
            }
            System.out.println(n);  // 输出最后一个需要换行
            System.out.println(posNum);
        } else {
            switch (pos) {
                case 1:
                    nums[0] = posNum;
                    nums[1] = posNum + 1;
                    nums[2] = posNum + 2;
                    nums[3] = posNum + 3;
                    break;
                case 2:
                    nums[0] = posNum - 1;
                    nums[1] = posNum;
                    nums[2] = posNum + 1;
                    nums[3] = posNum + 2;
                    break;
                case 3:
                    nums[0] = posNum - 2;
                    nums[1] = posNum - 1;
                    nums[2] = posNum;
                    nums[3] = posNum + 1;
                    break;
                case 4:
                    nums[0] = posNum - 3;
                    nums[1] = posNum - 2;
                    nums[2] = posNum - 1;
                    nums[3] = posNum;
                    break;
            }
            for (int i = 0; i < 3; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println(nums[3]);
            System.out.println(posNum);
        }
    }
}
