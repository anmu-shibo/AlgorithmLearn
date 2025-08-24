package controller.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataTranslation {
    static Pattern pattern = Pattern.compile("<.*?>");

    static String[] strs;

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        String sc = "1<B>2,3<C>,<D>,456";
        strs = sc.split(",");
        System.out.println(getResult());

    }

    public static String getResult() {
        StringBuffer sb = new StringBuffer();
        if (strs.length > 26) {
            return "-1";
        }
        for (int i = 0; i < strs.length; i++) {
            if (!translate(i)) {
                return "-1";
            }
            sb.append(strs[i]);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static Boolean translate(int i) {
        Matcher matcher = pattern.matcher(strs[i]);
        while (matcher.find()) {
            String reference = matcher.group(0);
            // <>中应该只有一个字母
            if (reference.length() != 3) {
                return false;
            }
            // 判断第二个字符是否为大写字母
            if (!(reference.charAt(1) >= 'A' && reference.charAt(1) <= 'Z')) {
                return false;
            }
            // 判断字符是否是当前的字母，如第一个单元格不能为<A>
            if (reference.charAt(1) - 'A' == i) {
                return false;
            }
            strs[i] = strs[i].replace(reference, strs[reference.charAt(1) - 'A']);
            matcher = pattern.matcher(strs[i]);
        }
        return true;
    }
}
