package basic.impl;

import basic.interfaceJava.Eatable;

public class Cat implements Eatable {
    @Override
    public void eat() {
        System.out.println("吃鱼");
    }
}
