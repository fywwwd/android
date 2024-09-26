
import java.util.Scanner;

public class Run {
    
    final static int NUM = 5;
    private static String[] userArr;
    private static SortAlgorithm algorithm;

    public static void main(String[] args) {
        createArray();
        chooseSortingAlgorithm();
        showSortedArray();
    }

    public static void createArray() {
        Scanner scanner = new Scanner(System.in);
        userArr = new String[NUM];

        for (int i = 0; i < NUM; i++) {
            System.out.print("Введите строку " + (i + 1) + ": ");
            userArr[i] = scanner.nextLine();
        }

        System.out.println("Исходный массив: ");
        showArray(userArr);
    }

    public static void chooseSortingAlgorithm() {
        Scanner scanner = new Scanner(System.in);
        int check = 0;
        while (check == 0){
        System.out.println("Выберите алгоритм сортировки:");
        System.out.println("1. Сортировка вставками");
        System.out.println("2. Сортировка пузырьком");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                algorithm = new InsertionSort();
                check++;
                break;
            case 2:
                algorithm = new BubbleSort();
                check++;
                break;
            default:
                System.out.println("Некорректный выбор!");
            }
        }
    }

    public static void showSortedArray() {
        
        algorithm.sort(userArr);
        System.out.println("Отсортированный массив: ");
        showArray(userArr);
    }

    public static void showArray(String[] arr) {
        for (String str : arr) {
            System.out.println(str);
        }
    }
}
