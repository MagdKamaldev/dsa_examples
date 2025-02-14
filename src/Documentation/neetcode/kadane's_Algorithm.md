# Kadane's Algorithm

Kadane's Algorithm is an efficient method to solve the **maximum subarray sum problem**.
It finds the largest sum of a contiguous subarray within a one-dimensional array of numbers, including both positive and negative values.

---

## Algorithm Concept

1. **Iterate through the array** while maintaining:
   - A variable `current_sum` to store the sum of the current subarray.
   - A variable `max_sum` to store the maximum subarray sum encountered so far.

2. **Update the variables** at each step:
   - Add the current element to `current_sum`.
   - If `current_sum` becomes less than the current element, reset `current_sum` to the current element (start a new subarray).
   - Update `max_sum` if `current_sum` is greater than `max_sum`.

3. The **final value of `max_sum`** is the largest sum of any contiguous subarray.

---

## Algorithm Steps

1. Initialize `current_sum` to `0` and `max_sum` to a very small value (e.g., `-∞` or the smallest integer in the array).
2. Loop through each element in the array:
   - Update `current_sum = max(current_sum + arr[i], arr[i])`.
   - Update `max_sum = max(max_sum, current_sum)`.
3. Return `max_sum`.

---

## Code

```java
    // Function to find the maximum subarray sum
    public static int maxSubArraySum(int[] arr) {
        // Initialize variables
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        // Loop through the array
        for (int num : arr) {
            // Update currentSum to the maximum of currentSum + num or num
            currentSum = Math.max(currentSum + num, num);
            // Update maxSum if currentSum is greater
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
```