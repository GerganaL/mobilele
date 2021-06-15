package bg.softuni.lection2.demo.test;

import org.springframework.stereotype.Component;


public class Cat implements  Animal{
    @Override
    public String makeNoise() {
        return "meow-meow";
    }
}
