package Inheritence;

public class Test {
    public static void main(String[] args){
        try {
            Child c = new Child();
            c.getMsg();
        } catch (NullPointerException e){
            System.out.println("got exception");
        }
    }
}
