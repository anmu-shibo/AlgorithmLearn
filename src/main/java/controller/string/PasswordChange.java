package controller.string;

public class PasswordChange {
    public static void main(String[] args) {
        String str = "<As2<sdsaDs@sad";
        StringBuilder sb = new StringBuilder();
        str = changePassword(str);
        sb.append(str);
        sb.append(",");
        if (confirmPassword(str)) {
            sb.append("true");
        } else {
            sb.append("false");
        }
        System.out.println(sb.toString());
    }
    public static String changePassword(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.isEmpty()) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '<') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static Boolean confirmPassword(String str) {
        int upperWord = 0;
        int lowerWord = 0;
        int number = 0;
        int symbol = 0;
        if (str.length() < 8) {
            return false;
        }
        //遍历str判断
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= 'z' && str.charAt(i) >= 'a') {
                lowerWord++;
            } else if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                upperWord++;
            } else if (str.charAt(i) <= '9' && str.charAt(i) >= '0') {
                number++;
            } else {
                symbol++;
            }
        }
        if (lowerWord >= 1 && upperWord >= 1 && number >= 1 && symbol >= 1) {
            return true;
        }
        return false;
    }
}
