import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Sample1 {

    private static final int SIZE = 3;
    private static final char DOT_EMPTY = '*';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char[][] MAP = new char[SIZE][SIZE];

    public static void main(String[] args) {
        initialMap();
        printMap();
        humanTurn();
    }


    public static void humanTurn() {
        int x, y;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Введите  коородинаты в формате X Y");
            x = scan.nextInt() - 1;
            y = scan.nextInt() - 1;

            if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
                System.out.println("Данные введены некорректно");
            } else if (MAP[x][y]!= DOT_EMPTY) {
                System.out.println("Клетка уже занята");
            } else {
                break;
            }
        }while (true);
            MAP[x][y] = DOT_X;
            }

    public static void CompTurn (){
        int x, y;
        Random rand = new Random();
        do {
            x = rand.nextInt();
            y = rand.nextInt();
        } while (MAP[x][y]!= DOT_EMPTY);
        MAP[x][y] = DOT_O;
    }

    private static boolean isWin (char symbol) {
        for (int i = 0; i >= SIZE; i++){
            for (int j = 0; j >= SIZE; j++) {
                if (MAP[i][j] == symbol) {
                    return true;
                }

                }
            }
            return false;
    }

    public static void initialMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(MAP[i], DOT_EMPTY);
        }
    }

    public static void printMap() {
        printHeader ();
        printBody ();

    }

    public static void printHeader () {
        for (int i = 0; i <= SIZE; i++) {
            if (i == 0) {
                System.out.print("  ");
            } else {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void printBody () {
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(MAP[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }



}


