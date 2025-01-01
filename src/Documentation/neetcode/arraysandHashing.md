# Arrays and hashing

## 217. Contains Duplicate
### Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
### Example 1:
### Input: nums = [1,2,3,1]
### Output: true
### Explanation:
### The element 1 occurs at the indices 0 and 3.
### Example 2:
### Input: nums = [1,2,3,4]
### Output: false
### Explanation:
### All elements are distinct.
### Example 3:
### Input: nums = [1,1,1,3,3,4,3,2,4,2]
### Output: true
#### Solution: 
#### Use a hashset to store all the values we pass by called numSet
#### run the for loop on nums with a condition to return true if the set conatians nums[i] and save the current nums[i] to the set anyway
#### in the end return false by default
```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> numsSet = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length ;i++){
            if(numsSet.contains(nums[i])){
                return true;
            }
            numsSet.add(nums[i]);
        }
        return false;
    }
}
```

## 242. Valid Anagram
### Given two strings s and t, return true if t is an anagram of s, and false otherwise.
### Example 1:
### Input: s = "anagram", t = "nagaram"
### Output: true
### Example 2:
### Input: s = "rat", t = "car"
### Output: false
#### Solution:
#### if the two strings length are not equal return false
#### make a new int array conut to be a frequency array for characters
#### run a for loop for every character in s or t (since both have the same size) and at every index increment for the item at s and decrement for the item at t
#### if they are anagram all the frequencies will end as zero so make a check if any item is not zero return false
#### in the end return true
```java
class Solution {
    public boolean isAnagram(String s, String t) {
      if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }
}
```

## 1. Two Sum
### Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
### You may assume that each input would have exactly one solution, and you may not use the same element twice.
### You can return the answer in any order.
### Example 1:
### Input: nums = [2,7,11,15], target = 9
### Output: [0,1]
### Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
### Example 2:
### Input: nums = [3,2,4], target = 6
### Output: [1,2]
### Example 3:
### Input: nums = [3,3], target = 6
### Output: [0,1]
#### Solution:
#### we create a hashmap to save values as key and index as value
#### then we run a for loop on nums and on every pass we create a complement integer which is target - nums[i]
#### if the hashmap conatians this complement we return a new int array with map.get(complement) and i which is the current index
#### then we save nums[i] as key and i as value for every pass anyway
#### in the end return {-1,-1} for if an edge case happens
```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length ; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] {map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}
```

## 49. Group Anagrams
### Given an array of strings strs, group the anagrams together. You can return the answer in any order.
### Example 1:
### Input: strs = ["eat","tea","tan","ate","nat","bat"]
### Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
### Explanation:
### There is no string in strs that can be rearranged to form "bat".
### The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
### The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
### Example 2:
### Input: strs = [""]
### Output: [[""]]
### Example 3:
### Input: strs = ["a"]
### Output: [["a"]]
#### Solution:
#### we create an arraylist of arraylist answer and a hashmap of with key as string and value as list of string 
#### we run a for loop for the main strs list that has:
#### a frequency int array of size 26 
#### then we fill this frequency array with an inner for loop
#### we make a String key which is the frquencty array we have.toString() which makes it saved as a String
#### if the hashMap doesn't contain the string we generated we put the key String as key and the value is a new arraylist
#### in the end of the outer loop we add the str to map.get(key) anyways
#### after the lopp is executed we add all the values from the hashmap to the arraylist and return it
```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] freq = new int[26];
            for (char c : str.toCharArray()) {
                freq[c - 'a']++;
            }
            String key = Arrays.toString(freq);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        answer.addAll(map.values());
        return answer;
    }
}
```

## 347. Top K Frequent Elements
### Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
### Example 1:
### Input: nums = [1,1,1,2,2,3], k = 2
### Output: [1,2]
### Example 2
### Input: nums = [1], k = 1
### Output: [1]
#### optimal O(N) time and space Solution:
#### we create a hshmap of Integer as key and value, and a list of integer frequency array of size nums.length+1
#### we run a for loop to fill every item in the frequency array with a new arraylist
#### we run another for loop nums to put in count hashmap current number as key and this: count.getOrDefault(n, 0) + 1 as value to incement the value as frequency every time
#### we run another for loop for all items in the hashmap to add to the frequency array in the values of hashmaps which are the frequencies as index and in this index we add the hashmap keys which are the values
#### then we create a result array with k size and int index that starts with zero
#### we run a for loop from freq.length-1 till 0 that runs if index is smaller than k in the backwards direction
#### inside it anothe for loop that runs for items in freq[i] 
#### insied the inner loop we add n to res array at the index made outside and then increment it 
#### then if index becomes equal to k we return res immidietly in order to not complete in the inner loop
#### after both loops end if they complete we return res in the end anyways
```java
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] res = new int[k];
        int index = 0;
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            for (int n : freq[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }    
        return res;
    }
}
```

## 271. Encode and Decode Strings
### Design an algorithm to encode a list of strings to a single string. The encoded string is then decoded back to the original list of strings.
### Please implement encode and decode
### Example 1:
### Input: ["neet","code","love","you"]
### Output:["neet","code","love","you"]
### Example 2:
### Input: ["we","say",":","yes"]
### Output: ["we","say",":","yes"]
#### Solution:
#### encode function:
#### we create a string builder and for every string in the list we add by this order: length of the string, #, the String
#### then return the builder.toString()
#### decode function:
#### we create the res list and int i as a counter and set it to zero
#### while (i < str.lenght) we run this loop
#### we create a new counter j and set it to i
#### we run another wile loop that increment j untill we reach the # to get the full number
#### then we create an int list which is the number we got which is str.substring(from i to j)
#### then we set i to j+1 (the start of the word) and j to i + length (the end of the word)
#### and add the substring from i to j to the res list and then set i to j for the next round
#### in the end we return res in the end
```java
class Solution {

    public String encode(List<String> strs) {
       StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s.length()).append('#').append(s);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i =0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + length;
            res.add(str.substring(i, j));
            i = j;
        }
        return res;
    }
}
```

## 238. Product of Array Except Self
### Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
### The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
### You must write an algorithm that runs in O(n) time and without using the division operation.
### Example 1:
### Input: nums = [1,2,3,4]
### Output: [24,12,8,6]
### Example 2:
### Input: nums = [-1,1,0,-3,3]
### Output: [0,0,9,0,0]
#### Solution:
#### At first we save the nums.length in an integer n and create an answer array with n size to display and return the answer in it
#### then we in the answer array we set the first item to zero and then run a for loop that makes every item the multiplication of all prefix items using this: res[i]= res[i-1] * nums[i-1];
#### then we add an int post and set it to one and runa for loop in reverse from n-1 till 0 to add suffix multiplications using this: res[i] *= post; post *= nums[i] and return the answer array
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0]=1;
        for(int i = 1;i<nums.length;i++){
            res[i]= res[i-1] * nums[i-1];
        }
        int post = 1;
        for(int i = n-1;i>=0;i--){
            res[i]*=post;
            post*= nums[i];
        }
        return res;
    }
}
```

## 36. Valid Sudoku
### Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
### Each row must contain the digits 1-9 without repetition.
### Each column must contain the digits 1-9 without repetition.
### Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
### Note:
### A Sudoku board (partially filled) could be valid but is not necessarily solvable.
### Only the filled cells need to be validated according to the mentioned rules.
### Example 1:
### Input: board = 
### [["5","3",".",".","7",".",".",".","."]
### ,["6",".",".","1","9","5",".",".","."]
### ,[".","9","8",".",".",".",".","6","."]
### ,["8",".",".",".","6",".",".",".","3"]
### ,["4",".",".","8",".","3",".",".","1"]
### ,["7",".",".",".","2",".",".",".","6"]
### ,[".","6",".",".",".",".","2","8","."]
### ,[".",".",".","4","1","9",".",".","5"]
### ,[".",".",".",".","8",".",".","7","9"]]
### Output: true
### Example 2:
### Input: board = 
### [["8","3",".",".","7",".",".",".","."]
### ,["6",".",".","1","9","5",".",".","."]
### ,[".","9","8",".",".",".",".","6","."]
### ,["8",".",".",".","6",".",".",".","3"]
### ,["4",".",".","8",".","3",".",".","1"]
### ,["7",".",".",".","2",".",".",".","6"]
### ,[".","6",".",".",".",".","2","8","."]
### ,[".",".",".","4","1","9",".",".","5"]
### ,[".",".",".",".","8",".",".","7","9"]]
### Output: false
### Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
#### Solution: 
#### we check every row and column on it's own saving items in a hashset 
#### then we check in every square using a hashset also with row = (square / 3) * 3 + i, and col = (square % 3) * 3 + j for every item
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < 9; row++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[row][i] == '.') continue;
                if (seen.contains(board[row][i])) return false;
                seen.add(board[row][i]);
            }
        }
        
        for (int col = 0; col < 9; col++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 9; i++) {
                if (board[i][col] == '.') continue;
                if (seen.contains(board[i][col])) return false;
                seen.add(board[i][col]);
            }
        }
        
        for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }
        
        return true;
    }
}
```

## 128. Longest Consecutive Sequence
### Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
### You must write an algorithm that runs in O(n) time.
### Example 1:
### Input: nums = [100,4,200,1,3,2]
### Output: 4
### Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
### Example 2:
### Input: nums = [0,3,7,2,5,8,4,6,0,1]
### Output: 9
#### Solutions:
#### A) O(N logN) time and O(1) space Solution:
#### Sort the array and add four variables res = 0, curr = nums[0], streak = 0, i = 0
#### make an outer while loop that runs while i < nums.length
#### if curr is not equal to nums[i] we set it to nums[i] and make the streak zero to count another streak
#### and then we make an inner while loop that runs once at least and to skip duplicates incrementing i
#### then increment streak and curr and set res to the greatest of them so the curr is the next expected element
#### after the while loop return res
```java
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }
            // Here it increments i one time if there are no duplicates and duplictes count times if there are
            while (i < nums.length && nums[i] == curr) {
                i++;
            }
            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }
}
```
#### B) O(N) time and O(N) space Solution:
#### save all the items of the array to a hashset called numSet and then make an int longest which starts with zero
#### run a for loop on numsSet and inside it if the numset contains current num-1 make an int length = 1 and make a while loop that runs while numset contains num + length and inside the inner while loop increment length
#### after the inner while loop excutes set longest to length if length is greater than the current longest then return longest after the outer loop ends
```java
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longest = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
```
