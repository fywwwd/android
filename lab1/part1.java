import java.util.Arrays;
import java.util.Random;

    public class Main{
        
    static int len = 20;
    static int a = -10; 
    static int b = 10;
    static int[] firstArr = new int[len];
    static int[] secondArr = new int[len];
    static Random rand = new Random();
    
    public static void main(String[] args) {
    
    fillArray(firstArr, a, b);
    fillArray(secondArr, a, b);
    
    System.out.println("Неотсортированные массивы:");
    System.out.println(Arrays.toString(firstArr));
    System.out.println(Arrays.toString(secondArr));
    
    bubbleSort(firstArr);
    bubbleSort(secondArr);
    
    System.out.println("Отсортированные массивы:");
    System.out.println(Arrays.toString(firstArr));
    System.out.println(Arrays.toString(secondArr));
    
    int[] combinedArr = new int[firstArr.length + secondArr.length];
    
    System.arraycopy(firstArr, 0, combinedArr, 0, firstArr.length);
    System.arraycopy(secondArr, 0, combinedArr, firstArr.length, secondArr.length);
    
    bubbleSort(combinedArr);
    
    System.out.println("Объединенный отсортированный массив:");
    System.out.println(Arrays.toString(combinedArr));
        
    }
    
    public static void fillArray(int[] arr, int a, int b) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(b - a + 1) + a;
        }
    }
    
  public static void bubbleSort(int[] arr){
      for (int i = 0; i < arr.length - 1; i++) {
        boolean check = false;
        for (int j = 0; j < arr.length - i - 1; j++) {
          if (arr[j] < arr[j + 1]) {
            check = true;
            int tmp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = tmp;
      }
    }
    if (!check) break;
    }
}
}
