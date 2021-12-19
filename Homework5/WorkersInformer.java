package Office;

public class WorkersInformer {
    static Worker [] workers;

    public static void main (String[] args) {
// Здесь я Вывел информацию о сотруднике.
        Worker user1 = new Worker("Ivanov Dmitrii", "Engineer", "+79313345673", "ivanov@work.ru", 60000, 35);
        user1.printUserInfo();

// А здесь Вывел информацию о сотрудниках из массива, старше 40 лет.
        workers = new Worker [5];
        workers [0] = new Worker("Pavlov Petr", "Manager", "+79112344351", "pavlov@work.ru", 35000, 41);
        workers [1] = new Worker("Vasiliev Denis", "HR director", "+79112747751", "denis@work.ru", 75000, 47);
        workers [2] = new Worker("Vasiliev Oleg", "Receptionist", "+79133466651", "olegka@work.ru", 15000, 29);
        workers [3] = new Worker("Ranta Andrei", "Manager", "+79215544587", "ranta@work.ru", 30000, 53);
        workers [4] = new Worker("Gavrikov Philipp", "Game designer", "+79135578951", "Phil@work.ru", 45000, 38);
        printWorkersInfo(41);
    }

    static void printWorkersInfo(int minAge) {
        for (int i = 0; i < workers.length; i++) {
            if (workers[i].age >= minAge) {
                workers[i].printUserInfo();
            }
        }
    }
}
