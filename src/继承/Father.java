package 继承;

public class Father {
    int age = 30;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    Father(){
        System.out.println("Father");
    }
    Father(int age){
        System.out.println("Father--age"+age);
    }

    void eat(){
        System.out.println("Father--eat");
    }
}
