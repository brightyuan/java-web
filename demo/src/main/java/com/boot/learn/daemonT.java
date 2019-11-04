package com.boot.learn;

public class daemonT {
    public static void main(String[] args) {
        System.out.println("main start ");
        System.out.println(daemonT.class);
//        System.exit(0);

        ThreadTest test = new ThreadTest();
        test.setDaemon(true);
        test.start();

        System.out.println("main end ");
    }

}


class ThreadTest extends Thread{
    @Override
    public void run() {
        super.run();
        while (true){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello!");
        }
    }
}
