package org.example;

public class MyTest {
    private int counter;
    private CustomReentranceLock lock = new CustomReentranceLock();

    public MyTest(){
        counter = 0;
    }

    public int getCounter(){
        return counter;
    }

    public void increment(){
        lock.lock();
        counter++;
        print();
        lock.unlock();
    }

    private void print(){
        lock.lock();
        System.out.println(counter);
        lock.unlock();
    }
}
