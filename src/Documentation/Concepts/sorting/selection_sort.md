# Selection Sort Algorithm (Selecting the Greatest Element)

**Selection Sort** is a simple comparison-based sorting algorithm. The idea behind selection sort is to repeatedly select the largest element from the unsorted part of the list and move it to the sorted part. It works by iterating over the list, finding the maximum element, and swapping it with the last unsorted element.

### Key Characteristics of Selection Sort:
- **Time Complexity**:
  - Worst, Average, and Best case: O(n^2), where `n` is the number of elements.
- **Space Complexity**: O(1) because it’s an in-place sorting algorithm.
- **Stable**: No, selection sort is **not stable** because equal elements might be swapped.

### Note: it can also be done using the smallest element.

### How Selection Sort Works:
1. Find the largest element in the unsorted part of the list.
2. Swap it with the last element of the unsorted part.
3. Repeat the process for the remaining unsorted part of the list.
4. Stop when the entire list is sorted.

---

### Selection Sort Algorithm (Code Example)

```java
    static void selection(int [] arr){
        for (int i = 0; i < arr.length; i++) {
            int last = arr.length-i-1;
            int maxIndex = getMaxIndex(arr,0,last);
            swap(arr,maxIndex,last);
        }
    }

    static void swap(int [] arr,int first ,int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    static int getMaxIndex(int[] arr,int start, int end){
        int max = start;
        for (int i = start; i <= end; i++) {
            if(arr[max]<arr[i]){
                max = i;
            }
        }
        return max;
    }
```


### Selection Sort Algorithm (Code Example with recursion)

```java
static void selectionRecursive(int[] arr , int r, int c, int max){
        if(r ==0){
            return;
        }
        if(c<r){
            if(arr[c]>arr[max]){
                selectionRecursive(arr, r, c+1, c);
            }else{
                selectionRecursive(arr, r, c+1, max);
            }
        }else{
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selectionRecursive(arr, r -1,0,0);
        }
    }
```