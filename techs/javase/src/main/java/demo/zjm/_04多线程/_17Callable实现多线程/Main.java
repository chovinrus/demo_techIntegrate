package demo.zjm._04多线程._17Callable实现多线程;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Main {
    public static void main(String[] args) {
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("return 1");
                return 1;
            }
        };
        FutureTask<Integer> integerFutureTask = new FutureTask<>(callable);
        //这里FutureTask继承了Runnable接口
        Thread thread = new Thread(integerFutureTask);
        thread.start();
        Integer integer = 0;
        try {
            integer = integerFutureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(integer);

        //我们看下直接用FutureTask取代Runnable
        new Thread(new FutureTask(() -> null) {
            public void run() {
                System.out.println("啦啦啦");
            }
        }).start();
        //啦啦啦

        // futuretaske提供了一些方法如取消执行、是否完成
        integerFutureTask.isDone();
        integerFutureTask.cancel(true);//参数为true将会中断正在执行的线程
        integerFutureTask.isCancelled();
        integerFutureTask.isCancelled();
    }
}
