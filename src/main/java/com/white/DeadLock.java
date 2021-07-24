package com.white;

// jps -l 查找进程id
// jstack -l 12316  发现死锁
// jConsole
// jvisualvm

public class DeadLock {

    public static String lock_A = "lock_A";
    public static String lock_B = "lock_B";

    public static void main(String[] args) {

        Thread threadA = new Thread(new Lock_A());
        Thread threadB = new Thread(new Lock_B());

        threadA.start();
        threadB.start();
    }
}

class Lock_A implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.lock_A) {
            System.out.println(Thread.currentThread().getName() + "--" + DeadLock.lock_A);
            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            synchronized (DeadLock.lock_B) {
                System.out.println(Thread.currentThread().getName() + "--" + DeadLock.lock_B);
            }
        }
    }
}

class Lock_B implements Runnable {
    @Override
    public void run() {
        synchronized (DeadLock.lock_B) {
            System.out.println(Thread.currentThread().getName() + "--" + DeadLock.lock_B);
            try {
                Thread.sleep(3000);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            synchronized (DeadLock.lock_A) {
                System.out.println(Thread.currentThread().getName() + "--" + DeadLock.lock_A);
            }
        }
    }
}
