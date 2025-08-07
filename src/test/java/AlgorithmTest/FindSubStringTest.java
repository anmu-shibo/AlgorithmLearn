package AlgorithmTest;

import Algorithm.FindSubString;
import org.junit.Test;

import java.util.List;

public class FindSubStringTest {

    FindSubString barfoothefoobarman = new FindSubString();
    @Test
    public void test() {

        String[] words = {"bar","foo","the"};
        String s = "barfoofoobarthefoobarman";
        List<Integer> list = barfoothefoobarman.findSubstring(s, words);
        System.out.println(list.toString());
    }
}
