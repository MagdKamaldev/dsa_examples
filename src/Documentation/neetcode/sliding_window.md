# Sliding window: 
## uses two pointers to define a subarray (or substring) within the input structure. One pointer expands the window, and the other shrinks it to maintain constraints.

## A) Fixed length

### Q: given an array, return true if there are two elements within a window of size k that are equal

#### The Brute force approach O(N*K), would be to search with L pointer on every item and for every item we check form L+1 k times using R pointer, and if element at L and element at R are equal we return true
```java   
    // Check if array contains a pair of duplicate values,
    // where the two duplicates are no farther than k positions from 
    // eachother (i.e. arr[i] == arr[j] and abs(i - j) + 1 <= k).
    // O(n * k)
    public static boolean closeDuplicatesBruteForce(int[] nums, int k) {
        for (int L = 0; L < nums.length; L++) {
            for (int R = L + 1; R < Math.min(nums.length, L + k); R++) {
                if (nums[L] == nums[R]) {
                    return true;
                }
            }
        }
        return false;
    }
```
#### A better O(N) time and O(K) Approach would be to use a hashset and save every item we pass by in it and if R - L + 1 > k we remove the l item and return L and then if the window contains the item at R we return true
```java
    // Same problem using sliding window.
    // O(n)
    public static boolean closeDuplicates(int[] nums, int k) {
        HashSet<Integer> window = new HashSet<>(); // Cur window of size <= k
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (R - L + 1 > k) {
                window.remove(nums[L]);
                L++;
            }
            if (window.contains(nums[R])) {
                return true;
            }
            window.add(nums[R]);
        }
        return false;
    }
```

## A) Variable Length

### Q: find the length of the longest subarray, with the same value at each position

#### The solution here will be to use two pointers and start them bot from zero then make r increment every time and in the loop if nums[R] != nums[L] we make L equal to r to start searching for a new valid window and in every pass we make the answer variable the greatest of the answer value itself and R - L + 1
```java
public static int longestSubarray(int[] nums) {
        int length = 0;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (nums[L] != nums[R]) {
                L = R;
            }
            length = Math.max(length, R - L + 1);
        }
        return length;
    }
```

### Q2: find the minimum length subarray, where the sum is greater than or equal to target. Assuming that all values are positive.

#### Solution: close to the last one but using a total variable and increment and decrement values from it and we run a while loop that keeps incrementing l until total is less than target and in it we kep getiing min value for R-L+1 and the value already exists

```java
public static int shortestSubarray(int[] nums, int target) {
        int L = 0, total = 0;
        int length = Integer.MAX_VALUE;

        for (int R = 0; R < nums.length; R++) {
            total += nums[R];
            while (total >= target) {
                length = Math.min(R - L + 1, length);
                total -= nums[L];
                L++;
            }
        }

        if (length ==  Integer.MAX_VALUE) {
            return 0;
        } 
        return length;
    }
```