import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);
    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        new Thread (deadLock::operation1, "T1").start();
        new Thread (deadLock::operation2, "T2").start();
    }

    public void operation1() {
        lock1.lock();
        System.out.println("lock1 success, waiting to lock2");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock2.lock();
        System.out.println("lock2 success");
        System.out.println("Executing first operation");
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        lock2.lock();
        System.out.println("lock2 success, waiting to lock1");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        lock1.lock();
        System.out.println("lock1 success");
        System.out.println("Executing second operation");
        lock1.unlock();
        lock2.unlock();
    }
}
