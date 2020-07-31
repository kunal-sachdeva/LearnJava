package Strategy;

abstract public class Duck {
    abstract public void  swim();
    abstract public void display();
    public FlyBehave flybehave;
    public void PerformFly(){
        flybehave.fly();
    }
}
