package 多线程;


//这个例子为了演示 wait() 和 notify()
//来自：https://www.cnblogs.com/lbhym/p/11722898.html

public class Thread_Sychronized2 {
    //一定要确保等待和唤醒是同一个对象，用类锁也可以，至于什么是类锁可以看后面synchronized部分
    static Object object=new Object();
    static int i = 0;
    static class Demo1 implements Runnable {
        @Override
        public void run() {
            synchronized (object){
                for(int j=0;j<10000;j++){
                    i++;
                    if(i==5000){
                        //1.因为t1先启动并进入同步代码块，所以首先输出5000
                        System.out.println();
                        try {
                            //释放锁并等待
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                //3.被唤醒后接着执行完剩余的代码，输出20000
                System.out.println("demo1---"+i);
            }
        }
    }
    static class Demo2 implements Runnable{
        @Override
        public void run() {
            synchronized (object){
                for(int j=0;j<10000;j++){
                    i++;
                }
                //2.获取到t1释放的锁，执行完代码后输出15000并唤醒object上等待的线程
                System.out.println("demo2---"+i);
                object.notify();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Demo1 task1 = new Demo1();
        Demo2 task2 = new Demo2();
        Thread thread1=new Thread(task1);
        Thread thread2=new Thread(task2);
        thread1.start();
        thread2.start();
    }
}
