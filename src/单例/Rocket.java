package 单例;

//饿汉式
public class Rocket {

    private static Rocket instance = new Rocket();

    public static Rocket getInstance(){
        return instance;
    }
}

//懒汉式(并非线程安全)
//public class Rocket {
//
//    private static Rocket instance = null;
//
//    public static Rocket getInstance(){
//
//        if (instance == null){
//            instance = new Rocket();
//        }
//        return instance;
//    }
//}
