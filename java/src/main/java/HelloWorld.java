import java.util.Scanner;

class HelloWorld {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for (int i = 0; i < cases; i++) {
            String name = sc.next();
            System.out.println("Hello, " + name + "!");
        }
    }
}
