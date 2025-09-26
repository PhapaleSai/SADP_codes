// slip 7:
// Write a Java Program to implement undo command to test Ceiling fan.

// Command interface
interface Command {
    void execute();
    void undo();
}

// Receiver
class CeilingFan {
    enum Speed { OFF, LOW, MEDIUM, HIGH }
    private Speed speed = Speed.OFF;
    void setSpeed(Speed s) { System.out.println("Ceiling Fan is " + s); speed = s; }
    Speed getSpeed() { return speed; }
}

// Concrete Command
class CeilingFanCommand implements Command {
    private CeilingFan fan;
    private CeilingFan.Speed prev, next;
    CeilingFanCommand(CeilingFan fan, CeilingFan.Speed next) { this.fan = fan; this.next = next; }
    public void execute() { prev = fan.getSpeed(); fan.setSpeed(next); }
    public void undo() { fan.setSpeed(prev); System.out.println("Undo: Fan speed is " + prev); }
}

// Invoker
class RemoteControl {
    private Command last;
    void pressButton(Command c) { c.execute(); last = c; }
    void pressUndo() { if (last != null) last.undo(); }
}

// Client
public class FanController {
    public static void main(String[] args) {
        CeilingFan fan = new CeilingFan();
        RemoteControl remote = new RemoteControl();

        remote.pressButton(new CeilingFanCommand(fan, CeilingFan.Speed.MEDIUM));
        remote.pressUndo();

        remote.pressButton(new CeilingFanCommand(fan, CeilingFan.Speed.HIGH));
        remote.pressUndo();
    }
}

// Output:
// Ceiling Fan is MEDIUM
// Ceiling Fan is OFF
// Undo: Fan speed is OFF
// Ceiling Fan is HIGH
// Ceiling Fan is OFF
// Undo: Fan speed is OFF