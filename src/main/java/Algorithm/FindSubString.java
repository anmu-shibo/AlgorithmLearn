package Algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubString {

    /**
     * 暴力解法
     * @param s
     * @param words
     * @return
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> wordCount = new HashMap<>();

        // 统计words中每个单词的出现次数
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        int n = words[0].length();
        int totalLength = words.length * n;

        // 如果字符串长度小于总长度，直接返回空列表
        if (s.length() < totalLength) {
            return list;
        }

        // 遍历所有可能的起始位置
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> tempMap = new HashMap<>(wordCount);
            boolean isValid = true;

            // 检查从位置i开始的totalLength个字符
            for (int j = 0; j < words.length; j++) {
                int start = i + j * n;
                int end = start + n;
                String currentWord = s.substring(start, end);

                // 如果当前单词不在map中或者已经用完，则无效
                if (!tempMap.containsKey(currentWord) || tempMap.get(currentWord) <= 0) {
                    isValid = false;
                    break;
                }

                // 减少当前单词的计数
                tempMap.put(currentWord, tempMap.get(currentWord) - 1);
            }

            // 如果所有单词都匹配，添加起始位置
            if (isValid) {
                list.add(i);
            }
        }

        return list;
    }

    /**
     * 滑动窗口的解法
     * @param s
     * @param words
     * @return
     */

    public List<Integer> findSubstring2(String s, String[] words) {
        int wordLen = words[0].length(); // 一个单词的长度
        int windowLen = wordLen * words.length; // 所有单词的总长度，即窗口大小

        // 目标：窗口中的单词出现次数必须与 targetCnt 完全一致
        Map<String, Integer> targetCnt = new HashMap<>();
        for (String w : words) {
            targetCnt.merge(w, 1, Integer::sum); // targetCnt[w]++
        }

        List<Integer> ans = new ArrayList<>();
        // 枚举窗口起点，做 wordLen 次滑动窗口
        for (int start = 0; start < wordLen; start++) {
            Map<String, Integer> cnt = new HashMap<>();
            int overload = 0;
            // 枚举窗口最后一个单词的右端点+1
            for (int right = start + wordLen; right <= s.length(); right += wordLen) {
                // 1. inWord 进入窗口
                String inWord = s.substring(right - wordLen, right);
                // 下面 cnt[inWord]++ 后，inWord 的出现次数过多
                if (cnt.getOrDefault(inWord, 0).equals(targetCnt.getOrDefault(inWord, 0))) {
                    overload++;
                }
                cnt.merge(inWord, 1, Integer::sum); // cnt[inWord]++

                int left = right - windowLen; // 窗口第一个单词的左端点
                if (right < windowLen) { // 窗口大小不足 windowLen
                    continue;
                }

                // 2. 更新答案
                // 如果没有超出 targetCnt 的单词，那么也不会有少于 targetCnt 的单词
                if (overload == 0) {
                    ans.add(left);
                }

                // 3. 窗口最左边的单词 outWord 离开窗口，为下一轮循环做准备
                String outWord = s.substring(left, left + wordLen);
                cnt.merge(outWord, -1, Integer::sum); // cnt[outWord]--
                if (cnt.get(outWord).equals(targetCnt.getOrDefault(outWord, 0))) {
                    overload--;
                }
            }
        }

        return ans;
    }



}
