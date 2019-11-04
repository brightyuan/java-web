package com.boot.demo.annotations;

import java.lang.reflect.Field;

public class TestAnnotation {
    @UserAnnotation(age = 10, gender = "男", name = "哈士奇", id = 1024)
    public  Object obj;

    public static void main(String[] args) throws NoSuchFieldException {
        Field objField = TestAnnotation.class.getField("obj");
        UserAnnotation ua = objField.getAnnotation(UserAnnotation.class);
        System.out.println(ua.name() + "-" + ua.gender() + "-" + ua.age());
    }
}
