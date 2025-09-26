// Slip 8
// Write a Java Program to implement State Pattern for Gumball Machine. 
// Create instance variable that holds current state from there, we just need to handle all actions, behaviors and state transition that can happen 

// State interface with default methods
interface State {
    default void insertQuarter() { System.out.println("Action not allowed."); }
    default void ejectQuarter() { System.out.println("Action not allowed."); }
    default void turnCrank() { System.out.println("Action not allowed."); }
    default void dispense() { System.out.println("Action not allowed."); }
}

// Receiver & Context
class CandyDispenser {
    enum StateEnum { NO_QUARTER, HAS_QUARTER, SOLD, SOLD_OUT }
    private StateEnum state;
    private int count;

    public CandyDispenser(int count) {
        this.count = count;
        state = (count > 0) ? StateEnum.NO_QUARTER : StateEnum.SOLD_OUT;
    }

    void insertQuarter() {
        switch(state) {
            case NO_QUARTER -> { System.out.println("You inserted a quarter."); state = StateEnum.HAS_QUARTER; }
            case HAS_QUARTER -> System.out.println("Can't insert more than one quarter.");
            case SOLD -> System.out.println("Please wait, dispensing gumball.");
            case SOLD_OUT -> System.out.println("Sold out.");
        }
    }

    void ejectQuarter() {
        switch(state) {
            case HAS_QUARTER -> { System.out.println("Quarter returned."); state = StateEnum.NO_QUARTER; }
            case NO_QUARTER -> System.out.println("No quarter inserted.");
            default -> System.out.println("Can't eject now.");
        }
    }

    void turnCrank() {
        if (state == StateEnum.HAS_QUARTER) {
            System.out.println("You turned the crank.");
            state = StateEnum.SOLD;
            dispense();
        } else if (state == StateEnum.NO_QUARTER) {
            System.out.println("Insert a quarter first.");
        } else if (state == StateEnum.SOLD) {
            System.out.println("Already dispensing a gumball.");
        } else {
            System.out.println("No gumballs left.");
        }
    }

    void dispense() {
        if (state == StateEnum.SOLD) {
            System.out.println("A gumball comes rolling out!");
            count--;
            state = (count > 0) ? StateEnum.NO_QUARTER : StateEnum.SOLD_OUT;
        }
    }

    void reportState() { System.out.println("Current state: " + state); }
}

// Client
public class CandyDispenserDemo {
    public static void main(String[] args) {
        CandyDispenser dispenser = new CandyDispenser(3);

        dispenser.insertQuarter();
        dispenser.turnCrank();

        dispenser.insertQuarter();
        dispenser.turnCrank();

        dispenser.insertQuarter();
        dispenser.turnCrank();

        dispenser.reportState();
    }
}


//Output:
// You inserted a quarter.
// You turned the crank.
// A gumball comes rolling out!
// You inserted a quarter.
// You turned the crank.
// A gumball comes rolling out!
// You inserted a quarter.
// You turned the crank.
// A gumball comes rolling out!
// Current state: SOLD_OUT