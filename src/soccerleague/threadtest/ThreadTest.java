package soccerleague.threadtest;

public class ThreadTest {
    public static void main(String args[]){
        Thread thread1 = new ThreadExample("Thread 1");
        Thread thread2 = new ThreadExample("Thread 2");
        Runnable runnable = new RunnableExample();
        Runnable anotherRunnable = new AnotherRunnableExample();
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(anotherRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


    }
}
