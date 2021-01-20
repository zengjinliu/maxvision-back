package com.maxvision.zfba.pub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author minte
 * @date 2020/12/11 13:34
 */
public class ThreadPoolTaskExector {
    private static final ExecutorService execService = Executors.newFixedThreadPool(500);

    private ThreadPoolTaskExector() {
    }

    public static void execute(Runnable command) {
        execService.execute(command);
    }


    public static <T> T submit(Callable<T> callable) throws InterruptedException, ExecutionException, TimeoutException {
        return submit(callable,2,TimeUnit.SECONDS);
    }

    public static <T> T submit(Callable<T> vCallable,long time,TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        Future<T> future = execService.submit(vCallable);
        T t = future.get(time, timeUnit);
        return t;
    }

    public static void destroyExecutor() {
        if (execService != null) {
            execService.shutdown();
            try {
                execService.awaitTermination(500, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
            }
        }
    }

    /**
     * 回调结果
     *
     * @param task 任务
     * @param <T>  泛型
     * @return {@link List} 泛型T
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    public static <T> List<T> listTaskProcess(List<Future<T>> task) throws InterruptedException, ExecutionException, TimeoutException {
        List<T> result = new ArrayList<>();
        int time = 20;
        for (Future<T> future : task) {
            result.add(future.get(time,TimeUnit.MINUTES));
        }
        return result;
    }

    /**
     * 回调结果
     *
     * @param task 任务
     * @param <T>  泛型
     * @return {@link List} 泛型T
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    public static <T> List<T> listTaskProcessList(List<Future<List<T>>> task) throws InterruptedException, ExecutionException, TimeoutException {
        List<T> result = new ArrayList<>();
        int time = 20;
        for (Future<List<T>> future : task) {
            result.addAll(future.get(time,TimeUnit.MINUTES));
        }
        return result;
    }

    /**
     * 异步调用的所有任务都需要和传入的值一样
     *
     * @param task 任务列表
     * @param t    传入值
     * @param <T>  传入值的类型
     * @return true 调用结果全部一样，false 调用结果不一样
     * @throws InterruptedException
     * @throws ExecutionException
     * @throws TimeoutException
     */
    public static <T> boolean listTaskProcessAllMatch(List<Future<T>> task,final T t) throws InterruptedException, ExecutionException, TimeoutException {
        List<T> ts = listTaskProcess(task);
        return ts.parallelStream().allMatch(e->e.equals(t));
    }


}
