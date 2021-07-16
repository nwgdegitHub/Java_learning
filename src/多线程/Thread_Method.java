package 多线程;

//线程方法


//getName()

//守护线程：设置一个线程为守护线程，该线程不会单独执行，当其他非守护线程都执行结束后，自动退出

//join()

//yield() 某个线程让出cpu

public class Thread_Method {
    public static void main(String[] args) throws InterruptedException {
//        Thread td = new Thread();
//        td.getName();
//        td.isDaemon();//是否是守护线程
//        Thread.currentThread();
//        Thread.sleep(1);

        Thread td1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0;i <2;i++){
                    System.out.println("----------Thread1()----------"+Thread.currentThread());
                }
            }
        };
        Thread td2 = new Thread(){
            @Override
            public void run() {
                super.run();

                for(int i = 0;i <100;i++){
                    System.out.println("----------Thread2()----------"+Thread.currentThread());
                }

            }
        };

        //设置td2为守护线程 从这个例子看出，只要td1结束了，td2的run()便不会继续执行
        td2.setDaemon(true);
        td2.start();
        td1.start();

    }

}

class Join {
    public static void main(String[] args) {
        Thread td1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0;i <10;i++){
                    System.out.println("----------Thread1()----------"+Thread.currentThread());
                }
            }
        };
        Thread td2 = new Thread(){
            @Override
            public void run() {
                super.run();

                for(int i = 0;i <10;i++){
                    if (i == 2){
                        try {
                            td1.join(); //表示td1 线程来插个队 td1做完了后继续往下走td2才跟着执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("----------Thread2()----------"+Thread.currentThread());
                }

            }
        };

        td2.start();
        td1.start();
    }
}

//效果不明显(不重要)
class YieldThread{
    public static void main(String[] args) {
        Thread td1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0;i <1000;i++){
                    System.out.println("----------Thread1()----------"+Thread.currentThread());
                }
            }
        };
        Thread td2 = new Thread(){
            @Override
            public void run() {
                super.run();

                for(int i = 0;i <1000;i++){
                    if (i > 2 ){
                        Thread.yield(); //让给另一条线程
                    }
                    System.out.println("----------Thread2()----------"+Thread.currentThread());
                }

            }
        };

        td2.start();
        td1.start();
    }
}

class Priority{
    public static void main(String[] args) {
        Thread td1 = new Thread(){
            @Override
            public void run() {
                super.run();
                for(int i = 0;i <1000;i++){
                    System.out.println("----------Thread1()----------"+Thread.currentThread());
                }
            }
        };
        Thread td2 = new Thread(){
            @Override
            public void run() {
                super.run();

                for(int i = 0;i <1000;i++){
                    System.out.println("----------Thread2()----------"+Thread.currentThread());
                }

            }
        };

        td1.setPriority(10);
        td2.setPriority(1);

        td2.start();
        td1.start();
    }
}
