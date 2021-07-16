package 函数;

import java.util.ArrayList;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {

        int a = 10;
        int[] array = {1,2,3,4,5};


        ArrayList arrList = new ArrayList();
        arrList.add(7);
        arrList.add(8);
        //arrList.addAll(Collections.singleton(array));
        System.out.println(arrList);

        test(a, array, arrList);

        System.out.println(a);
        for (int i=0; i < array.length; i ++){
            System.out.print(array[i] + ",");

        }
        System.out.println();
        System.out.println(arrList);

//        test2();
// 本类static方法 要想调用成员方法，必须有本类实例
        //否则就将方法转成static方法 或者将main（）转成非static方法

        Main main = new Main();
        main.test2();
    }
    static void test(int x, int[] arr, ArrayList arrlist){
        x = x + 1;
        System.out.println(x);

        arrlist.add(9);


    }

    public void test2(){
        System.out.println("public void test2()");
    }

    Main() {
        test2();
    }
}
