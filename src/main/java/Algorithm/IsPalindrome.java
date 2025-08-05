package Algorithm;

public class IsPalindrome {
    /**
     * 判断字符串是否是回文串
     * @param s String
     * @return boolean
     */
    public static boolean isPalindrome(String s) {

        //首先移除非字母和非数字的字符，然后将字符串转为小写
        String newString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int left = 0, right = newString.length() - 1;
        if (newString.isEmpty()) {
            return true;
        }
        while (left < right) {
            if (newString.charAt(left) == (newString.charAt(right))) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }
}
