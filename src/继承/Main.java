package 继承;
//java 不支持多继承
// 注意访问控制，不是什么都能继承
// 构造方法不能继承，只能super()访问
// 应避免重复定义父类中已有的成员
// 子类中没有某个属性时, this.age 会去父类找

public class Main {
    public static void main(String[] args) {
        Son son = new Son();
        son.eat();
    }


}
