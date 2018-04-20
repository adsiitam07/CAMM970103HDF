package mx.com.itam.adsi;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Prubas unitarias para Solucion
 */
public class SolucionTest
{
     private final static Logger LOG = Logger.getLogger(SolucionTest.class);

     @BeforeClass
     public static void beforeClass() {
         System.out.println("Before Class");
     }

     @Before
     public void before() {
         System.out.println("Before Test Case");
     }

    @Test
    public void prueba()
    {
        assertTrue("Verifica", true);
    }
    @After
    public void after() {
      System.out.println("After Test Case");
    }

    @AfterClass
    public static void afterClass() {
      System.out.println("After Class");
    }
}
