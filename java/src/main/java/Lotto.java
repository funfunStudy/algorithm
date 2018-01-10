import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static List<List<Integer>> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String currentLine = sc.nextLine();

        while (!currentLine.equals("0")) {
            printLotto(currentLine);
            currentLine = sc.nextLine();
            System.out.println();
        }
    }

    private static void printLotto(String currentLine) {
        List<Integer> inputs = Arrays.stream(currentLine.split(" "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());

        int k = inputs.get(0);
        List<Integer> tailList = inputs.subList(1, inputs.size());

        lotto(k, tailList);
        results.stream()
                .sorted(getLottoComparator())
                .map(result -> result.stream().map(String::valueOf).collect(Collectors.joining(" ")))
                .distinct()
                .forEach(System.out::println);
    }

    private static void lotto(int k, List<Integer> list) {
        if (list.size() == 6) {
            results.add(list);
        } else {
            for (int i = 0; i < k; i++) {
                List<Integer> subList = new ArrayList<>(list);
                subList.remove(i);
                lotto(k - 1, subList);
            }
        }
    }

    private static Comparator<List<Integer>> getLottoComparator() {
        return (s1, s2) -> {
            for (int i = 0; i < 6; i++) {
                if (s1.get(i) > s2.get(i)) {
                    return 1;
                } else if (s1.get(i) < s2.get(i)) {
                    return -1;
                }
            }

            return 0;
        };
    }
}
