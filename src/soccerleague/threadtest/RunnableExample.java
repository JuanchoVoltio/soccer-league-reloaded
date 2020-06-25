package soccerleague.threadtest;

public class RunnableExample implements Runnable{

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("Thread Runnable" +": " + i * -1);
        }
    }
}
