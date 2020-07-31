package Command;

public class RemoteControlDemo {
    public static void main(String[] args){
        RemoteControl rc=new RemoteControl();
        LightController lc=new LightController("Drawing room light");
        rc.setCommand(lc);
        rc.buttonPress();
        rc.buttonPress();
    }
}
