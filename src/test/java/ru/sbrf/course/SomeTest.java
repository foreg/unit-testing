package ru.sbrf.course;

import org.junit.*;
import org.junit.rules.TemporaryFolder;

import java.io.File;

public class SomeTest {

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();

    private File output;

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Some per class initializations");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Some per class deinitializations");
    }

    @Before
    public void setUp() {
        output = new File("1.txt");
    }

    @After
    public void tearDown() {
        output.delete();
    }

    @Test
    public void test() {
        System.out.println(output.getAbsoluteFile());
    }

}
