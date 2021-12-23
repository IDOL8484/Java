package Farm;

public class Cat extends Animal {

    protected int maxDistanceRun;
    static int catCount = 0;

    protected Cat(String name, int speed, int speedSwim) {
        super(name, speed, speedSwim);
        this.maxDistanceRun = 200;
        Cat.catCount++;
    }

    @Override
    protected void run() {
        int distanceRun = time * speed;
        if (distanceRun <= maxDistanceRun) {
            System.out.println(name + " пробежал " + distanceRun + " метра(ов) со скоростью " + speed + " м/с.");
        } else {
            System.out.println(name + " не может бежать так быстро. Введите меньшее значение скорости");
        }
    }
    @Override
    protected void swim(){
      System.out.println("Коты не могут плавать.");
    }
    public static void setCatCount() {
        System.out.println("==========================\nКолличество кошек = "
        + catCount + "\n==========================\n");
    }
}
