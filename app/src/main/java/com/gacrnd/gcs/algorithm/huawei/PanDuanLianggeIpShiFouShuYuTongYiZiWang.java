package com.gacrnd.gcs.algorithm.huawei;

import java.util.Arrays;
import java.util.Scanner;

/**
 * HJ39 判断两个IP是否属于同一子网
 * 描述
 * 子网掩码是用来判断任意两台计算机的IP地址是否属于同一子网络的根据。
 * 子网掩码与IP地址结构相同，是32位二进制数，其中网络号部分全为“1”和主机号部分全为“0”。利用子网掩码可以判断两台主机是否中同一子网中。若两台主机的IP地址分别与它们的子网掩码相“与”后的结果相同，则说明这两台主机在同一子网中。
 *
 * 示例：
 * I P 地址　 192.168.0.1
 * 子网掩码　 255.255.255.0
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　  11000000.10101000.00000000.00000001
 * 子网掩码　11111111.11111111.11111111.00000000
 *
 * AND运算   11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 *
 * I P 地址　 192.168.0.254
 * 子网掩码　 255.255.255.0
 *
 *
 * 转化为二进制进行运算：
 *
 * I P 地址　11000000.10101000.00000000.11111110
 * 子网掩码  11111111.11111111.11111111.00000000
 *
 * AND运算  11000000.10101000.00000000.00000000
 *
 * 转化为十进制后为：
 * 192.168.0.0
 *
 * 通过以上对两台计算机IP地址与子网掩码的AND运算后，我们可以看到它运算结果是一样的。均为192.168.0.0，所以这二台计算机可视为是同一子网络。
 *
 * 输入一个子网掩码以及两个ip地址，判断这两个ip地址是否是一个子网络。
 * 若IP地址或子网掩码格式非法则输出1，若IP1与IP2属于同一子网络输出0，若IP1与IP2不属于同一子网络输出2。
 *
 * 注:
 * 有效掩码与IP的性质为：
 * 1. 掩码与IP每一段在 0 - 255 之间
 * 2. 掩码的二进制字符串前缀为网络号，都由‘1’组成；后缀为主机号，都由'0'组成
 *
 * 本题有多组输入
 *
 * @ClassName: PanDuanLianggeIpShiFouShuYuTongYiZiWang
 * @Author: JackOu
 * @CreateDate: 2021/12/5 14:41
 */
class PanDuanLianggeIpShiFouShuYuTongYiZiWang {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String yanma=sc.nextLine();
            String ip1=sc.nextLine();
            String ip2=sc.nextLine();
            System.out.println(choice(yanma,ip1,ip2));;
        }
    }
    private static int choice(String yanma, String ip1, String ip2) {
        String[] yanma1=yanma.split("\\.");
        String[] ip11=ip1.split("\\.");
        String[] ip21=ip2.split("\\.");
        int[] yanmanum=new int[4];
        int[] ip1num=new int[4];
        int[] ip2num=new int[4];

        int[] num1=new int[4];
        int[] num2=new int[4];
        StringBuilder sb=new StringBuilder();

        for(int i=0;i<4;i++){
            yanmanum[i]=Integer.parseInt(yanma1[i]);
            ip1num[i]=Integer.parseInt(ip11[i]);
            ip2num[i]=Integer.parseInt(ip21[i]);
            int len=Integer.toBinaryString(yanmanum[i]).length();
            for(int j=8;j>0;j--){
                if(len>=j){
                    sb.append(Integer.toBinaryString(yanmanum[i]));
                    break;
                }else {
                    sb.append("0");
                }
            }
        }
        char[] cs=sb.toString().toCharArray();
        Arrays.sort(cs);
        String css=new String(cs);
        String bss=new String(sb.reverse());
        if(!bss.equals(css)){
            return 1;
        }

        for(int i=0;i<4;i++){
            num1[i]=yanmanum[i]&ip1num[i];
            num2[i]=yanmanum[i]&ip2num[i];
            if(ip1num[i]<0||ip1num[i]>255||ip2num[i]<0||ip2num[i]>255||yanmanum[i]<0||yanmanum[i]>255){
                return 1;
            }
        }
        for(int i=0;i<4;i++){
            if(num1[i]!=num2[i]){
                return 2;
            }
        }
        return 0;
    }
}
