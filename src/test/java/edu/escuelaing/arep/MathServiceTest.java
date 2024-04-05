package edu.escuelaing.arep;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class MathServiceTest extends TestCase {

    public MathServiceTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(MathServiceTest.class);
    }

    public void test_is_position_when_value_is_in_the_list() {
        int[] numbers = { 1, 2, 3, 4, 5, 0, 16, 14 };
        int number = 3;
        int expectedValue = 2;
        int value = MathServices.linealSearch(numbers, number);
        assertEquals(expectedValue, value);
    }

    public void test_is_minus_one_when_value_is_not_in_the_list() {
        int[] numbers = { 1, 2, 3, 4, 5, 0, 16, 14 };
        int number = 6;
        int expectedValue = -1;
        int value = MathServices.linealSearch(numbers, number);
        assertEquals(expectedValue, value);
    }

    public void test_is_position_when_value_is_in_the_list_binary_search() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int number = 3;
        int expectedValue = 2;
        int value = MathServices.binarySearch(numbers, number, 0, numbers.length - 1);
        assertEquals(expectedValue, value);
    }

    public void test_is_minus_one_when_value_is_not_in_the_list_binary_search() {
        int[] numbers = { 1, 2, 3, 4, 5 };
        int number = 6;
        int expectedValue = -1;
        int value = MathServices.binarySearch(numbers, number, 0, numbers.length - 1);
        assertEquals(expectedValue, value);
    }

}
