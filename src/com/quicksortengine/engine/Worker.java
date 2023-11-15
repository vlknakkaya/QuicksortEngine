package com.quicksortengine.engine;

import com.quicksortengine.util.Util;

public class Worker extends Thread {

    private String name;

    private volatile boolean alive = true;

    public Worker(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            while (alive) {
                SortJob sortJob = QuicksortEngine.takeJob();
                if (sortJob != null) {
                    long start = System.currentTimeMillis();
                    System.out.println("[" + this.name + "] started to work on " + sortJob.getFileName());
                    sortJob.run();
                    System.out.println("[" + this.name + "] finished the job in " + Util.elapsedTime(start) + " ms");
                } else {
                    setAlive(false);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void setAlive(boolean alive) throws InterruptedException {
        this.alive = alive;
        if (alive) {
            System.out.println("[" + this.name + "] thread is now active");
            this.notify();
        } else {
            System.out.println("[" + this.name + "] thread is now waiting");
            this.wait();
        }
    }

}
