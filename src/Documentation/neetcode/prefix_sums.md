# Prefix sums

### what is a prefix ? it's a subpart of the item (the whole item can be a prefix of it's self) that has to stat from the beginnning.
### There's also something called the postfix which is the opposite of prefix

### Q: given an array of values, design a data structure that can query the sum of a subarray of the values.
#### in the init function we will save the prefix sum for evey value in an array.
#### and in the function that calculates the range sum it can be done in constant time by getting the item at right index in preRight and left -1 index if left is greater than zero in preLeft, then return the preRight = preLeft
```java
public class PrefixSum {
    
    List<Integer> prefix;

    public PrefixSum(int[] nums) {
        prefix = new ArrayList<>();
        int total = 0;
        for (int n : nums) {
            total += n;
            prefix.add(total);
        }
    }

    public int rangeSum(int left, int right) {
        int preRight = prefix.get(right);
        int preLeft = left > 0 ? prefix.get(left - 1) : 0;
        return (preRight - preLeft);      
    }
}
```