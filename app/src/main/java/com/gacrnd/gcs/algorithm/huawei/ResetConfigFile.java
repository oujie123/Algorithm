package com.gacrnd.gcs.algorithm.huawei;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unknown command。
 * <p>
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 * <p>
 * 注意：有多组输入。
 * 数据范围：数据组数：，字符串长度
 * 进阶：时间复杂度：，空间复杂度：
 * 输入描述：
 * 多行字符串，每行字符串一条命令
 * <p>
 * 输出描述：
 * 执行结果，每条命令输出一行
 *
 * @ClassName: ResetConfigFile
 * @Author: JackOu
 * @CreateDate: 2021/12/4 23:19
 */
class ResetConfigFile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] commands = {"reset", "reset board", "board add", "board delete",
                "reboot backplane", "backplane abort"};
        String[] responses = {"reset what", "board fault", "where to add",
                "no board at all", "impossible", "install first", "unknown command"};
        while (in.hasNextLine()) {
            String input = in.nextLine();
            if (input.isEmpty()) {//阻止最后一行的空行输出unknown command
                continue;
            }
            int match_num = 0;//记录有多少match的指令
            int index = 6;//记录最后一个match的指令的下表
            for (int i = 0; i < commands.length; i++) {
                if (match(input, commands[i])) {
                    match_num++;
                    index = i;
                }
            }
            if (match_num != 1) {
                index = 6;
            }
            System.out.println(responses[index]);

        }
    }

    public static boolean match(String input, String command) {
        if (input.isEmpty()) {//空白输入不应该有符合的结果
            return false;
        }
        String[] inputs = input.split(" ");
        String[] commands = command.split(" ");
        if (inputs.length == 1 && commands.length == 1) {
            String pattern = input + ".*";
            return Pattern.matches(pattern, command);
        } else if (inputs.length == 2 && commands.length == 2) {
            String pattern_1 = inputs[0] + ".*";
            String pattern_2 = inputs[1] + ".*";
            return Pattern.matches(pattern_1, commands[0]) && Pattern.matches(pattern_2, commands[1]);
        }
        return false;
    }
}
