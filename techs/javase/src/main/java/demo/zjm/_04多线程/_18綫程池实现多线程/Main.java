package demo.zjm._04多线程._18綫程池实现多线程;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println(executorService.getClass());
        ((ThreadPoolExecutor) executorService).setMaximumPoolSize(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("啦啦啦");
                //啦啦啦
            }
        });

        Integer integer = null;
        try {
            integer = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    return 4;
                }
            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(integer);//4
    }
}
