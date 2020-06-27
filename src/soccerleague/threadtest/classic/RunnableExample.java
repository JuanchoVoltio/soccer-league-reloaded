package soccerleague.threadtest.classic;

public class RunnableExample implements Runnable{

    private String name;

    public RunnableExample(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            System.out.println("Thread Runnable " + name +": " + i * -1);
        }
    }
}
