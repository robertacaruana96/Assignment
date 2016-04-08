import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest
{
    Calculator calc;
    @Before
    public void initialize()
    {
        calc = new Calculator(); 
    }
    
    @After 
    public void teardown()
    {
        calc = null;
    }

    @Test
    public void testAdd()
    {
        int result = calc.add(1,2);
        assertEquals(3,result);
    }
    
    @Test
    public void testSubtract0()
    {
        int result = calc.subtract(1,2);
        assertEquals(-1,result);
    }
    
    @Test
    public void testSubtract1()
    {
        int result = calc.subtract(5,4);
        assertEquals(1,result);
    }
    
    @Test
    public void testMultiply()
    {
        int result = calc.multiply(1,2);
        assertEquals(2,result);
    }
    
    @Test
    public void testDivide0()
    {
        int result = calc.divide(4,2);
        assertEquals(2,result);
    }
    
    @Test
    public void testDivide1()
    {
        int result = calc.divide(4,0);
        assertEquals(-999,result);
    }
}