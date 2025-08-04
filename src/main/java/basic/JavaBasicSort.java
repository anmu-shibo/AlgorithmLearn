package basic;

import basic.impl.Cat;
import basic.impl.Dog;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JavaBasicSort {
    public static void main(String[] args) {
        Person xiaoming = new Person();
        Dog dog = new Dog();
        Cat cat = new Cat();
        xiaoming.feed(dog);
        xiaoming.feed(cat);
    }
    public static void test05(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date startDate = sdf.parse("2020-02-02 20:20:20");
            Date endDate = sdf.parse("2020-11-11 11:11:11");
            long diffInMillis = endDate.getTime() - startDate.getTime();
            long diffInSeconds = diffInMillis / 1000;
            System.out.println(diffInSeconds);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static void test04(String[] args) {
        Calendar calendar = Calendar.getInstance();
        int nowHour = calendar.getTime().getHours();
        System.out.println("nowHour = " + nowHour);
        calendar.add(Calendar.DAY_OF_YEAR, -520);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        String weekday = weekDays[day - 1];
        System.out.println("weekday = " + weekday);
    }

    public static void test02(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(date);
        System.out.println(formattedDate);

        String str = new String("2020-02-02 20:20:20");
        SimpleDateFormat sdf01 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date01 = sdf01.parse(str);
            System.out.println(date01.toString());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public static void test01(String[] args) {
//        String str = new String("2.0");
//        Double d = Double.valueOf(str);
//        Integer i = (int) d.doubleValue();
//        Double d1 = (double) i.intValue();
//        String s = d1.toString();
//        BigDecimal b = new BigDecimal("18.2");
//        BigDecimal a = new BigDecimal("2.4");
//        BigDecimal i1 = a.add(b);
//        System.out.println(i1);
//        BigDecimal i2 = a.divide(b, 2, RoundingMode.HALF_UP);
//        System.out.println(i2);
//        BigDecimal i3 = a.multiply(b);
//        System.out.println(i3);
//        BigDecimal i4 = a.subtract(b);
//        System.out.println(i4);
        Map<String, String> carMap= new HashMap<>();
        carMap.put("color", "白色");
        carMap.put("brand", "奥迪");
        carMap.put("price", "30w");
        carMap.put("length", "5");
        System.out.println(carMap.toString());
        carMap.put("price", "28w");
        carMap.remove("length");
        System.out.println(carMap.toString());
        List<Map<String, Object>> carShop = new ArrayList<>();
        Map<String,Object> inSaleCare1 = new HashMap<>();
        inSaleCare1.put("color", "白色");
        inSaleCare1.put("brand", "奥迪");
        carShop.add(inSaleCare1);
        Map<String,Object> inSaleCare2 = new HashMap<>();
        inSaleCare2.put("color", "黑色");
        inSaleCare2.put("brand", "奔驰");
        carShop.add(inSaleCare2);
        Map<String,Object> inSaleCare3 = new HashMap<>();
        inSaleCare3.put("color", "红色");
        inSaleCare3.put("brand", "宝马");
        carShop.add(inSaleCare3);
        System.out.println(carShop.toString());
        Map<String,Object> inSaleCare4 = new HashMap<>();
        inSaleCare4.put("color", "黑色");
        inSaleCare4.put("brand", "大众");
        carShop.add(inSaleCare4);
        System.out.println(carShop.toString());

        for (Map<String, Object> car : carShop) {
            String brand = (String) car.get("brand");
            switch (brand) {
                case "奥迪":
                    car.put("price", "30w");
                    break;
                case "奔驰":
                    car.put("price", "40w");
                    break;
                case "宝马":
                    car.put("price", "50w");
                    break;
                case "大众":
                    car.put("price", "20w");
                    break;
                default:
                    System.out.println("未知品牌");
                    break;
            }
        }
        System.out.println(carShop.toString());

        for (Map<String, Object> car : carShop) {
            if (car.get("brand").equals("奥迪")) {
                System.out.println(car.get("price"));
            }
        }
    }
}
