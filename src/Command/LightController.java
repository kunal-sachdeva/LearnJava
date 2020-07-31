package Command;

public class LightController implements Command {
    Boolean light=false;
    String lightName;
    public LightController(String lightName){
        this.lightName=lightName;
    }

    @Override
    public void execute() {
        light = !light;
        System.out.println(lightName+" status is: "+ light);
    }
}
