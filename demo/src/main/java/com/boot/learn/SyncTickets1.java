package com.boot.learn;

public class SyncTickets1 {

    public static void main(String[] args) {

        Tickets t = new Tickets(10);

        new Consumer(t).start();
        new Producer(t).start();

    }
}

/**
 * 存入一张，卖一张；售出后在存入
 */
class Tickets {
    int number = 0;
    int size;
    boolean available = false;

    public Tickets(int size) {
        this.size = size;
    }

    public synchronized void put() {
        if (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                   }
            System.out.println("producer ---- put tickets---" + (++number));
            available = true;
            notify();


    }

    public synchronized void sell() {
        if (!available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            System.out.println("Consumer get tickets---" + (number));
            available = false;
            notify();
            if (number == size) number = size + 1;


    }

}


class Producer extends Thread {
    Tickets t;
    public Producer(Tickets t) {
        this.t = t;
    }


    @Override
    public void run() {
        while (t.number < t.size) {
            t.put();
        }
    }
}

class Consumer extends Thread {
    Tickets t;
    public Consumer(Tickets t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (t.number <= t.size) {
            t.sell();
        }
    }
}