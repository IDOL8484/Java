package Farm;

public class Animal {

    protected String name;
    protected int speed;
    protected int speedSwim;
    protected int maxDistanceRun;
    protected int maxDistanceSwim;
    protected int time;
    static int animalCount = 0;

    protected Animal(String name, int speed, int speedSwim) {
        this.name = name;
        this.speed = speed;
        this.speedSwim = speedSwim;
        this.maxDistanceRun = 500;
        this.maxDistanceSwim = 35;
        this.time = 10;
        Animal.animalCount++;
    }

    protected void run() {
        int distanceRun = time * speed;
        if (distanceRun <= maxDistanceRun) {
            System.out.println(name + " пробежал " + distanceRun + " метра(ов) со скоростью " + speed + " м/с.");
        } else {
            System.out.println(name + " не может бежать так быстро. Введите меньшее значение скорости");
        }
    }
    protected void swim() {
        int distanceSwim = time * speedSwim;
        if (distanceSwim <= maxDistanceSwim) {
            System.out.println(name + " пролыл " + distanceSwim + " метра(ов). Со скоростью "
                    + speedSwim + " м/с.");
        }
        else {
            System.out.println(name + " чуть не утонул. Собаки не могут плыть больше " + maxDistanceSwim);
        }

    }
    public static void setAnimalCount() {
                System.out.println("==========================\nОбщее колличество животных = "
                        + animalCount + "\n==========================\n");
    }
}


