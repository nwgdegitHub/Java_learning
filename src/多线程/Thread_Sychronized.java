package 多线程;

//同步：在执行一个线程时，不想让CPU 切换到另一个线程， 这时候要用到同步
public class Thread_Sychronized {
    public static void main(String[] args) {

        //1。 在静态方法中使用
        Sychronized_Demo sd = new Sychronized_Demo();

        Thread td1 = new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (sd){ //锁对象不能用匿名对象，匿名对象不是对象
                    System.out.println("黑");
                    System.out.println("马");
                    System.out.println("程");
                    System.out.println("序");
                    System.out.println("员");
                    System.out.println("J");
                    System.out.println("A");
                    System.out.println("V");
                    System.out.println("A");
                    System.out.println("视");
                    System.out.println("频");
                }

            }
        };
        Thread td2 = new Thread(){
            @Override
            public void run() {
                super.run();
                synchronized (sd){
                    System.out.println("传");
                    System.out.println("智");
                    System.out.println("播");
                    System.out.println("客");
                }
            }
        };
        td1.start();
        td2.start();


        //2。在非静态方法中使用this
    }
}
class Sychronized_Demo{}
