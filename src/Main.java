import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(new Solution().maxSubArray(nums));
        int[] one = {1,2};
        int[] two = {1,2};
        int[] three = {3,3};
//        boolean ans = one.equals(two); // false
//        boolean ans2 = one == two; // false
        boolean ans3 = Arrays.equals(one,two);
        boolean ans4 = Arrays.equals(one,three);
//        System.out.println(ans);
//        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);

        int[] complete = {1,2,3,4,5};
        int[] subarray = Arrays.copyOfRange(complete,1,3);
//        System.out.println(Arrays.toString(subarray)); // here is a subarray storage mechanism.
//        HashMap<List<Integer>,Integer> memo = new HashMap<>();
//        memo.put(subarray,4); // doesn't work, must be an arraylist not an array
        // take 2
        HashMap<String,Integer> memo = new HashMap<>();
        memo.put(Arrays.toString(subarray),4);
        // will loop subarray to get sum if subarray as string not found as Map key
        // still  have to loop through tons of times....

// memo attempt. store array and compare to current array via Arrays.equals().
// must be able to create subarrays
    }

}


// the way freaking better version like container of water problem, eliminating the content prior to the most
// restrictive element. also somewhat similar to longest substrng without repeating characters where L pointer moved up.

class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }

            if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }
}











// chance of redundancy such as array {2,1,-10,2,1} where 2,1 occurs twice, separately. May want to store, but not sure
// how since other memoization problems involved storing of a single number such as a coin value or a substring.
// substring is similar though that is passed multiple chars. can't store via array though and not sure i can have a
// subarray as a key in a map

// long version. nersted loops. lets start there.

// non-optimized nested for loop
class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSum = 0;
            for (int j = i; j < nums.length; j++) {
                currentSum += nums[j];
                if (currentSum >= maxSum) {
                    maxSum = currentSum;
                }
            }

        }
        return maxSum;
    }
}

