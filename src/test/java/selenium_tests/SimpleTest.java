package selenium_tests;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;

public class SimpleTest {

    @Test
    public void simpleTest()
    {
        System.out.println("This is a simple test");
        Assertions.assertEquals(1, 0+1);}
}
