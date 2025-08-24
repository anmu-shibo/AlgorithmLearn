package controller.string;

import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MoneyChange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        sc.nextLine();
        String[] strs = new String[i];
        for (int j = 0; j < i; j++) {
            strs[j] = sc.nextLine();
        }
//        String str = "53HKD87cents";
        System.out.println(transferMoney(strs));

    }

    // 金额转换
    public static int transferMoney(String[] strs) {
        String reg = "(\\d+)((CNY)|(JPY)|(HKD)|(EUR)|(GBP)|(fen)|(cents)|(sen)|(eurocents)|(pence))";

        HashMap<String, Double> exchange = new HashMap<>();
        exchange.put("CNY", 100.0);
        exchange.put("JPY", 100.0 / 1825 * 100);
        exchange.put("HKD", 100.0 / 123 * 100);
        exchange.put("EUR", 100.0 / 14 * 100);
        exchange.put("GBP", 100.0 / 12 * 100);
        exchange.put("fen", 1.0);
        exchange.put("cents", 100.0 / 123);
        exchange.put("sen", 100.0 / 1825);
        exchange.put("eurocents", 100.0 / 14);
        exchange.put("pence", 100.0 / 12);
        Pattern compile = Pattern.compile(reg);
        double ans = 0.0;
        for (String str : strs) {
            Matcher matcher = compile.matcher(str);
            while (matcher.find()) {
                Double amount = Double.parseDouble(matcher.group(1));
                String unit = matcher.group(2);
                ans += amount * exchange.get(unit);
            }
        }
        return (int) ans;
    }
}
