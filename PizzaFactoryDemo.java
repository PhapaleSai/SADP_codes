//Slip - 4 and Slip 19
//Q.1 Write a Java Program to implement Factory method for Pizza Store with createPizza(), orederPizza(), prepare(), Bake(), cut(), box(). Use this to create variety of pizza’s like NyStyleCheesePizza, ChicagoStyleCheesePizza etc. 

abstract class Pizza 
{
    void prepare() { System.out.println("Preparing " + this); }
    void bake() { System.out.println("Baking " + this); }
    void cut() { System.out.println("Cutting " + this); }
    void box() { System.out.println("Boxing " + this); }
    public String toString() { return getClass().getSimpleName(); }
}

class NyStyleCheesePizza extends Pizza {}
class ChicagoStyleCheesePizza extends Pizza {}

abstract class PizzaStore {
    public Pizza orderPizza() {
        Pizza pizza = createPizza();
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        return pizza;
    }
    protected abstract Pizza createPizza();
}

class NyPizzaStore extends PizzaStore 
{
    protected Pizza createPizza() 
    {
         return new NyStyleCheesePizza();
        }
}

class ChicagoPizzaStore extends PizzaStore {
    protected Pizza createPizza() { return new ChicagoStyleCheesePizza(); }
}

public class PizzaFactoryDemo {
    public static void main(String[] args) {
        new NyPizzaStore().orderPizza();
        System.out.println();
        new ChicagoPizzaStore().orderPizza();
    }
}

/*Output
Preparing NyStyleCheesePizza
Baking NyStyleCheesePizza
Cutting NyStyleCheesePizza
Boxing NyStyleCheesePizza

Preparing ChicagoStyleCheesePizza
Baking ChicagoStyleCheesePizza
Cutting ChicagoStyleCheesePizza
Boxing ChicagoStyleCheesePizza
*/