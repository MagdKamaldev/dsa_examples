# Insertion Sort Algorithm

**Insertion Sort** is a simple comparison-based sorting algorithm that builds the final sorted array one element at a time. It works by taking one element from the unsorted part of the array, and inserting it into the correct position in the sorted part.

### Key Characteristics of Insertion Sort:
- **Time Complexity**:
  - Worst, Average case: O(n^2), where `n` is the number of elements.
  - Best case: O(n), when the array is already sorted.
- **Space Complexity**: O(1) because it’s an in-place sorting algorithm.
- **Stable**: Yes, insertion sort is stable because equal elements retain their relative order.

### How Insertion Sort Works:
1. Start from the second element of the array (since the first element is already "sorted").
2. Compare the current element with the elements before it.
3. Shift all larger elements one position to the right.
4. Insert the current element into its correct position.
5. Repeat the process for the rest of the elements.

---

### Insertion Sort Algorithm (Code Example)

```java
static void insertion(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j>0 ; j--) {
                    if(arr[j]<arr[j-1]){
                        swap(arr,j,j-1);
                    }else{
                        break;
                    }
                }
        }
    }
    static void swap(int [] arr,int first ,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
static void insertion(int [] arr){
        for (int i = 0; i < arr.length-1; i++) {
                for (int j = i+1; j>0 ; j--) {
                    if(arr[j]<arr[j-1]){
                        swap(arr,j,j-1);
                    }else{
                        break;
                    }
                }
        }
    }
    static void swap(int [] arr,int first ,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
```