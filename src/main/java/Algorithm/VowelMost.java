package Algorithm;

public class VowelMost {
    /**
     * 给定一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串，要求该子串中的元音字母总数为 k
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        char[] c = s.toCharArray();
        int ans = 0;
        int vowel = 0;
        for (int i = 0; i < c.length; i++) {
            // 1. 进入窗口
            if (c[i] == 'a' || c[i] == 'e' || c[i] == 'i' || c[i] == 'o' || c[i] == 'u') {
                vowel++;
            }
            if (i < k - 1) { // 窗口大小不足 k
                continue;
            }
            // 2. 更新答案
            ans = Math.max(ans, vowel);
            // 3. 离开窗口，为下一个循环做准备
            char out = c[i - k + 1];
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || out == 'u') {
                vowel--;
            }
        }
        return ans;
    }

}
