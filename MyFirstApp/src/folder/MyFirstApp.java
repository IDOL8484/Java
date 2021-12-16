package folder;

import java.util.Random;
import java.util.Scanner;

public class MyApp{

    public static Random random = new Random();
    public static Scanner scanner = new Scanner(System.in);

    //Map
    public static int level;
    public static char[][] map;
    public static int mapWight;
    public static int mapHeight;
    public static int mapSizeMin = 3;
    public static int mapSizeMax = 5;
    public static char empty = '_';
    public static char ready = '*';

    //Player
    public static char player = '@';
    public static String playerName = "Boris";
    public static int playerHP = 100;
    public static int playerX;
    public static int playerY;
    public static final int playerMoveUp = 8;
    public static final int playerMoveLeft = 4;
    public static final int playerMoveRight = 6;
    public static final int playerMoveDown = 2;

    //Trap
    public static char trap = 'T';
    public static int trapAttack;
    public static int trapCount;
    public static int trapDamageMin = 5;
    public static int trapDamageMax = 15;

// В main оставил только startLevelCycle, который запускает игру и цикл повторения уровня.
    public static void main(String[] args) {
        startLevelsCycle();
    }

    public static void startLevelsCycle() {
        while (isPlayerAlive()) {
            ++level;
            System.out.println("Welcome to New Level " + level);
            levelCycle();
        }
    }

    public static void levelCycle(){

        createMap();
        spawnPlayer();
        spawnTrap();

        while (true) {
            showMap();
            movePlayer();

            if (!isPlayerAlive()) {
                System.out.println(playerName + " is dead");
                break;
            }

            if (isFullMap()) {
                System.out.println(playerName + " win this map");
                break;
            }
        }
        System.out.println("GAME OVER");
    }

    public static void createMap() {
        mapWight = randomValue(mapSizeMin, mapSizeMax);
        mapHeight = randomValue(mapSizeMin, mapSizeMax);
        map = new char[mapHeight][mapWight];

        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                map[y][x] = empty;
            }
        }

        System.out.println("Map has been created. Map size is " + mapWight + "x" + mapHeight);
    }

//    Добавил output для маскировки ловушек. Ловушки наносят урон и программа видит их как не empty.
    public static void showMap() {
        System.out.println("==========> MAP <==========");
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                char output = map[y][x];
                if (output == trap) {
                    output = empty;
                }
                System.out.print(output + "|");
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    public static void spawnPlayer() {
        playerX = randomValue(0, mapWight - 1);
        playerY = randomValue(0, mapHeight - 1);
        map[playerY][playerX] = player;
        System.out.println(playerName + " has spawn in [" + (playerX + 1) + ":" + (playerY + 1) + "]");
    }

    public static void spawnTrap() {
        trapAttack = randomValue(trapDamageMin, trapDamageMax);
        trapCount = (mapWight + mapHeight) / 2;

        int trapX;
        int trapY;

        for (int i = 1; i <= trapCount; i++) {

            do {
                trapX = random.nextInt(mapWight);
                trapY = random.nextInt(mapHeight);
            } while (!isEmpty(trapX, trapY));

            map[trapY][trapX] = trap;
        }
        System.out.println(trapCount + " trap's has been created. Trap's Attack = " + trapAttack);
    }

    public static void movePlayer() {

        int currentPlayerX = playerX;
        int currentPlayerY = playerY;
        int playerDestination;

        do {
            System.out.print("Enter your move: (Up: " + playerMoveUp + " | Down: " + playerMoveDown +
                    " | Left: " + playerMoveLeft + " | Right: " + playerMoveRight + ") >>> ");

            playerDestination = scanner.nextInt();

            switch (playerDestination) {
                case playerMoveUp:
                    playerY -= 1;
                    break;
                case playerMoveDown:
                    playerY += 1;
                    break;
                case playerMoveLeft:
                    playerX -= 1;
                    break;
                case playerMoveRight:
                    playerX += 1;
                    break;
            }
        } while (!checkValidMove(currentPlayerX, currentPlayerY, playerX, playerY));

        playerMoveAction(currentPlayerX, currentPlayerY, playerX, playerY);
    }

    public static boolean isEmpty(int x, int y) {
        return map[y][x] == empty;
    }

    public static boolean isFullMap() {
        for (int y = 0; y < mapHeight; y++) {
            for (int x = 0; x < mapWight; x++) {
                if (map[y][x] == empty) return false;
            }
        }
        return true;
    }

    public static boolean checkValidMove(int pastX, int pastY, int nextX, int nextY) {
        if (nextX >= 0 && nextX < mapWight && nextY >= 0 && nextY < mapHeight) {
            System.out.println(playerName + " move to [" + (nextX + 1) + ":" + (nextY + 1) + "] success");
            return true;
        } else {
            System.out.println(playerName + " move invalid! Please try again!");
            playerX = pastX;
            playerY = pastY;
            return false;
        }
    }

    public static void playerMoveAction(int pastX, int pastY, int nextX, int nextY) {

        if (map[nextY][nextX] == trap) {
            playerHP -= trapAttack;
            trapCount--;
            System.out.println("Alarm! " + playerName + " has been attack. HP = " + playerHP);
        }
            map[nextY][nextX] = player;
            map[pastY][pastX] = ready;

    }

    public static int randomValue(int min, int max) {
        return min + random.nextInt(max - min + 1);
    }

    public static boolean isPlayerAlive() {
        return playerHP > 0;
    }

}

