package Farm;

public class Dog extends Animal {

    static int dogCount = 0;
    public Dog(String name, int speed, int speedSwim) {
        super(name, speed, speedSwim);
        Dog.dogCount++ ;
    }
    public static void setDogCount (){
        System.out.println("==========================\nКолличество собак = "
        + dogCount + "\n==========================\n");
    }
}
