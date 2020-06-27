package soccerleague.threadtest.classic;

public class ThreadExample extends Thread {

    String name;

    public ThreadExample(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("Thread " + name +": " + i);
        }
    }
}
