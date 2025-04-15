import java.util.*;

public class EditDistance {
    public static int minEditDistance(String X, String Y) {
        int n = X.length(), m = Y.length();
        int[][] C = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++)
            C[i][0] = i;
        for (int j = 0; j <= m; j++)
            C[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    C[i][j] = C[i - 1][j - 1];
                else
                    C[i][j] = Math.min(C[i - 1][j - 1] + 2, Math.min(C[i - 1][j] + 1, C[i][j - 1] + 1));
            }
        }

        return C[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String X = scanner.nextLine();
        System.out.print("Enter second string: ");
        String Y = scanner.nextLine();
        scanner.close();
        System.out.println("Minimum edit distance: " + minEditDistance(X, Y));
    }
}
//output
Enter first string: bhaskar
Enter second string: aravind
Minimum edit distance: 10
