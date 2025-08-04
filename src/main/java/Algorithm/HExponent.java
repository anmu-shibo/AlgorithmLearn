package Algorithm;

import java.util.Arrays;

public class HExponent {


    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = citations.length - 1;
        int h = 1;
        while (i >= 0 && citations[i] >= h) {
            i--;
            h++;
        }
        return h - 1;
    }

}
