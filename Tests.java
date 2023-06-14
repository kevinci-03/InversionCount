import static org.junit.Assert.*;
import org.junit.Test;

public class Tests {


    @Test
    public void test1() {

        int[] list = {6, 4, 3, 1};
        assertEquals(Inversions.invCounter(list), 6);

    }

    @Test
    public void test2() {

        int[] list = {2, 3, 8, 6, 1};
        assertEquals(Inversions.invCounter(list), 5);

    }

    @Test
    public void test3() {

        int[] list = {};
        assertEquals(Inversions.invCounter(list), 0);

    }

    @Test
    public void test4() {

        int[] list = {42};
        assertEquals(Inversions.invCounter(list), 0);

    }

    @Test
    public void test5() {

        int[] list = {5, 4, 3, 2, 1};
        assertEquals(Inversions.invCounter(list), 10);

    }

    @Test
    public void test6() {

        int[] list = {1, 1, 1, 1, 1, 1, 1};
        assertEquals(Inversions.invCounter(list), 0);

    }

    @Test
    public void test() {

     int[] list = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3};
     assertEquals(Inversions.invCounter(list), 15);

    }

}