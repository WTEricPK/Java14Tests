package org.example.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Writing assertions for balance tests.")
public class BalancedBracketsTest {


    @Test
    public void balancedSymmetric()
    {
        assertEquals( "YES", BalancedBrackets.isBalanced("{[()]}"), "Should be balanced.");
        assertEquals( "YES", BalancedBrackets.isBalanced("{{[[(())]]}}"), "Should be balanced.");
    }


    @Test
    public void notBalancedSymmetric()
    {
        assertEquals("NO", BalancedBrackets.isBalanced("{[(])}"), "Brackets are not balanced.");
    }

    @Test
    public void notBalancedOddNumberOfBraces()
    {
        assertEquals("NO", BalancedBrackets.isBalanced("{)}"), "Brackets are not balanced.");
    }

}
