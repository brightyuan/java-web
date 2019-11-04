package com.boot.learn;

import com.boot.learn.objectAdd;

import java.util.ArrayList;
import java.util.List;

public class testObjectAdd {
    public static void main(String[] args) {
        List<objectAdd> la =  new ArrayList<>();
        objectAdd add = new objectAdd();
        add.setA(1);
        la.add(add);
        add.setB(2);
        System.out.println(la.get(0).toString());
    }
}
