package Inheritence;

public class Parent {
    int id;
    public Parent(int id){
        this.id=id;
    }
    public void getMsg(){
        throw new NullPointerException();
    }
}
