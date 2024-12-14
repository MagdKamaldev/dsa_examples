# Quick Sort Algorithm

**Quick Sort** is a **divide and conquer** algorithm that efficiently sorts an array by partitioning it around a pivot element. The array is divided into subarrays such that elements less than the pivot are on the left and those greater than the pivot are on the right. These subarrays are then recursively sorted.

---

## Key Characteristics of Quick Sort:
- **Time Complexity**:
  - Best/Average Case: O(n log n), where `n` is the number of elements.
  - Worst Case: O(n²), when the pivot consistently partitions poorly (e.g., smallest or largest element).
- **Space Complexity**: O(log n) for the recursive stack in the best case; O(n) in the worst case.
- **Unstable**: Quick Sort is not stable, meaning equal elements may not retain their original relative order.
- **Efficient for In-Place Sorting**: No additional arrays are required, as sorting is performed directly within the original array.

---

## How Quick Sort Works:
1. **Select Pivot**: A pivot element is selected (in this implementation, the middle element).
2. **Partition**: 
   - Reorder elements so that those less than the pivot are on the left, and those greater are on the right.
   - This is done by swapping elements as necessary.
3. **Recursively Sort**: 
   - Sort the left and right subarrays recursively.
4. **Combine**: The array is fully sorted once all recursive calls are completed.

---

## Quick Sort Code Example

```java
package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{45, 34, 26, 57, 89, 1, 3, 21, 14, 6, 8, 9};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    static void sort(int[] nums, int low, int high) {
        if (low >= high) {
            return; // Base case: if the segment has 0 or 1 element, it's sorted
        }

        int s = low; // Start pointer
        int e = high; // End pointer
        int mid = s + (e - s) / 2; // Calculate the pivot index
        int pivot = nums[mid]; // Pivot element

        // Partitioning process
        while (s <= e) {
            while (nums[s] < pivot) { // Move 's' forward until an element >= pivot is found
                s++;
            }
            while (nums[e] > pivot) { // Move 'e' backward until an element <= pivot is found
                e--;
            }
            if (s <= e) { // Swap elements if 's' and 'e' haven't crossed
                int temp = nums[s];
                nums[s] = nums[e];
                nums[e] = temp;
                s++;
                e--;
            }
        }

        // Recursively sort the two partitions
        sort(nums, low, e); // Sort the left partition
        sort(nums, s, high); // Sort the right partition
    }
}