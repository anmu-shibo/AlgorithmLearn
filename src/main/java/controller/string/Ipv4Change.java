package controller.string;

public class Ipv4Change {
    static String[] strs;
    public static void main(String[] args) {
        String str = "1#2#3#s";
        strs = str.split("#");
        if (checkIpv4()) {
            System.out.println(changeIpv4());
        } else {
            System.out.println("invalid IP");
        }
    }

    //校验Ipv4地址是否合法
    public static Boolean checkIpv4() {
        if (strs.length != 4) {
            return false;
        }
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == null) {
                return false;
            }
            //存在非法字符
            if (!strs[i].matches("^\\d+$")) {
                return false;
            }
            int num = Integer.parseInt(strs[i]);
            //判断地址是否会出现012这种情况
            if (strs[i].equals(num + "")) {
                //首位在1-128
                if (i == 0) {
                    if (num < 1 || num > 128)
                        return false;
                } else {
                    //后面则是0-255
                    if ( num < 0 || num > 255)
                        return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    //Ipv4地址转换
    public static Long changeIpv4() {
        Long result = 0L;
        String resultStr = new String();
        for (int i = 0; i < 4; i++) {
            String hexStr = Integer.toHexString(Integer.parseInt(strs[i]));
            // 补足前导0
            if (hexStr.length() < 2)
                hexStr = "0" + hexStr;
            resultStr += hexStr;
        }
        result = Long.parseLong(resultStr, 16);
        return result;
    }
}
