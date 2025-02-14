# stacks:
## A Stack is a data structure that follows the LIFO (Last In, First Out) principle.
## This means the last item added to the stack is the first one to be removed, just like a stack of plates.

### Implementation:

```java
import java.util.ArrayList;

// Implementing a stack is trivial using a dynamic array
// (which we implemented earlier).
public class Stack {

    ArrayList<Integer> stack = new ArrayList<Integer>();

    public Stack() {   
    }

    public void push(int n) {
        stack.add(n);
    }

    public int pop() {
        return stack.remove(stack.size() - 1);
    }

    public int size() {
        return stack.size();
    }
}
```

### Problems:

## 20. Valid Parentheses
### Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
### An input string is valid if:
### Open brackets must be closed by the same type of brackets.
### Open brackets must be closed in the correct order.
### Every close bracket has a corresponding open bracket of the same type.
### Example 1:
### Input: s = "()"
### Output: true
### Example 2:
### Input: s = "()[]{}"
### Output: true
### Example 3:
### Input: s = "(]"
### Output: false
### Example 4:
### Input: s = "([])"
### Output: true
#### Solution:
#### we use a stack and run a loop on the string to store all the opening brackets in it 
#### when we get a closing bracket the peek of the stack must be it's opening bracket so we pop it.
#### if the peek is something else or the stack is Empty we return false.
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
```

## 
 