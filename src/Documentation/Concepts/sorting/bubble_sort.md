# Bubble Sort Algorithm 

**Bubble Sort** is a simple comparison-based sorting algorithm. The basic idea is to repeatedly step through the list, compare adjacent elements, and swap them if they are in the wrong order. This process is repeated until the list is sorted.

### Key Characteristics of Bubble Sort:
- **Time Complexity**: 
  - Worst and Average case: O(n^2), where `n` is the number of elements.
  - Best case: O(n) when the list is already sorted (optimized version).
- **Space Complexity**: O(1) because it’s an in-place sorting algorithm.
- **Stable**: Does not change the relative order of equal elements.

### How Bubble Sort Works:
1. Start from the beginning of the array.
2. Compare adjacent elements and swap them if the left element is greater than the right.
3. After each pass, the largest unsorted element "bubbles up" to its correct position at the end of the list.
4. Repeat the process for the remaining unsorted part of the list.
5. Stop when no more swaps are needed, meaning the array is sorted.

---

### Bubble Sort Algorithm (Code Example)

```java
    static void bubble (int [] arr){
        boolean swapped;
        for (int i = 0; i < arr.length; i++) {
            swapped=false;
            for (int j = 1; j < arr.length-i; j++) {
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                    swapped= true;
                }
            }
            if(!swapped){
                break;
            }
        }
    }

     static void swap(int [] arr,int first ,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
```

### Bubble Sort Algorithm (Code Example with recursion)

```java
static void bubble(int[] arr, int r, int c){
    if(r == 0){
        return;
    }
    if(c>r){
        if(arr[c]> arr[c+1]){
            //swap
            int temp = arr[c];
            arr[c] = arr[c+1];
            arr[c+1] = temp;
            bubble(arr,r,)
        }
        bubble(arr,r,c+1);
    }else{
        bubble(arr,r-1,0);
    }
}

// will be called like this from main
bubble(arr,arr.length-1,0);
```