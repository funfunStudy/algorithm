import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by jeremy on 03/13/2019.
 */
public class Programmers {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> deploys = new ArrayList<>();
        Queue<Integer> works = IntStream.range(0, progresses.length).boxed().collect(Collectors.toCollection(LinkedList::new));

        while (!works.isEmpty()) {
            int done = 0;
            // 1. check if work is done
            for (int i = 0; i < progresses.length; i++) {
                int progress = progresses[i];
                if (works.element() == i && progress >= 100) {
                    done++;
                    works.remove();
                }
            }
            if (done > 0) deploys.add(done);

            // 2. work
            for (int i = 0; i < progresses.length; i++) {
                if (progresses[i] < 100) {
//                    print(progresses);
                    progresses[i] += speeds[i];
                }
            }
        }

        return deploys.stream().mapToInt(i -> i).toArray();
    }

    public static void print(int[] progresses) {
        Arrays.stream(progresses).boxed().forEach(p -> System.out.print(p + " "));
        System.out.println();
    }

    public static void main(String[] args) {
        assertArrayEquals(new int [] { 2, 1 }, solution(new int [] { 93,30,55 }, new int[] { 1,30,5 }));
    }
}
