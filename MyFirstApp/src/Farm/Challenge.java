package Farm;

class Challenge{
    
    public static void main(String[] args) {
         challenge();
         Dog.setDogCount();
         Cat.setCatCount();
         Animal.setAnimalCount();
    }
    public static void challenge() {
        Dog dog1 = new Dog("Maxim", 49, 3);
        Dog dog2 = new Dog("Johnny", 38, 4);
        Dog dog3 = new Dog("Bobby", 54, 1);
        Dog dog4 = new Dog("Бим", 41,2);
        Cat cat1 = new Cat("Барсик", 11, 44);
        Cat cat2 = new Cat("Васька", 19, 0);
        Cat cat3 = new Cat("Пушок", 23, 3);
        Animal[] animalPack = {dog4, dog1, dog2, cat1, dog3, cat2, cat3};
        for (int i = 0; i < animalPack.length; i++) {
            animalPack[i].run();
            animalPack[i].swim();
            System.out.println();
        }
    }
}
