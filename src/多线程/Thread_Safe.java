package 多线程;

//多个线程并发操作同一数据时，就可能出现线程安全问题
//使用同步技术可以解决这个问题，把操作数据的代码同步，不要多个线程一起操作
//场景：铁路售票 一共100张 通过4个窗口出售，那么就相当于4个线程在访问同一块资源

public class Thread_Safe {

    public static void main(String[] args) {

        TikectWindow tw = new TikectWindow();

        Thread sell1 = new Thread(tw);
        Thread sell2 = new Thread(tw);
        Thread sell3 = new Thread(tw);
        //Thread sell4 = new Thread(tw);

        sell1.setName("窗口1");
        sell2.setName("窗口2");
        sell3.setName("窗口3");
        //sell4.setName("窗口4");

        sell1.start();
        sell2.start();
        sell3.start();
        //sell4.start();

    }

}

class TikectWindow implements Runnable{

    Integer tikectNumber = 50;

    public void run() {

        while (true){
            synchronized (this){ //非静态方法中可以使用this
                if (tikectNumber > 0){
                    tikectNumber--;
                    System.out.println("当前窗口" + Thread.currentThread().getName() + "------" + String.format("卖了第%d张", tikectNumber));
                }
                else{
                    System.out.println("票已售罄");
                    break;
                }
            }
            try {
                Thread.sleep(100);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        }

}

//参考来自：https://bbs.csdn.net/topics/390857413

//public class Thread_Safe
//{
//    public static void main(String[] args)
//    {
//        SellWindow sellWindow = new SellWindow();
//        for (int i = 1; i < 4; i++)
//        {
//            new Thread(sellWindow, String.valueOf(i)).start();
//        }
//    }
//}
//
//
//class SellWindow implements Runnable
//{
//    Integer tickNum = 50;
//    boolean flag = true;
//
//    public void run() {
//        while (true) {
//            synchronized (this) {
//                if (tickNum > 0) {
//                    System.out.println("窗口 " + Thread.currentThread().getName()
//                            + " 已售出第 " + tickNum-- + " 张票");
//                } else {
//                    break;
//                }
//
//            }
//            try {
//                Thread.sleep(100);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
//    }
//}

//run方法中的代码就是线程要运行的代码，用while(true)是为了让run方法中的代码不断重复的运行，
// 也就是让线程不停的运行，便于查看效果，如果去掉，run运行结束，线程也就结束了。
// 打印自然只打印四行
