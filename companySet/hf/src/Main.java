import java.util.HashMap;
import java.util.Map;

public class Main {
    /**
     * Aleks is a strawberry merchant, selling strawberries at a price of 5 EUR for 1 kilogram.
     * Each customer can only buy 1 KG of strawberries, but can pay with 5 EUR, 10 EUR or 20 EUR bills.
     * When a customer is paying with a bill of more than 5 EUR, Aleks needs to return correct change.
     * Given an array of customers represented with the bills with which they are paying,
     * your function should return true if Aleks can serve each customer in the queue
     * (either the customer is paying the exact price or Aleks will need to return the correct change), or false otherwise.
     * <p>
     * <p>
     * Example 1: input array is: [5, 10, 5, 20]; should return true because:
     * - First customer pays with 5 EUR bill, gets no change
     * - Second customer pays with 10 EUR bill, gets 5 EUR change
     * - Third customer pays with 5 EUR bill, gets no change
     * - Fourth customer pays with 20 EUR bill, gets 15 EUR change (10 EUR + 5 EUR bills)
     * Example 2: input array is: [5, 20, 5, 20]; should return false because:
     * - First customer pays with 5 EUR bill, gets no change
     * - Second customer pays with 20 EUR bill, should get 15 EUR change,
     * but Aleks only has one 5 EUR bill. At this point Aleks cannot return the change and our function should return false.
     * <p>
     * [5, 10, 5, 20];
     * [5,10,....50,]
     *
     * // given 45 -> 5, 10, 20
     * <p>
     * 5, 10, 10+5, 20
     * <p>
     * [5, 20, 5, 20]
     * <p>
     * 5,
     */
    public static boolean canServeCustomer(int[] customerBill) {
        Map<Integer, Integer> billMap = new HashMap<>();
        for (int bill : customerBill) {
            billMap.put(bill, billMap.getOrDefault(bill, 0) + 1);
            int remainingAmount = bill - 5;
            if (remainingAmount == 5) {
                int countBill5 = billMap.getOrDefault(5, 0);
                if (countBill5 == 0) {
                    return false;
                } else {
                    billMap.put(5, billMap.get(5) - 1);
                    continue;
                }
            } else if (remainingAmount == 15) {
                // check for 10 and 5 bill
                if (billMap.containsKey(10) && billMap.get(10) > 0 && billMap.containsKey(5) && billMap.get(5) > 0) {
                    // reduce the count.
                    billMap.put(10, billMap.get(10) - 1);
                    billMap.put(5, billMap.get(5) - 1);
                    continue;
                } else if (billMap.containsKey(5) && billMap.get(5) >= 3) {
                    // reduce the count.
                    billMap.put(5, billMap.get(5) - 1);
                    continue;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("Testing customer bills");
        System.out.println("The customer can be served : expected - true received: " + canServeCustomer(new int[]{5, 10, 5, 20}));
        System.out.println("The customer can be served : expected - false received: " + canServeCustomer(new int[]{5, 20, 5, 20}));
        System.out.println("The customer can be served : expected - false received: " + canServeCustomer(new int[]{5, 10, 10}));
        System.out.println("The customer can be served : expected - false received: " + canServeCustomer(new int[]{10, 10, 10}));
        System.out.println("The customer can be served : expected - false received: " + canServeCustomer(new int[]{50}));
    }
}