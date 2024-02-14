import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = 0;
        int count = 0;
        Random random = new Random(a + b);
        do{
            int tempRandom = random.nextInt(a,b +1);
            if (tempRandom >= a && tempRandom <= b) {
                sum += tempRandom;
                count++;
            }
        } while (count < n);
        System.out.println(sum);
    }
}