package TESTNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGASSERTion {
    public int multiplation(int number1, int number2){
        return number1*number2;
    }
    @Test
    public void validateMultiplication(){
        int actualResult=multiplation(3,4);
        int expectedResult=12;
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void validateZero(){
        int actual=multiplation(0,9999);
        int expected=0;
        Assert.assertTrue(actual==expected);

    }
    @Test
    public void validateNegativeWithPositive(){
        int actual=multiplation(-1,9);
        int expected=-9;
        Assert.assertFalse(actual!=expected);

    }
    @Test
    public void validateNegativeWithNegative(){
       // int actual=multiplation(-1,-5);
       // int expected=5;
        Assert.assertEquals(multiplation(-1,-5), 5);

    }
}
