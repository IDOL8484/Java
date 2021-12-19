package Office;

    public class Worker {

        String name;
        String position;
        String numberPhone;
        String email;
        int salary;
        int age;

        public Worker(String name, String position, String numberPhone, String email, int salary, int age) {
            this.name = name;
            this.position = position;
            this.numberPhone = numberPhone;
            this.email = email;
            this.salary = salary;
            this.age = age;
        }

        String getUserInfo() {
            return ("Имя: " + name + " \nДолжность: " + position +
                   " \nЗарплата: " + salary + " \nВозвраст: " + age +
                   " \nНомер телефона:" + numberPhone + " \nEmail:" + email + "\n");
        }

        void printUserInfo() {
            System.out.println(getUserInfo() + "\n================================\n");
        }
    }