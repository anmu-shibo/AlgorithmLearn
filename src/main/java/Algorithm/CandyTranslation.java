package Algorithm;


public class CandyTranslation {

    //分配糖果
    public static int candy(int[] ratings) {
        int candies = 0;
        if (ratings == null || ratings.length == 0) {
            return 0;
        }
        int len = ratings.length;
        int[] candyNeed = new int[len];
        // 初始化每个位置至少需要1个糖果
        for (int i = 0; i < len; i++) {
            candyNeed[i] = 1;
        }
        // 从左到右遍历，如果当前评分大于前一个评分，则增加糖果数
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candyNeed[i] = candyNeed[i - 1] + 1;
            }
        }
        // 从右到左遍历，如果当前评分大于后一个评分，并且当前糖果数不大于后一个糖果数，则更新糖果数
        for (int i = len - 1; i > 0; i--) {
            if (ratings[i-1] > ratings[i] && candyNeed[i-1] <= candyNeed[i]) {
                candyNeed[i-1] = candyNeed[i] + 1;
            }
        }
        for (int i = 0; i < len; i++) {
            candies += candyNeed[i];
        }
        return candies;
    }

    public static void main(String[] args) {
        int resutl = candy(new int[]{10, 10, 10, 10, 10, 10});
        System.out.println(resutl);
    }
}
