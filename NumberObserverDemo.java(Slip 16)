// Slip 16
// Write a Java Program to implement Observer Design Pattern for number conversion. 
// Accept a number in Decimal form and represent it in Hexadecimal, Octal and Binary. 
// Change the Number and it reflects in other forms also

import java.util.*;

// Subject
class Number {
    private int number;
    private List<Runnable> observers = new ArrayList<>();

    void setNumber(int number) {
        this.number = number;
        notifyObservers();
    }

    int getNumber() { return number; }

    void addObserver(Runnable observer) { observers.add(observer); }

    private void notifyObservers() { observers.forEach(Runnable::run); }
}

// Client
public class NumberObserverDemo {
    public static void main(String[] args) {
        Number number = new Number();

        // Add observers
        number.addObserver(() -> System.out.println("Hexadecimal: " + Integer.toHexString(number.getNumber())));
        number.addObserver(() -> System.out.println("Octal: " + Integer.toOctalString(number.getNumber())));
        number.addObserver(() -> System.out.println("Binary: " + Integer.toBinaryString(number.getNumber())));

        // Set numbers
        number.setNumber(25);
        System.out.println("\nChanging number to 45:");
        number.setNumber(45);
    }
}
