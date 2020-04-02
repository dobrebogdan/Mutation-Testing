package com.example;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    //Equivaence classes - Category partitioning
    Main tester = new Main();

    @Test
    public void multipleAnswers() {
        Integer [] expected = {2,4};
        Integer [] actual = tester.numberSearh(4, 3, 2, 3);
        assertEquals( actual.length, expected.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }

    }

    @Test
    public void singleAnswer() {
        Integer [] expected = {4};
        Integer [] actual = tester.numberSearh(4, 3, 4, 3);
        assertEquals( actual.length, expected.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    @Test
    public void noAnswers() {
        Integer [] actual = tester.numberSearh(2, 2, 1, 10);
        assertEquals(0, actual.length);
    }

    //Boundray Analysis
    @Test(expected = ArithmeticException.class)
    public void divideByzero() {
        tester.numberSearh(1000, 1001, 0, 0);
    }

    @Test
    public void allArgsEqual() {
        Integer [] actual = tester.numberSearh(1,1,1, 1);
        assertEquals(0, actual.length);
    }

    //condition coverage
    //while iterating through the numbers from 1 to 4, each condition will get to be both true and false
    @Test
    public void conditionTest() {
        Integer [] expected = {2,4};
        Integer [] actual = tester.numberSearh(4, 3, 2, 3);
        assertEquals( actual.length, expected.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    //branch coverage
    //while iterating through the numbers from 1 to 8, each branch will be covered
    @Test
    public void branchTest() {
        Integer [] expected = {2, 4, 8};
        Integer [] actual = tester.numberSearh(8, 3, 2, 3);
        assertEquals( actual.length, expected.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    //statement coverage
    //this test wil cover all instructions
    @Test
    public void statementCoverage() {
        Integer [] expected = {3,6,9,18};
        Integer [] actual = tester.numberSearh(18, 1, 3, 4);
        assertEquals( actual.length, expected.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }


    //tests used for killing mutants which replace % with multiplication
    @Test
    public void mutantKiller() {
        Integer [] expected = {3};
        Integer [] actual = tester.numberSearh(15, 10, 3, 5);
        assertEquals( actual.length, expected.length);
        for(int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    // Mutant coverage without special tests: 87%
    // Mutant coverage with special tests: 91%
    // due to the uniqueness of the numbers mutants which replace > with >= can not be killed
    // there is also a mutant which switches < with <= in the first of the final 2 nested for loops that can not be killed
}