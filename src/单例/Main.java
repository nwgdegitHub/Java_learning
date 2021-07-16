package 单例;

import org.w3c.dom.ls.LSOutput;

public class Main{
    public static void main(String[] args) {

        System.out.println("在idea中直接输入sout 快捷键调出System.out.println");

        Rocket r1 = Rocket.getInstance();
        System.out.println(r1);

        Rocket r2 = Rocket.getInstance();
        System.out.println(r2);

        Rocket r3 = Rocket.getInstance();
        System.out.println(r3);

        System.out.println(r1 == r2);
    }



}
