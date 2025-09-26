// Slip 2 :- Write a Java Program to implement Singleton pattern for multithreading 
//(Singleton Pattern Example in Java)

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null)
         {
            synchronized (Singleton.class) 
            {
                if (instance == null) 
                    instance = new Singleton();
            }
        }
        return instance;
    }
}

public class SingletonDemo {
    public static void main(String[] args) 
    {
        Runnable task = () -> System.out.println("Instance: " + Singleton.getInstance());

        new Thread(task).start();
        new Thread(task).start();
    }
}

// Output :- 
// Instance: Singleton@15db9742
// Instance: Singleton@15db9742