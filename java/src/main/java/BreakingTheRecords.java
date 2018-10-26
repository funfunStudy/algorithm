import java.util.Arrays;
import java.util.Scanner;

public class BreakingTheRecords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BreakingTheRecords btr = new BreakingTheRecords();

        int count = sc.nextInt();
        int[] arr = new int[count];

        for (int i = 0; i < count; i++)
            arr[i] = sc.nextInt();

//        System.out.println(btr.btrMaxRec(arr[0], arr, 0, 0));
//
//        System.out.println(btr.btrMinRec(arr[0], arr, 0, 0));

        System.out.println(Arrays.toString(btr.btrMaxMin(arr, arr[0], arr[0], 0, new int[2])));
    }

    //3
    private int[] btrMaxMin(final int[] arr, final int max, final int min, final int index, final int[] count) {
        if (index >= arr.length)
            return count;

        int tempMax = max;
        int tempMin = min;
        int tempIndex = index;
        int[] tempCount = count.clone();

        if (arr[index] > max) {
            tempMax = arr[index];
            tempCount[0] = count[0] + 1;
        }

        if (arr[index] < min) {
            tempMin = arr[index];
            tempCount[1] = count[1] + 1;
        }

        return btrMaxMin(arr, tempMax, tempMin, ++tempIndex, tempCount);
    }


    //2
    private int btrMaxRec(int max, int[] arr, int count, int index) {
        if (index >= arr.length)
            return count;

        if (arr[index] > max) {
            return btrMaxRec(arr[index], arr, ++count, ++index);
        } else {
            return btrMaxRec(max, arr, count, ++index);
        }
    }

    private int btrMinRec(int min, int[] arr, int count, int index) {
        if (index >= arr.length)
            return count;

        if (arr[index] < min) {
            return btrMinRec(arr[index], arr, ++count, ++index);
        } else {
            return btrMinRec(min, arr, count, ++index);
        }
    }


    //1
    private int btrMax(int max, int[] arr, int count) {
        for (int i : arr) {
            if (i > max) {
                max = i;
                count++;
            }
        }

        return count;
    }

    private int btrMin(int min, int[] arr, int count) {
        for (int i : arr) {
            if (i < min) {
                min = i;
                count++;
            }
        }

        return count;
    }

}
