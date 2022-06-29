package org.example.algorithms;

import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    /*
     * Complete the 'isBalanced' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */
    public static String isBalanced(final String s) {
        // Write your code here
        final BracketAnalyser balancer = new BracketAnalyser(Map.of('{', '}', '(', ')', '[',']'));
        return balancer.isBalanced(s) ? "YES" : "NO";
    }

    private static class BracketAnalyser
    {

        public BracketAnalyser(final  Map<Character, Character> opposites) {
            this.opposites = Map.copyOf(opposites);
        }

        public boolean isBalanced(final String candidate)
        {

            if(candidate.length() % 2 > 0)
            {
                return false;
            }

            final Stack<Character> stack = new Stack<>();
            for(int i = 0; i < candidate.length(); i++)
            {
                char current = candidate.charAt(i);
                if(opposites.containsKey(current))
                {
                    // it is an opening bracket. Add the opposite to the stack.
                    stack.push(opposites.get(current));
                }
                else if(!stack.isEmpty() && stack.pop().equals(current))
                {
                    // do nothing as we have
                }
                else
                {
                    return false;
                }
            }

            return stack.isEmpty();
        }

        private final Map<Character, Character> opposites;
    }

}
