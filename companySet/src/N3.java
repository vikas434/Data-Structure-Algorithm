import java.util.ArrayList;
import java.util.List;

public class N3 {

    public int[] solution(int[] A, int F, int M) {
       int sumA = 0;
       int lengthA = A.length;
       for(int i : A) {
           sumA = i+sumA; //12
       }
        List<Integer> remainingList = new ArrayList<>();
       int totalSum = (lengthA +F) * M; //21
       int remaningSum = totalSum - sumA; //9
       int maxPerNo = remaningSum/F;
       if(maxPerNo > 6) {
           return new int[]{0};
       } else if (maxPerNo == 6) {
           return  new int[]{6,6};
       } else {
           // compute remainingSum from, using F no between 1, 6
//            int currentSum = 0;
//            while (currentSum < remaningSum) {
//
//            }

       }

       return remainingList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {

        //System.out.println(solution(A));
    }
}
