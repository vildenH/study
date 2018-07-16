package command;

/**
 * @author wh
 * @date 2018/7/13
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl()

    {
    }

    public void setCommand(Command command) {
        slot = command;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
