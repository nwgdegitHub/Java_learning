package 继承;

public class Son extends Father{
    Son(){
//        this(29); //报错 this只能调本类构造方法
//        super(30);
//        super.eat(); //super 也可以调用父类成员方法
//        System.out.println("Son");
        System.out.println(this.age);
    }

    public void eat(){

        System.out.println("Son--eat");
        super.eat();
    }
}
