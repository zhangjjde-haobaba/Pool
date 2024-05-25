package com.kgc.test;

import java.util.concurrent.*;

/**
 * Created by jiang on 10/10/23 9:40 AM
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executorService =new ThreadPoolExecutor(3,5,1L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for(int i=0;i<4;i++){
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName()+"===> 办理业务");
            });
        }
        executorService.shutdown();
    }
}
