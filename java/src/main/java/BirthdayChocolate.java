import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by yong on 2018. 11. 13..
 */
public class BirthdayChocolate {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] strs1 = br.readLine().trim().split(" ");
        int [] intArray = Arrays.stream(strs1).mapToInt(Integer::parseInt).toArray();
        List<Integer> list = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        String[] strs2 = br.readLine().trim().split(" ");
        int d = Integer.parseInt(strs2[0]);
        int m = Integer.parseInt(strs2[1]);
        System.out.println(solve(list, d, m , 0));
    }

    public static int solve(List list, int d, int m, int acc){

        if(list.size() < m) {
            return acc;
        }

        int sum = 0;
        for(int i = 0; i < m; i++){
            sum += (int)list.get(i);
        }

        list.remove(0);
        if(sum == d)
            return solve(list, d, m, acc + 1);

        else
            return solve(list, d, m, acc);
    }
}
