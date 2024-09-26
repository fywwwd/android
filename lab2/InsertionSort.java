/*
А (рус) > A (eng)
а > А
буква > цифра
*/

public class InsertionSort implements SortAlgorithm {
    @Override
    public void sort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(temp) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
