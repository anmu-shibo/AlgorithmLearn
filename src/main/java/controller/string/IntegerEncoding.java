package controller.string;

import java.util.Scanner;

public class IntegerEncoding {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        long num = sc.nextLong();
        //将给的整数型转换成二进制
        String result = Long.toBinaryString(16565L);
        System.out.println(getResult(result));

    }

    // 1.先将二进制数按7个拆分
    public static String getResult(String str) {
        StringBuilder sb = new StringBuilder();
        int count = str.length();
        while (count > 7) {
            sb.append(translate("1" + str.substring(count - 7, count)));
            count -= 7;
        }
        if (count >= 0) {
            sb.append(translate(str.substring(0, count)));
        }
        return sb.toString();
    }

    //2.对二进制数进行转换
    public static String translate(String str) {

        // 将输入的二进制字符串转换为十六进制字符串（先转换成十进制，然后再转换成16进制）
        // Integer.parseInt(str, 2)：将二进制字符串解析为整数
        // Integer.toHexString(...)：将整数转换为十六进制字符串
        String hexString = Integer.toHexString(Integer.parseInt(str, 2));
        // 如果十六进制字符串只有1位，则在前面补0，确保始终是2位
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        return hexString.toUpperCase();
    }
}
