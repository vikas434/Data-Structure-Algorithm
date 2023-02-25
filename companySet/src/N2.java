public class N2 {

    public static int solution(int[] A) {
        // Implement your solution here
        int length = A.length;
        if(length == 1) {
            return 1;
        }

        int valleyCount = 0;
        boolean up = false;
        boolean down = false;
        if(A[0] > A[1] ) {
            down = true;
            valleyCount++;
        } else if (A[0] < A[1]) {
            up = true;
            valleyCount++;
        }
        // TODO when first and next is same

        for(int i = 1; i< length-1; i++) {
            if(!up && !down) {
                if(A[i] > A[i+1] ) {
                    down = true;
                    valleyCount++;
                } else if (A[i] < A[i+1]) {
                    up = true;
                    valleyCount++;
                } else if(A[i] == A[i+1]) {
                    continue;
                }
            }
            if(up && A[i+1] < A[i]) {
                down = true;
                valleyCount++;
                continue;
            }

            if(down && A[i+1] > A[i]) {
                up = true;
                valleyCount++;
                continue;
            }

            // TODO check for equal case
        }

        return valleyCount+1; // last castle

    }

    public static void main(String[] args) {
        int[] A = {2, 2, 3, 4, 3, 3, 2, 2, 1, 1, 2, 5};
        System.out.println(solution(A));
    }
}
