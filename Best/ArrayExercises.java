package Best;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ArrayExercises {

    private static final Random rand = new Random();

    public static int[] generateRandomArray(int n, int maxBound) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(maxBound);
        }
        return arr;
    }

    
    public static int binarySearchAPI(int[] sortedArr, int key) {
        // Sử dụng API Arrays.binarySearch
        return Arrays.binarySearch(sortedArr, key);
    }

    public static int binarySearchManual(int[] sortedArr, int key) {
        int left = 0;
        int right = sortedArr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (sortedArr[mid] == key) {
                return mid;
            } else if (sortedArr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // --- CÂU 1b: CHÈN VÀO MẢNG ĐÃ SẮP XẾP ---

    public static int[] generateSortedRandomArray(int n, int maxBound) {
        int[] arr = generateRandomArray(n, maxBound);
        Arrays.sort(arr); // Sắp xếp mảng
        return arr;
    }

    public static int[] insertIntoSortedArray(int[] sortedArr, int value) {
        int n = sortedArr.length;
        int[] newArr = new int[n + 1];

        int insertIndex = Arrays.binarySearch(sortedArr, value);

        if (insertIndex < 0) {
            insertIndex = -(insertIndex + 1);
        }
        System.arraycopy(sortedArr, 0, newArr, 0, insertIndex);

        newArr[insertIndex] = value;

        System.arraycopy(sortedArr, insertIndex, newArr, insertIndex + 1, n - insertIndex);

        return newArr;
    }

    // --- CÂU 1c: TÌM MẢNG CON CÓ TỔNG BẰNG GIÁ TRỊ CHO TRƯỚC ---

    public static void findSubarraysWithSum(int[] arr, int targetSum) {
        System.out.println("Đang tìm mảng con có tổng = " + targetSum + "...");
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum += arr[j];

                if (currentSum == targetSum) {
                    count++;
                    System.out.print("  Tìm thấy mảng con (chỉ số " + i + " đến " + j + "): [ ");
                    for (int k = i; k <= j; k++) {
                        System.out.print(arr[k] + " ");
                    }
                    System.out.println("]");
                }
            }
        }
        if (count == 0) {
            System.out.println("  Không tìm thấy mảng con nào.");
        }
    }

    // --- CÂU 1d: LỌC SỐ NGUYÊN TỐ LÊN ĐẦU VÀ SẮP XẾP ---

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int[] sortPrimesToFront_List(int[] arr, boolean ascending) {
        List<Integer> primes = new ArrayList<>();
        List<Integer> nonPrimes = new ArrayList<>();

        for (int num : arr) {
            if (isPrime(num)) {
                primes.add(num);
            } else {
                nonPrimes.add(num);
            }
        }

        if (ascending) {
            Collections.sort(primes);
        } else {
            primes.sort(Collections.reverseOrder());
        }
        
        primes.addAll(nonPrimes);

        return primes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] sortPrimesToFront_Stream(int[] arr, boolean ascending) {
        
        Comparator<Integer> primeSorter = ascending ? Comparator.naturalOrder() : Comparator.reverseOrder();

        List<Integer> primes = Arrays.stream(arr)
                .filter(ArrayExercises::isPrime)
                .boxed()
                .sorted(primeSorter)
                .collect(Collectors.toList());

        List<Integer> nonPrimes = Arrays.stream(arr)
                .filter(n -> !isPrime(n))
                .boxed()
                .collect(Collectors.toList());

        primes.addAll(nonPrimes);
        return primes.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        
        System.out.println("--- CÂU 1a: TÌM KIẾM NHỊ PHÂN ---");
        int[] arr1a = generateSortedRandomArray(10, 50);
        int key1a = arr1a[3];
        int key1a_missing = 49; 
        
        System.out.println("Mảng 1a (đã sắp xếp): " + Arrays.toString(arr1a));
        
        System.out.println("Tìm " + key1a + " (dùng API): Vị trí " + binarySearchAPI(arr1a, key1a));
        System.out.println("Tìm " + key1a + " (dùng Manual): Vị trí " + binarySearchManual(arr1a, key1a));
        
        System.out.println("Tìm " + key1a_missing + " (dùng API): Vị trí " + binarySearchAPI(arr1a, key1a_missing));
        System.out.println("Tìm " + key1a_missing + " (dùng Manual): Vị trí " + binarySearchManual(arr1a, key1a_missing));

        System.out.println("\n--- CÂU 1b: CHÈN VÀO MẢNG SẮP XẾP ---");
        int[] arr1b = generateSortedRandomArray(10, 50);
        int valueToInsert = 25;
        System.out.println("Mảng 1b (trước khi chèn): " + Arrays.toString(arr1b));
        System.out.println("Chèn giá trị: " + valueToInsert);
        int[] newArr1b = insertIntoSortedArray(arr1b, valueToInsert);
        System.out.println("Mảng 1b (sau khi chèn):   " + Arrays.toString(newArr1b));
        System.out.println("Đánh giá độ phức tạp: O(n).");
        System.out.println("Lý do: Mặc dù tìm vị trí chèn (binarySearch) mất O(log n),");
        System.out.println("nhưng việc tạo mảng mới và sao chép (System.arraycopy) mất O(n) thời gian.");

        System.out.println("\n--- CÂU 1c: TÌM MẢNG CON CÓ TỔNG BẰNG X ---");
        int[] arr1c = {1, 4, 20, 3, 10, 5, 8, 2}; 
        int targetSum1c = 33;
        System.out.println("Mảng 1c: " + Arrays.toString(arr1c));
        findSubarraysWithSum(arr1c, targetSum1c);
        System.out.println("Đánh giá độ phức tạp: O(n^2).");
        System.out.println("Lý do: Sử dụng 2 vòng lặp lồng nhau (i và j) để duyệt qua tất cả các mảng con liên tiếp.");

        System.out.println("\n--- CÂU 1d: LỌC SỐ NGUYÊN TỐ LÊN ĐẦU ---");
        int[] arr1d = generateRandomArray(15, 100);
        System.out.println("Mảng 1d (ban đầu):      " + Arrays.toString(arr1d));
        
        int[] result1d_list_asc = sortPrimesToFront_List(arr1d, true);
        System.out.println("Cách 1 (List, Tăng dần): " + Arrays.toString(result1d_list_asc));

        int[] result1d_stream_desc = sortPrimesToFront_Stream(arr1d, false);
        System.out.println("Cách 2 (Stream, Giảm dần): " + Arrays.toString(result1d_stream_desc));
    }
}
