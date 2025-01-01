# Two Pointers

## 125. Valid Palindrome
### A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.
### Given a string s, return true if it is a palindrome, or false otherwise.
### Example 1:
### Input: s = "A man, a plan, a canal: Panama"
### Output: true
### Explanation: "amanaplanacanalpanama" is a palindrome.
### Example 2:
### Input: s = "race a car"
### Output: false
### Explanation: "raceacar" is not a palindrome.
### Example 3:
### Input: s = " "
### Output: true
### Explanation: s is an empty string "" after removing non-alphanumeric characters.
### Since an empty string reads the same forward and backward, it is a palindrome.
#### Solution:
#### An O(N) time and spcae solution would be to filter the string and then check if it's equal to it's reverse
#### a better solution ( O(N) time and O(1) space) would be to use two pointers one in the beginning and one in the end and making an outer while loop that runs while left is less than right
#### then run two while loops that increments left and decrement right if the character we are at is not a number or character
#### then if the character at left's lower case not equal to the right's lower case we return false
#### if we passed this we increment left and decrement right and then if the whole outer loop end s we return true
```java
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
```

## 167. Two Sum II - Input Array Is Sorted
### Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
### Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
### The tests are generated such that there is exactly one solution. You may not use the same element twice.
### Your solution must use only constant extra space.
### Example 1:
### Input: numbers = [2,7,11,15], target = 9
### Output: [1,2]
### Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
### Example 2:
### Input: numbers = [2,3,4], target = 6
### Output: [1,3]
### Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
### Example 3:
### Input: numbers = [-1,0], target = -1
### Output: [1,2]
### Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
#### Solution:
#### we create two pointers one for the left side and one for the right side
#### if element at left + element at right greater than target we decrement right
#### if they are less than target we increment left
#### if they were equal we return left+1 and right+1
```java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length-1;
        while(left<right){
            if(numbers[left] + numbers[right] > target){
                right--;
            }else if(numbers[left] + numbers[right] < target){
                left ++;
            }else {
                return new int[]{left+1,right+1};
            }
        }
        return new int[]{-1,-1};
    }
}
```

## 15. 3Sum
### Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
### Notice that the solution set must not contain duplicate triplets.
### Example 1:
### Input: nums = [-1,0,1,2,-1,-4]
### Output: [[-1,-1,2],[-1,0,1]]
### Explanation: 
### nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
### nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
### nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
### The distinct triplets are [-1,0,1] and [-1,-1,2].
### Notice that the order of the output and the order of the triplets does not matter.
### Example 2:
### Input: nums = [0,1,1]
### Output: []
### Explanation: The only possible triplet does not sum up to 0.
### Example 3:
### Input: nums = [0,0,0]
### Output: [[0,0,0]]
### Explanation: The only possible triplet sums up to 0.
#### Solution:
#### first we sort the array and create an answer array
#### we run a for loop from 0 till nums.length -2 to run for every i and have two sum problem on i+1 till the end
#### if i is greater than zero and nums of i equal to nums of i - 1 we comtimue to skip duplicates on i
#### after this we add an int start and set it to i+1 and end set to nums.length-1 and target set to -nums[i]
#### we run an inner while loop that runs while start is less than end and make an int sum that is nums[start] + nums[end]
#### if sum is equal to target we add a new array that has nums[i], nums[start], nums[end] and then run two while loops to skip duplicates from start and end then increment start and decrement end anyways
#### if sum is less than target we increment start and if it's less than target we decrement end
```java
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length -2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i+1;
            int end = nums.length-1;
            int target = -nums[i];
            while(start<end){
                int sum = nums[start] + nums[end];
                if(sum == target){
                    ans.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start < end && nums[start] == nums[start + 1]) start++;
                    while (start < end && nums[end] == nums[end - 1]) end--;
                    start++;
                    end--;
                }
                else if(sum < target){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return ans;
    }
}
```

## 11. Container With Most Water
### You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
### Find two lines that together with the x-axis form a container, such that the container contains the most water.
### Return the maximum amount of water a container can store.
### Notice that you may not slant the container.
### Example 1:
![Example](../../../assets/container_with_most_water.png)
### Input: height = [1,8,6,2,5,4,8,3,7]
### Output: 49
### Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
### Example 2:
### Input: height = [1,1]
### Output: 1
#### Solution:
#### We use two poiner method and move the smaller item of the two pointers for we are only interested in the smaller item, and if the are equal move any of them
```java
class Solution {
    public int maxArea(int[] height) {
        int greatest = 0; 
        int start = 0;
        int end = height.length-1;
        while(start<end){
            int area = Math.min(height[start], height[end]) * (end-start);
            greatest = Math.max(greatest,area);
            if(height[start] < height[end]){
                start ++;
            }else {
                end --;
            }
        }
        return greatest;    
    }
}
```

## 42. Trapping Rain Water
### Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
### Example 1:
![Example](../../../assets/trapping_rain_water.png)
### Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
### Output: 6
### Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are ### Example 2:
### Input: height = [4,2,0,3,2,5]
### Output: 9
#### Solution:
#### the answer for how much water can be saved at each item will be Math.min(maxLeft,maxRight) - the item value
#### an O(N) time and space solution would be to save left max and right max for every item in an array nd then calculate the answer for every item
```java
class Solution {
    public int trap(int[] height) {
       int n = height.length;
       if(n<3){
        return 0;
       } 

       int res = 0;

       int[] leftMax = new int[n];
       int[] rightMax = new int[n];

       leftMax[0] = height[0];
       for(int i = 1; i < n;i++){
        leftMax[i] = Math.max(leftMax[i - 1], height[i]);
       }

       rightMax[n-1] = height[n-1];
       for(int i = n-2;i>=0;i--){
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
       }

       for(int i = 0; i < n ; i++){
        res += Math.min(leftMax[i], rightMax[i]) - height[i];
       }
       return res;
    }
}
```
#### An O(N) time and O(1) space solution can be done using two pointers:
#### we use two pointers and every time we move the smaller so we know that the one we moved is the min one that should be used
```java
class Solution {
    public int trap(int[] height) {
       if (height == null || height.length < 3) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while(l<r){
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            }else{
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
```