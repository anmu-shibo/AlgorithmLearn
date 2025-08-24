package controller.string;

public class StringIndex {
    public static void main(String[] args) {
        String str = "HelloWorld";
        int i = 5;
        System.out.println(findIndex(str, i));
    }

    //寻找到下标索引
    public static int findIndex(String str, int index) {
        String changeString = changeString(str);
        char c = changeString.charAt(index - 1);
        System.out.println(str);
        System.out.println(changeString);
        return str.indexOf(c);
    }

    //字符串转换，大写字母在前，小写在后
    public static String changeString(String str) {
        StringBuilder upperSb = new StringBuilder();
        StringBuilder lowerSb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                upperSb.append(c);
            } else {
                lowerSb.append(c);
            }
        }
        return upperSb.append(lowerSb.toString()).toString();
    }
}
