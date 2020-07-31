package Strategy;

public class MallardDuck extends Duck{

    @Override
    public void swim() {
        System.out.println("I can swim");
    }

    @Override
    public void display() {
        System.out.println("I look like a mallard duck ");
    }
    public MallardDuck(){
        flybehave=new FlyNoWay();
    }
    public static void main(String args[]){
        MallardDuck md = new MallardDuck();
        md.PerformFly();
    }

}
