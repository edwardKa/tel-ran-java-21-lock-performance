package com.company;

public class Main {

    public static void main(String[] args) {
//        Incrementator incrementator = new Incrementator();
        IncrementatorMethodLock incrementator = new IncrementatorMethodLock();
//        IncrementatorSynchronizedCollection incrementator = new IncrementatorSynchronizedCollection();

        Thread thread_1 = new Thread() {
            @Override
            public void run() {
                incrementator.doIncrement();
            }
        };
        Thread thread_2 = new Thread() {
            @Override
            public void run() {
                incrementator.doIncrement();
            }
        };

        long startDate = System.currentTimeMillis();
        System.out.println("Начинаем инкрементировать...");

        thread_1.start();
        thread_2.start();

        try {
            thread_1.join();
            thread_2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endDate = System.currentTimeMillis();
        System.out.println("Закончили инкрементировать");
        System.out.println("Время: " + (endDate - startDate));
        System.out.print("; Размер list1: " + incrementator.getList1().size());
        System.out.print("; Размер list2: " + incrementator.getList2().size());
    }
}

