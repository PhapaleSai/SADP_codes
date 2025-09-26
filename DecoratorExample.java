//SLIP 1 and Slip 20
//  - Q.1 Write a Java Program to implement I/O Decorator for converting uppercase letters to lower case letters.(Decorator Pattern Example in Java)

class TextMessage {
    private String text;

    public TextMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    // Decorator method to convert text to lowercase
    public TextMessage toLowerCase() {
        this.text = this.text.toLowerCase();
        return this;  // return the same object for chaining
    }
}

// Main class
public class DecoratorExample {
    public static void main(String[] args) 
    {
        TextMessage message = new TextMessage("Hello, WORLD!");
        message.toLowerCase();  // Apply the lowercase transformation
        System.out.println(message.getText());  // Output: hello, world!
    }
}
