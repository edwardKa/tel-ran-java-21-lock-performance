package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Edward Kats
 */
public class Incrementator {

    private static final Integer RANDOM_LIMIT = 1000;
    private Random random = new Random();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private void incrementFirstList() {
        synchronized (lock1) {
            try {
                //Kill CPU optimizer
                Thread.sleep(1);
            } catch (InterruptedException e) {e.printStackTrace();}
            list1.add(random.nextInt(RANDOM_LIMIT));
        }
    }

    private void incrementSecondList() {
        synchronized (lock2) {
            try {
                //Kill CPU optimizer
                Thread.sleep(1);
            } catch (InterruptedException e) {e.printStackTrace();}
            list2.add(random.nextInt(RANDOM_LIMIT));
        }
    }

    public void doIncrement() {

        for (int i = 0; i < 1000; i++) {
            incrementFirstList();
            incrementSecondList();
        }
    }

    public List<Integer> getList1() {
        return list1;
    }

    public List<Integer> getList2() {
        return list2;
    }
}
