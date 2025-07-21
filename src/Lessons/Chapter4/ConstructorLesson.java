package Lessons.Chapter4;
public class ConstructorLesson{
    
    public static void main(String[] args) {
        Bunny bunny1 = new Bunny("Bugs");
        Bunny bunny2 = new Bunny("Lola");
        Hamster hamster1 = new Hamster(2);
        Hamster hamster2 = new Hamster(2,"White");
        System.out.println();
    }
}

class Bunny{
    String name;
    public Bunny(String name){
        this.name = name;
        System.out.println("this is Bunny Constructor");
    }
}

class Hamster{ 
    private String color;
    private int weight;
    public Hamster(int weight){ // 1st constructor
        // this.weight = weight; // will compile
        // color = "brown"; //will compile
        this(weight, "brown");
    }
    public Hamster(int weight,String color){ //2nd constructor
        this.weight = weight;
        this.color = color;
    }
}

class InitializationOrderSimple {
    private String name = "Torchie"; { 
        System.out.println(name); 
    }
    private static int COUNT = 0;
    static { 
        System.out.println(COUNT); 
    }
    static { 
        COUNT += 10; System.out.println(COUNT); 
    }
    public InitializationOrderSimple() {
      System.out.println("constructor");
    } 
    public static void main(String[] args) {
        InitializationOrderSimple init = new InitializationOrderSimple();
    }
}

class Mouse {
    private int numTeeth;
    private int numWhiskers;
    private int weight;

    public Mouse(int weight) {
        this(weight, 16); // calls constructor with 2 parameters
    }

    public Mouse(int weight, int numTeeth) {
        this(weight, numTeeth, 6); // calls constructor with 3 parameters
    }

    public Mouse(int weight, int numTeeth, int numWhiskers) {
        this.weight = weight;
        this.numTeeth = numTeeth;
        this.numWhiskers = numWhiskers;
    }

    public void print() {
        System.out.println(weight + " " + numTeeth + " " + numWhiskers);
    }

    public static void main(String[] args) {
        Mouse mouse = new Mouse(15);
        mouse.print();
    }
}