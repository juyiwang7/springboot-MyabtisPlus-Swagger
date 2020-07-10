package com.example.bootMp.threadtest;

/**
 * Create By weisan on 2020/7/10.
 */
public class RunnableTest {
    //Runnable 传参和创建子线程执行两种


    public static void main(String[] args) {

        // ①、创建子线程
        Thread thread = new Thread(new Helper("2020.7.10"));
        System.out.println("=== " + thread.getName());
        thread.start();

        // ② 直接调用run方法,传参作用
        //thread.run();

    }


    static class Helper implements Runnable{
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            doSomething(message);
        }

        private void doSomething(String message){
            Thread currentThread = Thread.currentThread();
            String threadName = currentThread.getName();
            System.out.println("executed by" + threadName);
            System.out.println("-----"+message);
            System.out.println(Thread.currentThread().getName());
        }
    }

}
