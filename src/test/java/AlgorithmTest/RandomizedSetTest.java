package AlgorithmTest;

import Algorithm.RandomizedSet;
import org.junit.Test;


public class RandomizedSetTest {
    RandomizedSet randomizedSet = new RandomizedSet();
    @Test
    public void test() {

//        boolean result = randomizedSet.insert(1);
//        System.out.println(result);

//        boolean result2 = randomizedSet.remove(1);
//        System.out.println(result2);
//        randomizedSet.insert(2);
//        randomizedSet.insert(3);
//        randomizedSet.insert(4);
//        System.out.println(randomizedSet.getRandom());
        randomizedSet.insert(0);
        randomizedSet.remove(0);
        randomizedSet.insert(-1);
        randomizedSet.remove(0);
        System.out.println(randomizedSet.getRandom());
    }
}
