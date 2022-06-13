package HW4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



public class TriangleTest {

    double result = Main.calculateTriangleSquare(2.0, 3.0, 4.0);

    @Test
    void checkTriangleSquareResultIsNotNull(){
        Assertions.assertNotEquals(null, result);
    }

    @Test
    void checkTriangleSquareResultIsPositive(){
        Assertions.assertTrue(result > 0);
    }

}
