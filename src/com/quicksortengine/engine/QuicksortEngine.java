package com.quicksortengine.engine;

import com.quicksortengine.util.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

public class QuicksortEngine {

    private final int maxPoolSize = Util.MAX_THREADS;
    private static ConcurrentLinkedQueue<Runnable> jobList;
    private List<Thread> threadList;

    public QuicksortEngine() {
        System.out.println("[QuicksortEngine] - Initializing...");
        this.jobList = new ConcurrentLinkedQueue<>();
        this.threadList = new ArrayList<>();
    }

    public static SortJob takeJob() {
        return (SortJob) jobList.poll();
    }

    public void addJob(Runnable job) {
        createThreadIfNecessary();

        jobList.add(job);

        notifyAllThreads();
    }

    private void createThreadIfNecessary() {
        if (threadList.size() < maxPoolSize) {
            Thread thread = new Worker("Worker-" + threadList.size());
            threadList.add(thread);
            System.out.println("[QuicksortEngine] - " + thread.getName() + " created.");
            thread.start();
        }
    }

    private void notifyAllThreads() {
        if (threadList.stream().allMatch(x -> x.getState().equals(Thread.State.WAITING))) {
            threadList.forEach(x -> {
                try {
                    ((Worker) x).setAlive(true);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }
    }

    public void terminate() {
        while (true) {
            if (jobList.isEmpty() && threadList.stream().allMatch(x -> x.getState().equals(Thread.State.WAITING))) {
                System.out.println("[QuicksortEngine] - Killing threads...");
                threadList.forEach(Thread::stop);
                return;
            }
        }
    }

}
