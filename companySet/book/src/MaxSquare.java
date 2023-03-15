import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxSquare {
    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
        int[] dp = new int[cols + 1];
        int maxsqlen = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (matrix[i - 1][j - 1] == '1') {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        return maxsqlen * maxsqlen;
    }

    public int findLargestSquareSize(List<List<Integer>> samples) {
        int rows = samples.size(), cols = rows > 0 ? samples.get(0).size() : 0;
        int[] dp = new int[cols + 1];
        int maxSquareLength = 0, prev = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                int temp = dp[j];
                if (samples.get(i - 1).get(j - 1) == 1) {
                    dp[j] = Math.min(Math.min(dp[j - 1], prev), dp[j]) + 1;
                    maxSquareLength = Math.max(maxSquareLength, dp[j]);
                } else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }
        Map<Timestamp, List<String>> finalMap = new HashMap<>();
        // date - 28.

        return maxSquareLength * maxSquareLength;

    }
}
