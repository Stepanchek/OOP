package org.example;

import java.util.concurrent.BrokenBarrierException;

public class CustomCyclicBarrier{
    private int threadsAmount;
    private int threadsLeft;
    private Runnable barrierEvent;
    private boolean isBroken;
    private int resets = 0;

    public CustomCyclicBarrier(Runnable barrierEvent, int threadsAmount){
        this.threadsAmount = threadsAmount;
        this.threadsLeft = threadsAmount;
        this.barrierEvent = barrierEvent;
        this.isBroken = false;
    }

    public CustomCyclicBarrier(int threadsAmount){
        this.threadsAmount = threadsAmount;
        this.threadsLeft = threadsAmount;
        this.barrierEvent = null;
    }

    public boolean isBroken(){
        return this.isBroken;
    }

    public int getThreadsAmount(){
        return this.threadsAmount;
    }

    public int getThreadsLeft(){
        return this.threadsLeft;
    }

    public synchronized void await() throws BrokenBarrierException, InterruptedException {
        if (this.isBroken) {
            throw new BrokenBarrierException();
        }

        --this.threadsLeft;
        int currResets = resets;

        while (this.threadsLeft > 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                this.isBroken = true;
                throw e;
            }
        }

        if (resets != currResets)
            return;

        this.threadsLeft = this.threadsAmount;
        notifyAll();
        if (this.barrierEvent != null) {
            this.barrierEvent.run();
        }
    }

    public void reset(){
        --this.resets;
        this.threadsLeft = this.threadsLeft;
        this.isBroken = false;
    }
}
