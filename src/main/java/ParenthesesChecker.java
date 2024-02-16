import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Stack;

public class ParenthesesChecker {
    public boolean checkParentheses(String input){
        // Make a dictionary to match correct brackets
        HashMap<Character, Character> bracketsHashmap = new HashMap<Character, Character>();
        bracketsHashmap.put(')','(');
        bracketsHashmap.put(']','[');
        bracketsHashmap.put('}','{');
        bracketsHashmap.put('>','<');

        // Make a stack out of open brackets
        Stack <Character> openBrackets = new Stack<Character>();

        for (int i = 0; i < input.length(); i++){
            //lines are getting a bit unreadable, this might shorten it
            char current = input.charAt(i);

            //Add any open brackets to stack
            if (bracketsHashmap.containsValue(current)){
                openBrackets.add(current);
            }
            try {
                //Pop the matching open bracket from top of stack IF it matches
                if ((bracketsHashmap.containsKey(current)) && (openBrackets.lastElement().equals(bracketsHashmap.get(current)))) {
                    openBrackets.pop();
                }
                //if we get a closing bracket but the stack is empty, return false since they are not matching
            } catch (NoSuchElementException e){
                return false;
            }
        }

        //If stack is not empty, we did not find a match for each bracket
        return (openBrackets.isEmpty());
    }
}
