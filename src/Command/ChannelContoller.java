package Command;

public class ChannelContoller implements Command  {
    int channel=1;
    @Override
    public void execute() {
        channel+=1;
        System.out.println("Channel Number changed to: "+channel);
    }
}
