package basic;

import basic.interfaceJava.Eatable;

public class Person {
    public void feed(Eatable eatable) {
        eatable.eat();
    }
}
