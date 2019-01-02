import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gold on 2010. 01. 02..
 */
public class AngryProfessor {

    public static void main(String[] args) {

        AngryProfessor ap = new AngryProfessor();

        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int students = sc.nextInt();
            int threshold = sc.nextInt();
            List<Integer> times = new ArrayList<>();

            for (int j = 0; j < students; j++)
                times.add(sc.nextInt());

            System.out.println(ap.solve(times, threshold) ? "YES" : "NO");
        }

    }

    private boolean solve(final List<Integer> times, final int threshold) {
        if (times.size() <= 0)
            return threshold > 0;

        int head = times.get(0);
        int tempThreshold = threshold;

        if (head > 0)
            tempThreshold--;

        return solve(new ArrayList<Integer>(times){{remove(0);}}, tempThreshold);
    }

}
