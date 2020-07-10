package soccerleague.threadtest.classic;

public class AnotherRunnableExample implements Runnable{

    @Override
    public void run() {
        for(int i = 1000; i < 1100; i++){
            System.out.println("Another Thread Runnable" +": " + i + "!!");
        }
    }
}