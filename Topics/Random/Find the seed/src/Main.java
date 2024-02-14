import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // write your code here
       
        int a = scanner.nextInt(); // seed start
        int b = scanner.nextInt(); // seed end
        int n = scanner.nextInt(); // number of pseudorandom numbers
        int k = scanner.nextInt(); // range from 0 (inclusive) to k (exclusive)

        int[] maximusFromSeeds = new int[2];
        int[] minimumFromMaximusSeeds = new int[2];
        minimumFromMaximusSeeds = showMaximumFromSeed(a, n, k); // for a
        for (int i = a + 1; i <= b; i++) { // for a + 1 to b
            maximusFromSeeds = showMaximumFromSeed(i, n, k); // [0] seed, [1] max
            if (minimumFromMaximusSeeds[1] > maximusFromSeeds[1]) {
                minimumFromMaximusSeeds = maximusFromSeeds;
            }
        }
        System.out.println(minimumFromMaximusSeeds[0]);
        System.out.println(minimumFromMaximusSeeds[1]);

    }

    private static int[] showMaximumFromSeed(int a, int n, int k) {
        Random random = new Random(a);
        ArrayList<Integer> listOfRandomNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listOfRandomNumbers.add(random.nextInt(k));
        }
        int[] max = new int[2];
        max[1] = Collections.max(listOfRandomNumbers);
        max[0] = a;
        return max;
    }
}
