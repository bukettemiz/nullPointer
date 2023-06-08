package TESTNG;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.annotations.Test;

public class TestNGintro {
    @Test(priority=1, invocationCount=10)//priority:order number invocationCount:how many times runs you want
    public void test1(){
        System.out.println("I am testing1");
    }
    @Test(priority=2)
    public void test2(){
        System.out.println("I am testing2");
    }
    @Test(priority=3)
    public void test3(){
        System.out.println("I am testing3");
    }
}
