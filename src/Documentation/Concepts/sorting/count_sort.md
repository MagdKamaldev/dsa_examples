# Count Sort Algorithm

## it's a non-comparison sorting algorithm, that's good for smaller numbers

### let's say you want to sort this array, with size => N:
![Example](../../../assets/count_sort_1.png)

### 1) Get the largest element in the array => 8
### 2) Create a frequency array with the largest element size + 1 => M, that contains every item's frequency
![Example](../../../assets/count_sort_2.png)
### 3) Replace the original array with the correct values form the frequency array
### Time and Space will both be O(N+M)
### Instead of saving the values in an array you also might use a hashMap to save the frequency Array
![Example](../../../assets/count_sort_3.png)