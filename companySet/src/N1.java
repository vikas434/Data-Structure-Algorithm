import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N1 {

    static boolean foundAnswerFirsttime;
    static List<Integer> finalList;


    public static int[] solution(int[] A, int F, int M) {
        foundAnswerFirsttime = false;
        finalList = new ArrayList<>();

        Map<String, Boolean> map = new HashMap<>();
        int sumA = 0;
        for (int i : A) {
            sumA += i;
        }

        int total = A.length + F;
        int diff = (M * total) - sumA;

        List<Integer> list = new ArrayList<>();

        findSum(F, diff, 0, list, map);
        if (finalList.size() == 0) {
            return new int[]{0};
        }

        int[] result = new int[finalList.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = finalList.get(i);
        }

        return result;
    }

    public static void findSum(int count, int sum, int curSum, List<Integer> list, Map<String, Boolean> map) {
        if (foundAnswerFirsttime) return;
        if (sum == curSum && count == 0) {
            finalList = new ArrayList<>(list);
            foundAnswerFirsttime = true;
            return;
        }
        int remainingSum = sum - count;
        if (map.getOrDefault(count + "," + remainingSum, false) == true)
            return;

        if (curSum > sum || count < 0) return;

        for (int i = 6; i >= 1; i--) {
            list.add(i);
            findSum(count - 1, sum, curSum + i, list, map);
            list.remove(list.size() - 1);
        }

        map.put(count + "," + remainingSum, foundAnswerFirsttime);
    }



    public static void main(String[] args) {

        //System.out.println(solution(A));
    }
}
