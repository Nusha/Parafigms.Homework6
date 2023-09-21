import java.util.*;

public class BinarySearchRecursive {
    public static void main(String[] args) {
        BinarySearchRecursive bsr = new BinarySearchRecursive();
        Random rnd = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        int n = rnd.nextInt(5, 20);
        for (int i = 0; i < n; i++) {
            arr.add(rnd.nextInt(1, 60));
        }
        Set<Integer> set = new HashSet<>(arr);
        arr.clear();
        arr.addAll(set);
        arr.sort(null);
        n = arr.size();
        System.out.println("Сгенерированный массив:");
        System.out.println(arr);
        System.out.println("Введите искомое число: ");
        Scanner in = new Scanner(System.in);
        int target = 0;
        boolean validInput = false;
        while (!validInput) {
            if (in.hasNextInt()) {
                target = in.nextInt();
                validInput = true;
            } else {
                System.out.println("Введите корректное целочисленное значение: ");
                in.next(); // Discard invalid input
            }
        }
        int result = bsr.binarySearchRecursive(arr, 0, n - 1, target);
        System.out.println(result == -1 ? "Элемент отсутствует в массиве" : "Элемент найден с индексом " + result);
    }

    int binarySearchRecursive(ArrayList<Integer> arr, int low, int high, int target) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) == target) return mid;
            if (arr.get(mid) > target) return binarySearchRecursive(arr, low, mid - 1, target);
            return binarySearchRecursive(arr, mid + 1, high, target);
        }
        return -1;
    }
}