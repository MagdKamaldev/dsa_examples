# Count Sort Algorithm

**Count Sort** is a non-comparison-based sorting algorithm ideal for sorting smaller numbers efficiently. It uses an auxiliary frequency array (or a HashMap) to count the occurrences of each element and then reconstructs the sorted array.

---

### Example: Sorting an Array

Let's consider the following array with size `N`:

![Example](../../../assets/count_sort_1.png)

---

### Steps to Perform Count Sort:

#### 1. Get the Largest Element
Find the largest element in the array, as this determines the size of the frequency array.  
**In this example**: The largest element is `8`.

---

#### 2. Create a Frequency Array
Create a frequency array of size `max + 1` (where `max` is the largest element) and populate it with the frequency of each number in the input array.  
**In this example**: The frequency array looks like this:

![Example](../../../assets/count_sort_2.png)

---

#### 3. Replace the Original Array
Reconstruct the sorted array by iterating through the frequency array and placing the numbers in their correct order.  
**In this example**: After replacing the original array, the result is:

![Example](../../../assets/count_sort_3.png)

---

### Time and Space Complexity:
- **Time Complexity**: O(N + M), where `N` is the size of the input array and `M` is the largest number in the array.
- **Space Complexity**: O(M) for the frequency array.

---

### Code Implementation:

Here’s the implementation of Count Sort:

```java
public static void countSort(int[] array) {
    if (array == null || array.length <= 1) {
        return; // If the array is null or has one element, it is already sorted
    }

    // Step 1: Find the largest element in the array
    int max = array[0];
    for (int num : array) {
        if (num > max) {
            max = num;
        }
    }

    // Step 2: Create and populate the frequency array
    int[] frequencyArray = new int[max + 1];
    for (int num : array) {
        frequencyArray[num]++;
    }

    // Step 3: Reconstruct the sorted array using the frequency array
    int index = 0;
    for (int i = 0; i < frequencyArray.length; i++) {
        while (frequencyArray[i] > 0) {
            array[index] = i; // Place the number in the sorted position
            index++;
            frequencyArray[i]--; // Decrease its frequency
        }
    }
}
```

### Code Implementation using HashMap:

```java
public static void countSortHash(int[] array){
        if(array == null || array.length <= 1){
            return;
        }
        int max = array[0];
        int min = array[0];
        for(int num : array){
            if(num>max){
                max = num;
            }
        }

         for(int num : array){
            if(num<min){
                min = num;
            }
        }

        Map<Integer,Integer> countMap = new HashMap<>();

        for(int num: array){
            countMap.put(num, countMap.getOrDefault(num, 0)+1);
        }

        int index = 0;
        for(int i = min; i < max; i++){
           int count = countMap.getOrDefault(i,0);
           for (int j = 0; j < count; j++) {
               array[index] = i;
               index++;
           }
        }
       
    }
```

