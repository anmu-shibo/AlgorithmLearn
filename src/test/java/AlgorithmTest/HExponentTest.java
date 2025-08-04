package AlgorithmTest;

import Algorithm.HExponent;
import org.junit.Test;

//import src.main.java.Algorithm.HExponent;
public class HExponentTest {

    HExponent hExponent = new HExponent();
    @Test
    public void testHIndex() {
//        int[] citations = {0, 3, 5, 4, 1, 8, 9};
//        int[] citations = {3,0,6,1,5};
        int[] citations = {1,3,1};
        int result = hExponent.hIndex(citations);


        System.out.println(result);
    }


}
