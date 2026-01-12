import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLock {
    private Lock lock1 = new ReentrantLock(true);
    private Lock lock2 = new ReentrantLock(true);

    public static void main(String[] args) {
        LiveLock liveLock = new LiveLock();
        new Thread (liveLock::operation1, "T1").start();
        new Thread (liveLock::operation2, "T2").start();
    }

    public void operation1() {
        while (true) {
            try {
                lock1.tryLock(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("lock1 success, try to lock2");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lock2.tryLock()) {
                System.out.println("lock2 success");
            } else {
                System.out.println("lock2 failed");
                lock1.unlock();
                continue;
            }

            System.out.println("Executing first operation");
            break;
        }
        lock2.unlock();
        lock1.unlock();
    }

    public void operation2() {
        while (true) {
            try {
                lock2.tryLock(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("lock2 success, try to lock1");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (lock1.tryLock()) {
                System.out.println("lock1 success");
            } else {
                System.out.println("lock1 failed");
                lock2.unlock();
                continue;
            }

            System.out.println("Executing second operation");
            break;
        }
        lock1.unlock();
        lock2.unlock();
    }
}
