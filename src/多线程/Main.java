package 多线程;

public class Main {

    public static void main(String[] args) {


        System.out.println("----------" + Thread.currentThread());//Thread[main,5,main] 意思是--》 [线程名称, 线程优先级, 线程所属线程组]

        new Thread(){
            @Override
            public void run() {
                super.run();
                System.out.println("----------Thread()----------"+Thread.currentThread());


            }
        }.start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("----------Runnable()----------"+Thread.currentThread());

            }
        }){

        }.start();

    }

}
