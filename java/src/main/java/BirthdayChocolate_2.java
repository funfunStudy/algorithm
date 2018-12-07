import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by gold on 2018. 12. 7.
 */
public class BirthdayChocolate_2 {

    public static void main(String[] args) {

        BirthdayChocolate_2 bc = new BirthdayChocolate_2();

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int d = sc.nextInt();

        int m = sc.nextInt();

        // m 의 개수의 정수의 합으로 d 를 만들어라.

        System.out.println(bc.solve(Arrays.stream(arr).boxed().collect(Collectors.toList()), m, d, new ArrayList<>()));
        System.out.println(bc.solve(Arrays.stream(arr).boxed().collect(Collectors.toList()), m, d, new ArrayList<>()).size());

    }

    private List<List<Integer>> solve(List<Integer> input, int m, int d, List<List<Integer>> acc) {
        if (input.size() <= 0 || input.size() < m)
            return acc;

        int sum = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            temp.add(input.get(i));
            sum += input.get(i);
        }

        if (sum == d)
            acc.add(temp);

        input.remove(0);

        return solve(input, m, d, acc);
    }

}
