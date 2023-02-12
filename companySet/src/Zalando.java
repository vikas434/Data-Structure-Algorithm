public class Zalando {
    public static void solution(int N) {
        var isNegative = N < 0 ? true : false;
        int enable_print = N % 10;
        //System.out.println(enable_print);
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                System.out.println("Here");
                return;
            }
            else  {
                System.out.print(N % 10);
            }
            N = N / 10;
            enable_print = N%10;
            //System.out.println(enable_print);
        }
    }

    public static void main(String[] args) {
       solution(54321);
        System.out.println();
        solution(10011);
        System.out.println();
        solution(1);
    }
}
