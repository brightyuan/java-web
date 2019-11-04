package com.boot.learn;

public class objectAdd {
    public int a;
    public int b;

    public void setA(int a) {
        this.a = a;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "{object:{a:"+this.a+"b:"+this.b+"}";
    }
}

