package AlgorithmTest;

import Algorithm.LengthOfLongestSubstring;
import org.junit.Test;

public class LengthOfLongestSubstringTest {

    private LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
    @Test
    public void test() {
        int i = lengthOfLongestSubstring.lengthOfLongestSubstring("abcaacbbedf");
        System.out.println(i);
    }
}
