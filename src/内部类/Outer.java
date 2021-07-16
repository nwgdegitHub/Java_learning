package 内部类;

//https://www.cnblogs.com/wjlwo2ni/p/11040967.html
//Java内部类可分为成员内部类、局部内部类、匿名内部类、静态内部类。

//public class Outer {
//    private String outerName = "outer";
//
//    private InnerClass inner = new InnerClass();
//    class InnerClass{
//        private String InnerName = "Inner";
//        public void show(){
//            System.out.println(outerName);
//        }
//    }
//    public void show(){
//        System.out.println(inner.InnerName);
//        inner.show();
//    }
//
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.show();
//
//        Outer.InnerClass inner = outer.new InnerClass();
//        inner.show();
//    }
//}

//public class Outer {
//    private String outerName = "outer";
//
//    public void show(final String str){
//
//        class InnerClass{
//            private String InnerName = "Inner";
//            public void print(){
//                System.out.println(outerName + str);
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.show("lalala");
//
//    }
//}


//public class Outer {
//    private String outerName = "outer";
//
//    public void show(final String str){
//
//        new InnerClass(){
//
//            public void print(){
//                System.out.println(outerName + str);
//            }
//        }.print();
//    }
//
//    public static void main(String[] args) {
//        Outer outer = new Outer();
//        outer.show("lalala");
//
//    }
//}
//interface InnerClass{
//    void print();
//}

public class Outer {
    private String outerName = "outer";
    private static int id = 123;

    private InnerClass inner = new InnerClass();
    public static class InnerClass{

        public void print1(){
            System.out.println(id);
        }
        public static void print2(){
            System.out.println(id);
        }
    }
    public void show(){
        inner.print1();
    }

    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.show();

        Outer.InnerClass.print2();
    }
}

