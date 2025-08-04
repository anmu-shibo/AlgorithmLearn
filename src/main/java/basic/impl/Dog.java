package basic.impl;

import basic.interfaceJava.Eatable;

public class Dog implements Eatable {
    @Override
    public void eat() {
        System.out.println("啃骨头");
    }
}
