package 多线程;

//这里说明了JVM启动了垃圾回收线程和主线程， 是多线程的
public class Thread_JVM {
    public static void main(String[] args) {
        for (int i = 0; i< 10000; i++){
            new Demo();
        }
        System.gc(); //增加垃圾回收器启动的概率
        for (int i = 0; i< 10000; i++){
            System.out.println("我是主线程代码");
        }


    }
}
class Demo{
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("垃圾被清扫了");
    }
}
