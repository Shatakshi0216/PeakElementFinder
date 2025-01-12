import java.util.*;

class FindPeak {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter the size of array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        input(arr);
        int peakIdx = findPeak(arr);
        if (peakIdx == -1) {
            System.out.println("No peak element is present.");
        } else {
            System.out.println("Peak index is " + peakIdx);
            System.out.println("Peak element is " + arr[peakIdx]);
        }
    }

    public static void input(int arr[]) {
        System.out.println("Enter the elements of array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
    }

    public static int findPeak(int arr[]) {
        int str = 0, end = arr.length - 1;

        while (str <= end) {
            int mid = str + (end - str) / 2;

            // Handle edge cases for the first and last elements
            if ((mid == 0 || arr[mid] > arr[mid - 1]) &&
                    (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid; // Peak element found
            }

            // If left neighbor is greater, move left
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                end = mid - 1;
            }
            // Otherwise, move right
            else {
                str = mid + 1;
            }
        }
        return -1; // No peak found
    }
}
