//package com.boot.learn;
//
//public class SyncTickets {
//
//    public static void main(String[] args) {
//
//        Tickets t = new Tickets(10);
//
//        new Consumer(t).start();
//        new Producer(t).start();
//
//    }
//}
//
//
//class Tickets {
//    int number = 0;
//    int size;
//    boolean available = false;
//
//    public Tickets(int size) {
//        this.size = size;
//    }
//}
//
//
//class Producer extends Thread {
//
//    Tickets t;
//
//    public Producer(Tickets t) {
//        this.t = t;
//    }
//
//    @Override
//    public void run() {
//        while (t.number < t.size) {
//            System.out.println("producer ---- put tickets---" + (++t.number));
//            t.available = true;
//        }
//    }
//}
//
//class Consumer extends Thread {
//    Tickets t;
//    int i = 0;
//
//    public Consumer(Tickets t) {
//        this.t = t;
//    }
//
//    @Override
//    public void run() {
//        while (i < t.size) {
//
//            if (t.available == true && i <= t.number) {
//                System.out.println("Consumer get tickets---" + (++i));
//            }
//
//            if (i == t.number && i>0) {//票已售完
//                try {
//                    System.out.println("i "+i+" t.number "+t.number+" sleep 1mills");
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                t.available = false;
//            }
//        }
//    }
//}