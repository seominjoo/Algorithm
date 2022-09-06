package hello.helloSpring.thread;

public class ThreadTest extends Thread {
    public void run() {
        // 인터럽트 됬을때 예외처리
        try {
            for (int i = 0; i < 10; i++) {
                // 스레드 0.5초동안 대기
                Thread.sleep(500);
                System.out.println("Thread : " + i);
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Thread1 {
    public static void main(String args[]) {
        ThreadTest t1 = new ThreadTest();
        ThreadTest t2 = new ThreadTest();

        // 1. 동시에 똑같은 숫자가 나오고(start)
//        t1.start();
//        t2.start();

        // 2. 번갈아가면서 나옴(run)
        t1.run();
        t2.run();
    }
}

// Runnable 인터페이스 상속
class RunnableTest implements Runnable {
    // Runnable 인터페이스의 run()오버라이딩
    public void run() {
        try    // 인터럽트 예외처리
        {
            for (int i = 0; i < 10; i++) {
                // 대기시간 0.2초
                Thread.sleep(200);
                System.out.println("스레드 : " + i);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class Thread2 {
    public static void main(String args[]) {
        // Runnable 인터페이스 객체생성
        RunnableTest Obj1 = new RunnableTest();
        RunnableTest Obj2 = new RunnableTest();

        // Runnable 객체를 매개변수로 하여 스레드 객체 th생성
        Thread th1 = new Thread(Obj1);
        Thread th2 = new Thread(Obj2);

        th1.run();
        th2.run();
    }
}