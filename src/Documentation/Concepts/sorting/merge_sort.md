# Merge Sort Algorithm

**Merge Sort** is a **divide and conquer** algorithm that divides the array into two halves, recursively sorts each half, and then merges the sorted halves. Merge Sort is known for its predictable time complexity, making it efficient for large datasets.

### Key Characteristics of Merge Sort:
- **Time Complexity**: O(n log n), where `n` is the number of elements.
  - This is because the array is split in half recursively (log n), and each half is merged in linear time (O(n)).
- **Space Complexity**: O(n), as it requires additional space for temporary arrays used during the merging process.
- **Stable**: Yes, Merge Sort is stable, meaning that equal elements maintain their relative order.
- **Applicable**: Merge Sort works well for large datasets and is also used for external sorting where data is too large to fit into memory.

### How Merge Sort Works:
1. **Divide**: The array is divided into two halves.
2. **Conquer**: Each half is recursively sorted.
3. **Combine**: The two sorted halves are merged into one sorted array.

---

### Merge Sort Code Example

```java
    static int[] mergeSort(int[] arr){
        if(arr.length ==1){
            return arr;
        }
        int mid = arr.length/2;
        int[] left = mergeSort(Arrays.copyOfRange(arr,0,mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr,mid,arr.length));

        return merge(left,right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] answer = new int[first.length+second.length];
        int i = 0;  // for second
        int j = 0;  // For first
        int k = 0;  // For the answer arrayx

        while(i<first.length && j< second.length){
            // Makes the comparing logic and ends when one of first and second is finsihed
            if(first[i]<second[j]){
                answer[k]= first[i];
                i++;
            }else{
                answer[k]= second[j];
                j++;
            }
            k++;
        }
        // To complete if there are remaining items in first
        while(i<first.length){
            answer[k]= first[i];
            i++;
            k++;
        }
        // To complete if there are remaining items in second
        while(j<second.length){
            answer[k]= second[j];
            j++;
            k++;
        }
        return  answer;
    }
```

### Merge Sort In Place Code Example

```java
    static void mergeSortInPlace(int[] arr,int start, int end){
        if(end-start == 1){
            return;
        }

        int mid = start + (end-start)/2;
        
        mergeSortInPlace(arr,start,mid);
        mergeSortInPlace(arr,mid,end);

        mergeInPlace(arr,start,mid,end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] answer = new int[end - start];  // Temporary array for merged result
        int i = start;  // Pointer for the first half
        int j = mid;    // Pointer for the second half
        int k = 0;      // Pointer for the answer array

        // Step 3: Compare and merge
        while (i < mid && j < end) {
            if (arr[i] < arr[j]) {
                answer[k] = arr[i];  // If the element in the first half is smaller
                i++;  // Move the pointer in the first half
            } else {
                answer[k] = arr[j];  // If the element in the second half is smaller
                j++;  // Move the pointer in the second half
            }
            k++;  // Move the pointer in the answer array
        }

        // Step 4: Copy remaining elements from the first half, if any
        while (i < mid) {
            answer[k] = arr[i];
            i++;
            k++;
        }

        // Step 4: Copy remaining elements from the second half, if any
        while (j < end) {
            answer[k] = arr[j];
            j++;
            k++;
        }

        // Step 5: Copy the merged result back into the original array
        System.arraycopy(answer, 0, arr, start, answer.length);
    }
```