# Sliding window

## A) Fixed

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

## A) Variable

