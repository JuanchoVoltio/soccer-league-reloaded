package soccerleague.threadtest.executorservice;
import soccerleague.threadtest.classic.RunnableExample;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceTest {

    public static void main(String... args){

        ExecutorService esCached = Executors.newCachedThreadPool();
        int numberOfCPUs = Runtime.getRuntime().availableProcessors();


        ExecutorService esFixed = Executors.newFixedThreadPool(numberOfCPUs);
        Runnable task1 = new RunnableExample("\nSimulación 1 ");
        Runnable task2 = new RunnableExample("\nSimulación 2");
        Runnable task3 = new RunnableExample("\nSimulación 3");
        Runnable task4 = new RunnableExample("\nSimulación 4");

        esCached.submit(task1);
        esCached.submit(task2);
        esCached.submit(task3);
        esCached.submit(task4);

        esCached.shutdown();

    }
}