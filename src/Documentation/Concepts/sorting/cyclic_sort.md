# Cyclic Sort Algorithm

**Cyclic Sort** is an efficient sorting algorithm for arrays where elements are in a specific range (typically from 1 to `n`). It places each element in its correct position using the cycle principle.

### Key Characteristics of Cyclic Sort:
- **Time Complexity**: O(n), where `n` is the size of the array.
  - Each element is visited at most once.
- **Space Complexity**: O(1) because it is an in-place sorting algorithm.
- **Stable**: No, Cyclic Sort is not a stable sorting algorithm.
- **Applicable**: Works best for arrays with elements in a range from 1 to `n`.

### How Cyclic Sort Works:
1. Start with the first element of the array.
2. Find the correct position for the current element by comparing its value with its index.
3. If the element is not in the correct position, swap it with the element at the correct index.
4. Repeat this process for the remaining elements.
5. The algorithm continues until every element is in its correct position.

### Cyclic Sort Code Example

```java
 static void sort(int [] arr){
      int i = 0;
      while(i<arr.length) {
          int correct = arr[i]-1;
          if(arr[i]!=arr[correct]){
           swap(arr,i,correct);
       }else{
           i++;
       }
      }
    }
    
    static  void swap(int [] arr,int first ,int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr [second] = temp;
    }
```