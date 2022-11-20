package org.example;
import org.example.Constants;


public class Main {
    public static void main(String[] args) {
        try (var executor = new ThreadPool(Constants.THREADS_COUNT)) {
            for (int i = 0; i < Constants.TASKS_COUNT; ++i) {
                int taskNo = i + 1;
                executor.execute(() -> {
                    try {
                        Thread.sleep(Constants.TASK_TIME);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.printf("Task %d executed\n", taskNo);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("All tasks finished");
    }
}