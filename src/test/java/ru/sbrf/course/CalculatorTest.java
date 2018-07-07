package ru.sbrf.course;

import org.junit.Assume;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@Category({SlowTests.class, FastTests.class})
@RunWith(Parameterized.class)
public class CalculatorTest {

    @Parameter
    public Type type;
    @Parameter (1)
    public int a;

    @Parameter(2)
    public int b;

    @Parameter(3)
    public int expected;

    private Calculator calculator = new Calculator();

    enum Type {MULTIPLY, ADD};
    @Parameters
    public static Iterable<Object[]> data() {

        return Arrays.asList(new Object[][]{{Type.ADD, 5, 2, 7}, {Type.ADD, 1, 1, 2}, {Type.ADD, 2, 1, 3}, {Type.MULTIPLY, 2, 2, 4}, {Type.MULTIPLY, 1, 1, 1}, {Type.MULTIPLY, 2, 1, 2}});
    }

    @Test
    public void testAdd() throws Exception {
        Assume.assumeTrue(type == Type.ADD);
        assertEquals(expected, calculator.add(a, b));
    }
    @Test
    public void testMultiply() throws Exception {
        Assume.assumeTrue(type == Type.MULTIPLY);
        assertEquals(expected, calculator.multiply(a, b));
    }

}
