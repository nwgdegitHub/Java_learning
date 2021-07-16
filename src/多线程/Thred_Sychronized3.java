package 多线程;


//下面这个可以正常演示 ，来自：https://www.cnblogs.com/lbhym/p/11726594.html
class ErrorDemo{
    public static void main(String[] args) throws InterruptedException {
        //因为synchronized里面要求的是对象，所以需要用Integer声明
        Integer Num = 10000;
        int n=10000;
        //声明线程数组，在后面使用join让主线程等待所有线程执行完。
        // 不然主线程跑完了，其他线程没执行完就输出结果会不对的。
        Thread[] add=new Thread[n];
        Thread[] reduce=new Thread[n];
        //创建1w个减少线程
        for(int i=0;i<n;i++){
            Thread t1=new Thread(){
                public void run(){
                    synchronized (Num) {
                        addNum(Num);
                    }
                }
            };
            t1.start();
            reduce[i]=t1;
        }
        //创建1w个增加线程
        for(int i=0;i<n;i++){
            Thread t2=new Thread(){
                public void run(){
                    synchronized (Num) {
                        reduceNum(Num);
                    }
                }
            };
            t2.start();
            add[i]=t2;
        }

        //让主线程等待所有线程执行完毕
        for(Thread t:add)
        {
            t.join();
        }
        for(Thread t:reduce)
        {
            t.join();
        }

        //输出结果
        System.out.println(Num);
    }

    public static int addNum(int Num){
        return Num+1;
    }
    public static int reduceNum(int Num){
        return Num-1;
    }
}
