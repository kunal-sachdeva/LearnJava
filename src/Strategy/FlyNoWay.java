package Strategy;

public class FlyNoWay implements FlyBehave {
    @Override
    public void fly() {
        System.out.println("I cant Fly");
    }
}
