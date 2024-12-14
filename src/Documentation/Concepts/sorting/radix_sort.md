# Radix Sort Algorithm Using Count Sort Logic

**Radix Sort** is a non-comparison-based sorting algorithm ideal for sorting numbers by processing individual digits. It uses **Count Sort** as a subroutine to sort numbers based on each digit place, starting from the least significant digit (LSD) to the most significant digit (MSD).

---

## Example: Sorting an Array

Let's consider the following array:  
`{29, 83, 471, 36, 91, 8}`

---

## Steps to Perform Radix Sort:

### 1. Find the Largest Number
Identify the largest number in the array to determine the number of passes required.  
**In this example**: The largest number is `471`, so we need 3 passes (ones, tens, and hundreds).

---

### 2. Sort Digit by Digit
For each digit place:
1. Use **Count Sort** to sort the elements based on the current digit.
2. Process digits starting from the least significant (ones) to the most significant (hundreds).

---

### 3. Replace the Original Array
After each pass, update the original array with the sorted output from Count Sort.

---

### Time and Space Complexity

#### Time Complexity
The time complexity of Radix Sort is determined by the number of digits in the largest number and the cost of sorting each digit:
- **Sorting Each Digit**: \(O(N + K)\), where:
  - \(N\): Number of elements in the array.
  - \(K\): Range of digits (0-9 for base-10 numbers).
- **Total Passes**: \(D\), the number of digits in the largest number.

Thus, the overall time complexity is:  
**\(O((N + K) * D)\)** 

#### Space Complexity
- **Count Map**: Requires \(O(K)\) space to store the frequency of digits (0-9).
- **Output Array**: Requires \(O(N)\) space to temporarily store the sorted elements.

Therefore, the total space complexity is:  
**\(O(N + K)\)**

---

## Code Implementation

```java
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class RadixSort {
    public static void main(String[] args) {
        int[] arr = {29, 83, 471, 36, 91, 8};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr) {
        // Step 1: Find the largest number in the array
        int max = Arrays.stream(arr).max().getAsInt();

        // Step 2: Sort the array digit by digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;

        // Step 1: Create a frequency map for the current digit
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            int digit = (num / exp) % 10;
            countMap.put(digit, countMap.getOrDefault(digit, 0) + 1);
        }

        // Step 2: Convert the count map to cumulative frequencies
        for (int i = 1; i < 10; i++) {
            countMap.put(i, countMap.getOrDefault(i - 1, 0) + countMap.getOrDefault(i, 0));
        }

        // Step 3: Create an output array to hold sorted elements
        int[] output = new int[n];

        // Step 4: Traverse the array in reverse to maintain stability
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[countMap.get(digit) - 1] = arr[i];
            countMap.put(digit, countMap.get(digit) - 1);
        }

        // Step 5: Copy the sorted output back to the original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}
```